package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Stock;


@Repository
public interface StockDao extends JpaRepository<Stock,Long> {


       List<Stock> findByCityName(String name);
       int deleteByCityName(String name);       
       List<Stock> findByCityId(Long id);
       int deleteByCityId(Long id);
       List<Stock> findByProductReference(String reference);
       int deleteByProductReference(String reference);       
       List<Stock> findByProductId(Long id);
       int deleteByProductId(Long id);
       List<Stock> findByAdminCode(String code);
       int deleteByAdminCode(String code);       
       List<Stock> findByAdminId(Long id);
       int deleteByAdminId(Long id);

}