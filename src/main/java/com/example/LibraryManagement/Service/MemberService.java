package com.example.LibraryManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.LibraryManagement.Enums.MemberStatus;
import com.example.LibraryManagement.Repository.MemberRepository;
import com.example.LibraryManagement.entities.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberById(Long id){
        return memberRepository.findById(id);
    }

    public Member addMember(Member member){
         return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member memberDetails){
        Optional<Member> optionalMember = memberRepository.findById(id);
        if(optionalMember.isPresent()){
            Member memberToUpdate = optionalMember.get();
            memberToUpdate.setName(memberDetails.getName());
            memberToUpdate.setEmail(memberDetails.getEmail());
            memberToUpdate.setMemberStatus(memberDetails.getMemberStatus());
            memberToUpdate.setPhoneNumber(memberDetails.getPhoneNumber());
            memberToUpdate.setAddress(memberDetails.getAddress());
            memberToUpdate.setMembershipDate(memberDetails.getMembershipDate());
            memberToUpdate.setMembershipExpiryDate(memberDetails.getMembershipExpiryDate());
            memberRepository.save(memberToUpdate);
            return memberToUpdate;
        } else {
            throw new RuntimeException("Member not found with id: " + id);
        }
        
    }

    public void deleteMember(Long id){
        if(memberRepository.existsById(id)){
            memberRepository.deleteById(id);
        } else {
            throw new RuntimeException("Member not found with id: " + id);
        }
    }

    public Member changeMemberStatus(Long id, MemberStatus status){
        Optional<Member> optionalMember = memberRepository.findById(id);
        if(optionalMember.isPresent()){
            Member memberToUpdate = optionalMember.get();
            memberToUpdate.setMemberStatus(status);
            memberRepository.save(memberToUpdate);
            return memberToUpdate;
        } else {
            throw new RuntimeException("Member not found with id: " + id);
        }
        
    }

    
}
