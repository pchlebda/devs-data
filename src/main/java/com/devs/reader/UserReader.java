package com.devs.reader;

import java.io.InputStream;
import java.util.List;

public interface UserReader {

    List<User> readAllUsersMatching(InputStream inputStream);
}
