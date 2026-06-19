package com.jud.yaari.Yaari.Backend.Code.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
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
}
