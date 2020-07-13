import {OrderLineVo} from './OrderLine.model';

export class ProductVo {
    public size: string;
    public qteStock: string;
    public label: string;
    public price: string;
    public weight: string;
    public reference: string;
    public id: string;
    public color: string;
    public qteStockMax: string;
    public qteStockMin: string;
    public priceMax: string;
    public priceMin: string;
    public weightMax: string;
    public weightMin: string;
    public orderLinesVo: Array<OrderLineVo> = new Array<OrderLineVo>();
    public totalOrders: number;
    public confirmed: number;
    public delivered: number;
    public return: number;
}
