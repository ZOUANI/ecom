package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Role;
import ma.zs.generated.ws.rest.provided.vo.RoleVo;

public interface RoleService {

        /**

     * find all Role in database 
     * @return List<Role> , If database is empty return  null.
     */
	List<Role> findAll();
	   
	/**

     * find Role from database by authority (reference)
     * @param authority - reference of Role 
     * @return the founded Role , If no Role were
     *         found in database return  null.
     */
	Role findByAuthority(String authority);

    /**
     * find Role from database by id (id)
     * @param id - id of Role 
     * @return the founded  Role , If no Role were
     *         found in database return  null.
     */
	Role findById(Long id);
     
     /**
     * delete Role from database
     * @param id - id of Role to be deleted
     * 
     */
	void deleteById(Long id);

    /**
     * save Role in database
     * @param role - Role to be saved 
     * @return the saved Role, If the Role can't be saved return null.
     */
	Role save(Role role);

	/**
     * save list Role in database
     * @param roles - list of Role to be saved 
     * @return the saved Role list
     */
	List<Role> save(List<Role> roles);
    
     /**
     * update Role in database
     * @param role - Role to be updated
     * @return the updated Role, If the Role can't be updated return null.
     */
    Role update(Role role);
    
       /**
     * delete Role from database
     * @param role - Role to be deleted
     * @return 1 if Role deleted successfully, If the Role can't be deleted return negative int
     */
	int delete(Role role);


    
        /**
     * delete Role from database by authority (reference)
     * 
     * @param authority - reference of Role to be deleted
     * @return 1 if Role deleted successfully
     */
	int deleteByAuthority(String authority);

     
	/**
     * search for Role in by some criteria
     * @return the searhed list Role 
     */
	List<Role> findByCriteria( RoleVo roleVo);
}