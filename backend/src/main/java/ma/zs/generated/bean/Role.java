package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Role {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String authority ;


     public Role(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getAuthority(){
          return this.authority;
     }
     public void setAuthority(String authority){
          this.authority = authority;
     }



}

