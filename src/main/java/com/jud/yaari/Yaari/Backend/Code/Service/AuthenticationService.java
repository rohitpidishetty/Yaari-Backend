package com.jud.yaari.Yaari.Backend.Code.Service;

import com.jud.yaari.Yaari.Backend.Code.DTO.LoginDTO;
import com.jud.yaari.Yaari.Backend.Code.DTO.SignUpDTO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthenticationService {

    public static class Validator {
        public static boolean isEmail(String email) {
            if (email == null || email.isBlank())
                return false;
            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
            return email.matches(regex);
        }

        public static boolean isPhone(String phone) {
            if (phone == null)
                return false;
            return phone.matches("^(\\+91|91)?[6-9]\\d{9}$");
        }

        public static boolean isUsername(String username) {
            if (username == null)
                return false;
            String regex =
                    "^(?=.{3,30}$)(?!.*\\.\\.)(?![._])[a-zA-Z0-9._]+(?<![._])$";
            return username.matches(regex);
        }
    }

    public Map<String, Object> validatePayload(LoginDTO payload, JdbcTemplate jdbc) {
        try {
            List<Map<String, Object>> result = jdbc.queryForList(Files.readString(Paths.get("src/main/resources/sql/find_user.sql")), payload.getUsername(), payload.getPassword());
            if (result.isEmpty()) return new HashMap<>() {{
                put("user_id", null);
            }};

            return result.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean createNewUser(SignUpDTO payload, JdbcTemplate jdbc) {
        try {
            jdbc.update(
                    Files.readString(
                            Paths.get("src/main/resources/sql/create_new_user.sql")),
                    payload.getUser_name(),
                    payload.getEmail_address(),
                    payload.getUser_password(),
                    LocalDate.now().toString(),
                    payload.getPhone_number());
        } catch (Exception err) {

            return false;
        }
        return true;
    }
}
