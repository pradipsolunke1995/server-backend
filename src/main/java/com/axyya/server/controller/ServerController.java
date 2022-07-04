package com.axyya.server.controller;

import com.axyya.server.model.Server;
import com.axyya.server.service.ServerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://editor.swagger.io/")
@RequestMapping("/server")
public class ServerController {
    @Autowired
    private ServerService serverService;

    /**GetMapping endpoint
     * getAllServer end point returns the list of server present in database
     * return type is list of server objects
     */
    @Operation(tags = {"To fetch all the data from DB"},description = "returns the list of server present in database and return type is list of server objects")
    @GetMapping("/")
    public List<Server> getAllServer() {
        return serverService.getAllServerDetails();
    }
    /**PutMapping endpoint
     * saveDetails end point saves the jason data into server object
     * return type is ResponseEntity status
     */

    @Operation(tags = {"To save the data to DB"},description = "return type is ResponseEntity status")
    @PutMapping("/saveData")
    public ResponseEntity<String> saveDetails(@RequestBody Server server){
        serverService.saveServerData(server);
        return ResponseEntity.ok().body("Data Saved !");
    }
    /**GetMapping endpoint
     * getServerByName end point returns the list of server present in database by searching with server name
     * return type is list of server objects with found record
     * if record not found in database returns 404 error status
     */

    @Operation(tags = {"To search the data by name from DB"}, description = "return type is list of server objects with found record, if record not found in database returns 404 error status ")
    @GetMapping("/serverList/{name}")
    public List<Server> getServerByName(@PathVariable("name") String name) {

        List<Server> serverByName = serverService.findServerByName(name);

        return serverByName;
    }
    /**DeleteMapping endpoint
     * deleteServerById end point deletes a record from database with passed id in url
     * return type is ResponseEntity status
     */
    @Operation(tags = {"Deletes a record from DB with referred id"})
    @DeleteMapping("/deleteServerById/{id}")
    public ResponseEntity<String> deleteServerById(@PathVariable("id") Integer id){
        serverService.deleteById(id);
        return ResponseEntity.ok().body("Data Deleted !");
    }
}
