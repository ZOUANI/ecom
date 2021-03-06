package ma.zs.generated.service.facade;

import java.util.Date;
import java.util.List;

import ma.zs.generated.bean.User;
import ma.zs.generated.ws.rest.provided.vo.AuthRequest;
import ma.zs.generated.ws.rest.provided.vo.UserVo;

public interface UserService {

    /**
     * find all User in database
     *
     * @return List<User> , If database is empty return null.
     */
    List<User> findAll();

    /**
     * find User from database by code (reference)
     *
     * @param code - reference of User
     * @return the founded User , If no User were found in database return null.
     */
    User findByCode(String code);

    /**
     * find User from database by id (id)
     *
     * @param id - id of User
     * @return the founded User , If no User were found in database return null.
     */
    User findById(Long id);

    void deleteById(Long id);

    List<User> findByAuthorityAuthority(String authority);

    int deleteByAuthorityAuthority(String authority);

    List<User> findByAuthorityId(Long id);

    int deleteByAuthorityId(Long id);

    List<User> findBySuperAdminCode(String code);

    int deleteBySuperAdminCode(String code);

    List<User> findBySuperAdminId(Long id);

    int deleteBySuperAdminId(Long id);

    List<User> findByDeliveryTypeLabel(String label);

    int deleteByDeliveryTypeLabel(String label);

    List<User> findByDeliveryTypeId(Long id);

    int deleteByDeliveryTypeId(Long id);

    List<User> findByCityName(String name);

    int deleteByCityName(String name);

    List<User> findByCityId(Long id);

    int deleteByCityId(Long id);

    /**
     * save User in database
     *
     * @param user - User to be saved
     * @return the saved User, If the User can't be saved return null.
     */
    User save(User user);

    /**
     * save list User in database
     *
     * @param users - list of User to be saved
     * @return the saved User list
     */
    List<User> save(List<User> users);

    /**
     * update User in database
     *
     * @param user - User to be updated
     * @return the updated User, If the User can't be updated return null.
     */
    User update(User user);

    /**
     * delete User from database
     *
     * @param user - User to be deleted
     * @return 1 if User deleted successfully, If the User can't be deleted return
     *         negative int
     */
    int delete(User user);

    /**
     * delete User from database by code (reference)
     *
     * @param code - reference of User to be deleted
     * @return 1 if User deleted successfully
     */
    int deleteByCode(String code);

    /**
     * search for User in by some criteria
     *
     * @return the searhed list User
     */
    List<User> findByCriteria(UserVo userVo);

    /**
     * search for Statistics Delivery between 2 date
     *
     * @return the searhed list Delivery
     */
    public List<UserVo> findStatisticsDelivery(Date start, Date end);

    /**
     * search for top 5 Delivery between 2 date
     *
     * @return the searhed list Delivery
     */
    public List<UserVo> findTopfiveDelivery(Date start, Date end);

    /**
     * search for User by firstName and lastName
     *
     * @return the searChed User
     */
    User findByFirstNameAndLastName(String firstName, String lastName);

    public List<User> findValidatorByCity(Long cityId);

    public List<User> findBySuperAdminIdAndAuthorityAuthority(Long adminId,String authority);

    public List<User> findValidatorOfAdmin(Long adminId);

    public List<User> findDeliveryOfAdmin(Long adminId);


    Object login(AuthRequest authRequest);

}
