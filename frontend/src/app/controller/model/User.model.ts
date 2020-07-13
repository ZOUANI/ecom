import {RoleVo} from './Role.model';
import {CityVo} from './City.model';
import {DeliveryTypeVo} from './DeliveryType.model';

export class UserVo {
    public password: string;
    public enabled: string;
    public phoneNumber: string;
    public lastName: string;
    public email: string;
    public created: string;
    public code: string;
    public firsttName: string;
    public id: string;
    public createdMax: string;
    public createdMin: string;
    private _superAdminVo: UserVo;
    public deliveryTypeVo: DeliveryTypeVo = new DeliveryTypeVo();
    public cityVo: CityVo = new CityVo();
    public authorityVo: RoleVo = new RoleVo();
    public commandProcessed: number;
    public commandsClosed: number;
    public commandsReturned: 0;
    public deliveryName: string;
    public firstName: string;
    public percentageClosed: number;
    public percentageReturned: number;
    public totalAmountCommand: number;
    public totalAmountCommandClosed: number;
    public totalCommandDelivered: number;

    get superAdminVo(): UserVo {
        if (this._superAdminVo == null) {
            this._superAdminVo = new UserVo();
        }
        return this._superAdminVo;
    }

    set superAdminVo(value: UserVo) {
        this._superAdminVo = value;
    }

}
