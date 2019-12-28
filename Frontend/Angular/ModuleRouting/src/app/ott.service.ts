import { Injectable } from '@angular/core';

import { OTTE } from './mock-otte';
import { Otto } from './otto';
import { Logger } from './logger.service';

@Injectable()
export class OttService{
    constructor(private logger: Logger) { }

    getList() { 
        this.logger.log('Getting heroes ...')
        return OTTE; 
    }
}