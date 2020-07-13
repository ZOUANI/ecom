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
import ma.zs.generated.bean.Product; 
import ma.zs.generated.service.facade.ProductService;
import ma.zs.generated.ws.rest.provided.converter.ProductConverter;
import ma.zs.generated.ws.rest.provided.vo.ProductVo;

@Api("Manages product services")
@RestController
@RequestMapping("generated/product")
public class ProductRest {

	@Autowired 
	private ProductService productService;
	
	@Autowired 
	private ProductConverter productConverter ;

    @ApiOperation("Saves the specified product")
	@PostMapping("/")
	public ProductVo save(@RequestBody ProductVo productVo){
		Product product= productConverter.toItem(productVo);
	  product=	productService.save(product);
		return productConverter.toVo(product);
	}

    @ApiOperation("Delete the specified product")
	@DeleteMapping("/")
	public int delete(@RequestBody ProductVo productVo){
		Product product = productConverter.toItem(productVo);
		return productService.delete(product);
	}

	@ApiOperation("Updates the specified product")
	@PutMapping("/")
	public ProductVo update(@RequestBody ProductVo productVo){
		Product product= productConverter.toItem(productVo);
	  product=	productService.update(product);
		return productConverter.toVo(product);
	}

	@ApiOperation("Finds a list of all products")
	@GetMapping("/")
	public List<ProductVo> findAll(){
		return productConverter.toVo(productService.findAll());
	}
    
	@ApiOperation("Finds a product by id")
	@GetMapping("/id/{id}")
	public ProductVo findById(@PathVariable Long id){
		return  productConverter.toVo(productService.findById(id));
	}
	@ApiOperation("Deletes a product by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 productService.deleteById(id);
	}

	@ApiOperation("Finds a  product by reference")
    @GetMapping("/reference/{reference}")
	public ProductVo findByReference(@PathVariable String reference){
		return  productConverter.toVo(productService.findByReference(reference));
	}
	@ApiOperation("Deletes a  product by reference")
    @DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference){
		return  productService.deleteByReference(reference);
	}
	


   
    @ApiOperation("Search product by a specific criterion")
    @PostMapping("/search")
	public List<ProductVo> findByCriteria(@RequestBody ProductVo productVo){
       return productConverter.toVo(productService.findByCriteria(productVo));
	}	
	public ProductConverter getProductConverter(){
		return productConverter;
	}
 
	public void setProductConverter(ProductConverter productConverter){
		this.productConverter=productConverter;
	}

	public ProductService getProductService(){
		return productService;
	}
	public void setProductService( ProductService productService){
	 	this.productService=productService;
	}
	

}