package com.codecool.honestoneapi.controller;

import com.codecool.honestoneapi.controller.dto.DeckUserInfoDto;
import com.codecool.honestoneapi.security.JwtUtil;
import com.codecool.honestoneapi.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;


@RestController
@RequestMapping("/vote")
@CrossOrigin
public class VoteController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private DeckService deckService;

    @PostMapping("/{method}")
    public void like(HttpServletRequest request,@RequestBody DeckUserInfoDto data,@PathVariable("method") String method) {
        data.setUsername(jwtUtil.getUsernameFromToken(jwtUtil.getTokenCookie(request).get().getValue()));
        switch (method) {
            case "like":
                deckService.like(data);
                break;
            case "unlike":
                deckService.unlike(data);
                break;
            case "dislike":
                deckService.dislike(data);
        }
    }

}

