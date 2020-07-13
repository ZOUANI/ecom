package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.DeliveryType;
import ma.zs.generated.bean.City;
import ma.zs.generated.bean.Role;
import ma.zs.generated.dao.UserDao;
import ma.zs.generated.service.facade.UserService;
import ma.zs.generated.service.facade.RoleService;   
import ma.zs.generated.service.facade.CityService;   
import ma.zs.generated.service.facade.DeliveryTypeService;   

import ma.zs.generated.ws.rest.provided.vo.UserVo;
import ma.zs.generated.service.util.*;
@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserDao userDao;
   
    @Autowired
    private RoleService roleService ;
    @Autowired
    private CityService cityService ;
    @Autowired
    private DeliveryTypeService deliveryTypeService ;

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<User> findAll(){
		return userDao.findAll();
	}	
	@Override
	public List<User> findBySuperAdminCode(String code){
		return userDao.findBySuperAdminCode(code);
	}
	@Override
	@Transactional
    public int deleteBySuperAdminCode(String code){
		return userDao.deleteBySuperAdminCode(code);
	}
	
     @Override
    public List<User> findBySuperAdminId(Long id){
		return userDao.findBySuperAdminId(id);

	}
	   @Override
	   @Transactional
    public int deleteBySuperAdminId(Long id){
		return userDao.deleteBySuperAdminId(id);

	}
     		
	@Override
	public List<User> findByDeliveryTypeLabel(String label){
		return userDao.findByDeliveryTypeLabel(label);
	}
	@Override
	@Transactional
    public int deleteByDeliveryTypeLabel(String label){
		return userDao.deleteByDeliveryTypeLabel(label);
	}
	
     @Override
    public List<User> findByDeliveryTypeId(Long id){
		return userDao.findByDeliveryTypeId(id);

	}
	   @Override
	   @Transactional
    public int deleteByDeliveryTypeId(Long id){
		return userDao.deleteByDeliveryTypeId(id);

	}
     		
	@Override
	public List<User> findByCityName(String name){
		return userDao.findByCityName(name);
	}
	@Override
	@Transactional
    public int deleteByCityName(String name){
		return userDao.deleteByCityName(name);
	}
	
     @Override
    public List<User> findByCityId(Long id){
		return userDao.findByCityId(id);

	}
	   @Override
	   @Transactional
    public int deleteByCityId(Long id){
		return userDao.deleteByCityId(id);

	}
     		
	@Override
	public List<User> findByAuthorityAuthority(String authority){
		return userDao.findByAuthorityAuthority(authority);
	}
	@Override
	@Transactional
    public int deleteByAuthorityAuthority(String authority){
		return userDao.deleteByAuthorityAuthority(authority);
	}
	
     @Override
    public List<User> findByAuthorityId(Long id){
		return userDao.findByAuthorityId(id);

	}
	   @Override
	   @Transactional
    public int deleteByAuthorityId(Long id){
		return userDao.deleteByAuthorityId(id);

	}
     		
	@Override
	public User findByCode(String code){
		if( code==null)
		  return null;
		return userDao.findByCode(code);
	}

   

	@Override
	@Transactional
	public int deleteByCode(String  code) {
		return userDao.deleteByCode(code);	 
	}

	@Override
	public User findById(Long id){
		 if(id==null)
		  return null;
		return userDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           userDao.deleteById(id);
   }
	@Override	
	public User save (User user){
			User foundedUser = findByCode(user.getCode());
	       if(foundedUser!=null)
	          return null;  
	    
	          if(user.getSuperAdmin()!=null){
                          User superAdmin  = findByCode(user.getSuperAdmin().getCode());
				  if(superAdmin == null)
				   	 user.setSuperAdmin(save(user.getSuperAdmin()));
				  else
				  user.setSuperAdmin(superAdmin);
			  }
	    
	          if(user.getDeliveryType()!=null){
				    DeliveryType deliveryType = deliveryTypeService.findByLabel(user.getDeliveryType().getLabel());
				  if(deliveryType == null)
				  user.setDeliveryType(deliveryTypeService.save(user.getDeliveryType()));
				  else
				  user.setDeliveryType(deliveryType);
			  }
	    
	          if(user.getCity()!=null){
				    City city = cityService.findByName(user.getCity().getName());
				  if(city == null)
				  user.setCity(cityService.save(user.getCity()));
				  else
				  user.setCity(city);
			  }
	    
	          if(user.getAuthority()!=null){
				    Role authority = roleService.findByAuthority(user.getAuthority().getAuthority());
				  if(authority == null)
				  user.setAuthority(roleService.save(user.getAuthority()));
				  else
				  user.setAuthority(authority);
			  }

	    User savedUser = userDao.save(user);
	   return savedUser;
	}

    @Override
    public List<User> save(List<User> users){
		List<User> list = new ArrayList<User>();
		for(User user: users){
		        list.add(save(user));	
		}
		return list;
	}


   @Override
   public User update(User user){
     
    
		  User foundedUser = findById(user.getId()); 
		       if(foundedUser==null)
	          return null;	  
	  
	   return  userDao.save(user);
     
     }
    
	@Override
	@Transactional
	public int delete(User user){

	        if(user.getCode()==null)
			  return -1;
		
			User foundedUser = findByCode(user.getCode());
	       if(foundedUser==null)
	          return -1;  
	   userDao.delete(foundedUser);
	   return 1;
	}


	public List<User> findByCriteria(UserVo userVo){
      String query = "SELECT o FROM User o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "password","LIKE",userVo.getPassword());

		 	 query += SearchUtil.addConstraint( "o", "enabled","=",userVo.getEnabled());
			 query += SearchUtil.addConstraint( "o", "phoneNumber","LIKE",userVo.getPhoneNumber());

			 query += SearchUtil.addConstraint( "o", "lastName","LIKE",userVo.getLastName());

			 query += SearchUtil.addConstraint( "o", "email","LIKE",userVo.getEmail());

	  query += SearchUtil.addConstraintDate( "o", "created","=",userVo.getCreated());
			 query += SearchUtil.addConstraint( "o", "code","LIKE",userVo.getCode());

			 query += SearchUtil.addConstraint( "o", "firsttName","LIKE",userVo.getFirsttName());

		 	 query += SearchUtil.addConstraint( "o", "id","=",userVo.getId());
	  query += SearchUtil.addConstraintMinMaxDate("o","created",userVo.getCreatedMin(),userVo.getCreatedMax());
   if(userVo.getSuperAdminVo()!=null){
     query += SearchUtil.addConstraint( "o", "superAdmin.id","=",userVo.getSuperAdminVo().getId());
     query += SearchUtil.addConstraint( "o", "superAdmin.code","LIKE",userVo.getSuperAdminVo().getCode());
   }
   
   if(userVo.getDeliveryTypeVo()!=null){
     query += SearchUtil.addConstraint( "o", "deliveryType.id","=",userVo.getDeliveryTypeVo().getId());
     query += SearchUtil.addConstraint( "o", "deliveryType.label","LIKE",userVo.getDeliveryTypeVo().getLabel());
   }
   
   if(userVo.getCityVo()!=null){
     query += SearchUtil.addConstraint( "o", "city.id","=",userVo.getCityVo().getId());
     query += SearchUtil.addConstraint( "o", "city.name","LIKE",userVo.getCityVo().getName());
   }
   
   if(userVo.getAuthorityVo()!=null){
     query += SearchUtil.addConstraint( "o", "authority.id","=",userVo.getAuthorityVo().getId());
     query += SearchUtil.addConstraint( "o", "authority.authority","LIKE",userVo.getAuthorityVo().getAuthority());
   }
   
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
