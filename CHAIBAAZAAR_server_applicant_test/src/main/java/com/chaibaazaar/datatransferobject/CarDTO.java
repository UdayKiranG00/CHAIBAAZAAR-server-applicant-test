package com.chaibaazaar.datatransferobject;

import javax.persistence.Column;

import com.chaibaazaar.domainobject.CarDO;
import com.chaibaazaar.domainobject.NotNUll;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {

	@JsonIgnore
    private Long id;
	
    @NotNUll(message="license_plate number can not be null")
    private String license_plate;
    
    @NotNUll(message="seat_count number can not be null")
    private int seat_count;
    
    private boolean convertible;
    
    @NotNUll(message="engine_type can not be null")
    private String engine_type;
    
    @NotNUll(message="cc can not be null")
    private int cc;
    
    @NotNUll(message="rating can not be null")
    private int rating;
    
    public CarDTO(CarDO carDO) {
    	this.id=carDO.getId();
    	this.license_plate=carDO.getLicense_plate();
    	this.seat_count=carDO.getSeat_count();
    	this.convertible=carDO.isConvertible();
    	this.engine_type=carDO.getEngine_type();
    	this.cc=carDO.getCc();
    	this.rating=carDO.getRating();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicense_plate() {
		return license_plate;
	}

	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}

	public int getSeat_count() {
		return seat_count;
	}

	public void setSeat_count(int seat_count) {
		this.seat_count = seat_count;
	}

	public boolean isConvertible() {
		return convertible;
	}

	public void setConvertible(boolean convertible) {
		this.convertible = convertible;
	}

	public String getEngine_type() {
		return engine_type;
	}

	public void setEngine_type(String engine_type) {
		this.engine_type = engine_type;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
