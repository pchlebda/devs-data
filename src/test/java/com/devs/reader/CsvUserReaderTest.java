package com.devs.reader;

import com.devs.mapper.UserCsvMapper;
import com.devs.predicates.UserMatchingPredicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

class CsvUserReaderTest {

    private UserReader testee;

    @BeforeEach
    void beforeEach() {
        testee = new CsvUserReader(new UserCsvMapper(), new UserMatchingPredicate());
    }

    @Test
    void shouldRead1User() throws FileNotFoundException {
        //when
        List<User> users = testee.readAllUsersMatching(new FileInputStream("src/test/resources/csv/sample.csv"));

        //then
        Assertions.assertEquals(1, users.size());
    }

    @Test
    void shouldRead0User() throws FileNotFoundException {
        //when
        List<User> users = testee.readAllUsersMatching(new FileInputStream("src/test/resources/csv/non-user.csv"));

        //then
        Assertions.assertEquals(0, users.size());
    }
}