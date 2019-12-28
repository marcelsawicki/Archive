import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ArtoisComponent } from './artois.component';
import { HedgesComponent } from './hedges.component';
import { TokeComponent } from './toke.component';

const hadesRoutes: Routes = [
    { path: 'artois', component: ArtoisComponent },
    { path: 'hedges', component: HedgesComponent },
    { path: 'toke', component: TokeComponent }
];


@NgModule({
    imports: [
        RouterModule.forChild(hadesRoutes)
    ],
    exports: [
        RouterModule
    ]

})

export class HadesModule {}