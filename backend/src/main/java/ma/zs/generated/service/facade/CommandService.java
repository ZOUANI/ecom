package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Command;
import ma.zs.generated.ws.rest.provided.vo.CommandVo;

public interface CommandService {

        /**

     * find all Command in database 
     * @return List<Command> , If database is empty return  null.
     */
	List<Command> findAll();
	   
	/**

     * find Command from database by reference (reference)
     * @param reference - reference of Command 
     * @return the founded Command , If no Command were
     *         found in database return  null.
     */
	Command findByReference(String reference);

    /**
     * find Command from database by id (id)
     * @param id - id of Command 
     * @return the founded  Command , If no Command were
     *         found in database return  null.
     */
	Command findById(Long id);
     
     /**
     * delete Command from database
     * @param id - id of Command to be deleted
     * 
     */
	void deleteById(Long id);

	List<Command> findByDeliveryCode(String code);
    int deleteByDeliveryCode(String code);       
			
    List<Command> findByDeliveryId(Long id);
    int deleteByDeliveryId(Long id);
			 
	List<Command> findByValidatorCode(String code);
    int deleteByValidatorCode(String code);       
			
    List<Command> findByValidatorId(Long id);
    int deleteByValidatorId(Long id);
			 
	List<Command> findByAdminCode(String code);
    int deleteByAdminCode(String code);       
			
    List<Command> findByAdminId(Long id);
    int deleteByAdminId(Long id);
			 
    List<Command> findByClientId(Long id);
    int deleteByClientId(Long id);
			 
	List<Command> findByOrderStatusLabel(String label);
    int deleteByOrderStatusLabel(String label);       
			
    List<Command> findByOrderStatusId(Long id);
    int deleteByOrderStatusId(Long id);
			 
	List<Command> findByCityName(String name);
    int deleteByCityName(String name);       
			
    List<Command> findByCityId(Long id);
    int deleteByCityId(Long id);
			 
    /**
     * save Command in database
     * @param command - Command to be saved 
     * @return the saved Command, If the Command can't be saved return null.
     */
	Command save(Command command);

	/**
     * save list Command in database
     * @param commands - list of Command to be saved 
     * @return the saved Command list
     */
	List<Command> save(List<Command> commands);
    
     /**
     * update Command in database
     * @param command - Command to be updated
     * @return the updated Command, If the Command can't be updated return null.
     */
    Command update(Command command);
    
       /**
     * delete Command from database
     * @param command - Command to be deleted
     * @return 1 if Command deleted successfully, If the Command can't be deleted return negative int
     */
	int delete(Command command);


    
        /**
     * delete Command from database by reference (reference)
     * 
     * @param reference - reference of Command to be deleted
     * @return 1 if Command deleted successfully
     */
	int deleteByReference(String reference);

     
	/**
     * search for Command in by some criteria
     * @return the searhed list Command 
     */
	List<Command> findByCriteria( CommandVo commandVo);
}