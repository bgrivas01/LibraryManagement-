package com.example.LibraryManagement.entities;

import java.time.LocalDate;

import com.example.LibraryManagement.Enums.MemberStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate membershipDate;
    private LocalDate membershipExpiryDate;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus; // ACTIVE, INACTIVE


    
}
