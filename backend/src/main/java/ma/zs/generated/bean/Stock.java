package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;   
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.City;
import ma.zs.generated.bean.Product;
import ma.zs.generated.bean.User;

@Entity
public class Stock {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private BigDecimal qte ;

     @ManyToOne
	private City city ;
     @ManyToOne
	private Product product ;
     @ManyToOne
	private User admin ;

     public Stock(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public Product getProduct(){
          return this.product;
     }
     public void setProduct(Product product){
          this.product = product;
     }
     public City getCity(){
          return this.city;
     }
     public void setCity(City city){
          this.city = city;
     }
     public User getAdmin(){
          return this.admin;
     }
     public void setAdmin(User admin){
          this.admin = admin;
     }
     public BigDecimal getQte(){
          return this.qte;
     }
     public void setQte(BigDecimal qte){
          this.qte = qte;
     }



}

