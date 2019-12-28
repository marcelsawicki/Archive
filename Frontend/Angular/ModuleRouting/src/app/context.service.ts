import { Injectable } from '@angular/core'

@Injectable()
export class ContextService {
     abcd : number = 12345;
    getList(){
        return this.abcd;
    }
}