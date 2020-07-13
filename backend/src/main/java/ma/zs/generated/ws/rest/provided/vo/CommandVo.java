package ma.zs.generated.ws.rest.provided.vo;

import ma.zs.generated.bean.City;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

public class CommandVo {


    private String total;

    private String reference;

    private String id;

    private String orderDate;
    private String regulationDate;



    private UserVo deliveryVo;
    private ClientVo clientVo;
    private UserVo validatorVo;
    private UserVo adminVo ;

    private OrderStatusVo orderStatusVo;
    private CityVo cityVo;
    private String adress;
    private String remarque;

    private List<OrderLineVo> orderLinesVo;

    private String regulationDateMax;
    private String regulationDateMin;
    private String totalMax;
    private String totalMin;
    private String orderDateMax;
    private String orderDateMin;

    private int day;
    private int month;
    private Long totalCommandInDay;
    private BigDecimal totalInDay;

    private BigDecimal totalSalesCurrentDay;
    private BigDecimal totalConfirmedCurrentDay;
    private BigDecimal totalClosedCurrentDay;
    private BigDecimal totalCommandsSales;
    private Long totalValidator;
    private Long totalDelivery;
    private Long confirmedCommands;
    private BigDecimal totalConfirmedCommands;
    private Long returnedCommands;
    private Long closedCommands;
    private BigDecimal totalClosedCommands;
    private Long processedCommand;

    private Long totalCommandInMonth;
    private BigDecimal totalInMonth;

    private BigDecimal TotalCommands;
    private BigDecimal TotalCommandsConfirmed;
    private BigDecimal TotalCommandsDelivred;
    private BigDecimal TotalCommandsPaid;


    public CommandVo(int month, Long totalCommandInMonth, BigDecimal totalInMonth) {
        this.month = month;
        this.totalCommandInMonth = totalCommandInMonth;
        this.totalInMonth = totalInMonth;
    }



    public CommandVo(BigDecimal totalSalesCurrentDay, BigDecimal totalConfirmedCurrentDay, BigDecimal totalClosedCurrentDay, BigDecimal totalCommandsSales, Long totalValidator, Long totalDelivery, Long confirmedCommands, BigDecimal totalConfirmedCommands, Long returnedCommands, Long closedCommands, BigDecimal totalClosedCommands, Long processedCommand) {
        this.totalCommandsSales = totalCommandsSales;
        this.totalValidator = totalValidator;
        this.totalDelivery = totalDelivery;
        this.confirmedCommands = confirmedCommands;
        this.totalConfirmedCommands = totalConfirmedCommands;
        this.returnedCommands = returnedCommands;
        this.closedCommands = closedCommands;
        this.totalClosedCommands = totalClosedCommands;
        this.processedCommand = processedCommand;
        this.totalSalesCurrentDay = totalSalesCurrentDay;
        this.totalConfirmedCurrentDay = totalConfirmedCurrentDay;
        this.totalClosedCurrentDay = totalClosedCurrentDay;

    }

    public CommandVo(BigDecimal totalConfirmedCurrentDay, BigDecimal totalClosedCurrentDay, Long totalDelivery, Long confirmedCommands, BigDecimal totalConfirmedCommands, Long returnedCommands, Long closedCommands, BigDecimal totalClosedCommands, Long processedCommand) {
        this.totalConfirmedCurrentDay = totalConfirmedCurrentDay;
        this.totalClosedCurrentDay = totalClosedCurrentDay;
        this.totalDelivery = totalDelivery;
        this.confirmedCommands = confirmedCommands;
        this.totalConfirmedCommands = totalConfirmedCommands;
        this.returnedCommands = returnedCommands;
        this.closedCommands = closedCommands;
        this.totalClosedCommands = totalClosedCommands;
        this.processedCommand = processedCommand;
    }

