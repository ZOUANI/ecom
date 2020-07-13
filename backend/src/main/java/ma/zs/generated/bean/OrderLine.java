package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;   
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.Command;
import ma.zs.generated.bean.Product;

@Entity
public class OrderLine {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private BigDecimal price ;

     @ManyToOne
	private Command command ;
     @ManyToOne
	private Product product ;

     public OrderLine(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public BigDecimal getQte(){
          return this.qte;
     }
     public void setQte(BigDecimal qte){
          this.qte = qte;
     }
     public BigDecimal getPrice(){
          return this.price;
     }
     public void setPrice(BigDecimal price){
          this.price = price;
     }
     public Product getProduct(){
          return this.product;
     }
     public void setProduct(Product product){
          this.product = product;
     }
     public Command getCommand(){
          return this.command;
     }
     public void setCommand(Command command){
          this.command = command;
     }



}

