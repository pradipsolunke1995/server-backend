package com.axyya.server.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString

@Document(collection = "Server")
public class Server {

    private String name;
    @Id
    private Integer id;

    private String language;

    private String framework;
}
