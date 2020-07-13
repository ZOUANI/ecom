package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.DeliveryCost; 
import ma.zs.generated.ws.rest.provided.vo.DeliveryCostVo;

@Component 
public class DeliveryCostConverter extends AbstractConverter<DeliveryCost,DeliveryCostVo>{ 
	
	   @Autowired
         private UserConverter userConverter ;
	   @Autowired
         private CityConverter cityConverter ;
    private Boolean city;
    private Boolean delivery;

	public  DeliveryCostConverter(){
		init(true);
	}

	@Override 
 	public DeliveryCost toItem(DeliveryCostVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	DeliveryCost item = new DeliveryCost();
			 if(StringUtil.isNotEmpty(vo.getShippingCost()))
                  item.setShippingCost(NumberUtil.toBigDecimal(vo.getShippingCost()));
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getCityVo()!=null && this.city)
			     item.setCity(cityConverter.toItem(vo.getCityVo())) ;
             if(vo.getDeliveryVo()!=null && this.delivery)
			     item.setDelivery(userConverter.toItem(vo.getDeliveryVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public DeliveryCostVo toVo(DeliveryCost item) {
 		if (item == null) {
    		return null;
      	} else {
			DeliveryCostVo vo = new DeliveryCostVo();

			 if(item.getShippingCost()!=null)
				vo.setShippingCost(NumberUtil.toString(item.getShippingCost()));
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getCity()!=null && this.city) {
				   vo.setCityVo(cityConverter.toVo(item.getCity())) ;
			   } 
            if(item.getDelivery()!=null && this.delivery) {
				   vo.setDeliveryVo(userConverter.toVo(item.getDelivery())) ;
			   } 

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       city = value;
       delivery = value;
	}


	

	
	   public UserConverter getUserConverter(){
		return this.userConverter;
	}  
        public void setUserConverter(UserConverter userConverter ){
		 this.userConverter = userConverter;
	}  
	   public CityConverter getCityConverter(){
		return this.cityConverter;
	}  
        public void setCityConverter(CityConverter cityConverter ){
		 this.cityConverter = cityConverter;
	}  
	
	 public boolean  isCity(){
		  return this.city;
	 }
	 public void  setCity(boolean city){
		   this.city = city;
	 }
	 public boolean  isDelivery(){
		  return this.delivery;
	 }
	 public void  setDelivery(boolean delivery){
		   this.delivery = delivery;
	 }
}