package com.example.test.mapper;

import com.example.test.dto.AccountCreateRequest;
import com.example.test.entity.Account;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {
    Account getEntityFromRequest(AccountCreateRequest accountCreateRequest);
}
