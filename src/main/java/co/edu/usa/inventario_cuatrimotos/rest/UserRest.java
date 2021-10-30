package co.edu.usa.inventario_cuatrimotos.rest;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
public class UserRest {

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {

//        for (Map.Entry<String, Object> entry : principal.getAttributes().entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }

        Map<String, Object> user = new LinkedHashMap<>();
        user.put("name", principal.getAttribute("name"));
        user.put("image", principal.getAttribute("avatar_url"));

        return user;
    }

}
