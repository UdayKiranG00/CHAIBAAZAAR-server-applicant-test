package com.chaibaazaar.domainobject;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="Car")
public class CarDO {

	
	@Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();
    
    @Column(nullable=false)
    @NotNUll(message="license_plate number can not be null")
    private String license_plate;
    
    @Column(nullable=false)
    @NotNUll(message="seat_count number can not be null")
    private int seat_count;
    
    @Column(nullable=false)
    private boolean convertible;
    
    @Column(nullable=false)
    @NotNUll(message="engine_type can not be null")
    private String engine_type;
    
    @Column(nullable=false)
    @NotNUll(message="cc can not be null")
    private int cc;
    
    @Column(nullable=false)
    @NotNUll(message="rating can not be null")
    private int rating;
    
    @Column(nullable=false)
    private boolean isBooked;
    
    @Column
    private long driverId;
    
    public CarDO(String license_plate,int seat_count,boolean convertible,String engine_type,int cc,int rating) {
    	this.license_plate=license_plate;
    	this.seat_count=seat_count;
    	this.convertible=convertible;
    	this.engine_type=engine_type;
    	this.cc=cc;
    	this.rating=rating;
    	this.isBooked=false;
    	this.driverId=0;
    }


	public long getDriverId() {
		return driverId;
	}


	public void setDriverId(long driverId) {
		this.driverId = driverId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
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


	public boolean isisBooked() {
		return isBooked;
	}


	public void setisBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
    
    
}
