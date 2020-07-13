package ma.zs.generated.service.facade;

import java.util.List;
import ma.zs.generated.bean.Stock;
import ma.zs.generated.ws.rest.provided.vo.StockVo;

public interface StockService {

    /**

     * find all Stock in database
     * @return List<Stock> , If database is empty return  null.
     */
    List<Stock> findAll();


    /**
     * find Stock from database by id (id)
     * @param id - id of Stock
     * @return the founded  Stock , If no Stock were
     *         found in database return  null.
     */
    Stock findById(Long id);

    /**
     * delete Stock from database
     * @param id - id of Stock to be deleted
     *
     */
    void deleteById(Long id);

    List<Stock> findByCityName(String name);
    int deleteByCityName(String name);

    List<Stock> findByCityId(Long id);
    int deleteByCityId(Long id);

    List<Stock> findByProductReference(String reference);
    int deleteByProductReference(String reference);

    List<Stock> findByProductId(Long id);
    int deleteByProductId(Long id);

    List<Stock> findByAdminCode(String code);
    int deleteByAdminCode(String code);

    List<Stock> findByAdminId(Long id);
    int deleteByAdminId(Long id);

    /**
     * save Stock in database
     * @param stock - Stock to be saved
     * @return the saved Stock, If the Stock can't be saved return null.
     */
    Stock save(Stock stock);

    /**
     * save list Stock in database
     * @param stocks - list of Stock to be saved
     * @return the saved Stock list
     */
    List<Stock> save(List<Stock> stocks);

    /**
     * update Stock in database
     * @param stock - Stock to be updated
     * @return the updated Stock, If the Stock can't be updated return null.
     */
    Stock update(Stock stock);

    /**
     * delete Stock from database
     * @param stock - Stock to be deleted
     * @return 1 if Stock deleted successfully, If the Stock can't be deleted return negative int
     */
    int delete(Stock stock);





    /**
     * search for Stock in by some criteria
     * @return the searhed list Stock
     */
    List<Stock> findByCriteria( StockVo stockVo);
}