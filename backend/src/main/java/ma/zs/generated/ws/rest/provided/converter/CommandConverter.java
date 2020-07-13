package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Command; 
import ma.zs.generated.ws.rest.provided.vo.CommandVo;

@Component 
public class CommandConverter extends AbstractConverter<Command,CommandVo>{ 
	
	   @Autowired
         private UserConverter userConverter ;
	   @Autowired
         private OrderLineConverter orderLineConverter ;
	   @Autowired
         private CityConverter cityConverter ;
	   @Autowired
         private ClientConverter clientConverter ;
	   @Autowired
         private OrderStatusConverter orderStatusConverter ;
    private Boolean delivery;
    private Boolean validator;
    private Boolean admin;
    private Boolean client;
    private Boolean orderStatus;
    private Boolean city;
    private Boolean orderLines;

	public  CommandConverter(){
		init(true);
	}

	@Override 
 	public Command toItem(CommandVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Command item = new Command();
			 if(StringUtil.isNotEmpty(vo.getTotal()))
                  item.setTotal(NumberUtil.toBigDecimal(vo.getTotal()));
             if(StringUtil.isNotEmpty(vo.getRegulationDate()))
			      item.setRegulationDate(DateUtil.parse(vo.getRegulationDate()));
			 if(StringUtil.isNotEmpty(vo.getAdress()))
                  item.setAdress(vo.getAdress());
			 if(StringUtil.isNotEmpty(vo.getReference()))
                  item.setReference(vo.getReference());
			 if(StringUtil.isNotEmpty(vo.getRemarque()))
                  item.setRemarque(vo.getRemarque());
             if(StringUtil.isNotEmpty(vo.getOrderDate()))
			      item.setOrderDate(DateUtil.parse(vo.getOrderDate()));
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getDeliveryVo()!=null && this.delivery)
			     item.setDelivery(userConverter.toItem(vo.getDeliveryVo())) ;
             if(vo.getValidatorVo()!=null && this.validator)
			     item.setValidator(userConverter.toItem(vo.getValidatorVo())) ;
             if(vo.getAdminVo()!=null && this.admin)
			     item.setAdmin(userConverter.toItem(vo.getAdminVo())) ;
             if(vo.getClientVo()!=null && this.client)
			     item.setClient(clientConverter.toItem(vo.getClientVo())) ;
             if(vo.getOrderStatusVo()!=null && this.orderStatus)
			     item.setOrderStatus(orderStatusConverter.toItem(vo.getOrderStatusVo())) ;
             if(vo.getCityVo()!=null && this.city)
			     item.setCity(cityConverter.toItem(vo.getCityVo())) ;

	         if(ListUtil.isNotEmpty(vo.getOrderLinesVo()) && this.orderLines)
                  item.setOrderLines(orderLineConverter.toItem(vo.getOrderLinesVo()));



		return item;
 		}
 	}

 	 @Override 
 	public CommandVo toVo(Command item) {
 		if (item == null) {
    		return null;
      	} else {
			CommandVo vo = new CommandVo();

			 if(item.getTotal()!=null)
				vo.setTotal(NumberUtil.toString(item.getTotal()));
            if(item.getRegulationDate()!=null)
			    vo.setRegulationDate(DateUtil.formateDate(item.getRegulationDate()));	     
			if(StringUtil.isNotEmpty(item.getAdress()))
				vo.setAdress(item.getAdress());
			
			if(StringUtil.isNotEmpty(item.getReference()))
				vo.setReference(item.getReference());
			
			if(StringUtil.isNotEmpty(item.getRemarque()))
				vo.setRemarque(item.getRemarque());
			
            if(item.getOrderDate()!=null)
			    vo.setOrderDate(DateUtil.formateDate(item.getOrderDate()));	     
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getDelivery()!=null && this.delivery) {
				   vo.setDeliveryVo(userConverter.toVo(item.getDelivery())) ;
			   } 
            if(item.getValidator()!=null && this.validator) {
				   vo.setValidatorVo(userConverter.toVo(item.getValidator())) ;
			   } 
            if(item.getAdmin()!=null && this.admin) {
				   vo.setAdminVo(userConverter.toVo(item.getAdmin())) ;
			   } 
            if(item.getClient()!=null && this.client) {
				   vo.setClientVo(clientConverter.toVo(item.getClient())) ;
			   } 
            if(item.getOrderStatus()!=null && this.orderStatus) {
				   vo.setOrderStatusVo(orderStatusConverter.toVo(item.getOrderStatus())) ;
			   } 
            if(item.getCity()!=null && this.city) {
				   vo.setCityVo(cityConverter.toVo(item.getCity())) ;
			   } 
	         if(ListUtil.isNotEmpty(item.getOrderLines()) && this.orderLines){
				
				 orderLineConverter.init(false);
                vo.setOrderLinesVo(orderLineConverter.toVo(item.getOrderLines()));
              	 orderLineConverter.init(true);
			 }

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       delivery = value;
       validator = value;
       admin = value;
       client = value;
       orderStatus = value;
       city = value;
       orderLines = value;
	}


	

	
	   public UserConverter getUserConverter(){
		return this.userConverter;
	}  
        public void setUserConverter(UserConverter userConverter ){
		 this.userConverter = userConverter;
	}  
	   public OrderLineConverter getOrderLineConverter(){
		return this.orderLineConverter;
	}  
        public void setOrderLineConverter(OrderLineConverter orderLineConverter ){
		 this.orderLineConverter = orderLineConverter;
	}  
	   public CityConverter getCityConverter(){
		return this.cityConverter;
	}  
        public void setCityConverter(CityConverter cityConverter ){
		 this.cityConverter = cityConverter;
	}  
	   public ClientConverter getClientConverter(){
		return this.clientConverter;
	}  
        public void setClientConverter(ClientConverter clientConverter ){
		 this.clientConverter = clientConverter;
	}  
	   public OrderStatusConverter getOrderStatusConverter(){
		return this.orderStatusConverter;
	}  
        public void setOrderStatusConverter(OrderStatusConverter orderStatusConverter ){
		 this.orderStatusConverter = orderStatusConverter;
	}  
	
	 public boolean  isDelivery(){
		  return this.delivery;
	 }
	 public void  setDelivery(boolean delivery){
		   this.delivery = delivery;
	 }
	 public boolean  isValidator(){
		  return this.validator;
	 }
	 public void  setValidator(boolean validator){
		   this.validator = validator;
	 }
	 public boolean  isAdmin(){
		  return this.admin;
	 }
	 public void  setAdmin(boolean admin){
		   this.admin = admin;
	 }
	 public boolean  isClient(){
		  return this.client;
	 }
	 public void  setClient(boolean client){
		   this.client = client;
	 }
	 public boolean  isOrderStatus(){
		  return this.orderStatus;
	 }
	 public void  setOrderStatus(boolean orderStatus){
		   this.orderStatus = orderStatus;
	 }
	 public boolean  isCity(){
		  return this.city;
	 }
	 public void  setCity(boolean city){
		   this.city = city;
	 }
       public Boolean  isOrderLines(){
		 return this.orderLines ;
	   }
		 public void  setOrderLines(Boolean orderLines ){
            this.orderLines  = orderLines ;
		 }
}