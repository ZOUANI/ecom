import {Component, OnInit} from '@angular/core';
import {ProductService} from '../../../controller/service/Product.service';
import {ProductVo} from '../../../controller/model/product.model';
import {OrderLineVo} from '../../../controller/model/OrderLine.model';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  constructor(private productService: ProductService) { }

   ngOnInit(): void {
    }

   get product(): ProductVo {
    return this.productService.product;
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
   saveProduct() {
    this.productService.saveProduct();
  }


}