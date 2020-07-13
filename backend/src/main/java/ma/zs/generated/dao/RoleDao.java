package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Role;


@Repository
public interface RoleDao extends JpaRepository<Role,Long> {

	Role findByAuthority(String authority);
       int deleteByAuthority(String authority);


}