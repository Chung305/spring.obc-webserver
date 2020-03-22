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
    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }
}
