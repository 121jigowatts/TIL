package com.jigowatts.soap_server.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import com.jigowatts.soap_server.User;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserRepository {
    private static final Map<Integer, User> users = new HashMap<>();

    @PostConstruct
    public void initData() {
        User alice = new User();
        alice.setId(1);
        alice.setName("Alice");

        users.put(alice.getId(), alice);

        User bob = new User();
        bob.setId(2);
        bob.setName("Bob");

        users.put(bob.getId(), bob);

        User cindy = new User();
        cindy.setId(3);
        cindy.setName("Cindy");

        users.put(cindy.getId(), cindy);
    }

    public User findUser(int id) {
        Assert.notNull(id, "The user's ID must not be null");
        return users.get(id);
    }
}