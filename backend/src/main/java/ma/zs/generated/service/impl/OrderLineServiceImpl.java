package ma.zs.generated.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ma.zs.generated.ws.rest.provided.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import ma.zs.generated.bean.OrderLine;
import ma.zs.generated.bean.Product;
import ma.zs.generated.bean.Command;
import ma.zs.generated.dao.OrderLineDao;
import ma.zs.generated.service.facade.OrderLineService;
import ma.zs.generated.service.facade.ProductService;
import ma.zs.generated.service.facade.CommandService;
import ma.zs.generated.ws.rest.provided.vo.OrderLineVo;
import ma.zs.generated.service.util.*;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    private OrderLineDao orderLineDao;

    @Autowired
    private ProductService productService;
    @Autowired
    private CommandService commandService;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<OrderLine> findAll() {
        return orderLineDao.findAll();
    }

    @Override
    public List<OrderLine> findByProductReference(String reference) {
        return orderLineDao.findByProductReference(reference);
    }

    @Override
    @Transactional
    public int deleteByProductReference(String reference) {
        return orderLineDao.deleteByProductReference(reference);
    }

    @Override
    public List<OrderLine> findByProductId(Long id) {
        return orderLineDao.findByProductId(id);

    }

    @Override
    @Transactional
    public int deleteByProductId(Long id) {
        return orderLineDao.deleteByProductId(id);

    }

    @Override
    public List<OrderLine> findByCommandReference(String reference) {
        return orderLineDao.findByCommandReference(reference);
    }

    @Override
    @Transactional
    public int deleteByCommandReference(String reference) {
        return orderLineDao.deleteByCommandReference(reference);
    }

    @Override
    public List<OrderLine> findByCommandId(Long id) {
        return orderLineDao.findByCommandId(id);

    }

    @Override
    @Transactional
    public int deleteByCommandId(Long id) {
        return orderLineDao.deleteByCommandId(id);

    }

    @Override
    public OrderLine findById(Long id) {
        return orderLineDao.getOne(id);
    }

    @Transactional
    public void deleteById(Long id) {
        orderLineDao.deleteById(id);
    }

    @Override
    public OrderLine save(Long adminId,OrderLine orderLine) {

        if (orderLine.getProduct() != null) {
            Product product = productService.findByReference(orderLine.getProduct().getReference());
            if (product == null)
                orderLine.setProduct(productService.save(orderLine.getProduct()));
            else
                orderLine.setProduct(product);
        }

        if (orderLine.getCommand() != null) {
            Command command = commandService.findByReference(orderLine.getCommand().getReference());
            if (command == null)
                orderLine.setCommand(commandService.save(adminId,orderLine.getCommand()));
            else
                orderLine.setCommand(command);
        }

        OrderLine savedOrderLine = orderLineDao.save(orderLine);
        return savedOrderLine;
    }

    @Override
    public List<OrderLine> save(Long adminId,List<OrderLine> orderLines) {
        List<OrderLine> list = new ArrayList<OrderLine>();
        for (OrderLine orderLine : orderLines) {
            list.add(save(adminId,orderLine));
        }
        return list;
    }

    @Override
    public List<OrderLine> savePlainOrderLines(List<OrderLine> orderLines) {
        return orderLines.stream().map(oLine -> orderLineDao.save(oLine)).collect(Collectors.toList());
    }

    @Override
    public OrderLine update(OrderLine orderLine){


        OrderLine foundedOrderLine = findById(orderLine.getId());
        if(foundedOrderLine==null)
            return null;

        return  orderLineDao.save(orderLine);

    }

    @Override
    @Transactional
    public int delete(OrderLine orderLine){

        if(orderLine.getId()==null)
            return -1;
        OrderLine foundedOrderLine = findById(orderLine.getId());
        if(foundedOrderLine==null)
            return -1;
        orderLineDao.delete(foundedOrderLine);
        return 1;
    }


    public List<OrderLine> findByCriteria(OrderLineVo orderLineVo){
        String query = "SELECT o FROM OrderLine o where 1=1 ";
        query += SearchUtil.addConstraint( "o", "price","=",orderLineVo.getPrice());
        query += SearchUtil.addConstraint( "o", "id","=",orderLineVo.getId());
        query += SearchUtil.addConstraintMinMax("o","qte",orderLineVo.getQteMin(),orderLineVo.getQteMax());
        if(orderLineVo.getCommandVo()!=null){
            query += SearchUtil.addConstraint( "o", "command.id","=",orderLineVo.getCommandVo().getId());
            query += SearchUtil.addConstraint( "o", "command.reference","LIKE",orderLineVo.getCommandVo().getReference());
        }

        if(orderLineVo.getProductVo()!=null){
            query += SearchUtil.addConstraint( "o", "product.id","=",orderLineVo.getProductVo().getId());
            query += SearchUtil.addConstraint( "o", "product.reference","LIKE",orderLineVo.getProductVo().getReference());
        }

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<OrderLine> findOrdersLineBetween(Date start, Date end) {
        return orderLineDao.findOrdersLineBetween(start, end);
    }

}
