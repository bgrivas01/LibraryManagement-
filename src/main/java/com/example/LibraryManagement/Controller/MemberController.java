package com.example.LibraryManagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LibraryManagement.Enums.MemberStatus;
import com.example.LibraryManagement.Service.MemberService;
import com.example.LibraryManagement.entities.Member;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("")
    public List<Member> getAllMemebers(){
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Optional<Member> getMemberById(@PathVariable Long id){
        return memberService.getMemberById(id);
    }

    @PostMapping("")
    public void addMember(@RequestBody Member member){
        memberService.addMember(member);
    }

    @PutMapping("/{id}")
    public void updateMember(@PathVariable Long id, @RequestBody Member memberDetails){
        memberService.updateMember(id, memberDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
    }

    @PutMapping("/changestatus/{id}")
    public void changeMemberStatus(@PathVariable Long id, @RequestBody MemberStatus status){
        memberService.changeMemberStatus(id, status);
    }
}
