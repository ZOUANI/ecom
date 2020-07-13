package  ma.zs.generated.ws.rest.provided.vo;


public class CategoryProductVo {

     private String id ;
   

	private CategoryVo categoryVo ;
	private ProductVo productVo ;



 public CategoryProductVo(){
       super();
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }


     

      public CategoryVo getCategoryVo(){
          return this.categoryVo;
     }
       
     public void setCategoryVo(CategoryVo categoryVo){
          this.categoryVo = categoryVo;
     }
   
      public ProductVo getProductVo(){
          return this.productVo;
     }
       
     public void setProductVo(ProductVo productVo){
          this.productVo = productVo;
     }
   




}