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
import ma.zs.generated.bean.Command; 
import ma.zs.generated.service.facade.CommandService;
import ma.zs.generated.ws.rest.provided.converter.CommandConverter;
import ma.zs.generated.ws.rest.provided.vo.CommandVo;

@Api("Manages command services")
@RestController
@RequestMapping("generated/command")
public class CommandRest {

	@Autowired 
	private CommandService commandService;
	
	@Autowired 
	private CommandConverter commandConverter ;

    @ApiOperation("Saves the specified command")
	@PostMapping("/")
	public CommandVo save(@RequestBody CommandVo commandVo){
		Command command= commandConverter.toItem(commandVo);
	  command=	commandService.save(command);
		return commandConverter.toVo(command);
	}

    @ApiOperation("Delete the specified command")
	@DeleteMapping("/")
	public int delete(@RequestBody CommandVo commandVo){
		Command command = commandConverter.toItem(commandVo);
		return commandService.delete(command);
	}

	@ApiOperation("Updates the specified command")
	@PutMapping("/")
	public CommandVo update(@RequestBody CommandVo commandVo){
		Command command= commandConverter.toItem(commandVo);
	  command=	commandService.update(command);
		return commandConverter.toVo(command);
	}

	@ApiOperation("Finds a list of all commands")
	@GetMapping("/")
	public List<CommandVo> findAll(){
		return commandConverter.toVo(commandService.findAll());
	}
    
	@ApiOperation("Finds a command by id")
	@GetMapping("/id/{id}")
	public CommandVo findById(@PathVariable Long id){
		return  commandConverter.toVo(commandService.findById(id));
	}
	@ApiOperation("Deletes a command by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 commandService.deleteById(id);
	}

