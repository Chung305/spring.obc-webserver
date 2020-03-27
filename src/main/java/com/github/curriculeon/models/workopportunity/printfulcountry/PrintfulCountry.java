package com.github.curriculeon.models.workopportunity.printfulcountry;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.curriculeon.utils.services.EntityInterface;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * @author leonhunter
 * @created 03/27/2020 - 6:46 PM
 */
@Entity
public class PrintfulCountry implements EntityInterface<Long> {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String code;
    private List<PrintfulState> stateList;

    public PrintfulCountry() {
    }

    public PrintfulCountry(Long id, String name, String code, List<PrintfulState> stateList) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.stateList = stateList;
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

    public List<PrintfulState> getStateList() {
        return stateList;
    }

    public void setStateList(List<PrintfulState> stateList) {
        this.stateList = stateList;
    }
}
