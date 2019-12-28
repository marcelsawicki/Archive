import { NgModule } from '@angular/core';
import { BrowserModule }  from '@angular/platform-browser';
import { AppRoutingModules } from './app-routing.module';
import { RouterModule, Routes }   from '@angular/router'; // routing
import { FormsModule }   from '@angular/forms'; // <-- NgModel lives here

import { PageNotFoundComponent } from './not.component';
import { AppComponent } from './app.component';
import { ExampleComponent } from './example.component';
import { AboutComponent } from './about.component';
import { AboutItemComponent } from './aboutItem.component';

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
    AboutComponent,
    AboutItemComponent
  ],
  providers: [],
  bootstrap: [ AppComponent ]
})
export class AppModule { }
