package com.example.securelink.link;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryLinkRepository implements LinkRepository {

    private final Map<String, Link> store = new HashMap<>();

    @Override
    public Optional<Link> findByToken(String token) {
        return Optional.ofNullable(store.get(token));
    }

    @Override
    public void save(Link link) {
        store.put(link.getToken(), link);
    }
}
