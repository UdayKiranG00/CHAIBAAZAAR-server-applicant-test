package com.chaibaazaar.controller.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.chaibaazaar.datatransferobject.CarDTO;
import com.chaibaazaar.datatransferobject.DriverDTO;
import com.chaibaazaar.domainobject.CarDO;
import com.chaibaazaar.domainobject.DriverDO;

public class CarMapper {

	public static CarDO makeCarDO(CarDTO carDTO)
    {
        return new CarDO(carDTO.getLicense_plate(), carDTO.getSeat_count(),carDTO.isConvertible(),carDTO.getEngine_type(),carDTO.getCc(),carDTO.getRating());
    }
	
	public static CarDTO makeCarDTO(CarDO carDO) {
		
		
		return new CarDTO(carDO);
	}
	public static List<CarDTO> makeCarDTOList(Collection<CarDO> drivers)
    {
        return drivers.stream()
            .map(CarMapper::makeCarDTO)
            .collect(Collectors.toList());
    }
}
