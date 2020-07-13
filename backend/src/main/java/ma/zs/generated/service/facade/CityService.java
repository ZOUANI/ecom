package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.City;
import ma.zs.generated.ws.rest.provided.vo.CityVo;

public interface CityService {

        /**

     * find all City in database 
     * @return List<City> , If database is empty return  null.
     */
	List<City> findAll();
	   
	/**

     * find City from database by name (reference)
     * @param name - reference of City 
     * @return the founded City , If no City were
     *         found in database return  null.
     */
	City findByName(String name);

    /**
     * find City from database by id (id)
     * @param id - id of City 
     * @return the founded  City , If no City were
     *         found in database return  null.
     */
	City findById(Long id);
     
     /**
     * delete City from database
     * @param id - id of City to be deleted
     * 
     */
	void deleteById(Long id);

    /**
     * save City in database
     * @param city - City to be saved 
     * @return the saved City, If the City can't be saved return null.
     */
	City save(City city);

	/**
     * save list City in database
     * @param citys - list of City to be saved 
     * @return the saved City list
     */
	List<City> save(List<City> citys);
    
     /**
     * update City in database
     * @param city - City to be updated
     * @return the updated City, If the City can't be updated return null.
     */
    City update(City city);
    
       /**
     * delete City from database
     * @param city - City to be deleted
     * @return 1 if City deleted successfully, If the City can't be deleted return negative int
     */
	int delete(City city);


    
        /**
     * delete City from database by name (reference)
     * 
     * @param name - reference of City to be deleted
     * @return 1 if City deleted successfully
     */
	int deleteByName(String name);

     
	/**
     * search for City in by some criteria
     * @return the searhed list City 
     */
	List<City> findByCriteria( CityVo cityVo);
}