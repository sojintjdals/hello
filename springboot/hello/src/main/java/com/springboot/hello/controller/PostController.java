package com.springboot.hello.controller;

import ch.qos.logback.classic.Logger;
import com.springboot.hello.dto.MemberDto;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

// PostMapping
//    @PostMapping(value = "/member")
//    public String postMember(@RequestBody Map<String, Object> postData){
//        StringBuilder sb = new StringBuilder();
//
//        postData.entrySet().forEach(map ->{
//            sb.append(map.getKey() + " : " + map.getValue() + "\n");
//        });
//
//        return sb.toString();
//    }

//    @PostMapping(value="/member2")
//    public String postMemberDto(@RequestBody MemberDto memberDto){
//        return memberDto.toString();
//    }

//PutMapping
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PutMapping(value="/member1")
    public String postMemberDto1(@RequestBody MemberDto memberDto){
        return memberDto.toString();
    }

    @PutMapping(value="/member2")
    public MemberDto postMemberDto2(@RequestBody MemberDto memberDto){
        return memberDto;
    }
    //responseEntity
    @PutMapping(value="/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }

    // delete
    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email){
        return "e-mail : " + email;
    }
}
