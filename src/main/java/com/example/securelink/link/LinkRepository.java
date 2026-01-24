package com.example.securelink.link;

import java.util.Optional;

public interface LinkRepository {

    Optional<Link> findByToken(String token);

    void save(Link link);
}
