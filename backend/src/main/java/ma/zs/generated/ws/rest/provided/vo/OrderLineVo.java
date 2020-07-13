package  ma.zs.generated.ws.rest.provided.vo;

import java.math.BigDecimal;   

public class OrderLineVo {

     private String price ;
   
     private String id ;
   

	private CommandVo commandVo ;
	private ProductVo productVo ;


     private String priceMax ;
     private String priceMin ;

 public OrderLineVo(){
       super();
     }


     public String getPrice(){
          return this.price;
     }
      public void setPrice(String price){
          this.price = price;
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }



      public String getPriceMax(){
          return this.priceMax;
     }
     
      public String getPriceMin(){
          return this.priceMin;
     }

     public void setPriceMax(String priceMax){
          this.priceMax = priceMax;
     }

     public void setPriceMin(String priceMin){
          this.priceMin = priceMin;
     }
     
     
     

      public CommandVo getCommandVo(){
          return this.commandVo;
     }
       
     public void setCommandVo(CommandVo commandVo){
          this.commandVo = commandVo;
     }
   
      public ProductVo getProductVo(){
          return this.productVo;
     }
       
     public void setProductVo(ProductVo productVo){
          this.productVo = productVo;
     }
   




}