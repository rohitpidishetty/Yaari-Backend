package com.jud.yaari.Yaari.Backend.Code.Controller;

import com.jud.yaari.Yaari.Backend.Code.DTO.LoginDTO;
import com.jud.yaari.Yaari.Backend.Code.DTO.SignUpDTO;
import com.jud.yaari.Yaari.Backend.Code.Service.AuthenticationService;
import com.jud.yaari.Yaari.Backend.Code.Service.HomeFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

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
}
