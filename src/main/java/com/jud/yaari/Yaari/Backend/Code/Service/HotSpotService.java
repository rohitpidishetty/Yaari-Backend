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
public class HotSpotService {
    public ResponseEntity<List<Map<String, Object>>> fetch(double lon, double lat, int km, JdbcTemplate jdbc) {
        try {
            List<Map<String, Object>> result = jdbc.queryForList(Files.readString(Paths.get("src/main/resources/sql/fetch_hotspots.sql")), lon, lat, km);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
