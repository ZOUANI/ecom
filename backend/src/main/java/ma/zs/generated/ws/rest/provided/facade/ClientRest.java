package  ma.zs.generated.ws.rest.provided.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zs.generated.bean.Client; 
import ma.zs.generated.service.facade.ClientService;
import ma.zs.generated.ws.rest.provided.converter.ClientConverter;
import ma.zs.generated.ws.rest.provided.vo.ClientVo;

@Api("Manages client services")
@RestController
@RequestMapping("generated/client")
public class ClientRest {

	@Autowired 
	private ClientService clientService;
	
	@Autowired 
	private ClientConverter clientConverter ;

    @ApiOperation("Saves the specified client")
	@PostMapping("/")
	public ClientVo save(@RequestBody ClientVo clientVo){
		Client client= clientConverter.toItem(clientVo);
	  client=	clientService.save(client);
		return clientConverter.toVo(client);
	}

    @ApiOperation("Delete the specified client")
	@DeleteMapping("/")
	public int delete(@RequestBody ClientVo clientVo){
		Client client = clientConverter.toItem(clientVo);
		return clientService.delete(client);
	}

	@ApiOperation("Updates the specified client")
	@PutMapping("/")
	public ClientVo update(@RequestBody ClientVo clientVo){
		Client client= clientConverter.toItem(clientVo);
	  client=	clientService.update(client);
		return clientConverter.toVo(client);
	}

	@ApiOperation("Finds a list of all clients")
	@GetMapping("/")
	public List<ClientVo> findAll(){
		return clientConverter.toVo(clientService.findAll());
	}
    
	@ApiOperation("Finds a client by id")
	@GetMapping("/id/{id}")
	public ClientVo findById(@PathVariable Long id){
		return  clientConverter.toVo(clientService.findById(id));
	}
	@ApiOperation("Deletes a client by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 clientService.deleteById(id);
	}



    @ApiOperation("Finds a client by name of city")
	@GetMapping("/city/name/{name}")
	public List<ClientVo> findByCityName(@PathVariable String name){
		return clientConverter.toVo(clientService.findByCityName(name));
	}
	
	@ApiOperation("Deletes a client by name of city")
	@DeleteMapping("/city/name/{name}")
	public int deleteByCityName(@PathVariable String name){
		return clientService.deleteByCityName(name);
	}
	
	@ApiOperation("Finds client by id of city")
	@GetMapping("/city/id/{id}")
	public List<ClientVo> findByCityId(@PathVariable Long id){
		return clientConverter.toVo(clientService.findByCityId(id));
	}
	@ApiOperation("Deletes client by id of city")
	@DeleteMapping("/city/id/{id}")
	public int deleteByCityId(@PathVariable Long id){
		return clientService.deleteByCityId(id);
	}
     	
   
    @ApiOperation("Search client by a specific criterion")
    @PostMapping("/search")
	public List<ClientVo> findByCriteria(@RequestBody ClientVo clientVo){
       return clientConverter.toVo(clientService.findByCriteria(clientVo));
	}	
	public ClientConverter getClientConverter(){
		return clientConverter;
	}
 
	public void setClientConverter(ClientConverter clientConverter){
		this.clientConverter=clientConverter;
	}

	public ClientService getClientService(){
		return clientService;
	}
	public void setClientService( ClientService clientService){
	 	this.clientService=clientService;
	}
	

}