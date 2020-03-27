package com.github.curriculeon.models.workopportunity;

import com.github.curriculeon.utils.services.EntityInterface;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author leonhunter
 * @created 03/22/2020 - 3:32 PM
 */
@Entity
public class PayAmount implements EntityInterface<Long> {
    enum TemporalUnit { MONTH, DAY, YEAR; }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double value;
    private Integer frequency;
    private TemporalUnit temporalUnit;
    public PayAmount() {
    }

    public PayAmount(Double value, Integer frequency, TemporalUnit temporalUnit) {
        this.value = value;
        this.frequency = frequency;
        this.temporalUnit = temporalUnit;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public TemporalUnit getTemporalUnit() {
        return temporalUnit;
    }

    public void setTemporalUnit(TemporalUnit temporalUnit) {
        this.temporalUnit = temporalUnit;
    }
}
