package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.DeliveryType;


@Repository
public interface DeliveryTypeDao extends JpaRepository<DeliveryType,Long> {

	DeliveryType findByLabel(String label);
       int deleteByLabel(String label);


}