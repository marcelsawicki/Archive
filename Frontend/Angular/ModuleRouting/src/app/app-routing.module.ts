import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './not.component';
import { ExampleComponent } from './example.component';
import { InjectionComponent } from './injection.component';
import { HeroesComponent } from './heroes.component';
import { OttComponent } from './ott.component';
import { HadesComponent } from './poc-routing/hades.component';
import { ArtoisComponent } from './poc-routing/artois.component';
import { HedgesComponent } from './poc-routing/hedges.component';
import { TokeComponent } from './poc-routing/toke.component';

const appRoutes: Routes = [
    { path: 'app', component: AppComponent },
    { path: 'not', component: PageNotFoundComponent },
    { path: 'exp', component: ExampleComponent },
    { path: 'inj', component: InjectionComponent },
    { path: 'her', component: HeroesComponent },
    { path: 'ott', component: OttComponent },
    { path: 'hades', component: HadesComponent, children:[{path: 'artois', component: ArtoisComponent},{ path: 'hedges', component: HedgesComponent },{path: 'toke', component: TokeComponent}] },
    { path: '', redirectTo: '/exp', pathMatch: 'full' },
    { path: '**', component: PageNotFoundComponent }
];

@NgModule({
    imports: [
        RouterModule.forRoot(appRoutes)
    ],
    exports: [
        RouterModule
    ]
})

export class AppRoutingModules {}