    public CommandVo(BigDecimal totalCommands, BigDecimal totalCommandsConfirmed, BigDecimal totalCommandsDelivred, BigDecimal totalCommandsPaid) {
        TotalCommands = totalCommands;
        TotalCommandsConfirmed = totalCommandsConfirmed;
        TotalCommandsDelivred = totalCommandsDelivred;
        TotalCommandsPaid = totalCommandsPaid;
    }

    public CommandVo(int day, int month, Long totalCommandInDay, BigDecimal totalInDay) {

        this.day = day;
        this.month = month;
        this.totalCommandInDay = totalCommandInDay;
        this.totalInDay = totalInDay;
    }

    public CommandVo(BigDecimal totalClosedCurrentDay, Long closedCommands, BigDecimal totalClosedCommands, Long processedCommand) {
        this.totalClosedCurrentDay = totalClosedCurrentDay;
        this.closedCommands = closedCommands;
        this.totalClosedCommands = totalClosedCommands;
        this.processedCommand = processedCommand;
    }

    public BigDecimal getTotalCommandsSales() {
        return totalCommandsSales;
    }

    public BigDecimal getTotalCommands() {
        return TotalCommands;
    }

    public void setTotalCommands(BigDecimal totalCommands) {
        TotalCommands = totalCommands;
    }

    public BigDecimal getTotalCommandsConfirmed() {
        return TotalCommandsConfirmed;
    }

    public void setTotalCommandsConfirmed(BigDecimal totalCommandsConfirmed) {
        TotalCommandsConfirmed = totalCommandsConfirmed;
    }

    public BigDecimal getTotalCommandsDelivred() {
        return TotalCommandsDelivred;
    }

    public void setTotalCommandsDelivred(BigDecimal totalCommandsDelivred) {
        TotalCommandsDelivred = totalCommandsDelivred;
    }

    public BigDecimal getTotalCommandsPaid() {
        return TotalCommandsPaid;
    }

    public void setTotalCommandsPaid(BigDecimal totalCommandsPaid) {
        TotalCommandsPaid = totalCommandsPaid;
    }

    public void setTotalCommandsSales(BigDecimal totalCommandsSales) {
        this.totalCommandsSales = totalCommandsSales;
    }

    public Long getTotalValidator() {
        return totalValidator;
    }

    public BigDecimal getTotalSalesCurrentDay() {
        return totalSalesCurrentDay;
    }

    public Long getTotalCommandInMonth() {
        return totalCommandInMonth;
    }

    public void setTotalCommandInMonth(Long totalCommandInMonth) {
        this.totalCommandInMonth = totalCommandInMonth;
    }

    public BigDecimal getTotalInMonth() {
        return totalInMonth;
    }

    public void setTotalInMonth(BigDecimal totalInMonth) {
        this.totalInMonth = totalInMonth;
    }

    public void setTotalSalesCurrentDay(BigDecimal totalSalesCurrentDay) {
        this.totalSalesCurrentDay = totalSalesCurrentDay;
    }

    public BigDecimal getTotalConfirmedCurrentDay() {
        return totalConfirmedCurrentDay;
    }

    public void setTotalConfirmedCurrentDay(BigDecimal totalConfirmedCurrentDay) {
        this.totalConfirmedCurrentDay = totalConfirmedCurrentDay;
    }

    public BigDecimal getTotalClosedCurrentDay() {
        return totalClosedCurrentDay;
    }

    public void setTotalClosedCurrentDay(BigDecimal totalClosedCurrentDay) {
        this.totalClosedCurrentDay = totalClosedCurrentDay;
    }

    public void setTotalValidator(Long totalValidator) {
        this.totalValidator = totalValidator;
    }

    public Long getTotalDelivery() {
        return totalDelivery;
    }

    public void setTotalDelivery(Long totalDelivery) {
        this.totalDelivery = totalDelivery;
    }

    public Long getConfirmedCommands() {
        return confirmedCommands;
    }

    public void setConfirmedCommands(Long confirmedCommands) {
        this.confirmedCommands = confirmedCommands;
    }

    public String getRegulationDate() {
        return regulationDate;
    }

    public void setRegulationDate(String regulationDate) {
        this.regulationDate = regulationDate;
    }

