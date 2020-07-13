package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.Category;
import ma.zs.generated.bean.Product;

@Entity
public class CategoryProduct {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;


     @ManyToOne
	private Category category ;
     @ManyToOne
	private Product product ;

     public CategoryProduct(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public Category getCategory(){
          return this.category;
     }
     public void setCategory(Category category){
          this.category = category;
     }
     public Product getProduct(){
          return this.product;
     }
     public void setProduct(Product product){
          this.product = product;
     }



}

