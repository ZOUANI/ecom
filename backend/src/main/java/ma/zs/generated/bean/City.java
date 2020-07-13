package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class City {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String name ;
     private String postCode ;


     public City(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getName(){
          return this.name;
     }
     public void setName(String name){
          this.name = name;
     }
     public String getPostCode(){
          return this.postCode;
     }
     public void setPostCode(String postCode){
          this.postCode = postCode;
     }



}

