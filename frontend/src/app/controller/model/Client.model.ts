import {CommandVo} from './Command.model';
import {CityVo} from './City.model';

export class ClientVo {
    public phoneNumber: string;
    public lastName: string;
    public email: string;
    public firstName: string;
    public id: string;
    public cityVo: CityVo = new CityVo();
    public commandsVo: Array<CommandVo> = new Array<CommandVo>();
    public address: string;
    public totalCommands: number;
    public sales: number;
}
