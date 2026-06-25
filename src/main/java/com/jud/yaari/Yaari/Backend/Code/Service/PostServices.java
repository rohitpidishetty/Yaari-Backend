package com.jud.yaari.Yaari.Backend.Code.Service;

import com.jud.yaari.Yaari.Backend.Code.DTO.CommentsDTO;
import com.jud.yaari.Yaari.Backend.Code.DTO.LikedByUserDTO;
import com.jud.yaari.Yaari.Backend.Code.DTO.PictureUploadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PostServices {
    public void likePost(String postId, String likedByUsername, JdbcTemplate jdbc) {
        try {
            jdbc.update(Files.readString(Paths.get("src/main/resources/sql/like_post.sql")), postId, likedByUsername);
        } catch (Exception e) {
            try {
                jdbc.update(Files.readString(Paths.get("src/main/resources/sql/remove_like_post.sql")), likedByUsername, postId);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public ResponseEntity<List<LikedByUserDTO>> getUsersWhoLikedPost(String postId, JdbcTemplate jdbc) {
        try {
            List<Map<String, Object>> result = jdbc.queryForList(Files.readString(Paths.get("src/main/resources/sql/post_liked_by.sql")), postId);
            List<LikedByUserDTO> likedBy = new ArrayList<>();
            result.forEach(e -> {
                likedBy.add(new LikedByUserDTO(e.get("user_name").toString(), e.get("profile_picture").toString()));
            });
            return ResponseEntity.ok(likedBy);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<CommentsDTO>> readComments(String post_id, JdbcTemplate jdbc) {
        try {
            List<Map<String, Object>> result = jdbc.queryForList(Files.readString(Paths.get("src/main/resources/sql/comments.sql")), post_id);
            List<CommentsDTO> comments = new ArrayList<>();
            result.forEach(e -> {
                comments.add(new CommentsDTO(e.get("comment_id").toString(),
                        e.get("post_id").toString(),
                        e.get("comment_by").toString(),
                        e.get("comment_data").toString(),
                        e.get("comment_time").toString()));
            });
            return ResponseEntity.ok(comments);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int commentOnPost(String commentId, String postId, String commentBy, String comment, JdbcTemplate jdbc) {
        try {
            jdbc.update(Files.readString(Paths.get("src/main/resources/sql/post_comment.sql")), commentId, postId, commentBy, comment);
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public ResponseEntity<?> uploadPhoto(PictureUploadDTO picture, JdbcTemplate jdbc) {
        try {
           
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
