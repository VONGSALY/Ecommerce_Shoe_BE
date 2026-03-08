package com.example.test.service.account;

import com.example.test.base.error_success_handle.SuccessResponse;
import com.example.test.dto.AccountCreateRequest;
import com.example.test.dto.account.*;
import com.example.test.entity.AccountDetail;
import org.springframework.data.domain.Pageable;

import javax.mail.MessagingException;
import java.util.List;

public interface AccountService {
    SuccessResponse singUp(AccountCreateRequest account);
    TokenAndRole login(LoginRequest loginRequest);
    AccountResponse findByUsername(String username);
    SuccessResponse forgotPassword(ForgotPassRequest forgotPassRequest) throws MessagingException;
    AccountResponse getDetailById(Long id);
    SuccessResponse changePassword(ChangePasswordRequest changePasswordRequest);
    AccountDetail updateProfile(AccountUpdateRequest accountUpdateRequest);
    AccountResponse createAccount( AccountCreateRequest accountCreateRequest );
    Long countAccount();
    Integer getTotalPage();
    List<AccountResponse> findUserByRole(String roleName, Pageable pageable);
    List<AccountResponse> findAllUser(Pageable pageable);
}
