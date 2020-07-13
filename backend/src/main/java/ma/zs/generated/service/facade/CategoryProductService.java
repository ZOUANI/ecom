package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.CategoryProduct;
import ma.zs.generated.ws.rest.provided.vo.CategoryProductVo;

public interface CategoryProductService {

        /**

     * find all CategoryProduct in database 
     * @return List<CategoryProduct> , If database is empty return  null.
     */
	List<CategoryProduct> findAll();
	   

    /**
     * find CategoryProduct from database by id (id)
     * @param id - id of CategoryProduct 
     * @return the founded  CategoryProduct , If no CategoryProduct were
     *         found in database return  null.
     */
	CategoryProduct findById(Long id);
     
     /**
     * delete CategoryProduct from database
     * @param id - id of CategoryProduct to be deleted
     * 
     */
	void deleteById(Long id);

	List<CategoryProduct> findByCategoryLabel(String label);
    int deleteByCategoryLabel(String label);       
			
    List<CategoryProduct> findByCategoryId(Long id);
    int deleteByCategoryId(Long id);
			 
	List<CategoryProduct> findByProductReference(String reference);
    int deleteByProductReference(String reference);       
			
    List<CategoryProduct> findByProductId(Long id);
    int deleteByProductId(Long id);
			 
    /**
     * save CategoryProduct in database
     * @param categoryProduct - CategoryProduct to be saved 
     * @return the saved CategoryProduct, If the CategoryProduct can't be saved return null.
     */
	CategoryProduct save(CategoryProduct categoryProduct);

	/**
     * save list CategoryProduct in database
     * @param categoryProducts - list of CategoryProduct to be saved 
     * @return the saved CategoryProduct list
     */
	List<CategoryProduct> save(List<CategoryProduct> categoryProducts);
    
     /**
     * update CategoryProduct in database
     * @param categoryProduct - CategoryProduct to be updated
     * @return the updated CategoryProduct, If the CategoryProduct can't be updated return null.
     */
    CategoryProduct update(CategoryProduct categoryProduct);
    
       /**
     * delete CategoryProduct from database
     * @param categoryProduct - CategoryProduct to be deleted
     * @return 1 if CategoryProduct deleted successfully, If the CategoryProduct can't be deleted return negative int
     */
	int delete(CategoryProduct categoryProduct);


    

     
	/**
     * search for CategoryProduct in by some criteria
     * @return the searhed list CategoryProduct 
     */
	List<CategoryProduct> findByCriteria( CategoryProductVo categoryProductVo);
}