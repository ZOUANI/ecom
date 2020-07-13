package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.Command;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.User;
import ma.zs.generated.bean.Client;
import ma.zs.generated.bean.OrderStatus;
import ma.zs.generated.bean.City;
import ma.zs.generated.bean.OrderLine;
import ma.zs.generated.dao.CommandDao;
import ma.zs.generated.service.facade.CommandService;
import ma.zs.generated.service.facade.UserService;   
import ma.zs.generated.service.facade.OrderLineService;   
import ma.zs.generated.service.facade.CityService;   
import ma.zs.generated.service.facade.ClientService;   
import ma.zs.generated.service.facade.OrderStatusService;   

import ma.zs.generated.ws.rest.provided.vo.CommandVo;
import ma.zs.generated.service.util.*;
@Service
public class CommandServiceImpl implements CommandService {

   @Autowired
   private CommandDao commandDao;
   
    @Autowired
    private UserService userService ;
    @Autowired
    private OrderLineService orderLineService ;
    @Autowired
    private CityService cityService ;
    @Autowired
    private ClientService clientService ;
    @Autowired
    private OrderStatusService orderStatusService ;

   @Autowired 
   private EntityManager entityManager; 

	@Override
	public List<Command> findAll(){
		return commandDao.findAll();
	}	
	@Override
	public List<Command> findByDeliveryCode(String code){
		return commandDao.findByDeliveryCode(code);
	}
	@Override
	@Transactional
    public int deleteByDeliveryCode(String code){
		return commandDao.deleteByDeliveryCode(code);
	}
	
     @Override
    public List<Command> findByDeliveryId(Long id){
		return commandDao.findByDeliveryId(id);

	}
	   @Override
	   @Transactional
    public int deleteByDeliveryId(Long id){
		return commandDao.deleteByDeliveryId(id);

	}
     		
	@Override
	public List<Command> findByValidatorCode(String code){
		return commandDao.findByValidatorCode(code);
	}
	@Override
	@Transactional
    public int deleteByValidatorCode(String code){
		return commandDao.deleteByValidatorCode(code);
	}
	
     @Override
    public List<Command> findByValidatorId(Long id){
		return commandDao.findByValidatorId(id);

	}
	   @Override
	   @Transactional
    public int deleteByValidatorId(Long id){
		return commandDao.deleteByValidatorId(id);

	}
     		
	@Override
	public List<Command> findByAdminCode(String code){
		return commandDao.findByAdminCode(code);
	}
	@Override
	@Transactional
    public int deleteByAdminCode(String code){
		return commandDao.deleteByAdminCode(code);
	}
	
     @Override
    public List<Command> findByAdminId(Long id){
		return commandDao.findByAdminId(id);

	}
	   @Override
	   @Transactional
    public int deleteByAdminId(Long id){
		return commandDao.deleteByAdminId(id);

	}
     		
     @Override
    public List<Command> findByClientId(Long id){
		return commandDao.findByClientId(id);

	}
	   @Override
	   @Transactional
    public int deleteByClientId(Long id){
		return commandDao.deleteByClientId(id);

	}
     		
	@Override
	public List<Command> findByOrderStatusLabel(String label){
		return commandDao.findByOrderStatusLabel(label);
	}
	@Override
	@Transactional
    public int deleteByOrderStatusLabel(String label){
		return commandDao.deleteByOrderStatusLabel(label);
	}
	
     @Override
    public List<Command> findByOrderStatusId(Long id){
		return commandDao.findByOrderStatusId(id);

	}
	   @Override
	   @Transactional
    public int deleteByOrderStatusId(Long id){
		return commandDao.deleteByOrderStatusId(id);

	}
     		
	@Override
	public List<Command> findByCityName(String name){
		return commandDao.findByCityName(name);
	}
	@Override
	@Transactional
    public int deleteByCityName(String name){
		return commandDao.deleteByCityName(name);
	}
	
     @Override
    public List<Command> findByCityId(Long id){
		return commandDao.findByCityId(id);

	}
	   @Override
	   @Transactional
    public int deleteByCityId(Long id){
		return commandDao.deleteByCityId(id);

	}
     		
	@Override
	public Command findByReference(String reference){
		if( reference==null)
		  return null;
		return commandDao.findByReference(reference);
	}

   

	@Override
	@Transactional
	public int deleteByReference(String  reference) {
		return commandDao.deleteByReference(reference);	 
	}

	@Override
	public Command findById(Long id){
		 if(id==null)
		  return null;
		return commandDao.getOne(id);
	}
    
