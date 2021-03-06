package com.github.curriculeon.models.workopportunity;

import com.github.curriculeon.utils.services.EntityInterface;

import javax.persistence.*;

/**
 * @author leonhunter
 * @created 03/22/2020 - 3:07 PM
 */
@Entity
public class WorkOpportunity implements EntityInterface<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private League league;

    @OneToOne
    private PayAmount payAmount;

    @Enumerated
    private CountryEnum countryOfPosting;
    private Boolean housingIncluded;
    private String title;
    private String dateNeededBy;
    private String description;

    public WorkOpportunity() {
    }

    public WorkOpportunity(Long id, League league, PayAmount payAmount, CountryEnum countryOfPosting, Boolean housingIncluded, String title, String dateNeededBy, String description) {
        this.id = id;
        this.league = league;
        this.payAmount = payAmount;
        this.countryOfPosting = countryOfPosting;
        this.housingIncluded = housingIncluded;
        this.title = title;
        this.dateNeededBy = dateNeededBy;
        this.description = description;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public PayAmount getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(PayAmount payAmount) {
        this.payAmount = payAmount;
    }

    public CountryEnum getCountryOfPosting() {
        return countryOfPosting;
    }

    public void setCountryOfPosting(CountryEnum countryOfPosting) {
        this.countryOfPosting = countryOfPosting;
    }

    public Boolean getHousingIncluded() {
        return housingIncluded;
    }

    public void setHousingIncluded(Boolean housingIncluded) {
        this.housingIncluded = housingIncluded;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateNeededBy() {
        return dateNeededBy;
    }

    public void setDateNeededBy(String dateNeededBy) {
        this.dateNeededBy = dateNeededBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
