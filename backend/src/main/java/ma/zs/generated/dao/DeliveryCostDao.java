package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.DeliveryCost;


@Repository
public interface DeliveryCostDao extends JpaRepository<DeliveryCost,Long> {


       List<DeliveryCost> findByCityName(String name);
       int deleteByCityName(String name);       
       List<DeliveryCost> findByCityId(Long id);
       int deleteByCityId(Long id);
       List<DeliveryCost> findByDeliveryCode(String code);
       int deleteByDeliveryCode(String code);       
       List<DeliveryCost> findByDeliveryId(Long id);
       int deleteByDeliveryId(Long id);

}