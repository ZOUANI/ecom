package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.DeliveryType;
import ma.zs.generated.dao.DeliveryTypeDao;
import ma.zs.generated.service.facade.DeliveryTypeService;

import ma.zs.generated.ws.rest.provided.vo.DeliveryTypeVo;
import ma.zs.generated.service.util.*;
@Service
public class DeliveryTypeServiceImpl implements DeliveryTypeService {

   @Autowired
   private DeliveryTypeDao deliveryTypeDao;
   

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<DeliveryType> findAll(){
		return deliveryTypeDao.findAll();
	}	
	@Override
	public DeliveryType findByLabel(String label){
		if( label==null)
		  return null;
		return deliveryTypeDao.findByLabel(label);
	}

   

	@Override
	@Transactional
	public int deleteByLabel(String  label) {
		return deliveryTypeDao.deleteByLabel(label);	 
	}

	@Override
	public DeliveryType findById(Long id){
		 if(id==null)
		  return null;
		return deliveryTypeDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           deliveryTypeDao.deleteById(id);
   }
	@Override	
	public DeliveryType save (DeliveryType deliveryType){
			DeliveryType foundedDeliveryType = findByLabel(deliveryType.getLabel());
	       if(foundedDeliveryType!=null)
	          return null;  

	    DeliveryType savedDeliveryType = deliveryTypeDao.save(deliveryType);
	   return savedDeliveryType;
	}

    @Override
    public List<DeliveryType> save(List<DeliveryType> deliveryTypes){
		List<DeliveryType> list = new ArrayList<DeliveryType>();
		for(DeliveryType deliveryType: deliveryTypes){
		        list.add(save(deliveryType));	
		}
		return list;
	}


   @Override
   public DeliveryType update(DeliveryType deliveryType){
     
    
		  DeliveryType foundedDeliveryType = findById(deliveryType.getId()); 
		       if(foundedDeliveryType==null)
	          return null;	  
	  
	   return  deliveryTypeDao.save(deliveryType);
     
     }
    
	@Override
	@Transactional
	public int delete(DeliveryType deliveryType){

	        if(deliveryType.getLabel()==null)
			  return -1;
		
			DeliveryType foundedDeliveryType = findByLabel(deliveryType.getLabel());
	       if(foundedDeliveryType==null)
	          return -1;  
	   deliveryTypeDao.delete(foundedDeliveryType);
	   return 1;
	}


	public List<DeliveryType> findByCriteria(DeliveryTypeVo deliveryTypeVo){
      String query = "SELECT o FROM DeliveryType o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "label","LIKE",deliveryTypeVo.getLabel());

		 	 query += SearchUtil.addConstraint( "o", "id","=",deliveryTypeVo.getId());
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
