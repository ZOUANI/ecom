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
import ma.zs.generated.bean.OrderLine; 
import ma.zs.generated.service.facade.OrderLineService;
import ma.zs.generated.ws.rest.provided.converter.OrderLineConverter;
import ma.zs.generated.ws.rest.provided.vo.OrderLineVo;

@Api("Manages orderLine services")
@RestController
@RequestMapping("generated/orderLine")
public class OrderLineRest {

	@Autowired 
	private OrderLineService orderLineService;
	
	@Autowired 
	private OrderLineConverter orderLineConverter ;

    @ApiOperation("Saves the specified orderLine")
	@PostMapping("/")
	public OrderLineVo save(@RequestBody OrderLineVo orderLineVo){
		OrderLine orderLine= orderLineConverter.toItem(orderLineVo);
	  orderLine=	orderLineService.save(orderLine);
		return orderLineConverter.toVo(orderLine);
	}

    @ApiOperation("Delete the specified orderLine")
	@DeleteMapping("/")
	public int delete(@RequestBody OrderLineVo orderLineVo){
		OrderLine orderLine = orderLineConverter.toItem(orderLineVo);
		return orderLineService.delete(orderLine);
	}

	@ApiOperation("Updates the specified orderLine")
	@PutMapping("/")
	public OrderLineVo update(@RequestBody OrderLineVo orderLineVo){
		OrderLine orderLine= orderLineConverter.toItem(orderLineVo);
	  orderLine=	orderLineService.update(orderLine);
		return orderLineConverter.toVo(orderLine);
	}

	@ApiOperation("Finds a list of all orderLines")
	@GetMapping("/")
	public List<OrderLineVo> findAll(){
		return orderLineConverter.toVo(orderLineService.findAll());
	}
    
	@ApiOperation("Finds a orderLine by id")
	@GetMapping("/id/{id}")
	public OrderLineVo findById(@PathVariable Long id){
		return  orderLineConverter.toVo(orderLineService.findById(id));
	}
	@ApiOperation("Deletes a orderLine by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 orderLineService.deleteById(id);
	}



    @ApiOperation("Finds a orderLine by reference of command")
	@GetMapping("/command/reference/{reference}")
	public List<OrderLineVo> findByCommandReference(@PathVariable String reference){
		return orderLineConverter.toVo(orderLineService.findByCommandReference(reference));
	}
	
	@ApiOperation("Deletes a orderLine by reference of command")
	@DeleteMapping("/command/reference/{reference}")
	public int deleteByCommandReference(@PathVariable String reference){
		return orderLineService.deleteByCommandReference(reference);
	}
	
	@ApiOperation("Finds orderLine by id of command")
	@GetMapping("/command/id/{id}")
	public List<OrderLineVo> findByCommandId(@PathVariable Long id){
		return orderLineConverter.toVo(orderLineService.findByCommandId(id));
	}
	@ApiOperation("Deletes orderLine by id of command")
	@DeleteMapping("/command/id/{id}")
	public int deleteByCommandId(@PathVariable Long id){
		return orderLineService.deleteByCommandId(id);
	}
     	
    @ApiOperation("Finds a orderLine by reference of product")
	@GetMapping("/product/reference/{reference}")
	public List<OrderLineVo> findByProductReference(@PathVariable String reference){
		return orderLineConverter.toVo(orderLineService.findByProductReference(reference));
	}
	
	@ApiOperation("Deletes a orderLine by reference of product")
	@DeleteMapping("/product/reference/{reference}")
	public int deleteByProductReference(@PathVariable String reference){
		return orderLineService.deleteByProductReference(reference);
	}
	
	@ApiOperation("Finds orderLine by id of product")
	@GetMapping("/product/id/{id}")
	public List<OrderLineVo> findByProductId(@PathVariable Long id){
		return orderLineConverter.toVo(orderLineService.findByProductId(id));
	}
	@ApiOperation("Deletes orderLine by id of product")
	@DeleteMapping("/product/id/{id}")
	public int deleteByProductId(@PathVariable Long id){
		return orderLineService.deleteByProductId(id);
	}
     	
   
    @ApiOperation("Search orderLine by a specific criterion")
    @PostMapping("/search")
	public List<OrderLineVo> findByCriteria(@RequestBody OrderLineVo orderLineVo){
       return orderLineConverter.toVo(orderLineService.findByCriteria(orderLineVo));
	}	
	public OrderLineConverter getOrderLineConverter(){
		return orderLineConverter;
	}
 
	public void setOrderLineConverter(OrderLineConverter orderLineConverter){
		this.orderLineConverter=orderLineConverter;
	}

	public OrderLineService getOrderLineService(){
		return orderLineService;
	}
	public void setOrderLineService( OrderLineService orderLineService){
	 	this.orderLineService=orderLineService;
	}
	

}