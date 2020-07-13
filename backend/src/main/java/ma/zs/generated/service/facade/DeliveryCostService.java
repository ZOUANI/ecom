package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.DeliveryCost;
import ma.zs.generated.ws.rest.provided.vo.DeliveryCostVo;

public interface DeliveryCostService {

        /**

     * find all DeliveryCost in database 
     * @return List<DeliveryCost> , If database is empty return  null.
     */
	List<DeliveryCost> findAll();
	   

    /**
     * find DeliveryCost from database by id (id)
     * @param id - id of DeliveryCost 
     * @return the founded  DeliveryCost , If no DeliveryCost were
     *         found in database return  null.
     */
	DeliveryCost findById(Long id);
     
     /**
     * delete DeliveryCost from database
     * @param id - id of DeliveryCost to be deleted
     * 
     */
	void deleteById(Long id);

	List<DeliveryCost> findByCityName(String name);
    int deleteByCityName(String name);       
			
    List<DeliveryCost> findByCityId(Long id);
    int deleteByCityId(Long id);
			 
	List<DeliveryCost> findByDeliveryCode(String code);
    int deleteByDeliveryCode(String code);       
			
    List<DeliveryCost> findByDeliveryId(Long id);
    int deleteByDeliveryId(Long id);
			 
    /**
     * save DeliveryCost in database
     * @param deliveryCost - DeliveryCost to be saved 
     * @return the saved DeliveryCost, If the DeliveryCost can't be saved return null.
     */
	DeliveryCost save(DeliveryCost deliveryCost);

	/**
     * save list DeliveryCost in database
     * @param deliveryCosts - list of DeliveryCost to be saved 
     * @return the saved DeliveryCost list
     */
	List<DeliveryCost> save(List<DeliveryCost> deliveryCosts);
    
     /**
     * update DeliveryCost in database
     * @param deliveryCost - DeliveryCost to be updated
     * @return the updated DeliveryCost, If the DeliveryCost can't be updated return null.
     */
    DeliveryCost update(DeliveryCost deliveryCost);
    
       /**
     * delete DeliveryCost from database
     * @param deliveryCost - DeliveryCost to be deleted
     * @return 1 if DeliveryCost deleted successfully, If the DeliveryCost can't be deleted return negative int
     */
	int delete(DeliveryCost deliveryCost);


    

     
	/**
     * search for DeliveryCost in by some criteria
     * @return the searhed list DeliveryCost 
     */
	List<DeliveryCost> findByCriteria( DeliveryCostVo deliveryCostVo);
}