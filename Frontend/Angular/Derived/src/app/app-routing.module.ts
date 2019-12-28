import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './not.component';
import { ExampleComponent } from './example.component';
import { AboutComponent } from './about.component';
import { AboutItemComponent } from './aboutItem.component';

const appRoutes: Routes = [
    { path: 'app', component: AppComponent },
    { path: 'not', component: PageNotFoundComponent },
    { path: 'exp', component: ExampleComponent },
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