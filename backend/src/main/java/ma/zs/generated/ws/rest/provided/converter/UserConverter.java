package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.User; 
import ma.zs.generated.ws.rest.provided.vo.UserVo;

@Component 
public class UserConverter extends AbstractConverter<User,UserVo>{ 
	
	   @Autowired
         private RoleConverter roleConverter ;
	   @Autowired
         private CityConverter cityConverter ;
	   @Autowired
         private DeliveryTypeConverter deliveryTypeConverter ;
    private Boolean superAdmin;
    private Boolean deliveryType;
    private Boolean city;
    private Boolean authority;

	public  UserConverter(){
		init(true);
	}

	@Override 
 	public User toItem(UserVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	User item = new User();
			 if(StringUtil.isNotEmpty(vo.getPassword()))
                  item.setPassword(vo.getPassword());
			 if(StringUtil.isNotEmpty(vo.getEnabled()))
                  item.setEnabled(NumberUtil.toBoolean(vo.getEnabled()));
			 if(StringUtil.isNotEmpty(vo.getPhoneNumber()))
                  item.setPhoneNumber(vo.getPhoneNumber());
			 if(StringUtil.isNotEmpty(vo.getLastName()))
                  item.setLastName(vo.getLastName());
			 if(StringUtil.isNotEmpty(vo.getEmail()))
                  item.setEmail(vo.getEmail());
             if(StringUtil.isNotEmpty(vo.getCreated()))
			      item.setCreated(DateUtil.parse(vo.getCreated()));
			 if(StringUtil.isNotEmpty(vo.getCode()))
                  item.setCode(vo.getCode());
			 if(StringUtil.isNotEmpty(vo.getFirsttName()))
                  item.setFirsttName(vo.getFirsttName());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getSuperAdminVo()!=null && this.superAdmin)
			     item.setSuperAdmin(toItem(vo.getSuperAdminVo())) ;
             if(vo.getDeliveryTypeVo()!=null && this.deliveryType)
			     item.setDeliveryType(deliveryTypeConverter.toItem(vo.getDeliveryTypeVo())) ;
             if(vo.getCityVo()!=null && this.city)
			     item.setCity(cityConverter.toItem(vo.getCityVo())) ;
             if(vo.getAuthorityVo()!=null && this.authority)
			     item.setAuthority(roleConverter.toItem(vo.getAuthorityVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public UserVo toVo(User item) {
 		if (item == null) {
    		return null;
      	} else {
			UserVo vo = new UserVo();

			if(StringUtil.isNotEmpty(item.getPassword()))
				vo.setPassword(item.getPassword());
			
			if(item.isEnabled()!=null)
				vo.setEnabled(NumberUtil.toString(item.isEnabled()));
			if(StringUtil.isNotEmpty(item.getPhoneNumber()))
				vo.setPhoneNumber(item.getPhoneNumber());
			
			if(StringUtil.isNotEmpty(item.getLastName()))
				vo.setLastName(item.getLastName());
			
			if(StringUtil.isNotEmpty(item.getEmail()))
				vo.setEmail(item.getEmail());
			
            if(item.getCreated()!=null)
			    vo.setCreated(DateUtil.formateDate(item.getCreated()));	     
			if(StringUtil.isNotEmpty(item.getCode()))
				vo.setCode(item.getCode());
			
			if(StringUtil.isNotEmpty(item.getFirsttName()))
				vo.setFirsttName(item.getFirsttName());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getSuperAdmin()!=null && this.superAdmin) {
					this.setSuperAdmin(false);
					vo.setSuperAdminVo(toVo(item.getSuperAdmin())) ;
					this.setSuperAdmin(true);
			   } 
            if(item.getDeliveryType()!=null && this.deliveryType) {
				   vo.setDeliveryTypeVo(deliveryTypeConverter.toVo(item.getDeliveryType())) ;
			   } 
            if(item.getCity()!=null && this.city) {
				   vo.setCityVo(cityConverter.toVo(item.getCity())) ;
			   } 
            if(item.getAuthority()!=null && this.authority) {
				   vo.setAuthorityVo(roleConverter.toVo(item.getAuthority())) ;
			   } 

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       superAdmin = value;
       deliveryType = value;
       city = value;
       authority = value;
	}


	

	
	   public RoleConverter getRoleConverter(){
		return this.roleConverter;
	}  
        public void setRoleConverter(RoleConverter roleConverter ){
		 this.roleConverter = roleConverter;
	}  
	   public CityConverter getCityConverter(){
		return this.cityConverter;
	}  
        public void setCityConverter(CityConverter cityConverter ){
		 this.cityConverter = cityConverter;
	}  
	   public DeliveryTypeConverter getDeliveryTypeConverter(){
		return this.deliveryTypeConverter;
	}  
        public void setDeliveryTypeConverter(DeliveryTypeConverter deliveryTypeConverter ){
		 this.deliveryTypeConverter = deliveryTypeConverter;
	}  
	
	 public boolean  isSuperAdmin(){
		  return this.superAdmin;
	 }
	 public void  setSuperAdmin(boolean superAdmin){
		   this.superAdmin = superAdmin;
	 }
	 public boolean  isDeliveryType(){
		  return this.deliveryType;
	 }
	 public void  setDeliveryType(boolean deliveryType){
		   this.deliveryType = deliveryType;
	 }
	 public boolean  isCity(){
		  return this.city;
	 }
	 public void  setCity(boolean city){
		   this.city = city;
	 }
	 public boolean  isAuthority(){
		  return this.authority;
	 }
	 public void  setAuthority(boolean authority){
		   this.authority = authority;
	 }
}