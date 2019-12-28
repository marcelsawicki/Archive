import { Component } from '@angular/core';

@Component({
    selector: 'hades',
    template: `
    <h1> Hades Component </h1>
    This is the main component. Here will be modul with another (child) routing.
    <nav>
     <a routerLink="/hades/artois"> artois </a>
     <a routerLink="/hades/hedges"> hedges </a>
     <a routerLink="/hades/toke"> toke </a>
   </nav>
    <router-outlet></router-outlet>
    `
})

export class HadesComponent {}