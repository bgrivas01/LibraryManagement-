package com.example.LibraryManagement.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryManagement.Service.MemberService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;
    
}
