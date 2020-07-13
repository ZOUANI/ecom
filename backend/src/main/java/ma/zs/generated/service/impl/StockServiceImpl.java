package ma.zs.generated.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import ma.zs.generated.bean.Stock;
import ma.zs.generated.bean.City;
import ma.zs.generated.bean.Product;
import ma.zs.generated.bean.User;
import ma.zs.generated.dao.StockDao;
import ma.zs.generated.service.facade.StockService;
import ma.zs.generated.service.facade.UserService;
import ma.zs.generated.service.facade.ProductService;
import ma.zs.generated.service.facade.CityService;

import ma.zs.generated.ws.rest.provided.vo.StockVo;
import ma.zs.generated.service.util.*;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDao stockDao;

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CityService cityService;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Stock> findAll() {
        return stockDao.findAll();
    }

    @Override
    public List<Stock> findByCityName(String name) {
        return stockDao.findByCityName(name);
    }

    @Override
    @Transactional
    public int deleteByCityName(String name) {
        return stockDao.deleteByCityName(name);
    }

    @Override
    public List<Stock> findByCityId(Long id) {
        return stockDao.findByCityId(id);

    }

    @Override
    @Transactional
    public int deleteByCityId(Long id) {
        return stockDao.deleteByCityId(id);

    }

    @Override
    public List<Stock> findByProductReference(String reference) {
        return stockDao.findByProductReference(reference);
    }

    @Override
    @Transactional
    public int deleteByProductReference(String reference) {
        return stockDao.deleteByProductReference(reference);
    }

    @Override
    public List<Stock> findByProductId(Long id) {
        return stockDao.findByProductId(id);

    }

    @Override
    @Transactional
    public int deleteByProductId(Long id) {
        return stockDao.deleteByProductId(id);

    }

    @Override
    public List<Stock> findByAdminCode(String code) {
        return stockDao.findByAdminCode(code);
    }

    @Override
    @Transactional
    public int deleteByAdminCode(String code) {
        return stockDao.deleteByAdminCode(code);
    }

    @Override
    public List<Stock> findByAdminId(Long id) {
        return stockDao.findByAdminId(id);

    }

    @Override
    @Transactional
    public int deleteByAdminId(Long id) {
        return stockDao.deleteByAdminId(id);

    }


    @Override
    public Stock findById(Long id) {
        if (id == null)
            return null;
        return stockDao.getOne(id);
    }

    @Transactional
    public void deleteById(Long id) {
        stockDao.deleteById(id);
    }

    @Override
    public Stock save(Stock stock) {

        if (stock.getCity() != null) {
            City city = cityService.findByName(stock.getCity().getName());
            if (city == null)
                stock.setCity(cityService.save(stock.getCity()));
            else
                stock.setCity(city);
        }

        if (stock.getProduct() != null) {
            Product product = productService.findByReference(stock.getProduct().getReference());
            if (product == null)
                stock.setProduct(productService.save(stock.getProduct()));
            else
                stock.setProduct(product);
        }

        if (stock.getAdmin() != null) {
            User admin = userService.findByCode(stock.getAdmin().getCode());
            if (admin == null)
                stock.setAdmin(userService.save(stock.getAdmin()));
            else
                stock.setAdmin(admin);
        }

        Stock savedStock = stockDao.save(stock);
        return savedStock;
    }

    @Override
    public List<Stock> save(List<Stock> stocks) {
        List<Stock> list = new ArrayList<Stock>();
        for (Stock stock : stocks) {
            list.add(save(stock));
        }
        return list;
    }


    @Override
    public Stock update(Stock stock) {


        Stock foundedStock = findById(stock.getId());
        if (foundedStock == null)
            return null;

        return stockDao.save(stock);

    }

    @Override
    @Transactional
    public int delete(Stock stock) {

        if (stock.getId() == null)
            return -1;
        Stock foundedStock = findById(stock.getId());
        if (foundedStock == null)
            return -1;
        stockDao.delete(foundedStock);
        return 1;
    }


    public List<Stock> findByCriteria(StockVo stockVo) {
        String query = "SELECT o FROM Stock o where 1=1 ";
        query += SearchUtil.addConstraint("o", "id", "=", stockVo.getId());
        query += SearchUtil.addConstraint("o", "qte", "=", stockVo.getQte());
        query += SearchUtil.addConstraintMinMax("o", "qte", stockVo.getQteMin(), stockVo.getQteMax());
        if (stockVo.getCityVo() != null) {
            query += SearchUtil.addConstraint("o", "city.id", "=", stockVo.getCityVo().getId());
            query += SearchUtil.addConstraint("o", "city.name", "LIKE", stockVo.getCityVo().getName());
        }

        if (stockVo.getProductVo() != null) {
            query += SearchUtil.addConstraint("o", "product.id", "=", stockVo.getProductVo().getId());
            query += SearchUtil.addConstraint("o", "product.reference", "LIKE", stockVo.getProductVo().getReference());
        }

        if (stockVo.getAdminVo() != null) {
            query += SearchUtil.addConstraint("o", "admin.id", "=", stockVo.getAdminVo().getId());
            query += SearchUtil.addConstraint("o", "admin.code", "LIKE", stockVo.getAdminVo().getCode());
        }

        return entityManager.createQuery(query).getResultList();
    }


}
