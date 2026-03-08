package com.example.test.validation;

import lombok.AllArgsConstructor;
import com.example.test.base.error_success_handle.CodeAndMessage;
import com.example.test.dto.AccountCreateRequest;
import com.example.test.repository.AccountDetailRepository;
import com.example.test.repository.AccountRepository;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountValidationHelper {
    private final AccountRepository accountRepository;
    private final AccountDetailRepository accountDetailRepository;
    public void signUpValidate(AccountCreateRequest signUpRequest){
        if (accountRepository.existsByUsername(signUpRequest.getUsername())){
            throw new RuntimeException(CodeAndMessage.ME104);
        }
        if (accountDetailRepository.existsByEmail(signUpRequest.getEmail())){
            throw new RuntimeException(CodeAndMessage.ME105);
        }
    }
}
