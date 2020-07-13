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
import ma.zs.generated.bean.CategoryProduct; 
import ma.zs.generated.service.facade.CategoryProductService;
import ma.zs.generated.ws.rest.provided.converter.CategoryProductConverter;
import ma.zs.generated.ws.rest.provided.vo.CategoryProductVo;

@Api("Manages categoryProduct services")
@RestController
@RequestMapping("generated/categoryProduct")
public class CategoryProductRest {

	@Autowired 
	private CategoryProductService categoryProductService;
	
	@Autowired 
	private CategoryProductConverter categoryProductConverter ;

    @ApiOperation("Saves the specified categoryProduct")
	@PostMapping("/")
	public CategoryProductVo save(@RequestBody CategoryProductVo categoryProductVo){
		CategoryProduct categoryProduct= categoryProductConverter.toItem(categoryProductVo);
	  categoryProduct=	categoryProductService.save(categoryProduct);
		return categoryProductConverter.toVo(categoryProduct);
	}

    @ApiOperation("Delete the specified categoryProduct")
	@DeleteMapping("/")
	public int delete(@RequestBody CategoryProductVo categoryProductVo){
		CategoryProduct categoryProduct = categoryProductConverter.toItem(categoryProductVo);
		return categoryProductService.delete(categoryProduct);
	}

	@ApiOperation("Updates the specified categoryProduct")
	@PutMapping("/")
	public CategoryProductVo update(@RequestBody CategoryProductVo categoryProductVo){
		CategoryProduct categoryProduct= categoryProductConverter.toItem(categoryProductVo);
	  categoryProduct=	categoryProductService.update(categoryProduct);
		return categoryProductConverter.toVo(categoryProduct);
	}

	@ApiOperation("Finds a list of all categoryProducts")
	@GetMapping("/")
	public List<CategoryProductVo> findAll(){
		return categoryProductConverter.toVo(categoryProductService.findAll());
	}
    
	@ApiOperation("Finds a categoryProduct by id")
	@GetMapping("/id/{id}")
	public CategoryProductVo findById(@PathVariable Long id){
		return  categoryProductConverter.toVo(categoryProductService.findById(id));
	}
	@ApiOperation("Deletes a categoryProduct by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 categoryProductService.deleteById(id);
	}



    @ApiOperation("Finds a categoryProduct by label of category")
	@GetMapping("/category/label/{label}")
	public List<CategoryProductVo> findByCategoryLabel(@PathVariable String label){
		return categoryProductConverter.toVo(categoryProductService.findByCategoryLabel(label));
	}
	
	@ApiOperation("Deletes a categoryProduct by label of category")
	@DeleteMapping("/category/label/{label}")
	public int deleteByCategoryLabel(@PathVariable String label){
		return categoryProductService.deleteByCategoryLabel(label);
	}
	
	@ApiOperation("Finds categoryProduct by id of category")
	@GetMapping("/category/id/{id}")
	public List<CategoryProductVo> findByCategoryId(@PathVariable Long id){
		return categoryProductConverter.toVo(categoryProductService.findByCategoryId(id));
	}
	@ApiOperation("Deletes categoryProduct by id of category")
	@DeleteMapping("/category/id/{id}")
	public int deleteByCategoryId(@PathVariable Long id){
		return categoryProductService.deleteByCategoryId(id);
	}
     	
    @ApiOperation("Finds a categoryProduct by reference of product")
	@GetMapping("/product/reference/{reference}")
	public List<CategoryProductVo> findByProductReference(@PathVariable String reference){
		return categoryProductConverter.toVo(categoryProductService.findByProductReference(reference));
	}
	
	@ApiOperation("Deletes a categoryProduct by reference of product")
	@DeleteMapping("/product/reference/{reference}")
	public int deleteByProductReference(@PathVariable String reference){
		return categoryProductService.deleteByProductReference(reference);
	}
	
	@ApiOperation("Finds categoryProduct by id of product")
	@GetMapping("/product/id/{id}")
	public List<CategoryProductVo> findByProductId(@PathVariable Long id){
		return categoryProductConverter.toVo(categoryProductService.findByProductId(id));
	}
	@ApiOperation("Deletes categoryProduct by id of product")
	@DeleteMapping("/product/id/{id}")
	public int deleteByProductId(@PathVariable Long id){
		return categoryProductService.deleteByProductId(id);
	}
     	
   
    @ApiOperation("Search categoryProduct by a specific criterion")
    @PostMapping("/search")
	public List<CategoryProductVo> findByCriteria(@RequestBody CategoryProductVo categoryProductVo){
       return categoryProductConverter.toVo(categoryProductService.findByCriteria(categoryProductVo));
	}	
	public CategoryProductConverter getCategoryProductConverter(){
		return categoryProductConverter;
	}
 
	public void setCategoryProductConverter(CategoryProductConverter categoryProductConverter){
		this.categoryProductConverter=categoryProductConverter;
	}

	public CategoryProductService getCategoryProductService(){
		return categoryProductService;
	}
	public void setCategoryProductService( CategoryProductService categoryProductService){
	 	this.categoryProductService=categoryProductService;
	}
	

}