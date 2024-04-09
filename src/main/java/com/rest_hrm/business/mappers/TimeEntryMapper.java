package com.rest_hrm.business.mappers;

import com.rest_hrm.business.dto.HolidayDto;
import com.rest_hrm.business.dto.TimeEntryDto;
import com.rest_hrm.persistence.entities.Holiday;
import com.rest_hrm.persistence.entities.TimeEntry;

public class TimeEntryMapper extends GenericMapping<TimeEntry, TimeEntryDto> {

    private static TimeEntryMapper instance;

    private TimeEntryMapper(){
        if (instance!=null){
            throw new RuntimeException("wld 3eeb");
        }
    }

    public static synchronized TimeEntryMapper getInstance(){
        if (instance == null){
            instance = new TimeEntryMapper();
        }
        return instance;
    }
}
