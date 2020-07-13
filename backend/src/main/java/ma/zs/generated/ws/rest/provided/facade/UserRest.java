package ma.zs.generated.ws.rest.provided.facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import ma.zs.generated.bean.User;
import ma.zs.generated.service.facade.UserService;
import ma.zs.generated.ws.rest.provided.converter.UserConverter;
import ma.zs.generated.ws.rest.provided.vo.UserVo;

@Api("Manages user services")
@RestController
@RequestMapping("generated/user")
public class UserRest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @ApiOperation("Saves the specified user")
    @PostMapping("/")
    public UserVo save(@RequestBody UserVo userVo) {
        User user = userConverter.toItem(userVo);
        user = userService.save(user);
        return userConverter.toVo(user);
    }

    @ApiOperation("Delete the specified user")
    @DeleteMapping("/")
    public int delete(@RequestBody UserVo userVo) {
        User user = userConverter.toItem(userVo);
        return userService.delete(user);
    }

    @ApiOperation("Updates the specified user")
    @PutMapping("/")
    public UserVo update(@RequestBody UserVo userVo) {
        User user = userConverter.toItem(userVo);
        user = userService.update(user);
        return userConverter.toVo(user);
    }

    @ApiOperation("Finds a list of all users")
    @GetMapping("/")
    public List<UserVo> findAll() {
        return userConverter.toVo(userService.findAll());
    }

    @ApiOperation("Finds a user by id")
    @GetMapping("/id/{id}")
    public UserVo findById(@PathVariable Long id) {
        return userConverter.toVo(userService.findById(id));
    }

    @ApiOperation("Deletes a user by id")
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @ApiOperation("Finds a  user by code")
    @GetMapping("/code/{code}")
    public UserVo findByCode(@PathVariable String code) {
        return userConverter.toVo(userService.findByCode(code));
    }

    @ApiOperation("Deletes a  user by code")
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return userService.deleteByCode(code);
    }


    @ApiOperation("Finds a user by authority of authority")
    @GetMapping("/authority/authority/{authority}")
    public List<UserVo> findByAuthorityAuthority(@PathVariable String authority) {
        return userConverter.toVo(userService.findByAuthorityAuthority(authority));
    }

    @ApiOperation("Deletes a user by authority of authority")
    @DeleteMapping("/authority/authority/{authority}")
    public int deleteByAuthorityAuthority(@PathVariable String authority) {
        return userService.deleteByAuthorityAuthority(authority);
    }

    @ApiOperation("Finds user by id of authority")
    @GetMapping("/authority/id/{id}")
    public List<UserVo> findByAuthorityId(@PathVariable Long id) {
        return userConverter.toVo(userService.findByAuthorityId(id));
    }

    @ApiOperation("Deletes user by id of authority")
    @DeleteMapping("/authority/id/{id}")
    public int deleteByAuthorityId(@PathVariable Long id) {
        return userService.deleteByAuthorityId(id);
    }

    @ApiOperation("Finds a user by code of superAdmin")
    @GetMapping("/superAdmin/code/{code}")
    public List<UserVo> findBySuperAdminCode(@PathVariable String code) {
        return userConverter.toVo(userService.findBySuperAdminCode(code));
    }

    @ApiOperation("Deletes a user by code of superAdmin")
    @DeleteMapping("/superAdmin/code/{code}")
    public int deleteBySuperAdminCode(@PathVariable String code) {
        return userService.deleteBySuperAdminCode(code);
    }

    @ApiOperation("Finds user by id of superAdmin")
    @GetMapping("/superAdmin/id/{id}")
    public List<UserVo> findBySuperAdminId(@PathVariable Long id) {
        return userConverter.toVo(userService.findBySuperAdminId(id));
    }

    @ApiOperation("Deletes user by id of superAdmin")
    @DeleteMapping("/superAdmin/id/{id}")
    public int deleteBySuperAdminId(@PathVariable Long id) {
        return userService.deleteBySuperAdminId(id);
    }

    @ApiOperation("Finds a user by label of deliveryType")
    @GetMapping("/deliveryType/label/{label}")
    public List<UserVo> findByDeliveryTypeLabel(@PathVariable String label) {
        return userConverter.toVo(userService.findByDeliveryTypeLabel(label));
    }

    @ApiOperation("Deletes a user by label of deliveryType")
    @DeleteMapping("/deliveryType/label/{label}")
    public int deleteByDeliveryTypeLabel(@PathVariable String label) {
        return userService.deleteByDeliveryTypeLabel(label);
    }

    @ApiOperation("Finds user by id of deliveryType")
    @GetMapping("/deliveryType/id/{id}")
    public List<UserVo> findByDeliveryTypeId(@PathVariable Long id) {
        return userConverter.toVo(userService.findByDeliveryTypeId(id));
    }

    @ApiOperation("Deletes user by id of deliveryType")
    @DeleteMapping("/deliveryType/id/{id}")
    public int deleteByDeliveryTypeId(@PathVariable Long id) {
        return userService.deleteByDeliveryTypeId(id);
    }

    @ApiOperation("Finds a user by name of city")
    @GetMapping("/city/name/{name}")
    public List<UserVo> findByCityName(@PathVariable String name) {
        return userConverter.toVo(userService.findByCityName(name));
    }

    @ApiOperation("Deletes a user by name of city")
    @DeleteMapping("/city/name/{name}")
    public int deleteByCityName(@PathVariable String name) {
        return userService.deleteByCityName(name);
    }

    @ApiOperation("Finds user by id of city")
    @GetMapping("/city/id/{id}")
    public List<UserVo> findByCityId(@PathVariable Long id) {
        return userConverter.toVo(userService.findByCityId(id));
    }

    @ApiOperation("Deletes user by id of city")
    @DeleteMapping("/city/id/{id}")
    public int deleteByCityId(@PathVariable Long id) {
        return userService.deleteByCityId(id);
    }


    @ApiOperation("Search user by a specific criterion")
    @PostMapping("/search")
    public List<UserVo> findByCriteria(@RequestBody UserVo userVo) {
        return userConverter.toVo(userService.findByCriteria(userVo));
    }

    @ApiOperation("statistics  delivery between 2 date")
    @GetMapping("/startDate/{start}/endDate/{end}")
    public List<UserVo> findStatisticsDelivery(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
                                               @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) {
        return userService.findStatisticsDelivery(start, end);

    }

    @ApiOperation("top 5  delivery between 2 date")
    @GetMapping("/top5/startDate/{start}/endDate/{end}")
    public List<UserVo> findTopfiveDelivery(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
                                            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) {
        return userService.findTopfiveDelivery(start, end);

    }

    @ApiOperation("find validator by city")
    @GetMapping("/cityId/{cityId}")
    public List<UserVo> findValidatorByCity(@PathVariable Long cityId) {
        return userConverter.toVo(userService.findValidatorByCity(cityId));
    }

    @ApiOperation("find validator of an admin")
    @GetMapping("/validators/adminId/{adminId}")
    public List<UserVo> findValidatorOfAdmin(@PathVariable Long adminId) {
        return userConverter.toVo(userService.findValidatorOfAdmin(adminId));

    }

    @ApiOperation("find delivery of an admin")
    @GetMapping("/delivery/adminId/{adminId}")
    public List<UserVo> findDeliveryOfAdmin(@PathVariable Long adminId) {
        return userConverter.toVo(userService.findDeliveryOfAdmin(adminId));

    }


    public UserConverter getUserConverter() {
        return userConverter;
    }

    public void setUserConverter(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


}
