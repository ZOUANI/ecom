package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.DeliveryType;
import ma.zs.generated.ws.rest.provided.vo.DeliveryTypeVo;

public interface DeliveryTypeService {

        /**

     * find all DeliveryType in database 
     * @return List<DeliveryType> , If database is empty return  null.
     */
	List<DeliveryType> findAll();
	   
	/**

     * find DeliveryType from database by label (reference)
     * @param label - reference of DeliveryType 
     * @return the founded DeliveryType , If no DeliveryType were
     *         found in database return  null.
     */
	DeliveryType findByLabel(String label);

    /**
     * find DeliveryType from database by id (id)
     * @param id - id of DeliveryType 
     * @return the founded  DeliveryType , If no DeliveryType were
     *         found in database return  null.
     */
	DeliveryType findById(Long id);
     
     /**
     * delete DeliveryType from database
     * @param id - id of DeliveryType to be deleted
     * 
     */
	void deleteById(Long id);

    /**
     * save DeliveryType in database
     * @param deliveryType - DeliveryType to be saved 
     * @return the saved DeliveryType, If the DeliveryType can't be saved return null.
     */
	DeliveryType save(DeliveryType deliveryType);

	/**
     * save list DeliveryType in database
     * @param deliveryTypes - list of DeliveryType to be saved 
     * @return the saved DeliveryType list
     */
	List<DeliveryType> save(List<DeliveryType> deliveryTypes);
    
     /**
     * update DeliveryType in database
     * @param deliveryType - DeliveryType to be updated
     * @return the updated DeliveryType, If the DeliveryType can't be updated return null.
     */
    DeliveryType update(DeliveryType deliveryType);
    
       /**
     * delete DeliveryType from database
     * @param deliveryType - DeliveryType to be deleted
     * @return 1 if DeliveryType deleted successfully, If the DeliveryType can't be deleted return negative int
     */
	int delete(DeliveryType deliveryType);


    
        /**
     * delete DeliveryType from database by label (reference)
     * 
     * @param label - reference of DeliveryType to be deleted
     * @return 1 if DeliveryType deleted successfully
     */
	int deleteByLabel(String label);

     
	/**
     * search for DeliveryType in by some criteria
     * @return the searhed list DeliveryType 
     */
	List<DeliveryType> findByCriteria( DeliveryTypeVo deliveryTypeVo);
}