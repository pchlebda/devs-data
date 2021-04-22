package com.devs.reader;

import com.devs.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Slf4j
public class CsvUserReader implements UserReader {

    private final UserMapper userMapper;
    private final Predicate<User> predicate;

    @Override
    public List<User> readAllUsersMatching(InputStream inputStream) {
        List<User> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(inputStream)) {
            log.info("Start scanning csv file.");
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                User user = userMapper.fromCsvLine(line);
                if (predicate.test(user)) {
                    result.add(user);
                }
            }
        }
        log.info("Found {} lines matching criteria.", result.size());
        return result;
    }
}
