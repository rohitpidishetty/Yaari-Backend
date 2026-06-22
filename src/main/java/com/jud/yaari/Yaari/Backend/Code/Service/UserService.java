package com.jud.yaari.Yaari.Backend.Code.Service;

import com.jud.yaari.Yaari.Backend.Code.DTO.SearchUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    public ResponseEntity<List<Map<String, Object>>> fetchDetails(String username, JdbcTemplate jdbc) {
        try {
            List<Map<String, Object>> result = jdbc.queryForList(Files.readString(Paths.get("src/main/resources/sql/user_details.sql")), username);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    public ResponseEntity<List<Map<String, Object>>> fetchFeed(String username, long request_time, JdbcTemplate jdbc) {
        try {
            List<Map<String, Object>> result = jdbc.queryForList(Files.readString(Paths.get("src/main/resources/sql/personal_feed.sql")), username, request_time);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    public ResponseEntity<List<Map<String, Object>>> getFriends(String username, JdbcTemplate jdbc) {
        try {
            List<Map<String, Object>> result = jdbc.queryForList(Files.readString(Paths.get("src/main/resources/sql/get_users_friends.sql")), username);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    public ResponseEntity<List<SearchUserDTO>> searchUser(String searchToken, JdbcTemplate jdbc) {
        try {
            List<Map<String, Object>> result = jdbc.queryForList(Files.readString(Paths.get("src/main/resources/sql/search_users.sql")), searchToken + "%", searchToken + "%");
            List<SearchUserDTO> searchResults = new ArrayList<>();
            result.forEach(e -> {
                searchResults.add(new SearchUserDTO(e.get("profile_picture").toString(), e.get("user_name").toString(), e.get("fullname").toString(), e.get("bio_status").toString()));
            });
            return ResponseEntity.ok(searchResults);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
