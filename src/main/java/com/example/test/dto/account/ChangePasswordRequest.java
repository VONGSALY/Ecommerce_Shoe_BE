package com.example.test.dto.account;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ChangePasswordRequest {
    private String username;
    private String password;
    private String newPassword;
}
