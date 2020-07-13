package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import ma.zs.generated.bean.DeliveryCost;
import ma.zs.generated.bean.City;
import ma.zs.generated.bean.User;
import ma.zs.generated.dao.DeliveryCostDao;
import ma.zs.generated.service.facade.DeliveryCostService;
import ma.zs.generated.service.facade.CityService;
import ma.zs.generated.service.facade.UserService;
import ma.zs.generated.ws.rest.provided.vo.DeliveryCostVo;
import ma.zs.generated.service.util.*;
@Service
public class DeliveryCostServiceImpl implements DeliveryCostService {

   @Autowired
   private DeliveryCostDao deliveryCostDao;

   @Autowired
    private CityService cityService ;
	@Autowired
	private UserService userService ;
   @Autowired
   private EntityManager entityManager;
	@Override
	public List<DeliveryCost> findAll(){
		return deliveryCostDao.findAll();
	}
	@Override
	public List<DeliveryCost> findByCityName(String name){
		return deliveryCostDao.findByCityName(name);
	}
	@Override
	@Transactional
	public int deleteByCityName(String name){
		return deliveryCostDao.deleteByCityName(name);
	}

	@Override
	public List<DeliveryCost> findByCityId(Long id){
		return deliveryCostDao.findByCityId(id);

	}
	@Override
	@Transactional
	public int deleteByCityId(Long id){
		return deliveryCostDao.deleteByCityId(id);

	}

	@Override
	public List<DeliveryCost> findByDeliveryCode(String code){
		return deliveryCostDao.findByDeliveryCode(code);
	}
	@Override
	@Transactional
	public int deleteByDeliveryCode(String code){
		return deliveryCostDao.deleteByDeliveryCode(code);
	}

	@Override
	public List<DeliveryCost> findByDeliveryId(Long id){
		return deliveryCostDao.findByDeliveryId(id);

	}
	@Override
	@Transactional
	public int deleteByDeliveryId(Long id){
		return deliveryCostDao.deleteByDeliveryId(id);

	}


	@Override
	public DeliveryCost findById(Long id){
		if(id==null)
			return null;
		return deliveryCostDao.getOne(id);
	}

	@Transactional
	public void deleteById(Long id){
		deliveryCostDao.deleteById(id);
	}
	@Override
	public DeliveryCost save (DeliveryCost deliveryCost){

		if(deliveryCost.getCity()!=null){
			City city = cityService.findByName(deliveryCost.getCity().getName());
			if(city == null)
				deliveryCost.setCity(cityService.save(deliveryCost.getCity()));
			else
				deliveryCost.setCity(city);
		}

		if(deliveryCost.getDelivery()!=null){
			User delivery = userService.findByCode(deliveryCost.getDelivery().getCode());
			if(delivery == null)
				deliveryCost.setDelivery(userService.save(deliveryCost.getDelivery()));
			else
				deliveryCost.setDelivery(delivery);
		}

		DeliveryCost savedDeliveryCost = deliveryCostDao.save(deliveryCost);
		return savedDeliveryCost;
	}

	@Override
	public List<DeliveryCost> save(List<DeliveryCost> deliveryCosts){
		List<DeliveryCost> list = new ArrayList<DeliveryCost>();
		for(DeliveryCost deliveryCost: deliveryCosts){
			list.add(save(deliveryCost));
		}
		return list;
	}


	@Override
	public DeliveryCost update(DeliveryCost deliveryCost){


		DeliveryCost foundedDeliveryCost = findById(deliveryCost.getId());
		if(foundedDeliveryCost==null)
			return null;

		return  deliveryCostDao.save(deliveryCost);

	}

	@Override
	@Transactional
	public int delete(DeliveryCost deliveryCost){

		if(deliveryCost.getId()==null)
			return -1;
		DeliveryCost foundedDeliveryCost = findById(deliveryCost.getId());
		if(foundedDeliveryCost==null)
			return -1;
		deliveryCostDao.delete(foundedDeliveryCost);
		return 1;
	}


	public List<DeliveryCost> findByCriteria(DeliveryCostVo deliveryCostVo){
		String query = "SELECT o FROM DeliveryCost o where 1=1 ";
		query += SearchUtil.addConstraint( "o", "shippingCost","=",deliveryCostVo.getShippingCost());
		query += SearchUtil.addConstraint( "o", "id","=",deliveryCostVo.getId());
		query += SearchUtil.addConstraintMinMax("o","shippingCost",deliveryCostVo.getShippingCostMin(),deliveryCostVo.getShippingCostMax());
		if(deliveryCostVo.getCityVo()!=null){
			query += SearchUtil.addConstraint( "o", "city.id","=",deliveryCostVo.getCityVo().getId());
			query += SearchUtil.addConstraint( "o", "city.name","LIKE",deliveryCostVo.getCityVo().getName());
		}

		if(deliveryCostVo.getDeliveryVo()!=null){
			query += SearchUtil.addConstraint( "o", "delivery.id","=",deliveryCostVo.getDeliveryVo().getId());
			query += SearchUtil.addConstraint( "o", "delivery.code","LIKE",deliveryCostVo.getDeliveryVo().getCode());
		}

		return entityManager.createQuery(query).getResultList();
	}

	@Override
	public List<DeliveryCost> findByCityIdAndDeliverySuperAdminId(Long cityId, Long adminId) {
		return deliveryCostDao.findByCityIdAndDeliverySuperAdminId(cityId ,adminId);
	}


}
