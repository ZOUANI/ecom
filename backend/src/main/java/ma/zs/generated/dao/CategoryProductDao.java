package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.CategoryProduct;


@Repository
public interface CategoryProductDao extends JpaRepository<CategoryProduct,Long> {


       List<CategoryProduct> findByCategoryLabel(String label);
       int deleteByCategoryLabel(String label);       
       List<CategoryProduct> findByCategoryId(Long id);
       int deleteByCategoryId(Long id);
       List<CategoryProduct> findByProductReference(String reference);
       int deleteByProductReference(String reference);       
       List<CategoryProduct> findByProductId(Long id);
       int deleteByProductId(Long id);

}