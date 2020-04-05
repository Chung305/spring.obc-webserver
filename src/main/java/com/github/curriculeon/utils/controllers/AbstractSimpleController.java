package com.github.curriculeon.utils.controllers;

import com.github.curriculeon.utils.services.EntityInterface;
import com.github.curriculeon.utils.services.SimpleServiceInterface;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author leonhunter
 * @created 03/27/2020 - 5:23 PM
 */
@MappedSuperclass
public class AbstractSimpleController<
        IdType extends Serializable,
        EntityType extends EntityInterface<IdType>,
        CrudRepositoryType extends CrudRepository<EntityType, IdType>,
        ServiceType extends SimpleServiceInterface<IdType, EntityType, CrudRepositoryType>>
        implements SimpleControllerInterface<IdType, EntityType, CrudRepositoryType, ServiceType> {
    private ServiceType service;

    public AbstractSimpleController(ServiceType service) {
        this.service = service;
    }

    @Override
    public ServiceType getService() {
        return service;
    }
}
