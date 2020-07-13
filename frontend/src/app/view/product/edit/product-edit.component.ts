import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../controller/service/Product.service';
import {ProductVo} from '../../../controller/model/product.model';
import {OrderLineVo} from '../../../controller/model/OrderLine.model';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  constructor(private productService: ProductService) { }

   ngOnInit(): void {
    }

   get product(): ProductVo {
    return this.productService.product;
  }

   get editableProducts(): Array<ProductVo> {
    return this.productService.editableProducts;
   }

   set editableProducts(value: Array<ProductVo>) {
    this.productService.editableProducts = value;
   }


  get orderLine(): OrderLineVo {
    return this.productService.orderLine;
  }

  addOrderLine() {
   return this.productService.addOrderLine();
  }

  removeOrderLine(i: number) {
   this.productService.removeOrderLine(i);
  }
   editProduct() {
    this.productService.editProduct();
  }

     findByreference(ref: string) {
      this.productService.findByreference(ref);
     }


}