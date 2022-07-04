package com.axyya.server.service;

import com.axyya.server.model.Server;
import com.axyya.server.repository.ServerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServerServiceImpl implements ServerService{
    @Autowired
    private ServerRepo serverRepo;

    @Override
    public List<Server> getAllServerDetails() {
        return serverRepo.findAll();
    }

    @Override
    public void saveServerData(Server server) {
        serverRepo.save(server);
    }

    @Override
    public List<Server> findServerByName(String name) {
        List<Server> serverByName = serverRepo.findServerByName(name);
        if(serverByName.isEmpty()) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return serverByName;
    }

    @Override
    public void deleteById(Integer id) {
        serverRepo.deleteById(id);
    }
}
