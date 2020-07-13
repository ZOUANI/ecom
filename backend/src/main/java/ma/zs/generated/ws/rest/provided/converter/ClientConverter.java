package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Client; 
import ma.zs.generated.ws.rest.provided.vo.ClientVo;

@Component 
public class ClientConverter extends AbstractConverter<Client,ClientVo>{ 
	
	   @Autowired
         private CommandConverter commandConverter ;
	   @Autowired
         private CityConverter cityConverter ;
    private Boolean city;
    private Boolean commands;

	public  ClientConverter(){
		init(true);
	}

	@Override 
 	public Client toItem(ClientVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Client item = new Client();
			 if(StringUtil.isNotEmpty(vo.getPhoneNumber()))
                  item.setPhoneNumber(vo.getPhoneNumber());
			 if(StringUtil.isNotEmpty(vo.getLastName()))
                  item.setLastName(vo.getLastName());
			 if(StringUtil.isNotEmpty(vo.getEmail()))
                  item.setEmail(vo.getEmail());
			 if(StringUtil.isNotEmpty(vo.getFirstName()))
                  item.setFirstName(vo.getFirstName());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getCityVo()!=null && this.city)
			     item.setCity(cityConverter.toItem(vo.getCityVo())) ;

	         if(ListUtil.isNotEmpty(vo.getCommandsVo()) && this.commands)
                  item.setCommands(commandConverter.toItem(vo.getCommandsVo()));



		return item;
 		}
 	}

 	 @Override 
 	public ClientVo toVo(Client item) {
 		if (item == null) {
    		return null;
      	} else {
			ClientVo vo = new ClientVo();

			if(StringUtil.isNotEmpty(item.getPhoneNumber()))
				vo.setPhoneNumber(item.getPhoneNumber());
			
			if(StringUtil.isNotEmpty(item.getLastName()))
				vo.setLastName(item.getLastName());
			
			if(StringUtil.isNotEmpty(item.getEmail()))
				vo.setEmail(item.getEmail());
			
			if(StringUtil.isNotEmpty(item.getFirstName()))
				vo.setFirstName(item.getFirstName());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getCity()!=null && this.city) {
				   vo.setCityVo(cityConverter.toVo(item.getCity())) ;
			   } 
	         if(ListUtil.isNotEmpty(item.getCommands()) && this.commands){
				
				 commandConverter.init(false);
                vo.setCommandsVo(commandConverter.toVo(item.getCommands()));
              	 commandConverter.init(true);
			 }

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       city = value;
       commands = value;
	}


	

	
	   public CommandConverter getCommandConverter(){
		return this.commandConverter;
	}  
        public void setCommandConverter(CommandConverter commandConverter ){
		 this.commandConverter = commandConverter;
	}  
	   public CityConverter getCityConverter(){
		return this.cityConverter;
	}  
        public void setCityConverter(CityConverter cityConverter ){
		 this.cityConverter = cityConverter;
	}  
	
	 public boolean  isCity(){
		  return this.city;
	 }
	 public void  setCity(boolean city){
		   this.city = city;
	 }
       public Boolean  isCommands(){
		 return this.commands ;
	   }
		 public void  setCommands(Boolean commands ){
            this.commands  = commands ;
		 }
}