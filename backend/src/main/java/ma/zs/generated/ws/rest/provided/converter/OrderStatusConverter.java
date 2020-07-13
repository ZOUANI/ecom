package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.OrderStatus; 
import ma.zs.generated.ws.rest.provided.vo.OrderStatusVo;

@Component 
public class OrderStatusConverter extends AbstractConverter<OrderStatus,OrderStatusVo>{ 
	

	public  OrderStatusConverter(){
		init(true);
	}

	@Override 
 	public OrderStatus toItem(OrderStatusVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	OrderStatus item = new OrderStatus();
			 if(StringUtil.isNotEmpty(vo.getLabel()))
                  item.setLabel(vo.getLabel());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public OrderStatusVo toVo(OrderStatus item) {
 		if (item == null) {
    		return null;
      	} else {
			OrderStatusVo vo = new OrderStatusVo();

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