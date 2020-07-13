package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.CategoryProduct; 
import ma.zs.generated.ws.rest.provided.vo.CategoryProductVo;

@Component 
public class CategoryProductConverter extends AbstractConverter<CategoryProduct,CategoryProductVo>{ 
	
	   @Autowired
         private CategoryConverter categoryConverter ;
	   @Autowired
         private ProductConverter productConverter ;
    private Boolean category;
    private Boolean product;

	public  CategoryProductConverter(){
		init(true);
	}

	@Override 
 	public CategoryProduct toItem(CategoryProductVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	CategoryProduct item = new CategoryProduct();
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));
             if(vo.getCategoryVo()!=null && this.category)
			     item.setCategory(categoryConverter.toItem(vo.getCategoryVo())) ;
             if(vo.getProductVo()!=null && this.product)
			     item.setProduct(productConverter.toItem(vo.getProductVo())) ;


		return item;
 		}
 	}

 	 @Override 
 	public CategoryProductVo toVo(CategoryProduct item) {
 		if (item == null) {
    		return null;
      	} else {
			CategoryProductVo vo = new CategoryProductVo();

			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));
            if(item.getCategory()!=null && this.category) {
				   vo.setCategoryVo(categoryConverter.toVo(item.getCategory())) ;
			   } 
            if(item.getProduct()!=null && this.product) {
				   vo.setProductVo(productConverter.toVo(item.getProduct())) ;
			   } 

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
       category = value;
       product = value;
	}


	

	
	   public CategoryConverter getCategoryConverter(){
		return this.categoryConverter;
	}  
        public void setCategoryConverter(CategoryConverter categoryConverter ){
		 this.categoryConverter = categoryConverter;
	}  
	   public ProductConverter getProductConverter(){
		return this.productConverter;
	}  
        public void setProductConverter(ProductConverter productConverter ){
		 this.productConverter = productConverter;
	}  
	
	 public boolean  isCategory(){
		  return this.category;
	 }
	 public void  setCategory(boolean category){
		   this.category = category;
	 }
	 public boolean  isProduct(){
		  return this.product;
	 }
	 public void  setProduct(boolean product){
		   this.product = product;
	 }
}