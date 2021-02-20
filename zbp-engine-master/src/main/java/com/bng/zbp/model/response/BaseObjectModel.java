package com.bng.zbp.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @Author Mansi Rajora
 */

public class BaseObjectModel {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("crdt")
    private Date crdt;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;


    public BaseObjectModel() {
        super();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCrdt() {
        return crdt;
    }

    public void setCrdt(Date crdt) {
        this.crdt = crdt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}