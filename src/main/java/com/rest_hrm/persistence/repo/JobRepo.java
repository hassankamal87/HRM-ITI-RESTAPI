package com.rest_hrm.persistence.repo;

import com.rest_hrm.persistence.entities.Job;
import jakarta.persistence.EntityManager;

public class JobRepo extends CrudRepo<Job,Integer> {
    public JobRepo(EntityManager entityManager) {
        super(entityManager);
    }
}
