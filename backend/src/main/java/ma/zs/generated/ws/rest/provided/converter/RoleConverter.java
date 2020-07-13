package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Role; 
import ma.zs.generated.ws.rest.provided.vo.RoleVo;

@Component 
public class RoleConverter extends AbstractConverter<Role,RoleVo>{ 
	

	public  RoleConverter(){
		init(true);
	}

	@Override 
 	public Role toItem(RoleVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Role item = new Role();
			 if(StringUtil.isNotEmpty(vo.getAuthority()))
                  item.setAuthority(vo.getAuthority());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public RoleVo toVo(Role item) {
 		if (item == null) {
    		return null;
      	} else {
			RoleVo vo = new RoleVo();

			if(StringUtil.isNotEmpty(item.getAuthority()))
				vo.setAuthority(item.getAuthority());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
	}


	

	
	
}