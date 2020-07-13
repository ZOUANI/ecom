package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.City;

@Entity
public class Client {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String phoneNumber ;
     private String lastName ;
     private String email ;
     private String firstName ;

     @ManyToOne
	private City city ;
     @OneToMany(mappedBy = "client")
     private List<Command> commands ;

     public Client(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getFirstName(){
          return this.firstName;
     }
     public void setFirstName(String firstName){
          this.firstName = firstName;
     }
     public String getLastName(){
          return this.lastName;
     }
     public void setLastName(String lastName){
          this.lastName = lastName;
     }
     public String getEmail(){
          return this.email;
     }
     public void setEmail(String email){
          this.email = email;
     }
     public String getAddress(){
          return this.address;
     }
     public void setAddress(String address){
          this.address = address;
     }
     public String getPhoneNumber(){
          return this.phoneNumber;
     }
     public void setPhoneNumber(String phoneNumber){
          this.phoneNumber = phoneNumber;
     }
     public City getCity(){
          return this.city;
     }
     public void setCity(City city){
          this.city = city;
     }
     public List<Command> getCommands(){
          return this.commands;
     }
     public void setCommands(List<Command> commands){
          this.commands = commands;
     }



}

