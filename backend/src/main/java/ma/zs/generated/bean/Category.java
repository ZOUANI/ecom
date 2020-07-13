package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Category {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String label ;


     public Category(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getLabel(){
          return this.label;
     }
     public void setLabel(String label){
          this.label = label;
     }



}

