package com.chaibaazaar.service.driver;

import com.chaibaazaar.domainobject.DriverDO;
import com.chaibaazaar.domainvalue.OnlineStatus;
import com.chaibaazaar.exception.ConstraintsViolationException;
import com.chaibaazaar.exception.EntityNotFoundException;
import java.util.List;

public interface DriverService
{

    DriverDO find(Long driverId) throws EntityNotFoundException;

    DriverDO create(DriverDO driverDO) throws ConstraintsViolationException;

    void delete(Long driverId) throws EntityNotFoundException;

    void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException;

    List<DriverDO> find(OnlineStatus onlineStatus);

}
