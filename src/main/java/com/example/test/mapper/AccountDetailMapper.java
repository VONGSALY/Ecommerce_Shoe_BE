package com.example.test.mapper;

import com.example.test.dto.AccountCreateRequest;
import com.example.test.dto.account.AccountUpdateRequest;
import com.example.test.entity.AccountDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface AccountDetailMapper {
    AccountDetail getEntityFromRequest(AccountCreateRequest account);
    void updateEntityByUpdateAccount(@MappingTarget AccountDetail accountDetail, AccountUpdateRequest updateAccountRequest);
}
