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
import ma.zs.generated.bean.City; 
import ma.zs.generated.service.facade.CityService;
import ma.zs.generated.ws.rest.provided.converter.CityConverter;
import ma.zs.generated.ws.rest.provided.vo.CityVo;

@Api("Manages city services")
@RestController
@RequestMapping("generated/city")
public class CityRest {

	@Autowired 
	private CityService cityService;
	
	@Autowired 
	private CityConverter cityConverter ;

    @ApiOperation("Saves the specified city")
	@PostMapping("/")
	public CityVo save(@RequestBody CityVo cityVo){
		City city= cityConverter.toItem(cityVo);
	  city=	cityService.save(city);
		return cityConverter.toVo(city);
	}

    @ApiOperation("Delete the specified city")
	@DeleteMapping("/")
	public int delete(@RequestBody CityVo cityVo){
		City city = cityConverter.toItem(cityVo);
		return cityService.delete(city);
	}

	@ApiOperation("Updates the specified city")
	@PutMapping("/")
	public CityVo update(@RequestBody CityVo cityVo){
		City city= cityConverter.toItem(cityVo);
	  city=	cityService.update(city);
		return cityConverter.toVo(city);
	}

	@ApiOperation("Finds a list of all citys")
	@GetMapping("/")
	public List<CityVo> findAll(){
		return cityConverter.toVo(cityService.findAll());
	}
    
	@ApiOperation("Finds a city by id")
	@GetMapping("/id/{id}")
	public CityVo findById(@PathVariable Long id){
		return  cityConverter.toVo(cityService.findById(id));
	}
	@ApiOperation("Deletes a city by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 cityService.deleteById(id);
	}

	@ApiOperation("Finds a  city by name")
    @GetMapping("/name/{name}")
	public CityVo findByName(@PathVariable String name){
		return  cityConverter.toVo(cityService.findByName(name));
	}
	@ApiOperation("Deletes a  city by name")
    @DeleteMapping("/name/{name}")
	public int deleteByName(@PathVariable String name){
		return  cityService.deleteByName(name);
	}
	


   
    @ApiOperation("Search city by a specific criterion")
    @PostMapping("/search")
	public List<CityVo> findByCriteria(@RequestBody CityVo cityVo){
       return cityConverter.toVo(cityService.findByCriteria(cityVo));
	}	
	public CityConverter getCityConverter(){
		return cityConverter;
	}
 
	public void setCityConverter(CityConverter cityConverter){
		this.cityConverter=cityConverter;
	}

	public CityService getCityService(){
		return cityService;
	}
	public void setCityService( CityService cityService){
	 	this.cityService=cityService;
	}
	

}