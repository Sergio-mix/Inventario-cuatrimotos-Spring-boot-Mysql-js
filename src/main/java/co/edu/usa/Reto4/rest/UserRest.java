package co.edu.usa.Reto4.rest;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserRest {

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {

//        for (Map.Entry<String, Object> entry : principal.getAttributes().entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }

        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

}
