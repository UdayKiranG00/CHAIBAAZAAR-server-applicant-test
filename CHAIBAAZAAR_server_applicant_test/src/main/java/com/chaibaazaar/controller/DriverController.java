package com.chaibaazaar.controller;

import com.chaibaazaar.controller.mapper.DriverMapper;
import com.chaibaazaar.datatransferobject.DriverDTO;
import com.chaibaazaar.domainobject.DriverDO;
import com.chaibaazaar.domainvalue.OnlineStatus;
import com.chaibaazaar.exception.CarAlreadyInUseException;
import com.chaibaazaar.exception.ConstraintsViolationException;
import com.chaibaazaar.exception.EntityNotFoundException;
import com.chaibaazaar.service.driver.CarService;
import com.chaibaazaar.service.driver.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * All operations with a driver will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/drivers")
public class DriverController {

    


    @Autowired
    private DriverService driverService;

    @Autowired
    private CarService carService;

    @GetMapping("/{driverId}")
    public DriverDTO getDriver(@PathVariable long driverId) throws EntityNotFoundException {
        return DriverMapper.makeDriverDTO(driverService.find(driverId));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DriverDTO createDriver(@Valid @RequestBody DriverDTO driverDTO) throws ConstraintsViolationException {
        DriverDO driverDO = DriverMapper.makeDriverDO(driverDTO);
        return DriverMapper.makeDriverDTO(driverService.create(driverDO));
    }


    @DeleteMapping("/{driverId}")
    public void deleteDriver(@PathVariable long driverId) throws EntityNotFoundException {
        driverService.delete(driverId);
    }


    @PutMapping("/{driverId}")
    public void updateLocation(
            @PathVariable long driverId, @RequestParam double longitude, @RequestParam double latitude)
            throws EntityNotFoundException {
        driverService.updateLocation(driverId, longitude, latitude);
    }


    @GetMapping
    public List<DriverDTO> findDrivers(@RequestParam OnlineStatus onlineStatus)
    {
        return DriverMapper.makeDriverDTOList(driverService.find(onlineStatus));
    }
    
    
    @PutMapping("/{carId}")
    public void selectCar(@RequestParam Long driverId,@PathVariable Long carId) throws EntityNotFoundException, CarAlreadyInUseException {
    	carService.select(driverId, carId);
    }
    
    @PutMapping("/{driverId}")
    public void deselectCar(@PathVariable Long driverId) throws EntityNotFoundException {
    	carService.deselect(driverId);
    }
    
    @GetMapping
    public List<DriverDTO> findAllDriversByDifferentParam(@RequestParam String keyWord) throws EntityNotFoundException{
    	return driverService.findAllDriversByDifferentParam(keyWord);
    }
    
}
