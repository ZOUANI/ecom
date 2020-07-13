package  ma.zs.generated.ws.rest.provided.vo;

import java.math.BigDecimal;   

public class StockVo {

     private String id ;
   
     private String qte ;
   

	private CityVo cityVo ;
	private ProductVo productVo ;
	private UserVo adminVo ;


     private String qteMax ;
     private String qteMin ;

 public StockVo(){
       super();
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }


     public String getQte(){
          return this.qte;
     }
      public void setQte(String qte){
          this.qte = qte;
     }


     

      public String getQteMax(){
          return this.qteMax;
     }
     
      public String getQteMin(){
          return this.qteMin;
     }

     public void setQteMax(String qteMax){
          this.qteMax = qteMax;
     }

     public void setQteMin(String qteMin){
          this.qteMin = qteMin;
     }
     
     

      public CityVo getCityVo(){
          return this.cityVo;
     }
       
     public void setCityVo(CityVo cityVo){
          this.cityVo = cityVo;
     }
   
      public ProductVo getProductVo(){
          return this.productVo;
     }
       
     public void setProductVo(ProductVo productVo){
          this.productVo = productVo;
     }
   
      public UserVo getAdminVo(){
          return this.adminVo;
     }
       
     public void setAdminVo(UserVo adminVo){
          this.adminVo = adminVo;
     }
   




}