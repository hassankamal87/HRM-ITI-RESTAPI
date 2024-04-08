package com.rest_hrm.persistence.repo;

import com.rest_hrm.persistence.entities.Address;
import jakarta.persistence.EntityManager;

public class AddressRepo extends CrudRepo<Address, Integer> {
    public AddressRepo(EntityManager entityManager) {
        super(entityManager);
    }
}
