package ma.zs.generated.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ma.zs.generated.bean.Client;


@Repository
public interface ClientDao extends JpaRepository<Client,Long> {


       List<Client> findByCityName(String name);
       int deleteByCityName(String name);       
       List<Client> findByCityId(Long id);
       int deleteByCityId(Long id);

}