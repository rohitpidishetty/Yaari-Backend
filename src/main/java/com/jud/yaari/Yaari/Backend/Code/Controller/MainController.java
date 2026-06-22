package com.jud.yaari.Yaari.Backend.Code.Controller;

import com.jud.yaari.Yaari.Backend.Code.DTO.*;
import com.jud.yaari.Yaari.Backend.Code.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @RequestMapping("/")
    public String test() {
        return "hi";
    }

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private HomeFeedService homeFeedService;

    @Autowired
    private HotSpotService hotSpotService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessagingService messagingService;

    @Autowired
    private JdbcTemplate jdbc;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginDTO payload) {
        return authService.validatePayload(payload, jdbc);
    }

    @PostMapping("/signup")
    public boolean signup(@RequestBody SignUpDTO payload) {
        if (!AuthenticationService.Validator.isEmail(payload.getEmail_address()) ||
                !AuthenticationService.Validator.isPhone(payload.getPhone_number()) ||
                !AuthenticationService.Validator.isUsername(payload.getUser_name()))
            return false;
        return authService.createNewUser(payload, jdbc);
    }

    @GetMapping("/home")
    public ResponseEntity<List<Map<String, Object>>> home(@RequestParam String username, @RequestParam long request_time) {
        return homeFeedService.populateFeed(username, request_time, jdbc);
    }

    @GetMapping("/hotspots")
    public ResponseEntity<List<Map<String, Object>>> hotspots(@RequestParam double lon, @RequestParam double lat, @RequestParam int kilometer_range) {
        return hotSpotService.fetch(lon, lat, kilometer_range, jdbc);
    }

    @GetMapping("/user_details")
    public ResponseEntity<List<Map<String, Object>>> userDetails(@RequestParam String username) {
        return userService.fetchDetails(username, jdbc);
    }

    @GetMapping("/user_own_feed")
    public ResponseEntity<List<Map<String, Object>>> usersOwnFeed(@RequestParam String username, @RequestParam long request_time) {
        return userService.fetchFeed(username, request_time, jdbc);
    }

    @GetMapping("/get_friends")
    public ResponseEntity<List<Map<String, Object>>> getFriends(@RequestParam String username) {
        return userService.getFriends(username, jdbc);
    }

    @GetMapping("/message_pool")
    public ResponseEntity<List<Map<String, Object>>> getMessagePool(@RequestParam String username) {
        return messagingService.getMessagePool(username, jdbc);
    }

    @GetMapping("/chat_messages")
    public ResponseEntity<List<MessageDTO>> getChatMessages(@RequestParam String username, @RequestParam String receiver) {
        return messagingService.getChatMessages(username, receiver, jdbc);
    }

    @Autowired
    private PostServices postServices;

    @GetMapping("/like_post")
    public void likePost(@RequestParam String postId, @RequestParam String likedByUsername) {
        postServices.likePost(postId, likedByUsername, jdbc);
    }

    @GetMapping("/liked_by")
    public ResponseEntity<List<LikedByUserDTO>> getLikedBy(@RequestParam String postId) {
        return postServices.getUsersWhoLikedPost(postId, jdbc);
    }

    @GetMapping("/comments")
    public ResponseEntity<List<CommentsDTO>> comments(@RequestParam String post_id) throws Exception {
        return postServices.readComments(post_id, jdbc);

    }

    @PostMapping("/post_comment")
    public int postComment(@RequestBody PostCommentDTO commentsPayload) {
        return postServices.commentOnPost(commentsPayload.getCommentId(), commentsPayload.getPostId(), commentsPayload.getCommentBy(), commentsPayload.getComment(), jdbc);
    }

}
