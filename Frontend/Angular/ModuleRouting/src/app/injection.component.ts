import { Component } from '@angular/core';
import { ContextService } from './context.service'

import '../assets/css/styles.css';

@Component({
  selector: 'not-app',
  template: `<h1> Dependecy Injection! mojaZmienna: {{mojaZmienna}}</h1> `,
  providers: [ContextService]
})

export class InjectionComponent {
    constructor(private contextService: ContextService) {
      console.log('Serwis wstrzykuje zmienna: ' +this.mojaZmienna);
    }
    mojaZmienna: number = this.contextService.getList();
    
 }