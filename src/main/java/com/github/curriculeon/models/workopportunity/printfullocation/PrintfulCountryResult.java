package com.github.curriculeon.models.workopportunity.printfullocation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.curriculeon.utils.Jsonifier;
import com.github.curriculeon.utils.services.EntityInterface;

import javax.persistence.*;
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

    @OneToMany
    private List<PrintfulCountry> result;

    public PrintfulCountryResult() {
    }

    public PrintfulCountryResult(Long id, Integer code, List<PrintfulCountry> result) {
        this.id = id;
        this.code = code;
        this.result = result;
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

    public List<PrintfulCountry> getResult() {
        return result;
    }

    public void setResult(List<PrintfulCountry> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return Jsonifier.jsonify(this);
    }
}
