package com.rest_hrm.business.mappers;

import com.rest_hrm.business.dto.HolidayDto;
import com.rest_hrm.business.dto.JobDto;
import com.rest_hrm.persistence.entities.Holiday;
import com.rest_hrm.persistence.entities.Job;

public class HolidayMapper extends GenericMapping<Holiday, HolidayDto> {

    private static HolidayMapper instance;

    private HolidayMapper(){
        if (instance!=null){
            throw new RuntimeException("wld 3eeb");
        }
    }

    public static synchronized HolidayMapper getInstance(){
        if (instance == null){
            instance = new HolidayMapper();
        }
        return instance;
    }
}
