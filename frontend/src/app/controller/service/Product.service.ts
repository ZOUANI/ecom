import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ProductVo} from '../model/product.model';
import {OrderLineVo} from '../model/OrderLine.model';
import {map} from 'rxjs/operators';
import {environment} from '../../../environments/environment';
import {DeliveryVo} from '../model/delivery-vo';
import {DeliveryStats} from '../model/delivery-stats';

@Injectable({
    providedIn: 'root'
})
export class ProductService {

    constructor(private http: HttpClient) {
    }

    private _productDetail: ProductVo = new ProductVo();
    private _productListe: Array<ProductVo> = new Array<ProductVo>();

    private _productSearch: ProductVo = new ProductVo();
    private _product: ProductVo = new ProductVo();
    private _searchedProducts: Array<ProductVo> = new Array<ProductVo>();
    private _editableProducts: Array<ProductVo> = new Array<ProductVo>();
    private _orderLine: OrderLineVo;

    get orderLine(): OrderLineVo {
        if (this._orderLine == null) {
            this._orderLine = new OrderLineVo();
        }
        return this._orderLine;
    }

    set orderLine(value: OrderLineVo) {
        this._orderLine = value;
    }

    get product(): ProductVo {
        if (this._product == null) {
            this._product = new ProductVo();
        }
        return this._product;
    }

    set product(value: ProductVo) {
        this._product = value;
    }

    get productListe(): Array<ProductVo> {
        return this._productListe;
    }

    set productListe(value: Array<ProductVo>) {
        this._productListe = value;
    }

    get productDetail(): ProductVo {
        return this._productDetail;
    }

    set productDetail(value: ProductVo) {
        this._productDetail = value;
    }

    get productSearch(): ProductVo {
        return this._productSearch;
    }

    set productSearch(value: ProductVo) {
        this._productSearch = value;
    }

    get productShowDetail(): boolean {
        return this._productShowDetail;
    }

    set productShowDetail(value: boolean) {
        this._productShowDetail = value;
    }

    get editableProducts(): Array<ProductVo> {
        return this._editableProducts;
    }

    set editableProducts(value: Array<ProductVo>) {
        this._editableProducts = value;
    }

    public findAll() {
        this.http.get<Array<ProductVo>>('http://localhost:8036/generated/product/').subscribe(
            value => {
                if (value != null) {
                    this.productListe = value;
                    this.editableProducts = value;

                }
            }
        );
    }

    public saveProduct() {
        this.http.post('http://localhost:8036/generated/product/', this.product).subscribe();
        this.product.orderLinesVo.length = 0;
    }

    public editProduct() {
        this.http.put('http://localhost:8036/generated/product/', this.product).subscribe();
        this.product.orderLinesVo.length = 0;
    }

    public addOrderLine() {
        this.product.orderLinesVo.push(this.cloneOrderLine(this.orderLine));
    }

    public cloneOrderLine(orderLine: OrderLineVo) {
        const myOrderLineClone = new OrderLineVo();
        myOrderLineClone.price = orderLine.price;
        myOrderLineClone.id = orderLine.id;
        myOrderLineClone.commandVo.reference = orderLine.commandVo.reference;
        7;
        myOrderLineClone.productVo.reference = orderLine.productVo.reference;
        7;
        return myOrderLineClone;
    }

    public removeOrderLine(i: number) {
        this.product.orderLinesVo.splice(i, 1);
    }

    public findProduct(pojo: ProductVo) {
        this.http.post<Array<ProductVo>>('http://localhost:8036/generated/product/search/', pojo).subscribe(
            value => {
                this.productListe = value;
            });
    }

    public detailShow(pojo: ProductVo) {
        this.http.get<ProductVo>('http://localhost:8036/generated/product/reference/' + pojo.reference).subscribe(
            value => {
                if (value != null) {
                    this.productDetail = value;
                    this.productShowDetail = true;
                }
            });
    }


    delete(pojo: ProductVo) {
        this.http.delete<ProductVo>('http://localhost:8036/generated/product/id/' + pojo.id).subscribe(
            value => {
                var index = this.productListe.indexOf(pojo);
                if (index > -1) {
                    this.productListe.splice(index, 1);
                }
            }
        );


    }


    public findByreference(ref: string) {
        this.http.get<ProductVo>('http://localhost:8036/generated/product/reference/' + ref).subscribe(
            value => {
                if (value != null) {
                    this.product = value;
                }
            }
        );
    }


    /***********************************************************************************************/
    private _productShowDetail: boolean;

    public detailHide() {

        this.productShowDetail = false;
        this.productDetail = null;
    }

    getProducts(): Promise<any[]> {
        const data: any[] = [];
        for (let index = 0; index < 20; index++) {
            data.push({
                id: index + '',
                label: 'label' + index,
                totalOrders: 1000 + Number.parseInt((Math.random() * 2000).toFixed(0)),
                confirmed: 300 + Number.parseInt((Math.random() * 2000).valueOf().toFixed(0)),
                delivered: 600 + Number.parseInt((Math.random() * 2000).valueOf().toFixed(0)),
                return: 100 + Number.parseInt((Math.random() * 2000).valueOf().toFixed(0))
            });
        }
        return new Promise((resolve, reject) => {
            resolve(data), reject([]);
        });
    }

    getDeliveries(): Promise<any[]> {
        const data: any[] = [];
        for (let index = 0; index < 20; index++) {
            data.push({
                id: index,
                name: 'name' + index,
                totalOrders: 1000 + Number.parseInt((Math.random() * 2000).toFixed(0)),
                delivered: 600 + Number.parseInt((Math.random() * 2000).valueOf().toFixed(0)),
                return: 100 + Number.parseInt((Math.random() * 2000).valueOf().toFixed(0)),
                deliveredPeriod: 50 + Number.parseInt((Math.random() * 2000).valueOf().toFixed(0))
            });
        }
        return new Promise((resolve) => {
            resolve(data);
        });
    }

    getDeliveryStats(): Promise<DeliveryStats[]> {
        const data: DeliveryStats[] = [];
        for (let index = 0; index < 20; index++) {
            data.push({
                id: index,
                name: 'name' + index,
                paid: 1000 + Number.parseInt((Math.random() * 2000).toFixed(0)),
                processed: 600 + Number.parseInt((Math.random() * 2000).valueOf().toFixed(0)),
                closed: 100 + Number.parseInt((Math.random() * 2000).valueOf().toFixed(0)),
                return: 90 + Number.parseInt((Math.random() * 2000).valueOf().toFixed(0))
            });
        }
        return new Promise((resolve, reject) => {
            resolve(data), reject([]);
        });
    }

    getTopProducts(startDate: string, endDate: string) {
        return this.http.get<any[]>(`${environment.apiUrl}product/top5/startDate/${startDate}/endDate/${endDate}/`).pipe(
            map((productVos: any[]) =>
                productVos.map((productVo) =>
                    ({label: productVo.label, units: productVo.units, sales: productVo.sales, price: productVo.pricee})
                )
            ));
    }
}
