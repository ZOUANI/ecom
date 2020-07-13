package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.City; 
import ma.zs.generated.ws.rest.provided.vo.CityVo;

@Component 
public class CityConverter extends AbstractConverter<City,CityVo>{ 
	

	public  CityConverter(){
		init(true);
	}

	@Override 
 	public City toItem(CityVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	City item = new City();
			 if(StringUtil.isNotEmpty(vo.getName()))
                  item.setName(vo.getName());
			 if(StringUtil.isNotEmpty(vo.getPostCode()))
                  item.setPostCode(vo.getPostCode());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public CityVo toVo(City item) {
 		if (item == null) {
    		return null;
      	} else {
			CityVo vo = new CityVo();

			if(StringUtil.isNotEmpty(item.getName()))
				vo.setName(item.getName());
			
			if(StringUtil.isNotEmpty(item.getPostCode()))
				vo.setPostCode(item.getPostCode());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
	}


	

	
	
}