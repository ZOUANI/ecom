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
import ma.zs.generated.bean.Category; 
import ma.zs.generated.service.facade.CategoryService;
import ma.zs.generated.ws.rest.provided.converter.CategoryConverter;
import ma.zs.generated.ws.rest.provided.vo.CategoryVo;

@Api("Manages category services")
@RestController
@RequestMapping("generated/category")
public class CategoryRest {

	@Autowired 
	private CategoryService categoryService;
	
	@Autowired 
	private CategoryConverter categoryConverter ;

    @ApiOperation("Saves the specified category")
	@PostMapping("/")
	public CategoryVo save(@RequestBody CategoryVo categoryVo){
		Category category= categoryConverter.toItem(categoryVo);
	  category=	categoryService.save(category);
		return categoryConverter.toVo(category);
	}

    @ApiOperation("Delete the specified category")
	@DeleteMapping("/")
	public int delete(@RequestBody CategoryVo categoryVo){
		Category category = categoryConverter.toItem(categoryVo);
		return categoryService.delete(category);
	}

	@ApiOperation("Updates the specified category")
	@PutMapping("/")
	public CategoryVo update(@RequestBody CategoryVo categoryVo){
		Category category= categoryConverter.toItem(categoryVo);
	  category=	categoryService.update(category);
		return categoryConverter.toVo(category);
	}

	@ApiOperation("Finds a list of all categorys")
	@GetMapping("/")
	public List<CategoryVo> findAll(){
		return categoryConverter.toVo(categoryService.findAll());
	}
    
	@ApiOperation("Finds a category by id")
	@GetMapping("/id/{id}")
	public CategoryVo findById(@PathVariable Long id){
		return  categoryConverter.toVo(categoryService.findById(id));
	}
	@ApiOperation("Deletes a category by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 categoryService.deleteById(id);
	}

	@ApiOperation("Finds a  category by label")
    @GetMapping("/label/{label}")
	public CategoryVo findByLabel(@PathVariable String label){
		return  categoryConverter.toVo(categoryService.findByLabel(label));
	}
	@ApiOperation("Deletes a  category by label")
    @DeleteMapping("/label/{label}")
	public int deleteByLabel(@PathVariable String label){
		return  categoryService.deleteByLabel(label);
	}
	


   
    @ApiOperation("Search category by a specific criterion")
    @PostMapping("/search")
	public List<CategoryVo> findByCriteria(@RequestBody CategoryVo categoryVo){
       return categoryConverter.toVo(categoryService.findByCriteria(categoryVo));
	}	
	public CategoryConverter getCategoryConverter(){
		return categoryConverter;
	}
 
	public void setCategoryConverter(CategoryConverter categoryConverter){
		this.categoryConverter=categoryConverter;
	}

	public CategoryService getCategoryService(){
		return categoryService;
	}
	public void setCategoryService( CategoryService categoryService){
	 	this.categoryService=categoryService;
	}
	

}