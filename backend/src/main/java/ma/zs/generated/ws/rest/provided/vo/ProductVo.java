package  ma.zs.generated.ws.rest.provided.vo;

import java.util.List;
import java.math.BigDecimal;   

public class ProductVo {

     private String size ;
   
     private String qteStock ;
   
     private String label ;
   
     private String price ;
   
     private String weight ;
   
     private String reference ;
   
     private String id ;
   
     private String color ;
   


     private List<OrderLineVo> orderLinesVo ;

     private String qteStockMax ;
     private String qteStockMin ;
     private String priceMax ;
     private String priceMin ;
     private String weightMax ;
     private String weightMin ;

 public ProductVo(){
       super();
     }


     public String getSize(){
          return this.size;
     }
      public void setSize(String size){
          this.size = size;
     }


     public String getQteStock(){
          return this.qteStock;
     }
      public void setQteStock(String qteStock){
          this.qteStock = qteStock;
     }


     public String getLabel(){
          return this.label;
     }
      public void setLabel(String label){
          this.label = label;
     }


     public String getPrice(){
          return this.price;
     }
      public void setPrice(String price){
          this.price = price;
     }


     public String getWeight(){
          return this.weight;
     }
      public void setWeight(String weight){
          this.weight = weight;
     }


     public String getReference(){
          return this.reference;
     }
      public void setReference(String reference){
          this.reference = reference;
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }


     public String getColor(){
          return this.color;
     }
      public void setColor(String color){
          this.color = color;
     }



      public String getQteStockMax(){
          return this.qteStockMax;
     }
     
      public String getQteStockMin(){
          return this.qteStockMin;
     }

     public void setQteStockMax(String qteStockMax){
          this.qteStockMax = qteStockMax;
     }

     public void setQteStockMin(String qteStockMin){
          this.qteStockMin = qteStockMin;
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
     
     

      public String getWeightMax(){
          return this.weightMax;
     }
     
      public String getWeightMin(){
          return this.weightMin;
     }

     public void setWeightMax(String weightMax){
          this.weightMax = weightMax;
     }

     public void setWeightMin(String weightMin){
          this.weightMin = weightMin;
     }
     
     
     


      public List<OrderLineVo> getOrderLinesVo(){
          return this.orderLinesVo;
     }
       
     public void setOrderLinesVo(List<OrderLineVo> orderLinesVo){
          this.orderLinesVo = orderLinesVo;
     }



}