	@Transactional
   public void deleteById(Long id){
           commandDao.deleteById(id);
   }
	@Override	
	public Command save (Command command){
			Command foundedCommand = findByReference(command.getReference());
	       if(foundedCommand!=null)
	          return null;  
	    
	          if(command.getDelivery()!=null){
				    User delivery = userService.findByCode(command.getDelivery().getCode());
				  if(delivery == null)
				  command.setDelivery(userService.save(command.getDelivery()));
				  else
				  command.setDelivery(delivery);
			  }
	    
	          if(command.getValidator()!=null){
				    User validator = userService.findByCode(command.getValidator().getCode());
				  if(validator == null)
				  command.setValidator(userService.save(command.getValidator()));
				  else
				  command.setValidator(validator);
			  }
	    
	          if(command.getAdmin()!=null){
				    User admin = userService.findByCode(command.getAdmin().getCode());
				  if(admin == null)
				  command.setAdmin(userService.save(command.getAdmin()));
				  else
				  command.setAdmin(admin);
			  }
	    
	          if(command.getClient()!=null){
                      Client client = clientService.findById(command.getClient().getId());
				  
				  if(client == null)
				  command.setClient(clientService.save(command.getClient()));
				  else
				  command.setClient(client);
			  }
	    
	          if(command.getOrderStatus()!=null){
				    OrderStatus orderStatus = orderStatusService.findByLabel(command.getOrderStatus().getLabel());
				  if(orderStatus == null)
				  command.setOrderStatus(orderStatusService.save(command.getOrderStatus()));
				  else
				  command.setOrderStatus(orderStatus);
			  }
	    
	          if(command.getCity()!=null){
				    City city = cityService.findByName(command.getCity().getName());
				  if(city == null)
				  command.setCity(cityService.save(command.getCity()));
				  else
				  command.setCity(city);
			  }

	    Command savedCommand = commandDao.save(command);
               if(ListUtil.isNotEmpty(command.getOrderLines())){
		  savedCommand.setOrderLines(orderLineService.save(prepareOrderLines(savedCommand,command.getOrderLines())));
		 }
	   return savedCommand;
	}

    @Override
    public List<Command> save(List<Command> commands){
		List<Command> list = new ArrayList<Command>();
		for(Command command: commands){
		        list.add(save(command));	
		}
		return list;
	}

     private List<OrderLine> prepareOrderLines(Command command,List<OrderLine> orderLines){
		    for(OrderLine orderLine:orderLines ){
                  orderLine.setCommand(command); 
			}
			return orderLines;
	  }

   @Override
   public Command update(Command command){
     
    
		  Command foundedCommand = findById(command.getId()); 
		       if(foundedCommand==null)
	          return null;	  
	  
	   return  commandDao.save(command);
     
     }
    
	@Override
	@Transactional
	public int delete(Command command){

	        if(command.getReference()==null)
			  return -1;
		
			Command foundedCommand = findByReference(command.getReference());
	       if(foundedCommand==null)
	          return -1;  
	   commandDao.delete(foundedCommand);
	   return 1;
	}


	public List<Command> findByCriteria(CommandVo commandVo){
      String query = "SELECT o FROM Command o where 1=1 ";
		 	 query += SearchUtil.addConstraint( "o", "total","=",commandVo.getTotal());
	  query += SearchUtil.addConstraintDate( "o", "regulationDate","=",commandVo.getRegulationDate());
			 query += SearchUtil.addConstraint( "o", "adress","LIKE",commandVo.getAdress());

			 query += SearchUtil.addConstraint( "o", "reference","LIKE",commandVo.getReference());

			 query += SearchUtil.addConstraint( "o", "remarque","LIKE",commandVo.getRemarque());

	  query += SearchUtil.addConstraintDate( "o", "orderDate","=",commandVo.getOrderDate());
		 	 query += SearchUtil.addConstraint( "o", "id","=",commandVo.getId());
	  query += SearchUtil.addConstraintMinMax("o","total",commandVo.getTotalMin(),commandVo.getTotalMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","regulationDate",commandVo.getRegulationDateMin(),commandVo.getRegulationDateMax());
	  query += SearchUtil.addConstraintMinMaxDate("o","orderDate",commandVo.getOrderDateMin(),commandVo.getOrderDateMax());
   if(commandVo.getDeliveryVo()!=null){
     query += SearchUtil.addConstraint( "o", "delivery.id","=",commandVo.getDeliveryVo().getId());
     query += SearchUtil.addConstraint( "o", "delivery.code","LIKE",commandVo.getDeliveryVo().getCode());
   }
   
   if(commandVo.getValidatorVo()!=null){
     query += SearchUtil.addConstraint( "o", "validator.id","=",commandVo.getValidatorVo().getId());
     query += SearchUtil.addConstraint( "o", "validator.code","LIKE",commandVo.getValidatorVo().getCode());
   }
   
   if(commandVo.getAdminVo()!=null){
     query += SearchUtil.addConstraint( "o", "admin.id","=",commandVo.getAdminVo().getId());
     query += SearchUtil.addConstraint( "o", "admin.code","LIKE",commandVo.getAdminVo().getCode());
   }
   
   if(commandVo.getClientVo()!=null){
     query += SearchUtil.addConstraint( "o", "client.id","=",commandVo.getClientVo().getId());
   }
   
   if(commandVo.getOrderStatusVo()!=null){
     query += SearchUtil.addConstraint( "o", "orderStatus.id","=",commandVo.getOrderStatusVo().getId());
     query += SearchUtil.addConstraint( "o", "orderStatus.label","LIKE",commandVo.getOrderStatusVo().getLabel());
   }
   
   if(commandVo.getCityVo()!=null){
     query += SearchUtil.addConstraint( "o", "city.id","=",commandVo.getCityVo().getId());
     query += SearchUtil.addConstraint( "o", "city.name","LIKE",commandVo.getCityVo().getName());
   }
   
	 return entityManager.createQuery(query).getResultList();
	}
	
 
}
