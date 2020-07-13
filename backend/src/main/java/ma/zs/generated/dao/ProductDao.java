package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Product;


@Repository
public interface ProductDao extends JpaRepository<Product,Long> {

	Product findByReference(String reference);
       int deleteByReference(String reference);


}