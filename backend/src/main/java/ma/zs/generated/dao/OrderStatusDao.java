package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.OrderStatus;


@Repository
public interface OrderStatusDao extends JpaRepository<OrderStatus,Long> {

	OrderStatus findByLabel(String label);
       int deleteByLabel(String label);


}