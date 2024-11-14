package com.example.oauth2example.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class RestApiController {
    private static final Logger log = LogManager.getLogger(RestApiController.class);

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        log.info("principal {}", principal);
        String name =  principal.getAttribute("login");
        if(name == null) {
            name = principal.getAttribute("name");
        }
        return Collections.singletonMap("name",  name);
    }
}
