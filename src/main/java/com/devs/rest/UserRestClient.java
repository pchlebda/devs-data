package com.devs.rest;

import com.devs.reader.User;

import java.util.List;

public interface UserRestClient {

    void sendUsers(List<User> users);

}
