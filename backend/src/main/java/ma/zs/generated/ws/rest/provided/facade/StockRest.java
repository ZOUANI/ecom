package  ma.zs.generated.ws.rest.provided.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.zs.generated.bean.Stock;
import ma.zs.generated.service.facade.StockService;
import ma.zs.generated.ws.rest.provided.converter.StockConverter;
import ma.zs.generated.ws.rest.provided.vo.StockVo;

@Api("Manages stock services")
@RestController
@RequestMapping("generated/stock")
public class StockRest {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockConverter stockConverter ;

    @ApiOperation("Saves the specified stock")
    @PostMapping("/")
    public StockVo save(@RequestBody StockVo stockVo){
        Stock stock= stockConverter.toItem(stockVo);
        stock=	stockService.save(stock);
        return stockConverter.toVo(stock);
    }

    @ApiOperation("Delete the specified stock")
    @DeleteMapping("/")
    public int delete(@RequestBody StockVo stockVo){
        Stock stock = stockConverter.toItem(stockVo);
        return stockService.delete(stock);
    }

    @ApiOperation("Updates the specified stock")
    @PutMapping("/")
    public StockVo update(@RequestBody StockVo stockVo){
        Stock stock= stockConverter.toItem(stockVo);
        stock=	stockService.update(stock);
        return stockConverter.toVo(stock);
    }

    @ApiOperation("Finds a list of all stocks")
    @GetMapping("/")
    public List<StockVo> findAll(){
        return stockConverter.toVo(stockService.findAll());
    }

    @ApiOperation("Finds a stock by id")
    @GetMapping("/id/{id}")
    public StockVo findById(@PathVariable Long id){
        return  stockConverter.toVo(stockService.findById(id));
    }
    @ApiOperation("Deletes a stock by id")
    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id){
        stockService.deleteById(id);
    }



    @ApiOperation("Finds a stock by name of city")
    @GetMapping("/city/name/{name}")
    public List<StockVo> findByCityName(@PathVariable String name){
        return stockConverter.toVo(stockService.findByCityName(name));
    }

    @ApiOperation("Deletes a stock by name of city")
    @DeleteMapping("/city/name/{name}")
    public int deleteByCityName(@PathVariable String name){
        return stockService.deleteByCityName(name);
    }

    @ApiOperation("Finds stock by id of city")
    @GetMapping("/city/id/{id}")
    public List<StockVo> findByCityId(@PathVariable Long id){
        return stockConverter.toVo(stockService.findByCityId(id));
    }
    @ApiOperation("Deletes stock by id of city")
    @DeleteMapping("/city/id/{id}")
    public int deleteByCityId(@PathVariable Long id){
        return stockService.deleteByCityId(id);
    }

    @ApiOperation("Finds a stock by reference of product")
    @GetMapping("/product/reference/{reference}")
    public List<StockVo> findByProductReference(@PathVariable String reference){
        return stockConverter.toVo(stockService.findByProductReference(reference));
    }

    @ApiOperation("Deletes a stock by reference of product")
    @DeleteMapping("/product/reference/{reference}")
    public int deleteByProductReference(@PathVariable String reference){
        return stockService.deleteByProductReference(reference);
    }

    @ApiOperation("Finds stock by id of product")
    @GetMapping("/product/id/{id}")
    public List<StockVo> findByProductId(@PathVariable Long id){
        return stockConverter.toVo(stockService.findByProductId(id));
    }
    @ApiOperation("Deletes stock by id of product")
    @DeleteMapping("/product/id/{id}")
    public int deleteByProductId(@PathVariable Long id){
        return stockService.deleteByProductId(id);
    }

    @ApiOperation("Finds a stock by code of admin")
    @GetMapping("/admin/code/{code}")
    public List<StockVo> findByAdminCode(@PathVariable String code){
        return stockConverter.toVo(stockService.findByAdminCode(code));
    }

    @ApiOperation("Deletes a stock by code of admin")
    @DeleteMapping("/admin/code/{code}")
    public int deleteByAdminCode(@PathVariable String code){
        return stockService.deleteByAdminCode(code);
    }

    @ApiOperation("Finds stock by id of admin")
    @GetMapping("/admin/id/{id}")
    public List<StockVo> findByAdminId(@PathVariable Long id){
        return stockConverter.toVo(stockService.findByAdminId(id));
    }
    @ApiOperation("Deletes stock by id of admin")
    @DeleteMapping("/admin/id/{id}")
    public int deleteByAdminId(@PathVariable Long id){
        return stockService.deleteByAdminId(id);
    }


    @ApiOperation("Search stock by a specific criterion")
    @PostMapping("/search")
    public List<StockVo> findByCriteria(@RequestBody StockVo stockVo){
        return stockConverter.toVo(stockService.findByCriteria(stockVo));
    }
    public StockConverter getStockConverter(){
        return stockConverter;
    }

    public void setStockConverter(StockConverter stockConverter){
        this.stockConverter=stockConverter;
    }

    public StockService getStockService(){
        return stockService;
    }
    public void setStockService( StockService stockService){
        this.stockService=stockService;
    }


}