import { Component } from '@angular/core';
import { Otto } from './otto';
import { OttService } from './ott.service';

@Component({
    selector: 'ott-list',
    template: `
<div> I am reciving mock-otte
 <div *ngFor="let ott of otte">
    {{ott.id}} - {{ott.name}}
  </div>
</div>
`
})

export class OttListComponent {
    otte: Otto[];
    constructor(ottService: OttService){
        this.otte = ottService.getList();
    }
}