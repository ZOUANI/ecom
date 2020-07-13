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
import ma.zs.generated.bean.Role; 
import ma.zs.generated.service.facade.RoleService;
import ma.zs.generated.ws.rest.provided.converter.RoleConverter;
import ma.zs.generated.ws.rest.provided.vo.RoleVo;

@Api("Manages role services")
@RestController
@RequestMapping("generated/role")
public class RoleRest {

	@Autowired 
	private RoleService roleService;
	
	@Autowired 
	private RoleConverter roleConverter ;

    @ApiOperation("Saves the specified role")
	@PostMapping("/")
	public RoleVo save(@RequestBody RoleVo roleVo){
		Role role= roleConverter.toItem(roleVo);
	  role=	roleService.save(role);
		return roleConverter.toVo(role);
	}

    @ApiOperation("Delete the specified role")
	@DeleteMapping("/")
	public int delete(@RequestBody RoleVo roleVo){
		Role role = roleConverter.toItem(roleVo);
		return roleService.delete(role);
	}

	@ApiOperation("Updates the specified role")
	@PutMapping("/")
	public RoleVo update(@RequestBody RoleVo roleVo){
		Role role= roleConverter.toItem(roleVo);
	  role=	roleService.update(role);
		return roleConverter.toVo(role);
	}

	@ApiOperation("Finds a list of all roles")
	@GetMapping("/")
	public List<RoleVo> findAll(){
		return roleConverter.toVo(roleService.findAll());
	}
    
	@ApiOperation("Finds a role by id")
	@GetMapping("/id/{id}")
	public RoleVo findById(@PathVariable Long id){
		return  roleConverter.toVo(roleService.findById(id));
	}
	@ApiOperation("Deletes a role by id")
	@DeleteMapping("/id/{id}")
	public void deleteById(@PathVariable Long id){
		 roleService.deleteById(id);
	}

	@ApiOperation("Finds a  role by authority")
    @GetMapping("/authority/{authority}")
	public RoleVo findByAuthority(@PathVariable String authority){
		return  roleConverter.toVo(roleService.findByAuthority(authority));
	}
	@ApiOperation("Deletes a  role by authority")
    @DeleteMapping("/authority/{authority}")
	public int deleteByAuthority(@PathVariable String authority){
		return  roleService.deleteByAuthority(authority);
	}
	


   
    @ApiOperation("Search role by a specific criterion")
    @PostMapping("/search")
	public List<RoleVo> findByCriteria(@RequestBody RoleVo roleVo){
       return roleConverter.toVo(roleService.findByCriteria(roleVo));
	}	
	public RoleConverter getRoleConverter(){
		return roleConverter;
	}
 
	public void setRoleConverter(RoleConverter roleConverter){
		this.roleConverter=roleConverter;
	}

	public RoleService getRoleService(){
		return roleService;
	}
	public void setRoleService( RoleService roleService){
	 	this.roleService=roleService;
	}
	

}