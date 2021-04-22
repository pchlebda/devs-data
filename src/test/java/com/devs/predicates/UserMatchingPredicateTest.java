package com.devs.predicates;

import com.devs.reader.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserMatchingPredicateTest {

    private UserMatchingPredicate testee;

    @BeforeEach
    void beforeEach() {
        testee = new UserMatchingPredicate();
    }

    @Test
    void shouldMatchUser() {
        //given
        User user = User.builder()
                .firstName("firstName")
                .lastName("lastName")
                .email("firstName.lastName@domain.com")
                .build();
        //when
        boolean actual = testee.test(user);

        //then
        Assertions.assertTrue(actual);
    }

    @Test
    void shouldNotMatchUser() {
        //given
        User user = User.builder()
                .firstName("firstName")
                .lastName("lastName")
                .email("lastName.firstName@domain.com")
                .build();
        //when
        boolean actual = testee.test(user);

        //then
        Assertions.assertFalse(actual);
    }
}