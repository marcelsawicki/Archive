import { Component } from '@angular/core';

import '../assets/css/styles.css';

@Component({
  selector: 'example-app',
  template: `<h1> Example! </h1>`
})
export class ExampleComponent { 
  goBack(){
        console.log('Button is pushed.');
  };
      master: string = 'I am sending this prop to master component.';
}