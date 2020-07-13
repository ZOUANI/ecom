package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.DeliveryType; 
import ma.zs.generated.ws.rest.provided.vo.DeliveryTypeVo;

@Component 
public class DeliveryTypeConverter extends AbstractConverter<DeliveryType,DeliveryTypeVo>{ 
	

	public  DeliveryTypeConverter(){
		init(true);
	}

	@Override 
 	public DeliveryType toItem(DeliveryTypeVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	DeliveryType item = new DeliveryType();
			 if(StringUtil.isNotEmpty(vo.getLabel()))
                  item.setLabel(vo.getLabel());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public DeliveryTypeVo toVo(DeliveryType item) {
 		if (item == null) {
    		return null;
      	} else {
			DeliveryTypeVo vo = new DeliveryTypeVo();

			if(StringUtil.isNotEmpty(item.getLabel()))
				vo.setLabel(item.getLabel());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
	}


	

	
	
}