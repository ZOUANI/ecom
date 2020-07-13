package ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

import ma.zs.generated.bean.Product;
import ma.zs.generated.ws.rest.provided.vo.ProductVo;

@Component
public class ProductConverter extends AbstractConverter<Product, ProductVo> {
	@Autowired
	private OrderLineConverter orderLineConverter;
	private boolean orderLines;

	public ProductConverter() {
		init(true);
	}

	@Override
	public Product toItem(ProductVo vo) {
		if (vo == null) {
			return null;
		} else {
			Product item = new Product();
			if (StringUtil.isNotEmpty(vo.getSize()))
				item.setSize(vo.getSize());
			if (StringUtil.isNotEmpty(vo.getQteStock()))
				item.setQteStock(NumberUtil.toInteger(vo.getQteStock()));
			if (StringUtil.isNotEmpty(vo.getLabel()))
				item.setLabel(vo.getLabel());
			if (StringUtil.isNotEmpty(vo.getWeight()))
				item.setWeight(NumberUtil.toBigDecimal(vo.getWeight()));
			if (StringUtil.isNotEmpty(vo.getColor()))
				item.setColor(vo.getColor());
			if (StringUtil.isNotEmpty(vo.getPrice()))
				item.setPrice(NumberUtil.toBigDecimal(vo.getPrice()));
			if (StringUtil.isNotEmpty(vo.getReference()))
				item.setReference(vo.getReference());
			if (StringUtil.isNotEmpty(vo.getId()))
				item.setId(NumberUtil.toLong(vo.getId()));

			if (ListUtil.isNotEmpty(vo.getOrderLinesVo()) && this.orderLines)
				item.setOrderLines(orderLineConverter.toItem(vo.getOrderLinesVo()));

			return item;
		}
	}

	@Override
	public ProductVo toVo(Product item) {
		if (item == null) {
			return null;
		} else {
			ProductVo vo = new ProductVo();

			if (StringUtil.isNotEmpty(item.getSize()))
				vo.setSize(item.getSize());

			if (item.getQteStock() != null)
				vo.setQteStock(NumberUtil.toString(item.getQteStock()));
			if (StringUtil.isNotEmpty(item.getLabel()))
				vo.setLabel(item.getLabel());

			if (item.getWeight() != null)
				vo.setWeight(NumberUtil.toString(item.getWeight()));
			if (StringUtil.isNotEmpty(item.getColor()))
				vo.setColor(item.getColor());

			if (item.getPrice() != null)
				vo.setPrice(NumberUtil.toString(item.getPrice()));
			if (StringUtil.isNotEmpty(item.getReference()))
				vo.setReference(item.getReference());

			if (item.getId() != null)
				vo.setId(NumberUtil.toString(item.getId()));
			if (ListUtil.isNotEmpty(item.getOrderLines()) && this.orderLines) {
				orderLineConverter.init(false);
				vo.setOrderLinesVo(orderLineConverter.toVo(item.getOrderLines()));
				orderLineConverter.init(true);
			}

			return vo;

		}
	}

	public void init(boolean value) {
		orderLines = value;
	}

	public boolean isOrderLines() {
		return this.orderLines;
	}

	public void setOrderLines(boolean orderLines) {
		this.orderLines = orderLines;
	}
}
