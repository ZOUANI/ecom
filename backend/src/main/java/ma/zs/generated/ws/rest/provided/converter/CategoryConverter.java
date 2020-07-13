package  ma.zs.generated.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.generated.service.util.*;

  
import ma.zs.generated.bean.Category; 
import ma.zs.generated.ws.rest.provided.vo.CategoryVo;

@Component 
public class CategoryConverter extends AbstractConverter<Category,CategoryVo>{ 
	

	public  CategoryConverter(){
		init(true);
	}

	@Override 
 	public Category toItem(CategoryVo vo) {
 	if (vo == null) {
   	 return null;
      } else {
      	Category item = new Category();
			 if(StringUtil.isNotEmpty(vo.getLabel()))
                  item.setLabel(vo.getLabel());
			 if(StringUtil.isNotEmpty(vo.getId()))
                  item.setId(NumberUtil.toLong(vo.getId()));


		return item;
 		}
 	}

 	 @Override 
 	public CategoryVo toVo(Category item) {
 		if (item == null) {
    		return null;
      	} else {
			CategoryVo vo = new CategoryVo();

			if(StringUtil.isNotEmpty(item.getLabel()))
				vo.setLabel(item.getLabel());
			
			 if(item.getId()!=null)
				vo.setId(NumberUtil.toString(item.getId()));

 			return vo;
 
 		}
 	}
	public void init(Boolean value) { 
	}


	

	
	
}