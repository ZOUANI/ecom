package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Role;
import ma.zs.generated.dao.RoleDao;
import ma.zs.generated.service.facade.RoleService;

import ma.zs.generated.ws.rest.provided.vo.RoleVo;
import ma.zs.generated.service.util.*;
@Service
public class RoleServiceImpl implements RoleService {

   @Autowired
   private RoleDao roleDao;
   

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Role> findAll(){
		return roleDao.findAll();
	}	
	@Override
	public Role findByAuthority(String authority){
		if( authority==null)
		  return null;
		return roleDao.findByAuthority(authority);
	}

   

	@Override
	@Transactional
	public int deleteByAuthority(String  authority) {
		return roleDao.deleteByAuthority(authority);	 
	}

	@Override
	public Role findById(Long id){
		 if(id==null)
		  return null;
		return roleDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           roleDao.deleteById(id);
   }
	@Override	
	public Role save (Role role){
			Role foundedRole = findByAuthority(role.getAuthority());
	       if(foundedRole!=null)
	          return null;  

	    Role savedRole = roleDao.save(role);
	   return savedRole;
	}

    @Override
    public List<Role> save(List<Role> roles){
		List<Role> list = new ArrayList<Role>();
		for(Role role: roles){
		        list.add(save(role));	
		}
		return list;
	}


   @Override
   public Role update(Role role){
     
    
		  Role foundedRole = findById(role.getId()); 
		       if(foundedRole==null)
	          return null;	  
	  
	   return  roleDao.save(role);
     
     }
    
	@Override
	@Transactional
	public int delete(Role role){

	        if(role.getAuthority()==null)
			  return -1;
		
			Role foundedRole = findByAuthority(role.getAuthority());
	       if(foundedRole==null)
	          return -1;  
	   roleDao.delete(foundedRole);
	   return 1;
	}


	public List<Role> findByCriteria(RoleVo roleVo){
      String query = "SELECT o FROM Role o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "authority","LIKE",roleVo.getAuthority());

		 	 query += SearchUtil.addConstraint( "o", "id","=",roleVo.getId());
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
