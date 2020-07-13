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
import ma.zs.generated.bean.OrderStatus; 
import ma.zs.generated.service.facade.OrderStatusService;
import ma.zs.generated.ws.rest.provided.converter.OrderStatusConverter;
import ma.zs.generated.ws.rest.provided.vo.OrderStatusVo;

@Api("Manages orderStatus services")
@RestController
@RequestMapping("generated/orderStatus")
public class OrderStatusRest {

	@Autowired 
	private OrderStatusService orderStatusService;
	
	@Autowired 
	private OrderStatusConverter orderStatusConverter ;

    @ApiOperation("Saves the specified orderStatus")
	@PostMapping("/")
	public OrderStatusVo save(@RequestBody OrderStatusVo orderStatusVo){
		OrderStatus orderStatus= orderStatusConverter.toItem(orderStatusVo);
	  orderStatus=	orderStatusService.save(orderStatus);
		return orderStatusConverter.toVo(orderStatus);
	}

    @ApiOperation("Delete the specified orderStatus")
	@DeleteMapping("/")
	public int delete(@RequestBody OrderStatusVo orderStatusVo){
		OrderStatus orderStatus = orderStatusConverter.toItem(orderStatusVo);
		return orderStatusService.delete(orderStatus);
	}

	@ApiOperation("Updates the specified orderStatus")
	@PutMapping("/")
	public OrderStatusVo update(@RequestBody OrderStatusVo orderStatusVo){
		OrderStatus orderStatus= orderStatusConverter.toItem(orderStatusVo);
	  orderStatus=	orderStatusService.update(orderStatus);
		return orderStatusConverter.toVo(orderStatus);
	}

	@ApiOperation("Finds a list of all orderStatuss")
	@GetMapping("/")
	public List<OrderStatusVo> findAll(){
		return orderStatusConverter.toVo(orderStatusService.findAll());
	}
    
	@ApiOperation("Finds a orderStatus by id")
	@GetMapping("/id/{id}")
	public OrderStatusVo findById(@PathVariable Long id){
		return  orderStatusConverter.toVo(orderStatusService.findById(id));
	}
	@ApiOperation("Deletes a orderStatus by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 orderStatusService.deleteById(id);
	}

	@ApiOperation("Finds a  orderStatus by label")
    @GetMapping("/label/{label}")
	public OrderStatusVo findByLabel(@PathVariable String label){
		return  orderStatusConverter.toVo(orderStatusService.findByLabel(label));
	}
	@ApiOperation("Deletes a  orderStatus by label")
    @DeleteMapping("/label/{label}")
	public int deleteByLabel(@PathVariable String label){
		return  orderStatusService.deleteByLabel(label);
	}
	


   
    @ApiOperation("Search orderStatus by a specific criterion")
    @PostMapping("/search")
	public List<OrderStatusVo> findByCriteria(@RequestBody OrderStatusVo orderStatusVo){
       return orderStatusConverter.toVo(orderStatusService.findByCriteria(orderStatusVo));
	}	
	public OrderStatusConverter getOrderStatusConverter(){
		return orderStatusConverter;
	}
 
	public void setOrderStatusConverter(OrderStatusConverter orderStatusConverter){
		this.orderStatusConverter=orderStatusConverter;
	}

	public OrderStatusService getOrderStatusService(){
		return orderStatusService;
	}
	public void setOrderStatusService( OrderStatusService orderStatusService){
	 	this.orderStatusService=orderStatusService;
	}
	

}
