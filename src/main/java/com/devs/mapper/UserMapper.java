package com.devs.mapper;

import com.devs.reader.User;

public interface UserMapper {

    User fromCsvLine(final String line);
}
