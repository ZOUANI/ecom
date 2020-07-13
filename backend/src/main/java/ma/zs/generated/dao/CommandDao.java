package ma.zs.generated.dao;

import ma.zs.generated.bean.User;
import ma.zs.generated.ws.rest.provided.vo.CommandVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import ma.zs.generated.bean.Command;


@Repository
public interface CommandDao extends JpaRepository<Command, Long> {

    Command findByReference(String reference);

    int deleteByReference(String reference);

    //List<Command> findByAdminCode(String code);

//    int deleteByAdminCode(String code);
//
    List<Command> findByAdminId(Long id);
//
//    int deleteByAdminId(Long id);

    List<Command> findByDeliveryCode(String code);

    int deleteByDeliveryCode(String code);

    List<Command> findByDeliveryId(Long id);

    int deleteByDeliveryId(Long id);

    List<Command> findByClientId(Long id);

    int deleteByClientId(Long id);

//    List<Command> findByPackageStatusLabel(String label);
//
//    int deleteByPackageStatusLabel(String label);
//
//    List<Command> findByPackageStatusId(Long id);
//
//    int deleteByPackageStatusId(Long id);

    List<Command> findByValidatorCode(String code);

    int deleteByValidatorCode(String code);

    List<Command> findByValidatorId(Long id);

    int deleteByValidatorId(Long id);

    List<Command> findByOrderStatusLabel(String label);

    int deleteByOrderStatusLabel(String label);

    List<Command> findByOrderStatusId(Long id);

    int deleteByOrderStatusId(Long id);




    @Query("SELECT NEW ma.zs.generated.ws.rest.provided.vo.CommandVo(c.day,c.month,COUNT(c.id),SUM(c.total)) FROM Command c where c.orderDate BETWEEN  :start AND :end group by c.orderDate")
    public List<CommandVo> findStatisticsTotalCommands(@Param("start") Date start, @Param("end") Date end);

    @Query("SELECT NEW ma.zs.generated.ws.rest.provided.vo.CommandVo(c.day,c.month,COUNT(c.id),SUM(c.total)) FROM Command c where  c.orderStatus.label = :status or c.orderDate BETWEEN :start AND :end group by c.orderDate")
    public List<CommandVo> findStatisticsCommandsByStatus(@Param("start") Date start, @Param("end") Date end, @Param("status") String status);


    @Query("SELECT c FROM Command c where c.orderDate BETWEEN  :start AND :end")
    public List<Command> findAllCommandsBetween(@Param("start") Date start, @Param("end") Date end);

    @Query("SELECT NEW ma.zs.generated.ws.rest.provided.vo.CommandVo(c.month,COUNT(c.id),SUM(c.total)) FROM Command c where c.year = :year  group by c.month order by c.month")
    public List<CommandVo> findStatisticsTotalCommandsByCurrentYear(@Param("year") int year);

    @Query("SELECT c FROM Command c where c.validator.id = :id")
    public List<Command> findCommandsOfValidator(@Param("id") Long id);

    @Query("SELECT u FROM User u where u.superAdmin.id = :id")
    public List<User> findDeliveryOfValidator(@Param("id") Long id);

    @Query("SELECT NEW ma.zs.generated.ws.rest.provided.vo.CommandVo(c.month,COUNT(c.id),SUM(c.total)) FROM Command c where c.validator.id = :id and c.year = :year and c.orderStatus.label = 'confirmed' group by c.month order by c.month")
    public List<CommandVo> validatorChartByCurrentYear(@Param("id") Long id,@Param("year") int year);

    public List<Command> findCommandByDeliveryId(Long id);

    @Query("SELECT NEW ma.zs.generated.ws.rest.provided.vo.CommandVo(c.month,COUNT(c.id),SUM(c.total)) FROM Command c where c.delivery.id = :id and c.year = :year and c.orderStatus.label = 'closed' group by c.month order by c.month")
    public List<CommandVo> deliveryChartByCurrentYear(@Param("id") Long id,@Param("year") int year);

    public List<Command> findByAdminIdAndValidatorIsNullAndDeliveryIsNull(Long adminId);
}