import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddbookComponent } from './addbook/addbook.component';
import { AllbookComponent } from './allbook/allbook.component';
import { Routes, RouterModule } from '@angular/router';
import { BookService } from './service/book.service';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";


const routes: Routes = [
  {path:'allbook', component: AllbookComponent},
  {path: 'addbook', component: AddbookComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    AddbookComponent,
    AllbookComponent       
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
