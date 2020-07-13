package ma.zs.generated.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.generated.bean.City;
import ma.zs.generated.bean.Client;
import ma.zs.generated.bean.Command;
import ma.zs.generated.bean.OrderLine;
import ma.zs.generated.bean.OrderStatus;
import ma.zs.generated.bean.Product;
import ma.zs.generated.bean.Role;
import ma.zs.generated.bean.User;
import ma.zs.generated.dao.CommandDao;
import ma.zs.generated.service.facade.CityService;
import ma.zs.generated.service.facade.ClientService;
import ma.zs.generated.service.facade.CommandService;
import ma.zs.generated.service.facade.OrderLineService;
import ma.zs.generated.service.facade.OrderStatusService;
import ma.zs.generated.service.facade.ProductService;
import ma.zs.generated.service.facade.UserService;
import ma.zs.generated.service.util.DateUtil;
import ma.zs.generated.service.util.ListUtil;
import ma.zs.generated.service.util.NumberUtil;
import ma.zs.generated.service.util.SearchUtil;
import ma.zs.generated.ws.rest.provided.vo.CommandVo;

@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    private CommandDao commandDao;

    @Autowired
    private UserService userService;
    @Autowired
    private UserService deliveryService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private UserService validatorService;
    @Autowired
    private OrderStatusService orderStatusService;
    @Autowired
    private OrderLineService orderLinesService;
    @Autowired
    private CityService cityService;
    @Autowired
    private ProductService productService;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Command> findAll() {
        return commandDao.findAll();
    }

    //
    // @Override
    // public List<Command> findByAdminCode(String code) {
    // return commandDao.findByAdminCode(code);
    // }
    //
    // @Override
    // @Transactional
    // public int deleteByAdminCode(String code) {
    // return commandDao.deleteByAdminCode(code);
    // }
    //
    @Override
    public List<Command> findByAdminId(Long id) {
        return commandDao.findByAdminId(id);

    }
    //
    // @Override
    // @Transactional
    // public int deleteByAdminId(Long id) {
    // return commandDao.deleteByAdminId(id);
    //
    // }

    @Override
    public List<Command> findByDeliveryCode(String code) {
        return commandDao.findByDeliveryCode(code);
    }

    @Override
    @Transactional
    public int deleteByDeliveryCode(String code) {
        return commandDao.deleteByDeliveryCode(code);
    }

    @Override
    public List<Command> findByDeliveryId(Long id) {
        return commandDao.findByDeliveryId(id);

    }

    @Override
    @Transactional
    public int deleteByDeliveryId(Long id) {
        return commandDao.deleteByDeliveryId(id);

    }

    @Override
    public List<Command> findByClientId(Long id) {
        return commandDao.findByClientId(id);

    }

    @Override
    @Transactional
    public int deleteByClientId(Long id) {
        return commandDao.deleteByClientId(id);

    }
    //
    // @Override
    // public List<Command> findByPackageStatusLabel(String label) {
    // return commandDao.findByPackageStatusLabel(label);
    // }
    //
    // @Override
    // @Transactional
    // public int deleteByPackageStatusLabel(String label) {
    // return commandDao.deleteByPackageStatusLabel(label);
    // }
    //
    // @Override
    // public List<Command> findByPackageStatusId(Long id) {
    // return commandDao.findByPackageStatusId(id);
    //
    // }
    //
    // @Override
    // @Transactional
    // public int deleteByPackageStatusId(Long id) {
    // return commandDao.deleteByPackageStatusId(id);
    //
    // }

    @Override
    public List<Command> findByValidatorCode(String code) {
        return commandDao.findByValidatorCode(code);
    }

    @Override
    @Transactional
    public int deleteByValidatorCode(String code) {
        return commandDao.deleteByValidatorCode(code);
    }

    @Override
    public List<Command> findByValidatorId(Long id) {
        return commandDao.findByValidatorId(id);

    }

    @Override
    @Transactional
    public int deleteByValidatorId(Long id) {
        return commandDao.deleteByValidatorId(id);

    }

    @Override
    public List<Command> findByOrderStatusLabel(String label) {
        return commandDao.findByOrderStatusLabel(label);
    }

    @Override
    @Transactional
    public int deleteByOrderStatusLabel(String label) {
        return commandDao.deleteByOrderStatusLabel(label);
    }

    @Override
    public List<Command> findByOrderStatusId(Long id) {
        return commandDao.findByOrderStatusId(id);

    }

    @Override
    @Transactional
    public int deleteByOrderStatusId(Long id) {
        return commandDao.deleteByOrderStatusId(id);

    }

    @Override
    public Command findByReference(String reference) {
        return commandDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return commandDao.deleteByReference(reference);
    }

    @Override
    public Command findById(Long id) {
        return commandDao.getOne(id);
    }

    @Transactional
    public void deleteById(Long id) {
        commandDao.deleteById(id);
    }

    @Override
    public Command save(Long adminId, Command command) {

        Command foundedCommand = findByReference(command.getReference());
        if (foundedCommand != null)
            return null;
        if (command.getClient() != null) {
            Client client = clientService.findByFirstNameAndLastName(command.getClient().getFirstName(),
                    command.getClient().getLastName());
            System.out.println(command.getClient().getFirstName());
            if (client == null) {
                Client cl = new Client();
                cl.setFirstName(command.getClient().getFirstName());
                cl.setLastName(command.getClient().getLastName());
                cl.setPhoneNumber(command.getClient().getPhoneNumber());

                command.setClient(clientService.save(cl));
            } else
                command.setClient(client);
        }
        if (command.getDelivery().getId() == null) {
            command.setDelivery(null);
        }
        if (command.getValidator().getId() == null) {
            command.setValidator(null);
        }
        LocalDate localDate = DateUtil.fromDate(command.getOrderDate());
        command.setDay(localDate.plusDays(1).getDayOfMonth());
        command.setMonth(localDate.plusMonths(1).getMonthValue());
        command.setYear(localDate.getYear());
        LocalDate localDate2 = DateUtil.fromDate(command.getRegulationDate());
        command.setOrderDate(DateUtil.toDate(localDate.plusDays(1)));
        command.setRegulationDate(DateUtil.toDate(localDate2.plusDays(1)));
        User admin = userService.findById(adminId);
        command.setAdmin(admin);
        Command savedCommand = commandDao.save(command);
        if (ListUtil.isNotEmpty(command.getOrderLines())) {
            calculTotal(savedCommand, command.getOrderLines());
            savedCommand
                    .setOrderLines(orderLinesService.save(adminId, prepareOrderLines(savedCommand, command.getOrderLines())));
        }
        return savedCommand;
    }

    @Override
    public int save(String commands) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(commands);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                Command command = mapCommand(line);
                saveMappedCommand(command);
            }
            return 1;
        } catch (Exception e) {
            throw new RuntimeException("Cannot read plain text commands");
        } finally {
            scanner.close();
        }
    }

    /*
     * Map a plain text to an object of type Command
     */
    private Command mapCommand(String[] line) {
        Command command = new Command();
        OrderStatus orderStatus = new OrderStatus();
        City city = new City();
        Client client = new Client();
        OrderLine orderLine = new OrderLine();
        Product p = new Product();
        User delivery = new User();
        Role deliveryRole = new Role();
        User validator = new User();
        Role validatorRole = new Role();

        command.setOrderDate(DateUtil.parse(line[0].trim()));
        command.setRegulationDate(DateUtil.parse(line[1].trim()));

        orderStatus.setLabel(line[2].trim());
        command.setOrderStatus(orderStatus);

        command.setReference(line[3].trim());

        String[] clientFullName = line[4].trim().replaceAll("\\s{2,}", " ").split(" ");
        client.setLastName(clientFullName[0]);
        client.setFirstName(clientFullName[1]);
        client.setPhoneNumber(line[5].trim());
        client.setCity(city);
        command.setClient(client);

        city.setName(line[6].trim());
        command.setCity(city);

        command.setAddress(line[7].trim());

        command.setTotal(NumberUtil.toBigDecimal(line[8].trim()));

        p.setLabel(line[9].trim());
        orderLine.setProduct(p);
        orderLine.setQte(NumberUtil.toBigDecimal(line[10].trim()));
        orderLine.setPrice(command.getTotal().divide(orderLine.getQte()));
        command.setOrderLines(Stream.of(orderLine).collect(Collectors.toList()));

        command.setRemarque(line[11].trim());

        delivery.setCode(line[12].trim());
        delivery.setCreated(new Date());
        deliveryRole.setAuthority("Delivery");
        delivery.setAuthority(deliveryRole);

        command.setDelivery(delivery);

        String[] validatorFullName = line[13].trim().replaceAll("\\s{2,}", " ").split(" ");
        validator.setLastName(validatorFullName[0]);
        validator.setFirstName(validatorFullName[1]);
        validator.setCreated(new Date());
        validatorRole.setAuthority("Validator");
        validator.setAuthority(validatorRole);
        command.setValidator(validator);

        return command;
    }

    private void saveMappedCommand(Command c) {
        Command foundCmd = commandDao.findByReference(c.getReference());
        OrderLine oLine = c.getOrderLines().get(0);
        if (foundCmd != null) {
            Product product = productService.findByLabel(oLine.getProduct().getLabel());
            if (product == null)
                oLine.setProduct(productService.savePlainProduct(oLine.getProduct()));
            else {
                OrderLine duplicatedOL = foundCmd.getOrderLines().stream()
                        .filter((oL) -> oL.getProduct().getLabel().equals(oLine.getProduct().getLabel())).findFirst()
                        .orElse(null);
                if (duplicatedOL != null) {
                    duplicatedOL.setQte(oLine.getQte().add(duplicatedOL.getQte()));
                    foundCmd.setTotal(foundCmd.getTotal().add(c.getTotal()));

                    orderLinesService.update(duplicatedOL);
                    commandDao.save(foundCmd);
                    return;
                } else {
                    oLine.setProduct(product);
                }

            }
            foundCmd.getOrderLines().addAll(orderLinesService
                    .savePlainOrderLines(prepareOrderLines(foundCmd, Stream.of(oLine).collect(Collectors.toList()))));
            foundCmd.setTotal(foundCmd.getTotal().add(c.getTotal()));
            commandDao.save(foundCmd);
            return;
        }

        if (c.getDelivery() != null) {
            User delivery = deliveryService.findByCode(c.getDelivery().getCode());
            if (delivery == null)
                c.setDelivery(deliveryService.save(c.getDelivery()));
            else
                c.setDelivery(delivery);
        }

        if (c.getCity() != null) {
            City city = cityService.findByName(c.getCity().getName());
            if (city == null)
                c.setCity(cityService.save(c.getCity()));
            else
                c.setCity(city);
        }

        if (c.getClient() != null) {
            Client client = clientService.findByFirstNameAndLastNameAndPhoneNumber(c.getClient().getFirstName(),
                    c.getClient().getLastName(), c.getClient().getPhoneNumber());
            if (client == null)
                c.setClient(clientService.savePlainClient(c.getClient()));
            else
                c.setClient(client);
        }

        if (c.getValidator() != null) {
            User user = validatorService.findByFirstNameAndLastName(c.getValidator().getFirstName(),
                    c.getValidator().getLastName());
            if (user == null)
                c.setValidator(validatorService.save(c.getValidator()));
            else
                c.setValidator(user);
        }

        if (c.getOrderStatus() != null) {
            OrderStatus orderStatus = orderStatusService.findByLabel(c.getOrderStatus().getLabel());
            if (orderStatus == null)
                c.setOrderStatus(orderStatusService.save(c.getOrderStatus()));
            else
                c.setOrderStatus(orderStatus);
        }
        LocalDate orderDate = DateUtil.fromDate(c.getOrderDate());
        c.setDay(orderDate.getDayOfMonth());
        c.setMonth(orderDate.getMonthValue());
        c.setYear(orderDate.getYear());
        Command savedCommand = commandDao.save(c);

        if (oLine.getProduct() != null) {
            Product product = productService.findByLabel(oLine.getProduct().getLabel());
            if (product == null)
                oLine.setProduct(productService.savePlainProduct(oLine.getProduct()));
            else
                oLine.setProduct(product);
            savedCommand.setOrderLines(
                    orderLinesService.savePlainOrderLines(prepareOrderLines(savedCommand, c.getOrderLines())));
        }
    }

    @Override
    public List<Command> save(Long adminId, List<Command> commands) {
        List<Command> list = new ArrayList<Command>();
        for (Command command : commands) {
            list.add(save(adminId, command));
        }
        return list;
    }

    @Override
    public List<OrderLine> prepareOrderLines(Command command, List<OrderLine> orderLines) {
        for (OrderLine orderLine : orderLines) {
            orderLine.setCommand(command);
        }
        return orderLines;
    }

    @Override
    public Command update(Command command) {


        Command foundedCommand = findById(command.getId());
        if (foundedCommand == null)
            return null;

        return commandDao.save(command);

    }

    @Override
    @Transactional
    public int delete(Command command) {

        if (command.getReference() == null)
            return -1;

        Command foundedCommand = findByReference(command.getReference());
        if (foundedCommand == null)
            return -1;
        commandDao.delete(foundedCommand);
        return 1;
    }


    public List<Command> findByCriteria(CommandVo commandVo) {
        String query = "SELECT o FROM Command o where 1=1 ";
        query += SearchUtil.addConstraint("o", "total", "=", commandVo.getTotal());
        query += SearchUtil.addConstraintDate("o", "regulationDate", "=", commandVo.getRegulationDate());
        query += SearchUtil.addConstraint("o", "adress", "LIKE", commandVo.getAdress());

        query += SearchUtil.addConstraint("o", "reference", "LIKE", commandVo.getReference());

        query += SearchUtil.addConstraint("o", "remarque", "LIKE", commandVo.getRemarque());

        query += SearchUtil.addConstraintDate("o", "orderDate", "=", commandVo.getOrderDate());
        query += SearchUtil.addConstraint("o", "id", "=", commandVo.getId());
        query += SearchUtil.addConstraintMinMax("o", "total", commandVo.getTotalMin(), commandVo.getTotalMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "regulationDate", commandVo.getRegulationDateMin(), commandVo.getRegulationDateMax());
        query += SearchUtil.addConstraintMinMaxDate("o", "orderDate", commandVo.getOrderDateMin(), commandVo.getOrderDateMax());
        if (commandVo.getDeliveryVo() != null) {
            query += SearchUtil.addConstraint("o", "delivery.id", "=", commandVo.getDeliveryVo().getId());
            query += SearchUtil.addConstraint("o", "delivery.code", "LIKE", commandVo.getDeliveryVo().getCode());
        }

        if (commandVo.getValidatorVo() != null) {
            query += SearchUtil.addConstraint("o", "validator.id", "=", commandVo.getValidatorVo().getId());
            query += SearchUtil.addConstraint("o", "validator.code", "LIKE", commandVo.getValidatorVo().getCode());
        }

        if (commandVo.getAdminVo() != null) {
            query += SearchUtil.addConstraint("o", "admin.id", "=", commandVo.getAdminVo().getId());
            query += SearchUtil.addConstraint("o", "admin.code", "LIKE", commandVo.getAdminVo().getCode());
        }

        if (commandVo.getClientVo() != null) {
            query += SearchUtil.addConstraint("o", "client.id", "=", commandVo.getClientVo().getId());
        }

        if (commandVo.getOrderStatusVo() != null) {
            query += SearchUtil.addConstraint("o", "orderStatus.id", "=", commandVo.getOrderStatusVo().getId());
            query += SearchUtil.addConstraint("o", "orderStatus.label", "LIKE", commandVo.getOrderStatusVo().getLabel());
        }

        if (commandVo.getCityVo() != null) {
            query += SearchUtil.addConstraint("o", "city.id", "=", commandVo.getCityVo().getId());
            query += SearchUtil.addConstraint("o", "city.name", "LIKE", commandVo.getCityVo().getName());
        }

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<CommandVo> findStatisticsTotalCommands() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(7);
        return commandDao.findStatisticsTotalCommands(DateUtil.toDate(startDate), DateUtil.toDate(endDate));
    }

    @Override
    public List<CommandVo> findStatisticsCommandsByStatus(String status) {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(7);
        return commandDao.findStatisticsCommandsByStatus(DateUtil.toDate(startDate), DateUtil.toDate(endDate), status);
    }

    @Override
    public List<Command> findAllCommandsBetween(Date start, Date end) {
        return commandDao.findAllCommandsBetween(start, end);
    }

    @Override
    public CommandVo dashboardCommands() {
        List<Command> commands = findAll();
        List<User> users = userService.findAll();
        CommandVo commandVo = new CommandVo(new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0),
                (long) 0, (long) 0, (long) 0, new BigDecimal(0), (long) 0, (long) 0, new BigDecimal(0), (long) 0);
        List<Command> commandsDays = findAllCommandsBetween(new Date(), new Date());
        for (Command commandDay : commandsDays) {
            commandVo.setTotalSalesCurrentDay(commandVo.getTotalSalesCurrentDay().add(commandDay.getTotal()));
            if (commandDay.getOrderStatus().getLabel().equalsIgnoreCase("confirmed")) {
                commandVo.setTotalConfirmedCurrentDay(
                        commandVo.getTotalConfirmedCurrentDay().add(commandDay.getTotal()));
            } else if (commandDay.getOrderStatus().getLabel().equalsIgnoreCase("closed")) {
                commandVo.setTotalClosedCurrentDay(commandVo.getTotalClosedCurrentDay().add(commandDay.getTotal()));
            }
        }
        for (User user : users) {
            if (user.getAuthority().getAuthority().equalsIgnoreCase("validator")) {
                commandVo.setTotalValidator(commandVo.getTotalValidator() + 1);
            } else if (user.getAuthority().getAuthority().equalsIgnoreCase("delivery")) {
                commandVo.setTotalDelivery(commandVo.getTotalDelivery() + 1);
            }
        }
        for (Command command1 : commands) {
            commandVo.setTotalCommandsSales(commandVo.getTotalCommandsSales().add(command1.getTotal()));
            if (command1.getOrderStatus().getLabel().equalsIgnoreCase("confirmed")) {
                commandVo.setConfirmedCommands(commandVo.getConfirmedCommands() + 1);
                commandVo.setTotalConfirmedCommands(commandVo.getTotalConfirmedCommands().add(command1.getTotal()));
            } else if (command1.getOrderStatus().getLabel().equalsIgnoreCase("returned")) {
                commandVo.setReturnedCommands(commandVo.getReturnedCommands() + 1);
            } else if (command1.getOrderStatus().getLabel().equalsIgnoreCase("closed")) {
                commandVo.setTotalClosedCommands(commandVo.getTotalClosedCommands().add(command1.getTotal()));
                commandVo.setClosedCommands(commandVo.getClosedCommands() + 1);
            } else if ((command1.getOrderStatus().getLabel().equalsIgnoreCase("processed"))) {
                commandVo.setProcessedCommand(commandVo.getProcessedCommand() + 1);
            }

        }
        return commandVo;
    }

    @Override
    public List<CommandVo> findStatisticsTotalCommandsByCurrentYear() {
        LocalDate localDate = DateUtil.fromDate(new Date());
        int year = localDate.getYear();
        return commandDao.findStatisticsTotalCommandsByCurrentYear(year);
    }

    @Override
    public CommandVo findStatisticsTotalCommandAmount(Date start, Date end) {
        // LocalDate endDate = LocalDate.now();
        // LocalDate startDate = endDate.minusDays(7);
        List<Command> commands = findAllCommandsBetween(start, end);
        CommandVo commandVo = new CommandVo(new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0));
        for (Command command : commands) {
            commandVo.setTotalCommands((commandVo.getTotalCommands().add(command.getTotal())));
            if (command.getOrderStatus().getLabel().equalsIgnoreCase("confirmed")) {
                commandVo.setTotalCommandsConfirmed(commandVo.getTotalCommandsConfirmed().add(command.getTotal()));
            } else if (command.getOrderStatus().getLabel().equalsIgnoreCase("closed")) {
                commandVo.setTotalCommandsDelivred(commandVo.getTotalCommandsDelivred().add(command.getTotal()));
            } else if (command.getOrderStatus().getLabel().equalsIgnoreCase("paid")) {
                commandVo.setTotalCommandsPaid(commandVo.getTotalCommandsPaid().add(command.getTotal()));
            }
        }
        return commandVo;
    }

    @Override
    public List<Command> findCommandsOfValidator(Long id) {
        return commandDao.findCommandsOfValidator(id);
    }

    @Override
    public List<User> findDeliveryOfValidator(Long id) {
        return commandDao.findDeliveryOfValidator(id);
    }

    @Override
    public CommandVo validatorDashboard(Long id) {
        List<User> deliverys = findDeliveryOfValidator(id);
        List<Command> commands = findCommandsOfValidator(id);
        CommandVo commandVo = new CommandVo(new BigDecimal(0), new BigDecimal(0), (long) 0, (long) 0, new BigDecimal(0),
                (long) 0, (long) 0, new BigDecimal(0), (long) 0);
        commandVo.setTotalDelivery((long) deliverys.size());
        for (Command command1 : commands) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = formatter.format(command1.getOrderDate());
            String date2 = formatter.format(new Date());
            if (command1.getOrderStatus().getLabel().equalsIgnoreCase("confirmed") && date1.equals(date2)) {
                commandVo.setTotalConfirmedCurrentDay(commandVo.getTotalConfirmedCurrentDay().add(command1.getTotal()));
            } else if (command1.getOrderStatus().getLabel().equalsIgnoreCase("closed") && date1.equals(date2)) {
                commandVo.setTotalClosedCurrentDay(commandVo.getTotalClosedCurrentDay().add(command1.getTotal()));
            } else if (command1.getOrderStatus().getLabel().equalsIgnoreCase("confirmed")) {
                commandVo.setConfirmedCommands(commandVo.getConfirmedCommands() + 1);
                commandVo.setTotalConfirmedCommands(commandVo.getTotalConfirmedCommands().add(command1.getTotal()));
            } else if (command1.getOrderStatus().getLabel().equalsIgnoreCase("returned")) {
                commandVo.setReturnedCommands(commandVo.getReturnedCommands() + 1);
            } else if (command1.getOrderStatus().getLabel().equalsIgnoreCase("closed")) {
                commandVo.setTotalClosedCommands(commandVo.getTotalClosedCommands().add(command1.getTotal()));
                commandVo.setClosedCommands(commandVo.getClosedCommands() + 1);
            } else if ((command1.getOrderStatus().getLabel().equalsIgnoreCase("processed"))) {
                commandVo.setProcessedCommand(commandVo.getProcessedCommand() + 1);
            }

        }
        return commandVo;
    }

    @Override
    public List<CommandVo> validatorChartByCurrentYear(Long id) {
        LocalDate localDate = DateUtil.fromDate(new Date());
        int year = localDate.getYear();
        return commandDao.validatorChartByCurrentYear(id, year);
    }

    @Override
    public List<Command> findCommandByDeliveryId(Long id) {
        return commandDao.findCommandByDeliveryId(id);
    }

    @Override
    public CommandVo deliveryDashboard(Long id) {
        List<Command> commands = findCommandByDeliveryId(id);
        System.out.println(commands);
        CommandVo commandVo = new CommandVo(new BigDecimal(0), (long) 0, new BigDecimal(0), (long) 0);
        for (Command command1 : commands) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = formatter.format(command1.getOrderDate());
            String date2 = formatter.format(new Date());
            if (command1.getOrderStatus().getLabel().equalsIgnoreCase("closed") && date1.equals(date2)) {
                commandVo.setTotalClosedCurrentDay(commandVo.getTotalClosedCurrentDay().add(command1.getTotal()));
            } else if (command1.getOrderStatus().getLabel().equalsIgnoreCase("closed")) {
                commandVo.setTotalClosedCommands(commandVo.getTotalClosedCommands().add(command1.getTotal()));
                commandVo.setClosedCommands(commandVo.getClosedCommands() + 1);
            } else if ((command1.getOrderStatus().getLabel().equalsIgnoreCase("processed"))) {
                commandVo.setProcessedCommand(commandVo.getProcessedCommand() + 1);
            }

        }
        return commandVo;
    }

    @Override
    public List<CommandVo> deliveryChartByCurrentYear(Long id) {
        LocalDate localDate = DateUtil.fromDate(new Date());
        int year = localDate.getYear();
        return commandDao.deliveryChartByCurrentYear(id, year);
    }

    @Override
    public void calculTotal(Command command, List<OrderLine> orderLines) {
        BigDecimal total = BigDecimal.ZERO;
        if (orderLines != null && !orderLines.isEmpty()) {
            for (OrderLine orderLine : orderLines) {
                total = total.add(orderLine.getPrice().multiply(orderLine.getQte()));
            }
        }
        command.setTotal(total);
    }

    @Override
    public List<Command> findByAdminIdAndValidatorIsNullAndDeliveryIsNull(Long adminId) {
        return commandDao.findByAdminIdAndValidatorIsNullAndDeliveryIsNull(adminId);
    }

    @Override
    public Command assignment(Command command) {
        Command oldCommand = findById(command.getId());
        oldCommand.setValidator(command.getValidator());
        oldCommand.setDelivery(command.getDelivery());
        oldCommand.setOrderStatus(command.getOrderStatus());
        commandDao.save(oldCommand);
        return oldCommand;
    }

}
