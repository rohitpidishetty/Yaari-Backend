package com.jud.yaari.Yaari.Backend.Code.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Service
public class HomeFeedService {
    public ResponseEntity<List<Map<String, Object>>> populateFeed(
            String username,
            long request_time,
            JdbcTemplate jdbc) {

        try {
            String sql = Files.readString(
                    Paths.get("src/main/resources/sql/home_feed.sql")
            );

            List<Map<String, Object>> result =
                    jdbc.queryForList(sql, username, username, request_time);

            return ResponseEntity.ok(result);

        } catch (Exception e) {
            throw new RuntimeException("Failed to populate feed", e);
        }
    }
}
