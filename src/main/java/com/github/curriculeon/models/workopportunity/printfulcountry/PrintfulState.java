package com.github.curriculeon.models.workopportunity.printfulcountry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.curriculeon.utils.services.EntityInterface;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author leonhunter
 * @created 03/27/2020 - 6:47 PM
 */
@Entity
public class PrintfulState implements EntityInterface<Long> {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String code;

    public PrintfulState() {
    }

    public PrintfulState(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
