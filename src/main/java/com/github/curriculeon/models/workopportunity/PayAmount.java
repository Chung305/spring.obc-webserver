package com.github.curriculeon.models.workopportunity;

/**
 * @author leonhunter
 * @created 03/22/2020 - 3:32 PM
 */
public class PayAmount {
    enum TemporalUnit { MONTH, DAY, YEAR; }

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
