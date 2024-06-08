package com.chesnakov.hardwareecommerce.controller;

import com.chesnakov.hardwareecommerce.entity.JwtRequest;
import com.chesnakov.hardwareecommerce.entity.JwtResponse;
import com.chesnakov.hardwareecommerce.service.JwtService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://46.253.143.107:4200")
@RestController
@CrossOrigin
public class JwtController {


    private final JwtService jwtService;

    public JwtController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }
}

