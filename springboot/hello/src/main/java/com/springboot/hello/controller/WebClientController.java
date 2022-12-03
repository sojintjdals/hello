package com.springboot.hello.controller;

import com.springboot.hello.dto.MemberDto;
import com.springboot.hello.service.WebClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web-client")
public class WebClientController {
    private WebClientService webClientService;

    @Autowired
    public WebClientController(WebClientService webClientService){
        this.webClientService = webClientService;
    }

    @GetMapping
    public String getName() {
        return webClientService.getName();
    }

    @GetMapping("/path-variable")
    public String getNameWithPathVarible() {
        return webClientService.getNameWithPathVariable();
    }

    @GetMapping("/parameter")
    public String getNameWithParameter() {
        return webClientService.getNameWithParameter();
    }

    @PostMapping("/post-path-variable")
    public ResponseEntity<MemberDto> postWithHeader() {
        return webClientService.postWithHeader();
    }

    @PostMapping("/post-parameter")
    public ResponseEntity<MemberDto> postWithParamAndBody() {
        return webClientService.postWithParamAndBody();
    }
}
