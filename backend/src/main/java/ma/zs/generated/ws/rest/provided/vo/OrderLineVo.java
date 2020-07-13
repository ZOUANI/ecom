package ma.zs.generated.ws.rest.provided.vo;

import java.math.BigDecimal;

public class OrderLineVo {

    private String qte;

    private String id;
    private String price;


    private ProductVo productVo;
    private CommandVo commandVo;


    private String qteMax;
    private String qteMin;

    public OrderLineVo() {
        super();
    }


    public String getQte() {
        return this.qte;
    }

    public void setQte(String qte) {
        this.qte = qte;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getQteMax() {
        return this.qteMax;
    }

    public String getQteMin() {
        return this.qteMin;
    }

    public void setQteMax(String qteMax) {
        this.qteMax = qteMax;
    }

    public void setQteMin(String qteMin) {
        this.qteMin = qteMin;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ProductVo getProductVo() {
        return this.productVo;
    }

    public void setProductVo(ProductVo productVo) {
        this.productVo = productVo;
    }

    public CommandVo getCommandVo() {
        return this.commandVo;
    }

    public void setCommandVo(CommandVo commandVo) {
        this.commandVo = commandVo;
    }


}