    public BigDecimal getTotalConfirmedCommands() {
        return totalConfirmedCommands;
    }

    public void setTotalConfirmedCommands(BigDecimal totalConfirmedCommands) {
        this.totalConfirmedCommands = totalConfirmedCommands;
    }

    public Long getReturnedCommands() {
        return returnedCommands;
    }

    public void setReturnedCommands(Long returnedCommands) {
        this.returnedCommands = returnedCommands;
    }

    public Long getClosedCommands() {
        return closedCommands;
    }

    public void setClosedCommands(Long closedCommands) {
        this.closedCommands = closedCommands;
    }

    public BigDecimal getTotalClosedCommands() {
        return totalClosedCommands;
    }

    public void setTotalClosedCommands(BigDecimal totalClosedCommands) {
        this.totalClosedCommands = totalClosedCommands;
    }

    public Long getProcessedCommand() {
        return processedCommand;
    }

    public void setProcessedCommand(Long processedCommand) {
        this.processedCommand = processedCommand;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Long getTotalCommandInDay() {
        return totalCommandInDay;
    }

    public void setTotalCommandInDay(Long totalCommandInDay) {
        this.totalCommandInDay = totalCommandInDay;
    }

    public BigDecimal getTotalInDay() {
        return totalInDay;
    }

    public void setTotalInDay(BigDecimal totalInDay) {
        this.totalInDay = totalInDay;
    }

    public CommandVo() {
        super();
    }




    public String getTotal() {
        return this.total;
    }

    public void setTotal(String total) {
        this.total = total;
    }


    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }


    public String getRegulationDateMax() {
        return this.regulationDateMax;
    }

    public String getRegulationDateMin() {
        return this.regulationDateMin;
    }

    public void setRegulationDateMax(String regulationDateMax) {
        this.regulationDateMax = regulationDateMax;
    }

    public void setRegulationDateMin(String regulationDateMin) {
        this.regulationDateMin = regulationDateMin;
    }


    public String getTotalMax() {
        return this.totalMax;
    }

    public String getTotalMin() {
        return this.totalMin;
    }

    public void setTotalMax(String totalMax) {
        this.totalMax = totalMax;
    }

    public void setTotalMin(String totalMin) {
        this.totalMin = totalMin;
    }


    public String getOrderDateMax() {
        return this.orderDateMax;
    }

    public String getOrderDateMin() {
        return this.orderDateMin;
    }

    public void setOrderDateMax(String orderDateMax) {
        this.orderDateMax = orderDateMax;
    }

    public void setOrderDateMin(String orderDateMin) {
        this.orderDateMin = orderDateMin;
    }




    public UserVo getDeliveryVo() {
        return this.deliveryVo;
    }

    public void setDeliveryVo(UserVo deliveryVo) {
        this.deliveryVo = deliveryVo;
    }

    public ClientVo getClientVo() {
        return this.clientVo;
    }

    public void setClientVo(ClientVo clientVo) {
        this.clientVo = clientVo;
    }


    public UserVo getAdminVo() {
        return adminVo;
    }

    public void setAdminVo(UserVo adminVo) {
        this.adminVo = adminVo;
    }

    public UserVo getValidatorVo() {
        return this.validatorVo;
    }

    public void setValidatorVo(UserVo validatorVo) {
        this.validatorVo = validatorVo;
    }

    public OrderStatusVo getOrderStatusVo() {
        return this.orderStatusVo;
    }

    public void setOrderStatusVo(OrderStatusVo orderStatusVo) {
        this.orderStatusVo = orderStatusVo;
    }


    public List<OrderLineVo> getOrderLinesVo() {
        return this.orderLinesVo;
    }

    public void setOrderLinesVo(List<OrderLineVo> orderLinesVo) {
        this.orderLinesVo = orderLinesVo;
    }

    public CityVo getCityVo() {
        return cityVo;
    }

    public void setCityVo(CityVo cityVo) {
        this.cityVo = cityVo;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }
}