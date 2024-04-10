package com.rest_hrm;

import com.rest_hrm.business.dto.AddressDto;
import com.rest_hrm.business.service.AddressService;
import com.rest_hrm.business.service.DepartmentService;

import java.util.List;

public class App {
    public static void main(String[] args) {


        AddressService service = new AddressService();
        List<AddressDto> allAddresses = service.getAllAddresses();
        allAddresses.forEach(System.out::println);
    }
}
