package com.axyya.server.service;

import com.axyya.server.model.Server;

import java.util.List;

public interface ServerService {
    /**returns list of server objects
     */
    List<Server> getAllServerDetails();

    /**
     * saves the server data
     *
     */
    void saveServerData(Server server);

    List<Server> findServerByName(String name);

    void deleteById(Integer id);
}
