package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.OrderLine;


@Repository
public interface OrderLineDao extends JpaRepository<OrderLine,Long> {


       List<OrderLine> findByCommandReference(String reference);
       int deleteByCommandReference(String reference);       
       List<OrderLine> findByCommandId(Long id);
       int deleteByCommandId(Long id);
       List<OrderLine> findByProductReference(String reference);
       int deleteByProductReference(String reference);       
       List<OrderLine> findByProductId(Long id);
       int deleteByProductId(Long id);

}