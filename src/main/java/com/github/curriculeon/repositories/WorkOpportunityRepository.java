package com.github.curriculeon.repositories;

import com.github.curriculeon.models.workopportunity.WorkOpportunity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author leonhunter
 * @created 03/22/2020 - 5:21 PM
 */
@Repository
public interface WorkOpportunityRepository extends CrudRepository<WorkOpportunity, Long> {
}
