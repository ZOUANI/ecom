package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.OrderStatus;
import ma.zs.generated.dao.OrderStatusDao;
import ma.zs.generated.service.facade.OrderStatusService;

import ma.zs.generated.ws.rest.provided.vo.OrderStatusVo;
import ma.zs.generated.service.util.*;
@Service
public class OrderStatusServiceImpl implements OrderStatusService {

	@Autowired
	private OrderStatusDao orderStatusDao;


	@Autowired
	private EntityManager entityManager;

	@Override
	public List<OrderStatus> findAll(){
		return orderStatusDao.findAll();
	}
	@Override
	public OrderStatus findByLabel(String label){
		if( label==null)
			return null;
		return orderStatusDao.findByLabel(label);
	}



	@Override
	@Transactional
	public int deleteByLabel(String  label) {
		return orderStatusDao.deleteByLabel(label);
	}

	@Override
	public OrderStatus findById(Long id){
		if(id==null)
			return null;
		return orderStatusDao.getOne(id);
	}

	@Transactional
	public void deleteById(Long id){
		orderStatusDao.deleteById(id);
	}
	@Override
	public OrderStatus save (OrderStatus orderStatus){
		OrderStatus foundedOrderStatus = findByLabel(orderStatus.getLabel());
		if(foundedOrderStatus!=null)
			return null;

		OrderStatus savedOrderStatus = orderStatusDao.save(orderStatus);
		return savedOrderStatus;
	}

	@Override
	public List<OrderStatus> save(List<OrderStatus> orderStatuss){
		List<OrderStatus> list = new ArrayList<OrderStatus>();
		for(OrderStatus orderStatus: orderStatuss){
			list.add(save(orderStatus));
		}
		return list;
	}


	@Override
	public OrderStatus update(OrderStatus orderStatus){


		OrderStatus foundedOrderStatus = findById(orderStatus.getId());
		if(foundedOrderStatus==null)
			return null;

		return  orderStatusDao.save(orderStatus);

	}

	@Override
	@Transactional
	public int delete(OrderStatus orderStatus){

		if(orderStatus.getLabel()==null)
			return -1;

		OrderStatus foundedOrderStatus = findByLabel(orderStatus.getLabel());
		if(foundedOrderStatus==null)
			return -1;
		orderStatusDao.delete(foundedOrderStatus);
		return 1;
	}


	public List<OrderStatus> findByCriteria(OrderStatusVo orderStatusVo){
		String query = "SELECT o FROM OrderStatus o where 1=1 ";
		query += SearchUtil.addConstraint( "o", "label","LIKE",orderStatusVo.getLabel());

		query += SearchUtil.addConstraint( "o", "id","=",orderStatusVo.getId());
		return entityManager.createQuery(query).getResultList();
	}


}
