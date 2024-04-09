package com.rest_hrm.business.mappers;

import com.rest_hrm.business.dto.AddressDto;
import com.rest_hrm.business.dto.DepartmentDto;
import com.rest_hrm.persistence.entities.Address;
import com.rest_hrm.persistence.entities.Department;

public class DepartmentMapper extends GenericMapping<Department, DepartmentDto> {

    private static DepartmentMapper instance;

    private DepartmentMapper(){
        if (instance!=null){
            throw new RuntimeException("wld 3eeb");
        }
    }

    public static synchronized DepartmentMapper getInstance(){
        if (instance == null){
            instance = new DepartmentMapper();
        }
        return instance;
    }}
