package ma.zs.generated.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.zs.generated.bean.Client;
import ma.zs.generated.ws.rest.provided.vo.ClientVo;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {

    List<Client> findByCityName(String name);

    int deleteByCityName(String name);

    List<Client> findByCityId(Long id);

    int deleteByCityId(Long id);

    @Query("select new ma.zs.generated.ws.rest.provided.vo.ClientVo( c.client.lastName, count (c.id), sum(c.total)) from Command c  where c.orderDate BETWEEN :start AND :end group by c.client order by count (c.client) DESC,sum(c.total) DESC")
    public List<ClientVo> findTopfiveClient(@Param("start") Date start, @Param("end") Date end);

    Client findByFirstNameAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);

    public Client findByFirstNameAndLastName(String firstName, String lastName);

}
