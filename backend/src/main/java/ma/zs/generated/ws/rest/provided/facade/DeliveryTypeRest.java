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
import ma.zs.generated.bean.DeliveryType; 
import ma.zs.generated.service.facade.DeliveryTypeService;
import ma.zs.generated.ws.rest.provided.converter.DeliveryTypeConverter;
import ma.zs.generated.ws.rest.provided.vo.DeliveryTypeVo;

@Api("Manages deliveryType services")
@RestController
@RequestMapping("generated/deliveryType")
public class DeliveryTypeRest {

	@Autowired 
	private DeliveryTypeService deliveryTypeService;
	
	@Autowired 
	private DeliveryTypeConverter deliveryTypeConverter ;

    @ApiOperation("Saves the specified deliveryType")
	@PostMapping("/")
	public DeliveryTypeVo save(@RequestBody DeliveryTypeVo deliveryTypeVo){
		DeliveryType deliveryType= deliveryTypeConverter.toItem(deliveryTypeVo);
	  deliveryType=	deliveryTypeService.save(deliveryType);
		return deliveryTypeConverter.toVo(deliveryType);
	}

    @ApiOperation("Delete the specified deliveryType")
	@DeleteMapping("/")
	public int delete(@RequestBody DeliveryTypeVo deliveryTypeVo){
		DeliveryType deliveryType = deliveryTypeConverter.toItem(deliveryTypeVo);
		return deliveryTypeService.delete(deliveryType);
	}

	@ApiOperation("Updates the specified deliveryType")
	@PutMapping("/")
	public DeliveryTypeVo update(@RequestBody DeliveryTypeVo deliveryTypeVo){
		DeliveryType deliveryType= deliveryTypeConverter.toItem(deliveryTypeVo);
	  deliveryType=	deliveryTypeService.update(deliveryType);
		return deliveryTypeConverter.toVo(deliveryType);
	}

	@ApiOperation("Finds a list of all deliveryTypes")
	@GetMapping("/")
	public List<DeliveryTypeVo> findAll(){
		return deliveryTypeConverter.toVo(deliveryTypeService.findAll());
	}
    
	@ApiOperation("Finds a deliveryType by id")
	@GetMapping("/id/{id}")
	public DeliveryTypeVo findById(@PathVariable Long id){
		return  deliveryTypeConverter.toVo(deliveryTypeService.findById(id));
	}
	@ApiOperation("Deletes a deliveryType by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 deliveryTypeService.deleteById(id);
	}

	@ApiOperation("Finds a  deliveryType by label")
    @GetMapping("/label/{label}")
	public DeliveryTypeVo findByLabel(@PathVariable String label){
		return  deliveryTypeConverter.toVo(deliveryTypeService.findByLabel(label));
	}
	@ApiOperation("Deletes a  deliveryType by label")
    @DeleteMapping("/label/{label}")
	public int deleteByLabel(@PathVariable String label){
		return  deliveryTypeService.deleteByLabel(label);
	}
	


   
    @ApiOperation("Search deliveryType by a specific criterion")
    @PostMapping("/search")
	public List<DeliveryTypeVo> findByCriteria(@RequestBody DeliveryTypeVo deliveryTypeVo){
       return deliveryTypeConverter.toVo(deliveryTypeService.findByCriteria(deliveryTypeVo));
	}	
	public DeliveryTypeConverter getDeliveryTypeConverter(){
		return deliveryTypeConverter;
	}
 
	public void setDeliveryTypeConverter(DeliveryTypeConverter deliveryTypeConverter){
		this.deliveryTypeConverter=deliveryTypeConverter;
	}

	public DeliveryTypeService getDeliveryTypeService(){
		return deliveryTypeService;
	}
	public void setDeliveryTypeService( DeliveryTypeService deliveryTypeService){
	 	this.deliveryTypeService=deliveryTypeService;
	}
	

}