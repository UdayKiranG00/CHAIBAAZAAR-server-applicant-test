package com.chaibaazaar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chaibaazaar.controller.mapper.CarMapper;
import com.chaibaazaar.datatransferobject.CarDTO;
import com.chaibaazaar.domainobject.CarDO;
import com.chaibaazaar.exception.ConstraintsViolationException;
import com.chaibaazaar.exception.EntityNotFoundException;
import com.chaibaazaar.service.driver.CarService;


@RestController
@RequestMapping("v1/cars")
public class CarController {
	
	private final CarService carService;


    @Autowired
    public CarController(final CarService carService) {
        this.carService = carService;
    }
    
    @PostMapping
    public CarDTO create(@Validated @RequestBody CarDTO carDTO) throws ConstraintsViolationException {
    	CarDO carDO=CarMapper.makeCarDO(carDTO);
    	return CarMapper.makeCarDTO(carService.create(carDO));
    }
    
    @GetMapping("/{carId}")
    public CarDTO find(@PathVariable Long carId) throws EntityNotFoundException {
    	return CarMapper.makeCarDTO(carService.find(carId));
    }
    
    @DeleteMapping("/{carId}")
    public void delete(@PathVariable Long carId) throws EntityNotFoundException {
    	carService.delete(carId);
    }
    
    @GetMapping
    public List<CarDTO> findByBookedOrNot(@RequestParam boolean isbooked){
    	return CarMapper.makeCarDTOList(carService.findAll(isbooked));
    }
}
