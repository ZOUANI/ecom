package ma.zs.generated.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.zs.generated.bean.User;
import ma.zs.generated.ws.rest.provided.vo.UserVo;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByCode(String code);

    int deleteByCode(String code);

    List<User> findByAuthorityAuthority(String authority);

    int deleteByAuthorityAuthority(String authority);

    List<User> findByAuthorityId(Long id);

    int deleteByAuthorityId(Long id);

    List<User> findBySuperAdminCode(String code);

    int deleteBySuperAdminCode(String code);

    List<User> findBySuperAdminId(Long id);

    int deleteBySuperAdminId(Long id);

    List<User> findByDeliveryTypeLabel(String label);

    int deleteByDeliveryTypeLabel(String label);

    List<User> findByDeliveryTypeId(Long id);

    int deleteByDeliveryTypeId(Long id);

    List<User> findByCityName(String name);

    int deleteByCityName(String name);

    List<User> findByCityId(Long id);

    int deleteByCityId(Long id);

    List<User> findAll();

	@Query("select new ma.zs.generated.ws.rest.provided.vo.UserVo( c.delivery.lastName, count (c.id)) from Command c  where c.orderDate BETWEEN :start AND :end group by c.delivery order by count (c.delivery) DESC,sum(c.total) DESC")
	public List<UserVo> findTopfiveDelivery(@Param("start") Date start, @Param("end") Date end);

	User findByFirstNameAndLastName(String firstName, String lastName);


    public List<User> findBySuperAdminIdAndAuthorityAuthority(Long adminId , String authority);


	public List<User> findByCityIdAndAuthorityAuthority(Long cityId, String role);

	User findByEmail(String email);
}