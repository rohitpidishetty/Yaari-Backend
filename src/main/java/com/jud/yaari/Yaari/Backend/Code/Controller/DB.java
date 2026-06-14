package com.jud.yaari.Yaari.Backend.Code.Controller;

import com.jud.yaari.Yaari.Backend.Code.DTO.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class DB {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/db")
    public List<Map<String, Object>> conn() {
        return jdbcTemplate.queryForList("select * from users;");
    }

    @RequestMapping("/friends")
    public List<Map<String, Object>> friends(@RequestParam String friends_of) throws Exception {
        return jdbcTemplate.queryForList(Files.readString(Paths.get("src/main/resources/sql/friends.sql")
        ), friends_of);
    }

    @RequestMapping("/posts")
    public List<Map<String, Object>> posts(@RequestParam String of) throws Exception {
        return jdbcTemplate.queryForList(Files.readString(Paths.get("src/main/resources/sql/posts.sql")
        ), of);
    }

    @RequestMapping("/comments")
    public List<Map<String, Object>> comments(@RequestParam String post_id) throws Exception {
        return jdbcTemplate.queryForList(Files.readString(Paths.get("src/main/resources/sql/comments.sql")
        ), post_id);
    }

    @RequestMapping("/messages")
    public List<Map<String, Object>> messages(@RequestParam String sender_username, @RequestParam String receiver_username) throws Exception {
        return jdbcTemplate.queryForList(Files.readString(Paths.get("src/main/resources/sql/messages.sql")), sender_username, receiver_username, receiver_username, sender_username);
    }

    @PostMapping("/post_message")
    public boolean post_message(@RequestBody MessageDTO ref) throws Exception {
        try {
            jdbcTemplate.update(Files.readString(Paths.get("src/main/resources/sql/post_message.sql")), ref.getMessage_id(), ref.getSender_username(), ref.getReceiver_username(), ref.getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
