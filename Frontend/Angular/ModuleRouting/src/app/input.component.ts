import { Component, Input } from '@angular/core';

import '../assets/css/styles.css';

@Component({
  selector: 'input-app',
  template: `<p> Input component gain this string from child component! {{masterName}}</p>`
})
export class InputComponent { 
      @Input('master') masterName: string;
}