	@ApiOperation("Finds a  command by reference")
    @GetMapping("/reference/{reference}")
	public CommandVo findByReference(@PathVariable String reference){
		return  commandConverter.toVo(commandService.findByReference(reference));
	}
	@ApiOperation("Deletes a  command by reference")
    @DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference){
		return  commandService.deleteByReference(reference);
	}
	


    @ApiOperation("Finds a command by code of delivery")
	@GetMapping("/delivery/code/{code}")
	public List<CommandVo> findByDeliveryCode(@PathVariable String code){
		return commandConverter.toVo(commandService.findByDeliveryCode(code));
	}
	
	@ApiOperation("Deletes a command by code of delivery")
	@DeleteMapping("/delivery/code/{code}")
	public int deleteByDeliveryCode(@PathVariable String code){
		return commandService.deleteByDeliveryCode(code);
	}
	
	@ApiOperation("Finds command by id of delivery")
	@GetMapping("/delivery/id/{id}")
	public List<CommandVo> findByDeliveryId(@PathVariable Long id){
		return commandConverter.toVo(commandService.findByDeliveryId(id));
	}
	@ApiOperation("Deletes command by id of delivery")
	@DeleteMapping("/delivery/id/{id}")
	public int deleteByDeliveryId(@PathVariable Long id){
		return commandService.deleteByDeliveryId(id);
	}
     	
    @ApiOperation("Finds a command by code of validator")
	@GetMapping("/validator/code/{code}")
	public List<CommandVo> findByValidatorCode(@PathVariable String code){
		return commandConverter.toVo(commandService.findByValidatorCode(code));
	}
	
	@ApiOperation("Deletes a command by code of validator")
	@DeleteMapping("/validator/code/{code}")
	public int deleteByValidatorCode(@PathVariable String code){
		return commandService.deleteByValidatorCode(code);
	}
	
	@ApiOperation("Finds command by id of validator")
	@GetMapping("/validator/id/{id}")
	public List<CommandVo> findByValidatorId(@PathVariable Long id){
		return commandConverter.toVo(commandService.findByValidatorId(id));
	}
	@ApiOperation("Deletes command by id of validator")
	@DeleteMapping("/validator/id/{id}")
	public int deleteByValidatorId(@PathVariable Long id){
		return commandService.deleteByValidatorId(id);
	}
     	
    @ApiOperation("Finds a command by code of admin")
	@GetMapping("/admin/code/{code}")
	public List<CommandVo> findByAdminCode(@PathVariable String code){
		return commandConverter.toVo(commandService.findByAdminCode(code));
	}
	
	@ApiOperation("Deletes a command by code of admin")
	@DeleteMapping("/admin/code/{code}")
	public int deleteByAdminCode(@PathVariable String code){
		return commandService.deleteByAdminCode(code);
	}
	
	@ApiOperation("Finds command by id of admin")
	@GetMapping("/admin/id/{id}")
	public List<CommandVo> findByAdminId(@PathVariable Long id){
		return commandConverter.toVo(commandService.findByAdminId(id));
	}
	@ApiOperation("Deletes command by id of admin")
	@DeleteMapping("/admin/id/{id}")
	public int deleteByAdminId(@PathVariable Long id){
		return commandService.deleteByAdminId(id);
	}
     	
	
	@ApiOperation("Finds command by id of client")
	@GetMapping("/client/id/{id}")
	public List<CommandVo> findByClientId(@PathVariable Long id){
		return commandConverter.toVo(commandService.findByClientId(id));
	}
	@ApiOperation("Deletes command by id of client")
	@DeleteMapping("/client/id/{id}")
	public int deleteByClientId(@PathVariable Long id){
		return commandService.deleteByClientId(id);
	}
     	
    @ApiOperation("Finds a command by label of orderStatus")
	@GetMapping("/orderStatus/label/{label}")
	public List<CommandVo> findByOrderStatusLabel(@PathVariable String label){
		return commandConverter.toVo(commandService.findByOrderStatusLabel(label));
	}
	
	@ApiOperation("Deletes a command by label of orderStatus")
	@DeleteMapping("/orderStatus/label/{label}")
	public int deleteByOrderStatusLabel(@PathVariable String label){
		return commandService.deleteByOrderStatusLabel(label);
	}
	
	@ApiOperation("Finds command by id of orderStatus")
	@GetMapping("/orderStatus/id/{id}")
	public List<CommandVo> findByOrderStatusId(@PathVariable Long id){
		return commandConverter.toVo(commandService.findByOrderStatusId(id));
	}
	@ApiOperation("Deletes command by id of orderStatus")
	@DeleteMapping("/orderStatus/id/{id}")
	public int deleteByOrderStatusId(@PathVariable Long id){
		return commandService.deleteByOrderStatusId(id);
	}
     	
    @ApiOperation("Finds a command by name of city")
	@GetMapping("/city/name/{name}")
	public List<CommandVo> findByCityName(@PathVariable String name){
		return commandConverter.toVo(commandService.findByCityName(name));
	}
	
	@ApiOperation("Deletes a command by name of city")
	@DeleteMapping("/city/name/{name}")
	public int deleteByCityName(@PathVariable String name){
		return commandService.deleteByCityName(name);
	}
	
	@ApiOperation("Finds command by id of city")
	@GetMapping("/city/id/{id}")
	public List<CommandVo> findByCityId(@PathVariable Long id){
		return commandConverter.toVo(commandService.findByCityId(id));
	}
	@ApiOperation("Deletes command by id of city")
	@DeleteMapping("/city/id/{id}")
	public int deleteByCityId(@PathVariable Long id){
		return commandService.deleteByCityId(id);
	}
     	
   
    @ApiOperation("Search command by a specific criterion")
    @PostMapping("/search")
	public List<CommandVo> findByCriteria(@RequestBody CommandVo commandVo){
       return commandConverter.toVo(commandService.findByCriteria(commandVo));
	}	
	public CommandConverter getCommandConverter(){
		return commandConverter;
	}
 
	public void setCommandConverter(CommandConverter commandConverter){
		this.commandConverter=commandConverter;
	}

	public CommandService getCommandService(){
		return commandService;
	}
	public void setCommandService( CommandService commandService){
	 	this.commandService=commandService;
	}
	

}