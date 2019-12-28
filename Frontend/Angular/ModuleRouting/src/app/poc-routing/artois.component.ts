import { Component, Input } from '@angular/core';

@Component({
    selector: 'artois',
    template: `
    <h1> Artois Component  - child </h1>
    {{title}}
    `
})

export class ArtoisComponent {
    @Input() master: string;
    title: string = 'artois title';
    constructor(){
        //ArtoisComponent constructor
    }
}