package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Product;
import ma.zs.generated.ws.rest.provided.vo.ProductVo;

public interface ProductService {

        /**

     * find all Product in database 
     * @return List<Product> , If database is empty return  null.
     */
	List<Product> findAll();
	   
	/**

     * find Product from database by reference (reference)
     * @param reference - reference of Product 
     * @return the founded Product , If no Product were
     *         found in database return  null.
     */
	Product findByReference(String reference);

    /**
     * find Product from database by id (id)
     * @param id - id of Product 
     * @return the founded  Product , If no Product were
     *         found in database return  null.
     */
	Product findById(Long id);
     
     /**
     * delete Product from database
     * @param id - id of Product to be deleted
     * 
     */
	void deleteById(Long id);

    /**
     * save Product in database
     * @param product - Product to be saved 
     * @return the saved Product, If the Product can't be saved return null.
     */
	Product save(Product product);

	/**
     * save list Product in database
     * @param products - list of Product to be saved 
     * @return the saved Product list
     */
	List<Product> save(List<Product> products);
    
     /**
     * update Product in database
     * @param product - Product to be updated
     * @return the updated Product, If the Product can't be updated return null.
     */
    Product update(Product product);
    
       /**
     * delete Product from database
     * @param product - Product to be deleted
     * @return 1 if Product deleted successfully, If the Product can't be deleted return negative int
     */
	int delete(Product product);


    
        /**
     * delete Product from database by reference (reference)
     * 
     * @param reference - reference of Product to be deleted
     * @return 1 if Product deleted successfully
     */
	int deleteByReference(String reference);

     
	/**
     * search for Product in by some criteria
     * @return the searhed list Product 
     */
	List<Product> findByCriteria( ProductVo productVo);
}