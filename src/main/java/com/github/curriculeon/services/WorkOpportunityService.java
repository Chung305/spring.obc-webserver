package com.github.curriculeon.services;

import com.github.curriculeon.models.workopportunity.WorkOpportunity;
import com.github.curriculeon.repositories.WorkOpportunityRepository;
import com.github.curriculeon.utils.services.AbstractSimpleService;
import com.github.curriculeon.utils.services.SimpleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author leonhunter
 * @created 03/22/2020 - 5:21 PM
 */
@Service
public class WorkOpportunityService extends AbstractSimpleService<Long, WorkOpportunity, WorkOpportunityRepository>  {
    public WorkOpportunityService(WorkOpportunityRepository crudRepository) {
        super(crudRepository);
    }

    @Override
    public WorkOpportunity update(WorkOpportunity databaseValue, WorkOpportunity newEntityData) {
        databaseValue.setCountryOfPosting(newEntityData.getCountryOfPosting());
        databaseValue.setDateNeededBy(newEntityData.getDateNeededBy());
        databaseValue.setDescription(newEntityData.getDescription());
        databaseValue.setGender(newEntityData.getGender());
        databaseValue.setHousingIncluded(newEntityData.getHousingIncluded());
        databaseValue.setLeague(newEntityData.getLeague());
        databaseValue.setPayAmount(newEntityData.getPayAmount());
        databaseValue.setTitle(newEntityData.getTitle());
        getRepository().save(databaseValue);
        return databaseValue;
    }
}
