package com.chaibaazaar.service.driver;

import java.util.List;

import com.chaibaazaar.domainobject.CarDO;
import com.chaibaazaar.exception.CarAlreadyInUseException;
import com.chaibaazaar.exception.ConstraintsViolationException;
import com.chaibaazaar.exception.EntityNotFoundException;

public interface CarService {

	
	CarDO create(CarDO carDO) throws ConstraintsViolationException;
	CarDO find(Long carId) throws EntityNotFoundException;
	void delete(Long carId) throws EntityNotFoundException;
	void select(Long driverId,Long carId) throws EntityNotFoundException, CarAlreadyInUseException;
	void deselect(Long driverId) throws EntityNotFoundException;
	List<CarDO> findAll(boolean isbooked);
}
