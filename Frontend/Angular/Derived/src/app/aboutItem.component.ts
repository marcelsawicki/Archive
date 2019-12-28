import { Component } from '@angular/core';

import '../assets/css/styles.css';

@Component({
  selector: 'aboutItem-app',
  template: `<h1> About Item! </h1>`
})
export class AboutItemComponent { 
  goBack(){
        console.log('Button is pushed.');
  };
      master: string = 'I am sending this prop to master component.';
}