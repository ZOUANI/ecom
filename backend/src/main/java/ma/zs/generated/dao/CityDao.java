package ma.zs.generated.dao;

import ma.zs.generated.ws.rest.provided.vo.CityVo;
import ma.zs.generated.ws.rest.provided.vo.ClientVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import ma.zs.generated.bean.City;


@Repository
public interface CityDao extends JpaRepository<City, Long> {

    City findByName(String name);

    int deleteByName(String name);

    @Query("select new ma.zs.generated.ws.rest.provided.vo.CityVo( c.client.city.name, count (c.id)) from Command c  where c.orderDate BETWEEN :start AND :end group by c.client.city order by count (c.id) DESC,sum(c.total) DESC")
    public List<CityVo> findTopfiveCity(@Param("start") Date start, @Param("end") Date end);

}