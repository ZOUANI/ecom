package  ma.zs.generated.ws.rest.provided.vo;

import java.math.BigDecimal;   

public class DeliveryCostVo {

     private String shippingCost ;
   
     private String id ;
   

	private CityVo cityVo ;
	private UserVo deliveryVo ;


     private String shippingCostMax ;
     private String shippingCostMin ;

 public DeliveryCostVo(){
       super();
     }


     public String getShippingCost(){
          return this.shippingCost;
     }
      public void setShippingCost(String shippingCost){
          this.shippingCost = shippingCost;
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }



      public String getShippingCostMax(){
          return this.shippingCostMax;
     }
     
      public String getShippingCostMin(){
          return this.shippingCostMin;
     }

     public void setShippingCostMax(String shippingCostMax){
          this.shippingCostMax = shippingCostMax;
     }

     public void setShippingCostMin(String shippingCostMin){
          this.shippingCostMin = shippingCostMin;
     }
     
     
     

      public CityVo getCityVo(){
          return this.cityVo;
     }
       
     public void setCityVo(CityVo cityVo){
          this.cityVo = cityVo;
     }
   
      public UserVo getDeliveryVo(){
          return this.deliveryVo;
     }
       
     public void setDeliveryVo(UserVo deliveryVo){
          this.deliveryVo = deliveryVo;
     }
   




}