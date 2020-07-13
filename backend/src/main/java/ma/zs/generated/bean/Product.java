package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.OneToMany;
import java.math.BigDecimal;   
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Product {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String size ;
     private Integer qteStock ;
     private String label ;
     private BigDecimal weight ;
     private String color ;
     private BigDecimal price ;
     private String reference ;

     @OneToMany(mappedBy = "product")
     private List<OrderLine> orderLines ;

     public Product(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getReference(){
          return this.reference;
     }
     public void setReference(String reference){
          this.reference = reference;
     }
     public String getLabel(){
          return this.label;
     }
     public void setLabel(String label){
          this.label = label;
     }
     public BigDecimal getPrice(){
          return this.price;
     }
     public void setPrice(BigDecimal price){
          this.price = price;
     }
     public Integer getQteStock(){
          return this.qteStock;
     }
     public void setQteStock(Integer qteStock){
          this.qteStock = qteStock;
     }
     public String getSize(){
          return this.size;
     }
     public void setSize(String size){
          this.size = size;
     }
     public String getColor(){
          return this.color;
     }
     public void setColor(String color){
          this.color = color;
     }
     public BigDecimal getWeight(){
          return this.weight;
     }
     public void setWeight(BigDecimal weight){
          this.weight = weight;
     }
     public List<OrderLine> getOrderLines(){
          return this.orderLines;
     }
     
      public void setOrderLines(List<OrderLine> orderLines){
          this.orderLines = orderLines;
     }
     



}

