package com.example.test.base.black_list;

public interface BlackList {
    void putToUpdateAccountBlackList(Long userId);
    void putToLogOutAccountBlackList(String accessToken);
}
