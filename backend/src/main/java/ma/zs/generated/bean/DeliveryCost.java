package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;   
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.City;
import ma.zs.generated.bean.User;

@Entity
public class DeliveryCost {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private BigDecimal shippingCost ;

     @ManyToOne
	private City city ;
     @ManyToOne
	private User delivery ;

     public DeliveryCost(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public User getDelivery(){
          return this.delivery;
     }
     public void setDelivery(User delivery){
          this.delivery = delivery;
     }
     public City getCity(){
          return this.city;
     }
     public void setCity(City city){
          this.city = city;
     }
     public BigDecimal getShippingCost(){
          return this.shippingCost;
     }
     public void setShippingCost(BigDecimal shippingCost){
          this.shippingCost = shippingCost;
     }



}

