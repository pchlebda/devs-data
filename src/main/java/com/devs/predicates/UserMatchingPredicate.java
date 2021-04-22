package com.devs.predicates;

import com.devs.reader.User;

import java.util.function.Predicate;

public class UserMatchingPredicate implements Predicate<User> {
    @Override
    public boolean test(User user) {
        final String email = user.getEmail();
        final String name = user.getFirstName() + "." + user.getLastName() + "@domain.com";
        return email.equals(name);
    }
}
