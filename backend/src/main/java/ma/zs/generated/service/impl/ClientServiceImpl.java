package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Client;
import ma.zs.generated.bean.City;
import ma.zs.generated.bean.Command;
import ma.zs.generated.dao.ClientDao;
import ma.zs.generated.service.facade.ClientService;
import ma.zs.generated.service.facade.CommandService;   
import ma.zs.generated.service.facade.CityService;   

import ma.zs.generated.ws.rest.provided.vo.ClientVo;
import ma.zs.generated.service.util.*;
@Service
public class ClientServiceImpl implements ClientService {

   @Autowired
   private ClientDao clientDao;
   
    @Autowired
    private CommandService commandService ;
    @Autowired
    private CityService cityService ;

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Client> findAll(){
		return clientDao.findAll();
	}	
	@Override
	public List<Client> findByCityName(String name){
		return clientDao.findByCityName(name);
	}
	@Override
	@Transactional
    public int deleteByCityName(String name){
		return clientDao.deleteByCityName(name);
	}
	
     @Override
    public List<Client> findByCityId(Long id){
		return clientDao.findByCityId(id);

	}
	   @Override
	   @Transactional
    public int deleteByCityId(Long id){
		return clientDao.deleteByCityId(id);

	}
     		

	@Override
	public Client findById(Long id){
		 if(id==null)
		  return null;
		return clientDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           clientDao.deleteById(id);
   }
	@Override	
	public Client save (Client client){
	    
	          if(client.getCity()!=null){
				    City city = cityService.findByName(client.getCity().getName());
				  if(city == null)
				  client.setCity(cityService.save(client.getCity()));
				  else
				  client.setCity(city);
			  }

	    Client savedClient = clientDao.save(client);
               if(ListUtil.isNotEmpty(client.getCommands())){
		  savedClient.setCommands(commandService.save(prepareCommands(savedClient,client.getCommands())));
		 }
	   return savedClient;
	}

    @Override
    public List<Client> save(List<Client> clients){
		List<Client> list = new ArrayList<Client>();
		for(Client client: clients){
		        list.add(save(client));	
		}
		return list;
	}

     private List<Command> prepareCommands(Client client,List<Command> commands){
		    for(Command command:commands ){
                  command.setClient(client); 
			}
			return commands;
	  }

   @Override
   public Client update(Client client){
     
    
		  Client foundedClient = findById(client.getId()); 
		       if(foundedClient==null)
	          return null;	  
	  
	   return  clientDao.save(client);
     
     }
    
	@Override
	@Transactional
	public int delete(Client client){

		 if(client.getId()==null)
			  return -1;
		  Client foundedClient = findById(client.getId()); 
		       if(foundedClient==null)
	          return -1;	  
	   clientDao.delete(foundedClient);
	   return 1;
	}


	public List<Client> findByCriteria(ClientVo clientVo){
      String query = "SELECT o FROM Client o where 1=1 ";
			 query += SearchUtil.addConstraint( "o", "phoneNumber","LIKE",clientVo.getPhoneNumber());

			 query += SearchUtil.addConstraint( "o", "lastName","LIKE",clientVo.getLastName());

			 query += SearchUtil.addConstraint( "o", "email","LIKE",clientVo.getEmail());

			 query += SearchUtil.addConstraint( "o", "firstName","LIKE",clientVo.getFirstName());

		 	 query += SearchUtil.addConstraint( "o", "id","=",clientVo.getId());
   if(clientVo.getCityVo()!=null){
     query += SearchUtil.addConstraint( "o", "city.id","=",clientVo.getCityVo().getId());
     query += SearchUtil.addConstraint( "o", "city.name","LIKE",clientVo.getCityVo().getName());
   }
   
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
