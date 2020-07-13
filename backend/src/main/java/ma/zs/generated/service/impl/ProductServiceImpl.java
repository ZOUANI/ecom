package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Product;
import ma.zs.generated.bean.OrderLine;
import ma.zs.generated.dao.ProductDao;
import ma.zs.generated.service.facade.ProductService;
import ma.zs.generated.service.facade.OrderLineService;   

import ma.zs.generated.ws.rest.provided.vo.ProductVo;
import ma.zs.generated.service.util.*;
@Service
public class ProductServiceImpl implements ProductService {

   @Autowired
   private ProductDao productDao;
   
    @Autowired
    private OrderLineService orderLineService ;

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Product> findAll(){
		return productDao.findAll();
	}	
	@Override
	public Product findByReference(String reference){
		if( reference==null)
		  return null;
		return productDao.findByReference(reference);
	}

   

	@Override
	@Transactional
	public int deleteByReference(String  reference) {
		return productDao.deleteByReference(reference);	 
	}

	@Override
	public Product findById(Long id){
		 if(id==null)
		  return null;
		return productDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           productDao.deleteById(id);
   }
	@Override	
	public Product save (Product product){
			Product foundedProduct = findByReference(product.getReference());
	       if(foundedProduct!=null)
	          return null;  

	    Product savedProduct = productDao.save(product);
               if(ListUtil.isNotEmpty(product.getOrderLines())){
		  savedProduct.setOrderLines(orderLineService.save(prepareOrderLines(savedProduct,product.getOrderLines())));
		 }
	   return savedProduct;
	}

    @Override
    public List<Product> save(List<Product> products){
		List<Product> list = new ArrayList<Product>();
		for(Product product: products){
		        list.add(save(product));	
		}
		return list;
	}

     private List<OrderLine> prepareOrderLines(Product product,List<OrderLine> orderLines){
		    for(OrderLine orderLine:orderLines ){
                  orderLine.setProduct(product); 
			}
			return orderLines;
	  }

   @Override
   public Product update(Product product){
     
    
		  Product foundedProduct = findById(product.getId()); 
		       if(foundedProduct==null)
	          return null;	  
	  
	   return  productDao.save(product);
     
     }
    
	@Override
	@Transactional
	public int delete(Product product){

	        if(product.getReference()==null)
			  return -1;
		
			Product foundedProduct = findByReference(product.getReference());
	       if(foundedProduct==null)
	          return -1;  
	   productDao.delete(foundedProduct);
	   return 1;
	}


	public List<Product> findByCriteria(ProductVo productVo){
      String query = "SELECT o FROM Product o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "size","LIKE",productVo.getSize());

		 	 query += SearchUtil.addConstraint( "o", "qteStock","=",productVo.getQteStock());
			 query += SearchUtil.addConstraint( "o", "label","LIKE",productVo.getLabel());

		 	 query += SearchUtil.addConstraint( "o", "price","=",productVo.getPrice());
		 	 query += SearchUtil.addConstraint( "o", "weight","=",productVo.getWeight());
			 query += SearchUtil.addConstraint( "o", "reference","LIKE",productVo.getReference());

		 	 query += SearchUtil.addConstraint( "o", "id","=",productVo.getId());
			 query += SearchUtil.addConstraint( "o", "color","LIKE",productVo.getColor());

	  query += SearchUtil.addConstraintMinMax("o","qteStock",productVo.getQteStockMin(),productVo.getQteStockMax());
	  query += SearchUtil.addConstraintMinMax("o","price",productVo.getPriceMin(),productVo.getPriceMax());
	  query += SearchUtil.addConstraintMinMax("o","weight",productVo.getWeightMin(),productVo.getWeightMax());
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
