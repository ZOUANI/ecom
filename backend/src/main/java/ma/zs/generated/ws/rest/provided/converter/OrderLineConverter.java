package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.OrderLine; 
import ma.zs.generated.ws.rest.provided.vo.OrderLineVo;

@Component 
public class OrderLineConverter extends AbstractConverter<OrderLine,OrderLineVo>{ 
	
	   @Autowired
         private CommandConverter commandConverter ;
	   @Autowired
         private ProductConverter productConverter ;
    private Boolean command;
    private Boolean product;

	public  OrderLineConverter(){
		init(true);
	}

	@Override 
 	public OrderLine toItem(OrderLineVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	OrderLine item = new OrderLine();
			 if(StringUtil.isNotEmpty(vo.getPrice()))
                  item.setPrice(NumberUtil.toBigDecimal(vo.getPrice()));
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getCommandVo()!=null && this.command)
			     item.setCommand(commandConverter.toItem(vo.getCommandVo())) ;
             if(vo.getProductVo()!=null && this.product)
			     item.setProduct(productConverter.toItem(vo.getProductVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public OrderLineVo toVo(OrderLine item) {
 		if (item == null) {
    		return null;
      	} else {
			OrderLineVo vo = new OrderLineVo();

			 if(item.getPrice()!=null)
				vo.setPrice(NumberUtil.toString(item.getPrice()));
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getCommand()!=null && this.command) {
				   vo.setCommandVo(commandConverter.toVo(item.getCommand())) ;
			   } 
            if(item.getProduct()!=null && this.product) {
				   vo.setProductVo(productConverter.toVo(item.getProduct())) ;
			   } 

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       command = value;
       product = value;
	}


	

	
	   public CommandConverter getCommandConverter(){
		return this.commandConverter;
	}  
        public void setCommandConverter(CommandConverter commandConverter ){
		 this.commandConverter = commandConverter;
	}  
	   public ProductConverter getProductConverter(){
		return this.productConverter;
	}  
        public void setProductConverter(ProductConverter productConverter ){
		 this.productConverter = productConverter;
	}  
	
	 public boolean  isCommand(){
		  return this.command;
	 }
	 public void  setCommand(boolean command){
		   this.command = command;
	 }
	 public boolean  isProduct(){
		  return this.product;
	 }
	 public void  setProduct(boolean product){
		   this.product = product;
	 }
}