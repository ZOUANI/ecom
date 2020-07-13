package  ma.zs.generated.ws.rest.provided.vo;

import java.util.List;

public class ClientVo {

     private String phoneNumber ;
   
     private String lastName ;
   
     private String email ;
   
     private String firstName ;
   
     private String id ;
   

	private CityVo cityVo ;

     private List<CommandVo> commandsVo ;


 public ClientVo(){
       super();
     }


     public String getPhoneNumber(){
          return this.phoneNumber;
     }
      public void setPhoneNumber(String phoneNumber){
          this.phoneNumber = phoneNumber;
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


     public String getFirstName(){
          return this.firstName;
     }
      public void setFirstName(String firstName){
          this.firstName = firstName;
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }


     

      public CityVo getCityVo(){
          return this.cityVo;
     }
       
     public void setCityVo(CityVo cityVo){
          this.cityVo = cityVo;
     }
   

      public List<CommandVo> getCommandsVo(){
          return this.commandsVo;
     }
       
     public void setCommandsVo(List<CommandVo> commandsVo){
          this.commandsVo = commandsVo;
     }



}