package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Category;
import ma.zs.generated.dao.CategoryDao;
import ma.zs.generated.service.facade.CategoryService;

import ma.zs.generated.ws.rest.provided.vo.CategoryVo;
import ma.zs.generated.service.util.*;
@Service
public class CategoryServiceImpl implements CategoryService {

   @Autowired
   private CategoryDao categoryDao;
   

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Category> findAll(){
		return categoryDao.findAll();
	}	
	@Override
	public Category findByLabel(String label){
		if( label==null)
		  return null;
		return categoryDao.findByLabel(label);
	}

   

	@Override
	@Transactional
	public int deleteByLabel(String  label) {
		return categoryDao.deleteByLabel(label);	 
	}

	@Override
	public Category findById(Long id){
		 if(id==null)
		  return null;
		return categoryDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           categoryDao.deleteById(id);
   }
	@Override	
	public Category save (Category category){
			Category foundedCategory = findByLabel(category.getLabel());
	       if(foundedCategory!=null)
	          return null;  

	    Category savedCategory = categoryDao.save(category);
	   return savedCategory;
	}

    @Override
    public List<Category> save(List<Category> categorys){
		List<Category> list = new ArrayList<Category>();
		for(Category category: categorys){
		        list.add(save(category));	
		}
		return list;
	}


   @Override
   public Category update(Category category){
     
    
		  Category foundedCategory = findById(category.getId()); 
		       if(foundedCategory==null)
	          return null;	  
	  
	   return  categoryDao.save(category);
     
     }
    
	@Override
	@Transactional
	public int delete(Category category){

	        if(category.getLabel()==null)
			  return -1;
		
			Category foundedCategory = findByLabel(category.getLabel());
	       if(foundedCategory==null)
	          return -1;  
	   categoryDao.delete(foundedCategory);
	   return 1;
	}


	public List<Category> findByCriteria(CategoryVo categoryVo){
      String query = "SELECT o FROM Category o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "label","LIKE",categoryVo.getLabel());

		 	 query += SearchUtil.addConstraint( "o", "id","=",categoryVo.getId());
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
