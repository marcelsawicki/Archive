import { Component } from '@angular/core';

import '../assets/css/styles.css';

@Component({
  selector: 'about-app',
  template: `<h1> About! </h1>`
})
export class AboutComponent { 
  goBack(){
        console.log('Button is pushed.');
  };
      master: string = 'I am sending this prop to master component.';
}