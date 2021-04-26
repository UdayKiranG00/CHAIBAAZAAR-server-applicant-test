package com.chaibaazaar.service.driver;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import com.chaibaazaar.dataaccessobject.CarRepository;
import com.chaibaazaar.domainobject.CarDO;
import com.chaibaazaar.exception.CarAlreadyInUseException;
import com.chaibaazaar.exception.ConstraintsViolationException;
import com.chaibaazaar.exception.EntityNotFoundException;

public class DefaultCarService implements CarService{

	
	private static final Logger LOG = LoggerFactory.getLogger(DefaultDriverService.class);
	
    @Autowired
    private CarRepository carRepository;
        
    private CarDO findCarChecked(Long carId) throws EntityNotFoundException
    {
        return carRepository.findById(carId)
                .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + carId));
    }
	@Override
	public CarDO create(CarDO carDO) throws ConstraintsViolationException {
		CarDO cardo;
		try {
			cardo=carRepository.save(carDO);
		}catch(DataIntegrityViolationException e) {
			LOG.warn("ConstraintsViolationException while creating a driver: {}", carDO, e);
			throw new ConstraintsViolationException(e.getMessage());
		}
		return cardo;
	}
	@Override
	public CarDO find(Long carId) throws EntityNotFoundException{
		return findCarChecked(carId);
	}
	@Override
	@Transactional
	public void delete(Long carId) throws EntityNotFoundException{
		CarDO carDO=findCarChecked(carId);
		carRepository.delete(carDO);
	}
	@Override
	@Transactional
	public void select(Long driverId, Long carId) throws EntityNotFoundException, CarAlreadyInUseException{
		CarDO carDO=findCarChecked(carId);
		if(carDO.isisBooked()==false) {
			carDO.setisBooked(true);
			carDO.setDriverId(driverId);
		}else {
			throw new CarAlreadyInUseException("Car is already in use"+carId);
		}
	}
	
	@Override
	@Transactional
	public void deselect(Long driverId) throws EntityNotFoundException {
		CarDO carDO;
		try {
			carDO=carRepository.findByDriverId(driverId);
		}catch(Exception e) {
			throw new EntityNotFoundException("no car is found"+e.getMessage());
		}
		carDO.setisBooked(false);
		carDO.setDriverId(0);
	}
	
	@Override
	public List<CarDO> findAll(boolean isbooked){
		List<CarDO> lOfCars=carRepository.findByIsbooked(isbooked);
		return lOfCars;
	}
}
