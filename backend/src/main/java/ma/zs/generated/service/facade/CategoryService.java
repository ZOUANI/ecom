package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Category;
import ma.zs.generated.ws.rest.provided.vo.CategoryVo;

public interface CategoryService {

        /**

     * find all Category in database 
     * @return List<Category> , If database is empty return  null.
     */
	List<Category> findAll();
	   
	/**

     * find Category from database by label (reference)
     * @param label - reference of Category 
     * @return the founded Category , If no Category were
     *         found in database return  null.
     */
	Category findByLabel(String label);

    /**
     * find Category from database by id (id)
     * @param id - id of Category 
     * @return the founded  Category , If no Category were
     *         found in database return  null.
     */
	Category findById(Long id);
     
     /**
     * delete Category from database
     * @param id - id of Category to be deleted
     * 
     */
	void deleteById(Long id);

    /**
     * save Category in database
     * @param category - Category to be saved 
     * @return the saved Category, If the Category can't be saved return null.
     */
	Category save(Category category);

	/**
     * save list Category in database
     * @param categorys - list of Category to be saved 
     * @return the saved Category list
     */
	List<Category> save(List<Category> categorys);
    
     /**
     * update Category in database
     * @param category - Category to be updated
     * @return the updated Category, If the Category can't be updated return null.
     */
    Category update(Category category);
    
       /**
     * delete Category from database
     * @param category - Category to be deleted
     * @return 1 if Category deleted successfully, If the Category can't be deleted return negative int
     */
	int delete(Category category);


    
        /**
     * delete Category from database by label (reference)
     * 
     * @param label - reference of Category to be deleted
     * @return 1 if Category deleted successfully
     */
	int deleteByLabel(String label);

     
	/**
     * search for Category in by some criteria
     * @return the searhed list Category 
     */
	List<Category> findByCriteria( CategoryVo categoryVo);
}