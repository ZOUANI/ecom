package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Category;


@Repository
public interface CategoryDao extends JpaRepository<Category,Long> {

	Category findByLabel(String label);
       int deleteByLabel(String label);


}