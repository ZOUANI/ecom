package ma.zs.generated.ws.rest.provided.vo;

import java.math.BigDecimal;
import java.util.List;

public class ClientVo {

    private String phoneNumber;

    private String address;

    private String lastName;

    private String email;

    private String firstName;

    private String id;

    private CityVo cityVo;

    private List<CommandVo> commandsVo;

    private Long totalCommands;
    private BigDecimal sales;

    public ClientVo(String lastName, Long totalCommands, BigDecimal sales) {
        this.lastName = lastName;
        this.totalCommands = totalCommands;
        this.sales = sales;
    }

    public Long getTotalCommands() {
        return totalCommands;
    }

    public void setTotalCommands(Long totalCommands) {
        this.totalCommands = totalCommands;
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public ClientVo() {
        super();
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CityVo getCityVo() {
        return this.cityVo;
    }

    public void setCityVo(CityVo cityVo) {
        this.cityVo = cityVo;
    }

    public List<CommandVo> getCommandsVo() {
        return this.commandsVo;
    }

    public void setCommandsVo(List<CommandVo> commandsVo) {
        this.commandsVo = commandsVo;
    }

}