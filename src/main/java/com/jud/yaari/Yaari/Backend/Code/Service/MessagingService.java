package com.jud.yaari.Yaari.Backend.Code.Service;

import com.jud.yaari.Yaari.Backend.Code.DTO.MessageDTO;
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
public class MessagingService {
    public ResponseEntity<List<Map<String, Object>>> getMessagePool(String username, JdbcTemplate jdbc) {
        try {
            List<Map<String, Object>> result =
                    jdbc.queryForList(Files.readString(Paths.get("src/main/resources/sql/message_pool.sql")),
                            username,
                            username,
                            username,
                            username);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<List<MessageDTO>> getChatMessages(String username, String receiver, JdbcTemplate jdbc) {
        try {
            List<MessageDTO> messages = new ArrayList<>();
            List<Map<String, Object>> result =
                    jdbc.queryForList(Files.readString(Paths.get("src/main/resources/sql/messages.sql")), username, receiver, receiver, username);
            result.forEach(e -> {
                 messages.add(
                        new MessageDTO(
                                e.get("message_id").toString(),
                                e.get("sender_username").toString(),
                                e.get("receiver_username").toString(),
                                e.get("message_payload").toString(),
                                e.get("messaged_at").toString().split(" ")[1].split("\\.")[0])
                );
            });
            return ResponseEntity.ok(messages);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

