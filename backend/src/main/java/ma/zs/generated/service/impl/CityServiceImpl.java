package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.City;
import ma.zs.generated.dao.CityDao;
import ma.zs.generated.service.facade.CityService;

import ma.zs.generated.ws.rest.provided.vo.CityVo;
import ma.zs.generated.service.util.*;
@Service
public class CityServiceImpl implements CityService {

   @Autowired
   private CityDao cityDao;
   

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<City> findAll(){
		return cityDao.findAll();
	}	
	@Override
	public City findByName(String name){
		if( name==null)
		  return null;
		return cityDao.findByName(name);
	}

   

	@Override
	@Transactional
	public int deleteByName(String  name) {
		return cityDao.deleteByName(name);	 
	}

	@Override
	public City findById(Long id){
		 if(id==null)
		  return null;
		return cityDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           cityDao.deleteById(id);
   }
	@Override	
	public City save (City city){
			City foundedCity = findByName(city.getName());
	       if(foundedCity!=null)
	          return null;  

	    City savedCity = cityDao.save(city);
	   return savedCity;
	}

    @Override
    public List<City> save(List<City> citys){
		List<City> list = new ArrayList<City>();
		for(City city: citys){
		        list.add(save(city));	
		}
		return list;
	}


   @Override
   public City update(City city){
     
    
		  City foundedCity = findById(city.getId()); 
		       if(foundedCity==null)
	          return null;	  
	  
	   return  cityDao.save(city);
     
     }
    
	@Override
	@Transactional
	public int delete(City city){

	        if(city.getName()==null)
			  return -1;
		
			City foundedCity = findByName(city.getName());
	       if(foundedCity==null)
	          return -1;  
	   cityDao.delete(foundedCity);
	   return 1;
	}


	public List<City> findByCriteria(CityVo cityVo){
      String query = "SELECT o FROM City o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "name","LIKE",cityVo.getName());

			 query += SearchUtil.addConstraint( "o", "postCode","LIKE",cityVo.getPostCode());

		 	 query += SearchUtil.addConstraint( "o", "id","=",cityVo.getId());
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
