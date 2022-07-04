package com.axyya.server.repository;

import com.axyya.server.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServerRepo extends MongoRepository<Server, Integer> {
    @Query("{name:?0}")
    List<Server> findServerByName(String name);
}
