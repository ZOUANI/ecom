package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Client;
import ma.zs.generated.ws.rest.provided.vo.ClientVo;

public interface ClientService {

        /**

     * find all Client in database 
     * @return List<Client> , If database is empty return  null.
     */
	List<Client> findAll();
	   

    /**
     * find Client from database by id (id)
     * @param id - id of Client 
     * @return the founded  Client , If no Client were
     *         found in database return  null.
     */
	Client findById(Long id);
     
     /**
     * delete Client from database
     * @param id - id of Client to be deleted
     * 
     */
	void deleteById(Long id);

	List<Client> findByCityName(String name);
    int deleteByCityName(String name);       
			
    List<Client> findByCityId(Long id);
    int deleteByCityId(Long id);
			 
    /**
     * save Client in database
     * @param client - Client to be saved 
     * @return the saved Client, If the Client can't be saved return null.
     */
	Client save(Client client);

	/**
     * save list Client in database
     * @param clients - list of Client to be saved 
     * @return the saved Client list
     */
	List<Client> save(List<Client> clients);
    
     /**
     * update Client in database
     * @param client - Client to be updated
     * @return the updated Client, If the Client can't be updated return null.
     */
    Client update(Client client);
    
       /**
     * delete Client from database
     * @param client - Client to be deleted
     * @return 1 if Client deleted successfully, If the Client can't be deleted return negative int
     */
	int delete(Client client);


    

     
	/**
     * search for Client in by some criteria
     * @return the searhed list Client 
     */
	List<Client> findByCriteria( ClientVo clientVo);
}