package com.github.curriculeon.models.workopportunity;

import com.github.curriculeon.utils.EntityInterface;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author leonhunter
 * @created 03/22/2020 - 3:32 PM
 */
@Entity
public class League implements EntityInterface<Long> {
    @Id
    @GeneratedValue
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
