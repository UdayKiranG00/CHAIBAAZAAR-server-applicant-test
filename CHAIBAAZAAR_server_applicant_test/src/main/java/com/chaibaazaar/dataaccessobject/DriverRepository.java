package com.chaibaazaar.dataaccessobject;
import com.chaibaazaar.domainobject.DriverDO;
import com.chaibaazaar.domainvalue.OnlineStatus;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface DriverRepository extends CrudRepository<DriverDO, Long>
{

    List<DriverDO> findByOnlineStatus(OnlineStatus onlineStatus);
}
