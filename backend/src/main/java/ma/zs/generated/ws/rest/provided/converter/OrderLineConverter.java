package ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.OrderLine;
import ma.zs.generated.ws.rest.provided.vo.OrderLineVo;

@Component
public class OrderLineConverter extends AbstractConverter<OrderLine, OrderLineVo> {
    @Autowired
    private ProductConverter productConverter;
    private boolean product;
    @Autowired
    private CommandConverter commandConverter;
    private boolean command;

    public OrderLineConverter() {
        init(true);
    }

    @Override
    public OrderLine toItem(OrderLineVo vo) {
        if (vo == null) {
            return null;
        } else {
            OrderLine item = new OrderLine();
            if (StringUtil.isNotEmpty(vo.getQte()))
                item.setQte(NumberUtil.toBigDecimal(vo.getQte()));
            if (StringUtil.isNotEmpty(vo.getPrice()))
                item.setPrice(NumberUtil.toBigDecimal(vo.getPrice()));
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (vo.getProductVo() != null && this.product)
                item.setProduct(productConverter.toItem(vo.getProductVo()));
            if (vo.getCommandVo() != null && this.command)
                item.setCommand(commandConverter.toItem(vo.getCommandVo()));


            return item;
        }
    }

    @Override
    public OrderLineVo toVo(OrderLine item) {
        if (item == null) {
            return null;
        } else {
            OrderLineVo vo = new OrderLineVo();

            if (item.getQte() != null)
                vo.setQte(NumberUtil.toString(item.getQte()));
			if (item.getPrice() != null)
				vo.setPrice(NumberUtil.toString(item.getPrice()));
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));
            if (item.getProduct() != null && this.product) {
                productConverter.init(false);
                vo.setProductVo(productConverter.toVo(item.getProduct()));
                productConverter.init(true);
            }
            if (item.getCommand() != null && this.command) {
                commandConverter.init(false);
                vo.setCommandVo(commandConverter.toVo(item.getCommand()));
                commandConverter.init(true);
            }

            return vo;

        }
    }

    public void init(boolean value) {
        product = value;
        command = value;
    }


    public ProductConverter getProductConverter() {
        return this.productConverter;
    }

    public void setProductConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    public boolean isProduct() {
        return this.product;
    }

    public void setProduct(boolean product) {
        this.product = product;
    }

    public CommandConverter getCommandConverter() {
        return this.commandConverter;
    }

    public void setCommandConverter(CommandConverter commandConverter) {
        this.commandConverter = commandConverter;
    }

    public boolean isCommand() {
        return this.command;
    }

    public void setCommand(boolean command) {
        this.command = command;
    }
} 
