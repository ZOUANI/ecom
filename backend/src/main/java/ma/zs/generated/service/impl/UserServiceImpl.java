package ma.zs.generated.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import ma.zs.generated.ws.rest.provided.vo.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.generated.bean.City;
import ma.zs.generated.bean.Command;
import ma.zs.generated.bean.DeliveryType;
import ma.zs.generated.bean.Role;
import ma.zs.generated.bean.User;
import ma.zs.generated.dao.UserDao;
import ma.zs.generated.service.facade.CityService;
import ma.zs.generated.service.facade.CommandService;
import ma.zs.generated.service.facade.DeliveryTypeService;
import ma.zs.generated.service.facade.RoleService;
import ma.zs.generated.service.facade.UserService;
import ma.zs.generated.service.util.ListUtil;
import ma.zs.generated.service.util.SearchUtil;
import ma.zs.generated.ws.rest.provided.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService ;

    @Autowired
    private DeliveryTypeService deliveryTypeService;
    @Autowired
    private CityService cityService;
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CommandService commandService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll(){
        return userDao.findAll();
    }
    @Override
    public List<User> findBySuperAdminCode(String code){
        return userDao.findBySuperAdminCode(code);
    }
    @Override
    @Transactional
    public int deleteBySuperAdminCode(String code){
        return userDao.deleteBySuperAdminCode(code);
    }

    @Override
    public List<User> findBySuperAdminId(Long id){
        return userDao.findBySuperAdminId(id);

    }
    @Override
    @Transactional
    public int deleteBySuperAdminId(Long id){
        return userDao.deleteBySuperAdminId(id);

    }

    @Override
    public List<User> findByDeliveryTypeLabel(String label){
        return userDao.findByDeliveryTypeLabel(label);
    }
    @Override
    @Transactional
    public int deleteByDeliveryTypeLabel(String label){
        return userDao.deleteByDeliveryTypeLabel(label);
    }

    @Override
    public List<User> findByDeliveryTypeId(Long id){
        return userDao.findByDeliveryTypeId(id);

    }
    @Override
    @Transactional
    public int deleteByDeliveryTypeId(Long id){
        return userDao.deleteByDeliveryTypeId(id);

    }

    @Override
    public List<User> findByCityName(String name){
        return userDao.findByCityName(name);
    }
    @Override
    @Transactional
    public int deleteByCityName(String name){
        return userDao.deleteByCityName(name);
    }

    @Override
    public List<User> findByCityId(Long id){
        return userDao.findByCityId(id);

    }
    @Override
    @Transactional
    public int deleteByCityId(Long id){
        return userDao.deleteByCityId(id);

    }

    @Override
    public List<User> findByAuthorityAuthority(String authority){
        return userDao.findByAuthorityAuthority(authority);
    }
    @Override
    @Transactional
    public int deleteByAuthorityAuthority(String authority){
        return userDao.deleteByAuthorityAuthority(authority);
    }

    @Override
    public List<User> findByAuthorityId(Long id){
        return userDao.findByAuthorityId(id);

    }
    @Override
    @Transactional
    public int deleteByAuthorityId(Long id){
        return userDao.deleteByAuthorityId(id);

    }

    @Override
    public User findByCode(String code){
        if( code==null)
            return null;
        return userDao.findByCode(code);
    }



    @Override
    @Transactional
    public int deleteByCode(String  code) {
        return userDao.deleteByCode(code);
    }

    @Override
    public User findById(Long id){
        if(id==null)
            return null;
        return userDao.getOne(id);
    }

    @Transactional
    public void deleteById(Long id){
        userDao.deleteById(id);
    }
    @Override
    public User save (User user){
        User foundedUser = findByCode(user.getCode());
        if(foundedUser!=null)
            return null;

        if(user.getSuperAdmin()!=null){
            User superAdmin  = findByCode(user.getSuperAdmin().getCode());
            if(superAdmin == null)
                user.setSuperAdmin(save(user.getSuperAdmin()));
            else
                user.setSuperAdmin(superAdmin);
        }

        if(user.getDeliveryType()!=null){
            DeliveryType deliveryType = deliveryTypeService.findByLabel(user.getDeliveryType().getLabel());
            if(deliveryType == null)
                user.setDeliveryType(deliveryTypeService.save(user.getDeliveryType()));
            else
                user.setDeliveryType(deliveryType);
        }

        if(user.getCity()!=null){
            City city = cityService.findByName(user.getCity().getName());
            if(city == null)
                user.setCity(cityService.save(user.getCity()));
            else
                user.setCity(city);
        }

        if(user.getAuthority()!=null){
            Role authority = roleService.findByAuthority(user.getAuthority().getAuthority());
            if(authority == null)
                user.setAuthority(roleService.save(user.getAuthority()));
            else
                user.setAuthority(authority);
        }

        User savedUser = userDao.save(user);
        return savedUser;
    }

    @Override
    public List<User> save(List<User> users){
        List<User> list = new ArrayList<User>();
        for(User user: users){
            list.add(save(user));
        }
        return list;
    }


    @Override
    public User update(User user){


        User foundedUser = findById(user.getId());
        if(foundedUser==null)
            return null;

        return  userDao.save(user);

    }

    @Override
    @Transactional
    public int delete(User user){

        if(user.getCode()==null)
            return -1;

        User foundedUser = findByCode(user.getCode());
        if(foundedUser==null)
            return -1;
        userDao.delete(foundedUser);
        return 1;
    }


    public List<User> findByCriteria(UserVo userVo){
        String query = "SELECT o FROM User o where 1=1 ";
        query += SearchUtil.addConstraint( "o", "password","LIKE",userVo.getPassword());

        query += SearchUtil.addConstraint( "o", "enabled","=",userVo.getEnabled());
        query += SearchUtil.addConstraint( "o", "phoneNumber","LIKE",userVo.getPhoneNumber());

        query += SearchUtil.addConstraint( "o", "lastName","LIKE",userVo.getLastName());

        query += SearchUtil.addConstraint( "o", "email","LIKE",userVo.getEmail());

        query += SearchUtil.addConstraintDate( "o", "created","=",userVo.getCreated());
        query += SearchUtil.addConstraint( "o", "code","LIKE",userVo.getCode());

        query += SearchUtil.addConstraint( "o", "firsttName","LIKE",userVo.getFirstName());

        query += SearchUtil.addConstraint( "o", "id","=",userVo.getId());
        query += SearchUtil.addConstraintMinMaxDate("o","created",userVo.getCreatedMin(),userVo.getCreatedMax());
        if(userVo.getSuperAdminVo()!=null){
            query += SearchUtil.addConstraint( "o", "superAdmin.id","=",userVo.getSuperAdminVo().getId());
            query += SearchUtil.addConstraint( "o", "superAdmin.code","LIKE",userVo.getSuperAdminVo().getCode());
        }

        if(userVo.getDeliveryTypeVo()!=null){
            query += SearchUtil.addConstraint( "o", "deliveryType.id","=",userVo.getDeliveryTypeVo().getId());
            query += SearchUtil.addConstraint( "o", "deliveryType.label","LIKE",userVo.getDeliveryTypeVo().getLabel());
        }

        if(userVo.getCityVo()!=null){
            query += SearchUtil.addConstraint( "o", "city.id","=",userVo.getCityVo().getId());
            query += SearchUtil.addConstraint( "o", "city.name","LIKE",userVo.getCityVo().getName());
        }

        if(userVo.getAuthorityVo()!=null){
            query += SearchUtil.addConstraint( "o", "authority.id","=",userVo.getAuthorityVo().getId());
            query += SearchUtil.addConstraint( "o", "authority.authority","LIKE",userVo.getAuthorityVo().getAuthority());
        }

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<UserVo> findStatisticsDelivery(Date start, Date end) {

        List<Command> commands = commandService.findAllCommandsBetween(start, end);
        if (ListUtil.isEmpty(commands)) {
            return null;
        }
        System.out.println(commands);
        List<UserVo> userVos = new ArrayList<>();
        commands.stream().collect(Collectors.groupingBy(Command::getDelivery)).forEach((delivery, commandList) -> {
            UserVo userVo = new UserVo("", new BigDecimal(0), new BigDecimal(0), 0, 0, 0, new BigDecimal(0),
                    new BigDecimal(0));
            userVo.setDeliveryName(delivery.getLastName() + " " + delivery.getFirstName());
            commandList.forEach(command -> {
                userVo.setTotalAmountCommand(userVo.getTotalAmountCommand().add(command.getTotal()));

                if (command.getOrderStatus().getLabel().equalsIgnoreCase("closed")) {
                    userVo.setTotalAmountCommandClosed(userVo.getTotalAmountCommandClosed().add(command.getTotal()));
                    userVo.setCommandsClosed(userVo.getCommandsClosed() + 1);
                } else if (command.getOrderStatus().getLabel().equalsIgnoreCase("returned")) {
                    userVo.setCommandsReturned(userVo.getCommandsReturned() + 1);
                } else if (command.getOrderStatus().getLabel().equalsIgnoreCase("processed")) {
                    userVo.setCommandProcessed(userVo.getCommandProcessed() + 1);
                }
            });
            if ((userVo.getCommandProcessed()) != 0) {
                userVo.setPercentageReturned(((new BigDecimal(userVo.getCommandsReturned()))
                        .divide(new BigDecimal(userVo.getCommandProcessed()))).multiply(new BigDecimal(100)));
                userVo.setPercentageClosed(((new BigDecimal(userVo.getCommandsClosed()))
                        .divide(new BigDecimal(userVo.getCommandProcessed()))).multiply(new BigDecimal(100)));

            }

            userVos.add(userVo);
        });

        return userVos;
    }

    @Override
    public List<UserVo> findTopfiveDelivery(Date start, Date end) {
        List<UserVo> deUserVos = userDao.findTopfiveDelivery(start, end);
        if (deUserVos.size() < 5) {
            return deUserVos.subList(0, deUserVos.size());
        }
        return deUserVos.subList(0, 5);
    }

    @Override
    public User findByFirstNameAndLastName(String firstName, String lastName) {
        return userDao.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<User> findValidatorByCity(Long cityId) {
        return userDao.findByCityIdAndAuthorityAuthority(cityId, "validator");
    }

    @Override
    public List<User> findBySuperAdminIdAndAuthorityAuthority(Long adminId,String authority) {
        return userDao.findBySuperAdminIdAndAuthorityAuthority(adminId,authority);
    }

    @Override
    public List<User> findValidatorOfAdmin(Long adminId) {
        return findBySuperAdminIdAndAuthorityAuthority(adminId,"validator");
    }

    @Override
    public List<User> findDeliveryOfAdmin(Long adminId) {
        return findBySuperAdminIdAndAuthorityAuthority(adminId,"delivery");
    }


	@Override
	public Object login(AuthRequest authRequest) {

		User u = userDao.findByEmail(authRequest.getEmail());
		if (u == null || !passwordEncoder.matches(authRequest.getPassword(), u.getPassword())) {
			return "Invalid Credentials";
		}
		return u;
	}

}
