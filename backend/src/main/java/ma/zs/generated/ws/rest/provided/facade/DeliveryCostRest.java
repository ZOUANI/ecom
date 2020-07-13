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
import ma.zs.generated.bean.DeliveryCost; 
import ma.zs.generated.service.facade.DeliveryCostService;
import ma.zs.generated.ws.rest.provided.converter.DeliveryCostConverter;
import ma.zs.generated.ws.rest.provided.vo.DeliveryCostVo;

@Api("Manages deliveryCost services")
@RestController
@RequestMapping("generated/deliveryCost")
public class DeliveryCostRest {

	@Autowired 
	private DeliveryCostService deliveryCostService;
	
	@Autowired 
	private DeliveryCostConverter deliveryCostConverter ;

    @ApiOperation("Saves the specified deliveryCost")
	@PostMapping("/")
	public DeliveryCostVo save(@RequestBody DeliveryCostVo deliveryCostVo){
		DeliveryCost deliveryCost= deliveryCostConverter.toItem(deliveryCostVo);
	  deliveryCost=	deliveryCostService.save(deliveryCost);
		return deliveryCostConverter.toVo(deliveryCost);
	}

    @ApiOperation("Delete the specified deliveryCost")
	@DeleteMapping("/")
	public int delete(@RequestBody DeliveryCostVo deliveryCostVo){
		DeliveryCost deliveryCost = deliveryCostConverter.toItem(deliveryCostVo);
		return deliveryCostService.delete(deliveryCost);
	}

	@ApiOperation("Updates the specified deliveryCost")
	@PutMapping("/")
	public DeliveryCostVo update(@RequestBody DeliveryCostVo deliveryCostVo){
		DeliveryCost deliveryCost= deliveryCostConverter.toItem(deliveryCostVo);
	  deliveryCost=	deliveryCostService.update(deliveryCost);
		return deliveryCostConverter.toVo(deliveryCost);
	}

	@ApiOperation("Finds a list of all deliveryCosts")
	@GetMapping("/")
	public List<DeliveryCostVo> findAll(){
		return deliveryCostConverter.toVo(deliveryCostService.findAll());
	}
    
	@ApiOperation("Finds a deliveryCost by id")
	@GetMapping("/id/{id}")
	public DeliveryCostVo findById(@PathVariable Long id){
		return  deliveryCostConverter.toVo(deliveryCostService.findById(id));
	}
	@ApiOperation("Deletes a deliveryCost by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 deliveryCostService.deleteById(id);
	}



    @ApiOperation("Finds a deliveryCost by name of city")
	@GetMapping("/city/name/{name}")
	public List<DeliveryCostVo> findByCityName(@PathVariable String name){
		return deliveryCostConverter.toVo(deliveryCostService.findByCityName(name));
	}
	
	@ApiOperation("Deletes a deliveryCost by name of city")
	@DeleteMapping("/city/name/{name}")
	public int deleteByCityName(@PathVariable String name){
		return deliveryCostService.deleteByCityName(name);
	}
	
	@ApiOperation("Finds deliveryCost by id of city")
	@GetMapping("/city/id/{id}")
	public List<DeliveryCostVo> findByCityId(@PathVariable Long id){
		return deliveryCostConverter.toVo(deliveryCostService.findByCityId(id));
	}
	@ApiOperation("Deletes deliveryCost by id of city")
	@DeleteMapping("/city/id/{id}")
	public int deleteByCityId(@PathVariable Long id){
		return deliveryCostService.deleteByCityId(id);
	}
     	
    @ApiOperation("Finds a deliveryCost by code of delivery")
	@GetMapping("/delivery/code/{code}")
	public List<DeliveryCostVo> findByDeliveryCode(@PathVariable String code){
		return deliveryCostConverter.toVo(deliveryCostService.findByDeliveryCode(code));
	}
	
	@ApiOperation("Deletes a deliveryCost by code of delivery")
	@DeleteMapping("/delivery/code/{code}")
	public int deleteByDeliveryCode(@PathVariable String code){
		return deliveryCostService.deleteByDeliveryCode(code);
	}
	
	@ApiOperation("Finds deliveryCost by id of delivery")
	@GetMapping("/delivery/id/{id}")
	public List<DeliveryCostVo> findByDeliveryId(@PathVariable Long id){
		return deliveryCostConverter.toVo(deliveryCostService.findByDeliveryId(id));
	}
	@ApiOperation("Deletes deliveryCost by id of delivery")
	@DeleteMapping("/delivery/id/{id}")
	public int deleteByDeliveryId(@PathVariable Long id){
		return deliveryCostService.deleteByDeliveryId(id);
	}
     	
   
    @ApiOperation("Search deliveryCost by a specific criterion")
    @PostMapping("/search")
	public List<DeliveryCostVo> findByCriteria(@RequestBody DeliveryCostVo deliveryCostVo){
       return deliveryCostConverter.toVo(deliveryCostService.findByCriteria(deliveryCostVo));
	}	
	public DeliveryCostConverter getDeliveryCostConverter(){
		return deliveryCostConverter;
	}
 
	public void setDeliveryCostConverter(DeliveryCostConverter deliveryCostConverter){
		this.deliveryCostConverter=deliveryCostConverter;
	}

	public DeliveryCostService getDeliveryCostService(){
		return deliveryCostService;
	}
	public void setDeliveryCostService( DeliveryCostService deliveryCostService){
	 	this.deliveryCostService=deliveryCostService;
	}
	

}