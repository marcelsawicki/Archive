import { NgModule } from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { AppRoutingModules } from './app-routing.module';
import { RouterModule, Routes }   from '@angular/router'; // routing
import { FormsModule }   from '@angular/forms'; // <-- NgModel lives here

import { PageNotFoundComponent } from './not.component';
import { AppComponent } from './app.component';
import { ExampleComponent } from './example.component';
import { InputComponent } from './input.component';
import { InjectionComponent } from './injection.component';
import { HeroesComponent } from './heroes.component';
import { HeroDetailComponent } from './hero-detail.component';
import { HeroService } from './hero.service';
import { OttComponent } from './ott.component';
import { OttListComponent } from './ott-list.component';
import { HadesComponent } from './poc-routing/hades.component';
import { OttService } from './ott.service';
import { Logger } from './logger.service';

import { ArtoisComponent } from './poc-routing/artois.component';
import { HedgesComponent } from './poc-routing/hedges.component';
import { TokeComponent } from './poc-routing/toke.component';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule, // <-- import the FormsModule before binding with [(ngModel)]
    AppRoutingModules
  ],
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    ExampleComponent,
    InputComponent,
    InjectionComponent,
    HeroesComponent,
    HeroDetailComponent,
    OttComponent,
    OttListComponent,
    HadesComponent,
    ArtoisComponent,
    HedgesComponent,
    TokeComponent
  ],
  providers: [
    HeroService,
    OttService,
    Logger
  ],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
