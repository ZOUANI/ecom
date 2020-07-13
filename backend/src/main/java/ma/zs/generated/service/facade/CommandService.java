package ma.zs.generated.service.facade;

import ma.zs.generated.bean.Command;
import ma.zs.generated.bean.OrderLine;
import ma.zs.generated.bean.User;
import ma.zs.generated.ws.rest.provided.vo.CommandVo;

import java.util.Date;
import java.util.List;

public interface CommandService {

    /**
     * find all Command in database
     *
     * @return List<Command> , If database is empty return null.
     */
    List<Command> findAll();

    /**
     * find Command from database by reference (reference)
     *
     * @param reference - reference of Command
     * @return the founded Command , If no Command were found in database return
     *         null.
     */
    Command findByReference(String reference);

    /**
     * find Command from database by id (id)
     *
     * @param id - id of Command
     * @return the founded Command , If no Command were found in database return
     *         null.
     */
    Command findById(Long id);

    void deleteById(Long id);

    // List<Command> findByAdminCode(String code);

    // int deleteByAdminCode(String code);

     List<Command> findByAdminId(Long id);

    // int deleteByAdminId(Long id);

    List<Command> findByDeliveryCode(String code);

    int deleteByDeliveryCode(String code);

    List<Command> findByDeliveryId(Long id);

    int deleteByDeliveryId(Long id);

    List<Command> findByClientId(Long id);

    int deleteByClientId(Long id);

    // List<Command> findByPackageStatusLabel(String label);

    // int deleteByPackageStatusLabel(String label);

    // List<Command> findByPackageStatusId(Long id);

    // int deleteByPackageStatusId(Long id);

    List<Command> findByValidatorCode(String code);

    int deleteByValidatorCode(String code);

    List<Command> findByValidatorId(Long id);

    int deleteByValidatorId(Long id);

    List<Command> findByOrderStatusLabel(String label);

    int deleteByOrderStatusLabel(String label);

    List<Command> findByOrderStatusId(Long id);

    int deleteByOrderStatusId(Long id);

    public List<OrderLine> prepareOrderLines(Command command, List<OrderLine> orderLines);

    /**
     * save Command in database
     *
     * @param command - Command to be saved
     * @return the saved Command, If the Command can't be saved return null.
     */
    Command save(Long adminId,Command command);

    /**
     * save list Command in database
     *
     * @param commands - list of Command to be saved
     * @return the saved Command list
     */
    List<Command> save(Long adminId,List<Command> commands);

    /**
     * update Command in database
     *
     * @param command - Command to be updated
     * @return the updated Command, If the Command can't be updated return null.
     */
    Command update(Command command);

    /**
     * delete Command from database
     *
     * @param command - Command to be deleted
     * @return 1 if Command deleted successfully, If the Command can't be deleted
     *         return negative int
     */
    int delete(Command command);

    /**
     * delete Command from database by reference (reference)
     *
     * @param reference - reference of Command to be deleted
     * @return 1 if Command deleted successfully
     */
    int deleteByReference(String reference);

    /**
     * search for Command in by some criteria
     *
     * @return the searhed list Command
     */
    List<Command> findByCriteria(CommandVo commandVo);

    /**
     * search for Statistics Commands between 2 date
     *
     * @return the searhed list Command
     */
    public List<CommandVo> findStatisticsTotalCommands();

    /**
     * search for Statistics Commands by status between 2 date
     *
     * @return the searhed list Command
     */
    public List<CommandVo> findStatisticsCommandsByStatus(String status);

    public List<Command> findAllCommandsBetween(Date start, Date end);

    public CommandVo dashboardCommands();

    public List<CommandVo> findStatisticsTotalCommandsByCurrentYear();

    public CommandVo findStatisticsTotalCommandAmount(Date start, Date end);

    public List<Command> findCommandsOfValidator(Long id);

    public List<User> findDeliveryOfValidator(Long id);

    public CommandVo validatorDashboard(Long id);

    public List<CommandVo> validatorChartByCurrentYear(Long id);

    public List<Command> findCommandByDeliveryId(Long id);

    public CommandVo deliveryDashboard(Long id);

    public List<CommandVo> deliveryChartByCurrentYear(Long id);

    int save(String commands);

    public void calculTotal(Command command, List<OrderLine> orderLines);

    public List<Command> findByAdminIdAndValidatorIsNullAndDeliveryIsNull(Long adminId);

    public Command assignment(Command command);


}
