package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.City;


@Repository
public interface CityDao extends JpaRepository<City,Long> {

	City findByName(String name);
       int deleteByName(String name);


}