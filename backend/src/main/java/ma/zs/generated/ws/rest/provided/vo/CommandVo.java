package  ma.zs.generated.ws.rest.provided.vo;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;   

public class CommandVo {

     private String total ;
   
     private String regulationDate ;
   
     private String adress ;
   
     private String reference ;
   
     private String remarque ;
   
     private String orderDate ;
   
     private String id ;
   

	private UserVo deliveryVo ;
	private UserVo validatorVo ;
	private UserVo adminVo ;
	private ClientVo clientVo ;
	private OrderStatusVo orderStatusVo ;
	private CityVo cityVo ;

     private List<OrderLineVo> orderLinesVo ;

     private String totalMax ;
     private String totalMin ;
     private String regulationDateMax ;
     private String regulationDateMin ;
     private String orderDateMax ;
     private String orderDateMin ;

 public CommandVo(){
       super();
     }


     public String getTotal(){
          return this.total;
     }
      public void setTotal(String total){
          this.total = total;
     }


     public String getRegulationDate(){
          return this.regulationDate;
     }
      public void setRegulationDate(String regulationDate){
          this.regulationDate = regulationDate;
     }


     public String getAdress(){
          return this.adress;
     }
      public void setAdress(String adress){
          this.adress = adress;
     }


     public String getReference(){
          return this.reference;
     }
      public void setReference(String reference){
          this.reference = reference;
     }


     public String getRemarque(){
          return this.remarque;
     }
      public void setRemarque(String remarque){
          this.remarque = remarque;
     }


     public String getOrderDate(){
          return this.orderDate;
     }
      public void setOrderDate(String orderDate){
          this.orderDate = orderDate;
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }



      public String getTotalMax(){
          return this.totalMax;
     }
     
      public String getTotalMin(){
          return this.totalMin;
     }

     public void setTotalMax(String totalMax){
          this.totalMax = totalMax;
     }

     public void setTotalMin(String totalMin){
          this.totalMin = totalMin;
     }
     
     

      public String getRegulationDateMax(){
          return this.regulationDateMax;
     }
     
      public String getRegulationDateMin(){
          return this.regulationDateMin;
     }

     public void setRegulationDateMax(String regulationDateMax){
          this.regulationDateMax = regulationDateMax;
     }

     public void setRegulationDateMin(String regulationDateMin){
          this.regulationDateMin = regulationDateMin;
     }
     
     

      public String getOrderDateMax(){
          return this.orderDateMax;
     }
     
      public String getOrderDateMin(){
          return this.orderDateMin;
     }

     public void setOrderDateMax(String orderDateMax){
          this.orderDateMax = orderDateMax;
     }

     public void setOrderDateMin(String orderDateMin){
          this.orderDateMin = orderDateMin;
     }
     
     
     

      public UserVo getDeliveryVo(){
          return this.deliveryVo;
     }
       
     public void setDeliveryVo(UserVo deliveryVo){
          this.deliveryVo = deliveryVo;
     }
   
      public UserVo getValidatorVo(){
          return this.validatorVo;
     }
       
     public void setValidatorVo(UserVo validatorVo){
          this.validatorVo = validatorVo;
     }
   
      public UserVo getAdminVo(){
          return this.adminVo;
     }
       
     public void setAdminVo(UserVo adminVo){
          this.adminVo = adminVo;
     }
   
      public ClientVo getClientVo(){
          return this.clientVo;
     }
       
     public void setClientVo(ClientVo clientVo){
          this.clientVo = clientVo;
     }
   
      public OrderStatusVo getOrderStatusVo(){
          return this.orderStatusVo;
     }
       
     public void setOrderStatusVo(OrderStatusVo orderStatusVo){
          this.orderStatusVo = orderStatusVo;
     }
   
      public CityVo getCityVo(){
          return this.cityVo;
     }
       
     public void setCityVo(CityVo cityVo){
          this.cityVo = cityVo;
     }
   

      public List<OrderLineVo> getOrderLinesVo(){
          return this.orderLinesVo;
     }
       
     public void setOrderLinesVo(List<OrderLineVo> orderLinesVo){
          this.orderLinesVo = orderLinesVo;
     }



}