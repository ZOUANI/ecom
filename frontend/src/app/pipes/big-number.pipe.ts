import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'bigNumber'
})
export class BigNumberPipe implements PipeTransform {

  transform(value: number, ...args: any[]): any {
    if (value === undefined) {
      return null;
    }

    if (value >= 1000000000) {
      return (value / 1000000000).toFixed(2) + 'B';
    }

    if (value >= 1000000) {
      return (value / 1000000).toFixed(2) + 'M';
    }

    if (value >= 1000) {
      return (value / 1000).toFixed(2) + 'K';
    }

    return value;
  }

}