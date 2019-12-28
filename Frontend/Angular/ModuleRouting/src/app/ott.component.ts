import { Component } from '@angular/core';
import { OttService } from './ott.service';

@Component({
    selector: 'ott',
    providers: [OttService],
    templateUrl: './ott.component.html'
})

export class OttComponent {}