package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.User;


@Repository
public interface UserDao extends JpaRepository<User,Long> {

	User findByCode(String code);
       int deleteByCode(String code);

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
       List<User> findByAuthorityAuthority(String authority);
       int deleteByAuthorityAuthority(String authority);       
       List<User> findByAuthorityId(Long id);
       int deleteByAuthorityId(Long id);

}