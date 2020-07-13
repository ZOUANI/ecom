package ma.zs.generated.ws.rest.provided.vo;

import java.util.List;
import java.math.BigDecimal;

public class ProductVo {

    private String size;

    private String qteStock;

    private String label;

    private String weight;

    private String color;

    private String price;

    private String reference;

    private String id;

    private Long units;

    private BigDecimal sales;

    private List<OrderLineVo> orderLinesVo;

    private String qteStockMax;
    private String qteStockMin;
    private String weightMax;
    private String weightMin;
    private String priceMax;
    private String priceMin;
    private Long totalCommands;
    private BigDecimal totalAmountConfirmed;
    private BigDecimal totalAmountDelivered;
    private Long totalCommandsReturned;
    private BigDecimal pricee;

    public ProductVo(String label, BigDecimal pricee, Long units) {
        this.label = label;
        this.pricee = pricee;
        this.units = units;
        this.sales = pricee.multiply(new BigDecimal(units));
    }

    public ProductVo(String label, Long totalCommands, BigDecimal totalAmountConfirmed, BigDecimal totalAmountDelivered, Long totalCommandsReturned) {
        this.label = label;
        this.totalCommands = totalCommands;
        this.totalAmountConfirmed = totalAmountConfirmed;
        this.totalAmountDelivered = totalAmountDelivered;
        this.totalCommandsReturned = totalCommandsReturned;
    }

    public BigDecimal getSales() {
        return sales;
    }

    public BigDecimal getPricee() {
        return pricee;
    }

    public void setPricee(BigDecimal pricee) {
        this.pricee = pricee;
    }

    public Long getTotalCommands() {
        return totalCommands;
    }

    public void setTotalCommands(Long totalCommands) {
        this.totalCommands = totalCommands;
    }

    public BigDecimal getTotalAmountConfirmed() {
        return totalAmountConfirmed;
    }

    public void setTotalAmountConfirmed(BigDecimal totalAmountConfirmed) {
        this.totalAmountConfirmed = totalAmountConfirmed;
    }

    public Long getUnits() {
        return units;
    }

    public void setUnits(Long units) {
        this.units = units;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public BigDecimal getTotalAmountDelivered() {
        return totalAmountDelivered;
    }

    public void setTotalAmountDelivered(BigDecimal totalAmountDelivered) {
        this.totalAmountDelivered = totalAmountDelivered;
    }

    public Long getTotalCommandsReturned() {
        return totalCommandsReturned;
    }

    public void setTotalCommandsReturned(Long totalCommandsReturned) {
        this.totalCommandsReturned = totalCommandsReturned;
    }

    public ProductVo() {
        super();
    }


    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    public String getQteStock() {
        return this.qteStock;
    }

    public void setQteStock(String qteStock) {
        this.qteStock = qteStock;
    }



    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }


    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
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


    public String getQteStockMax() {
        return this.qteStockMax;
    }

    public String getQteStockMin() {
        return this.qteStockMin;
    }

    public void setQteStockMax(String qteStockMax) {
        this.qteStockMax = qteStockMax;
    }

    public void setQteStockMin(String qteStockMin) {
        this.qteStockMin = qteStockMin;
    }


    public String getWeightMax() {
        return this.weightMax;
    }

    public String getWeightMin() {
        return this.weightMin;
    }

    public void setWeightMax(String weightMax) {
        this.weightMax = weightMax;
    }

    public void setWeightMin(String weightMin) {
        this.weightMin = weightMin;
    }


    public String getPriceMax() {
        return this.priceMax;
    }

    public String getPriceMin() {
        return this.priceMin;
    }

    public void setPriceMax(String priceMax) {
        this.priceMax = priceMax;
    }

    public void setPriceMin(String priceMin) {
        this.priceMin = priceMin;
    }


    public List<OrderLineVo> getOrderLinesVo() {
        return this.orderLinesVo;
    }

    public void setOrderLinesVo(List<OrderLineVo> orderLinesVo) {
        this.orderLinesVo = orderLinesVo;
    }


}