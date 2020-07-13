package ma.zs.generated.service.facade;

import java.util.Date;
import java.util.List;
import ma.zs.generated.bean.Client;
import ma.zs.generated.ws.rest.provided.vo.ClientVo;
import org.springframework.data.repository.query.Param;

public interface ClientService {

     /**
      * 
      * find all Client in database
      * 
      * @return List<Client> , If database is empty return null.
      */
     List<Client> findAll();

     /**
      * find Client from database by id (id)
      * 
      * @param id - id of Client
      * @return the founded Client , If no Client were found in database return null.
      */
     Client findById(Long id);

     void deleteById(Long id);

     List<Client> findByCityName(String name);

     int deleteByCityName(String name);

     List<Client> findByCityId(Long id);

     int deleteByCityId(Long id);

     /**
      * save Client in database
      * 
      * @param client - Client to be saved
      * @return the saved Client, If the Client can't be saved return null.
      */
     Client save(Client client);

     /**
      * save list Client in database
      * 
      * @param clients - list of Client to be saved
      * @return the saved Client list
      */
     List<Client> save(List<Client> clients);

     /**
      * update Client in database
      * 
      * @param client - Client to be updated
      * @return the updated Client, If the Client can't be updated return null.
      */
     Client update(Client client);

     /**
      * delete Client from database
      * 
      * @param client - Client to be deleted
      * @return 1 if Client deleted successfully, If the Client can't be deleted
      *         return negative int
      */
     int delete(Client client);

     /**
      * search for Client in by some criteria
      * 
      * @return the searhed list Client
      */
     List<Client> findByCriteria(ClientVo clientVo);

     /**
      * search for top 5 Client
      * 
      * @return the searhed list Client
      */
     public List<ClientVo> findTopfiveClient(Date start, Date end);

     /**
      * find Client from database
      * 
      * @param firstName   of Client to be found
      * @param lastName    of Client to be found
      * @param phoneNumber of Client to be found
      * @return Client found successfully, If the Client can't be found return null
      */
     Client findByFirstNameAndLastNameAndPhoneNumber(String firstName, String lastName, String phoneNumber);

     /**
      * save Client in database
      * 
      * @param client - Client to be saved
      * @return the saved Client, If the Client can't be saved return null.
      */
     Client savePlainClient(Client client);

     public Client findByFirstNameAndLastName(String firstName, String lastName);

}
