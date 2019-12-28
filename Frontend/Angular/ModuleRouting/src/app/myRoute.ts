import { Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './not.component';
import { ExampleComponent } from './example.component';
import { InjectionComponent } from './injection.component';
import { HeroesComponent } from './heroes.component';
import { OttComponent } from './ott.component';

export const appRoutes: Routes = [
    { path: 'app', component: AppComponent },
    { path: 'not', component: PageNotFoundComponent },
    { path: 'exp', component: ExampleComponent },
    { path: 'inj', component: InjectionComponent },
    { path: 'her', component: HeroesComponent },
    { path: 'ott', component: OttComponent },
    { path: '', redirectTo: '/exp', pathMatch: 'full' },
    { path: '**', component: PageNotFoundComponent }
];