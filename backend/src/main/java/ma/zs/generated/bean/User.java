package ma.zs.generated.bean;

import javax.persistence.ManyToOne;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.DeliveryType;
import ma.zs.generated.bean.City;
import ma.zs.generated.bean.Role;

@Entity
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

     private String password ;
     private Boolean enabled;
     private String phoneNumber ;
     private String lastName ;
     private String email ;
     @JsonFormat(pattern="yyyy-MM-dd")
     @Temporal(TemporalType.DATE)
     private Date created ;
     private String code ;
     private String firsttName ;

     @ManyToOne
	private User superAdmin ;
     @ManyToOne
	private DeliveryType deliveryType ;
     @ManyToOne
	private City city ;
     @ManyToOne
	private Role authority ;

     public User(){
       super();
     }

     public Long getId(){
          return this.id;
     }
     public void setId(Long id){
          this.id = id;
     }
     public String getCode(){
          return this.code;
     }
     public void setCode(String code){
          this.code = code;
     }
     public String getFirsttName(){
          return this.firsttName;
     }
     public void setFirsttName(String firsttName){
          this.firsttName = firsttName;
     }
     public String getLastName(){
          return this.lastName;
     }
     public void setLastName(String lastName){
          this.lastName = lastName;
     }
     public Date getCreated(){
          return this.created;
     }
     public void setCreated(Date created){
          this.created = created;
     }
     public String getEmail(){
          return this.email;
     }
     public void setEmail(String email){
          this.email = email;
     }
     public String getPhoneNumber(){
          return this.phoneNumber;
     }
     public void setPhoneNumber(String phoneNumber){
          this.phoneNumber = phoneNumber;
     }
     public String getPassword(){
          return this.password;
     }
     public void setPassword(String password){
          this.password = password;
     }
    public Boolean isEnabled(){
          return this.enabled;
     }
       public void setEnabled(Boolean enabled){
          this.enabled = enabled;
     }
     public Role getAuthority(){
          return this.authority;
     }
     public void setAuthority(Role authority){
          this.authority = authority;
     }
     public City getCity(){
          return this.city;
     }
     public void setCity(City city){
          this.city = city;
     }
     public User getSuperAdmin(){
          return this.superAdmin;
     }
     public void setSuperAdmin(User superAdmin){
          this.superAdmin = superAdmin;
     }
     public DeliveryType getDeliveryType(){
          return this.deliveryType;
     }
     public void setDeliveryType(DeliveryType deliveryType){
          this.deliveryType = deliveryType;
     }



}

