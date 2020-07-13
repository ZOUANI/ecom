package ma.zs.generated.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date regulationDate;
    private BigDecimal total;
    private String reference;
    private int day;
    private int month;
    private int year;
    @Temporal(javax.persistence.TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

     @ManyToOne
     private User admin;

    @ManyToOne
    private User delivery;

    @ManyToOne
    private Client client;
    // @ManyToOne
    // private PackageStatus packageStatus;
    @ManyToOne
    private User validator;
    @ManyToOne
    private OrderStatus orderStatus;
    @OneToMany(mappedBy = "command")
    private List<OrderLine> orderLines;
    @ManyToOne
    private City city;
    private String address;
    private String remarque;

    public Command() {
        super();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getDelivery() {
        return this.delivery;
    }

    public void setDelivery(User delivery) {
        this.delivery = delivery;
    }

    public User getValidator() {
        return this.validator;
    }

    public void setValidator(User validator) {
        this.validator = validator;
    }

    public List<OrderLine> getOrderLines() {
        return this.orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getRegulationDate() {
        return regulationDate;
    }

    public void setRegulationDate(Date regulationDate) {
        this.regulationDate = regulationDate;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Command [adresse=" + address + ", city=" + city + ", client=" + client + ", day=" + day + ", delivery="
                + delivery + ", id=" + id + ", month=" + month + ", orderDate=" + orderDate + ", orderLines="
                + orderLines + ", orderStatus=" + orderStatus + ", reference=" + reference + ", regulationDate="
                + regulationDate + ", remarque=" + remarque + ", total=" + total + ", validator=" + validator
                + ", year=" + year + "]";
    }

}
