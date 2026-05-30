package com.example.LibraryManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LibraryManagement.entities.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    
}
