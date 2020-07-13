package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.CategoryProduct;
import ma.zs.generated.bean.Category;
import ma.zs.generated.bean.Product;
import ma.zs.generated.dao.CategoryProductDao;
import ma.zs.generated.service.facade.CategoryProductService;
import ma.zs.generated.service.facade.CategoryService;   
import ma.zs.generated.service.facade.ProductService;   

import ma.zs.generated.ws.rest.provided.vo.CategoryProductVo;
import ma.zs.generated.service.util.*;
@Service
public class CategoryProductServiceImpl implements CategoryProductService {

   @Autowired
   private CategoryProductDao categoryProductDao;
   
    @Autowired
    private CategoryService categoryService ;
    @Autowired
    private ProductService productService ;

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<CategoryProduct> findAll(){
		return categoryProductDao.findAll();
	}	
	@Override
	public List<CategoryProduct> findByCategoryLabel(String label){
		return categoryProductDao.findByCategoryLabel(label);
	}
	@Override
	@Transactional
    public int deleteByCategoryLabel(String label){
		return categoryProductDao.deleteByCategoryLabel(label);
	}
	
     @Override
    public List<CategoryProduct> findByCategoryId(Long id){
		return categoryProductDao.findByCategoryId(id);

	}
	   @Override
	   @Transactional
    public int deleteByCategoryId(Long id){
		return categoryProductDao.deleteByCategoryId(id);

	}
     		
	@Override
	public List<CategoryProduct> findByProductReference(String reference){
		return categoryProductDao.findByProductReference(reference);
	}
	@Override
	@Transactional
    public int deleteByProductReference(String reference){
		return categoryProductDao.deleteByProductReference(reference);
	}
	
     @Override
    public List<CategoryProduct> findByProductId(Long id){
		return categoryProductDao.findByProductId(id);

	}
	   @Override
	   @Transactional
    public int deleteByProductId(Long id){
		return categoryProductDao.deleteByProductId(id);

	}
     		

	@Override
	public CategoryProduct findById(Long id){
		 if(id==null)
		  return null;
		return categoryProductDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           categoryProductDao.deleteById(id);
   }
	@Override	
	public CategoryProduct save (CategoryProduct categoryProduct){
	    
	          if(categoryProduct.getCategory()!=null){
				    Category category = categoryService.findByLabel(categoryProduct.getCategory().getLabel());
				  if(category == null)
				  categoryProduct.setCategory(categoryService.save(categoryProduct.getCategory()));
				  else
				  categoryProduct.setCategory(category);
			  }
	    
	          if(categoryProduct.getProduct()!=null){
				    Product product = productService.findByReference(categoryProduct.getProduct().getReference());
				  if(product == null)
				  categoryProduct.setProduct(productService.save(categoryProduct.getProduct()));
				  else
				  categoryProduct.setProduct(product);
			  }

	    CategoryProduct savedCategoryProduct = categoryProductDao.save(categoryProduct);
	   return savedCategoryProduct;
	}

    @Override
    public List<CategoryProduct> save(List<CategoryProduct> categoryProducts){
		List<CategoryProduct> list = new ArrayList<CategoryProduct>();
		for(CategoryProduct categoryProduct: categoryProducts){
		        list.add(save(categoryProduct));	
		}
		return list;
	}


   @Override
   public CategoryProduct update(CategoryProduct categoryProduct){
     
    
		  CategoryProduct foundedCategoryProduct = findById(categoryProduct.getId()); 
		       if(foundedCategoryProduct==null)
	          return null;	  
	  
	   return  categoryProductDao.save(categoryProduct);
     
     }
    
	@Override
	@Transactional
	public int delete(CategoryProduct categoryProduct){

		 if(categoryProduct.getId()==null)
			  return -1;
		  CategoryProduct foundedCategoryProduct = findById(categoryProduct.getId()); 
		       if(foundedCategoryProduct==null)
	          return -1;	  
	   categoryProductDao.delete(foundedCategoryProduct);
	   return 1;
	}


	public List<CategoryProduct> findByCriteria(CategoryProductVo categoryProductVo){
      String query = "SELECT o FROM CategoryProduct o where 1=1 ";
		 	 query += SearchUtil.addConstraint( "o", "id","=",categoryProductVo.getId());
   if(categoryProductVo.getCategoryVo()!=null){
     query += SearchUtil.addConstraint( "o", "category.id","=",categoryProductVo.getCategoryVo().getId());
     query += SearchUtil.addConstraint( "o", "category.label","LIKE",categoryProductVo.getCategoryVo().getLabel());
   }
   
   if(categoryProductVo.getProductVo()!=null){
     query += SearchUtil.addConstraint( "o", "product.id","=",categoryProductVo.getProductVo().getId());
     query += SearchUtil.addConstraint( "o", "product.reference","LIKE",categoryProductVo.getProductVo().getReference());
   }
   
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
