package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Stock; 
import ma.zs.generated.ws.rest.provided.vo.StockVo;

@Component 
public class StockConverter extends AbstractConverter<Stock,StockVo>{ 
	
	   @Autowired
         private UserConverter userConverter ;
	   @Autowired
         private ProductConverter productConverter ;
	   @Autowired
         private CityConverter cityConverter ;
    private Boolean city;
    private Boolean product;
    private Boolean admin;

	public  StockConverter(){
		init(true);
	}

	@Override 
 	public Stock toItem(StockVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Stock item = new Stock();
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
			 if(StringUtil.isNotEmpty(vo.getQte()))
                  item.setQte(NumberUtil.toBigDecimal(vo.getQte()));
             if(vo.getCityVo()!=null && this.city)
			     item.setCity(cityConverter.toItem(vo.getCityVo())) ;
             if(vo.getProductVo()!=null && this.product)
			     item.setProduct(productConverter.toItem(vo.getProductVo())) ;
             if(vo.getAdminVo()!=null && this.admin)
			     item.setAdmin(userConverter.toItem(vo.getAdminVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public StockVo toVo(Stock item) {
 		if (item == null) {
    		return null;
      	} else {
			StockVo vo = new StockVo();

			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
			 if(item.getQte()!=null)
				vo.setQte(NumberUtil.toString(item.getQte()));
            if(item.getCity()!=null && this.city) {
				   vo.setCityVo(cityConverter.toVo(item.getCity())) ;
			   } 
            if(item.getProduct()!=null && this.product) {
				   vo.setProductVo(productConverter.toVo(item.getProduct())) ;
			   } 
            if(item.getAdmin()!=null && this.admin) {
				   vo.setAdminVo(userConverter.toVo(item.getAdmin())) ;
			   } 

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       city = value;
       product = value;
       admin = value;
	}


	

	
	   public UserConverter getUserConverter(){
		return this.userConverter;
	}  
        public void setUserConverter(UserConverter userConverter ){
		 this.userConverter = userConverter;
	}  
	   public ProductConverter getProductConverter(){
		return this.productConverter;
	}  
        public void setProductConverter(ProductConverter productConverter ){
		 this.productConverter = productConverter;
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
	 public boolean  isProduct(){
		  return this.product;
	 }
	 public void  setProduct(boolean product){
		   this.product = product;
	 }
	 public boolean  isAdmin(){
		  return this.admin;
	 }
	 public void  setAdmin(boolean admin){
		   this.admin = admin;
	 }
}