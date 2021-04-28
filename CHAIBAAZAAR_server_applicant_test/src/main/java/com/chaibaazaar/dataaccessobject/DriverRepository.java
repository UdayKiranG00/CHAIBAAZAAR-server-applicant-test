package com.chaibaazaar.dataaccessobject;
import com.chaibaazaar.datatransferobject.DriverDTO;
import com.chaibaazaar.domainobject.DriverDO;
import com.chaibaazaar.domainvalue.OnlineStatus;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface DriverRepository extends JpaRepository<DriverDO, Long>
{

    List<DriverDO> findByOnlineStatus(OnlineStatus onlineStatus);
    
    @Query("SELECT d.driverId,d.username,d.password,d.coordinate FROM driver d INNERJOIN car c ON"
    		+ "d.driverId=c.driverId where CONCAT(d.username,d.onlineStatus,c.license_plate,c.rating) LIKE %?1%")
    public List<DriverDTO> findAllByDifferentParam(String keyWord);
}
