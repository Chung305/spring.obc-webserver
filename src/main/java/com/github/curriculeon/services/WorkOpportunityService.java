package com.github.curriculeon.services;

import com.github.curriculeon.models.workopportunity.WorkOpportunity;
import com.github.curriculeon.repositories.WorkOpportunityRepository;
import com.github.curriculeon.utils.SimpleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leonhunter
 * @created 03/22/2020 - 5:21 PM
 */
@Service
public class WorkOpportunityService {
    private SimpleServiceImpl<Long, WorkOpportunity, WorkOpportunityRepository> simpleService;

    @Autowired
    public WorkOpportunityService(WorkOpportunityRepository repository) {
        this.simpleService = new SimpleServiceImpl<>(repository);
    }

    public WorkOpportunityRepository getRepository() {
        return simpleService.getRepository();
    }

    public List<WorkOpportunity> findAll() {
        return simpleService.findAll();
    }

    public WorkOpportunity findById(Long id) {
        return simpleService.findById(id);
    }

    public WorkOpportunity create(WorkOpportunity myModel) {
        return simpleService.create(myModel);
    }

    public WorkOpportunity update(Long id, WorkOpportunity myModel) {
        return simpleService.update(id, myModel);
    }

    public WorkOpportunity delete(Long id) {
        return simpleService.delete(id);
    }
}
