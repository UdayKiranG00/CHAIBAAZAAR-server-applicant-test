package com.chaibaazaar.dataaccessobject;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chaibaazaar.domainobject.CarDO;

public interface CarRepository extends CrudRepository<CarDO, Long>{
	
	
	List<CarDO> findByIsbooked(boolean isbooked);

	CarDO findByDriverId(Long driverId);
}
