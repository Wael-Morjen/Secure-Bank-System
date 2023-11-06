package com.project.banksystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String StateOfOrigin;
    private String email;
    private String password;
    private String phoneNumber;
    private String alternativePhoneNumber;
}
