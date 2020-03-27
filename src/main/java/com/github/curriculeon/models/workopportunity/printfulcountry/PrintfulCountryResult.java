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
 * @created 03/27/2020 - 6:44 PM
 */

@Entity
public class PrintfulCountryResult implements EntityInterface<Long> {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer code;
    private List<PrintfulCountry> countryList;

    public PrintfulCountryResult() {
    }

    public PrintfulCountryResult(Long id, Integer code, List<PrintfulCountry> countryList) {
        this.id = id;
        this.code = code;
        this.countryList = countryList;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<PrintfulCountry> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<PrintfulCountry> countryList) {
        this.countryList = countryList;
    }
}
