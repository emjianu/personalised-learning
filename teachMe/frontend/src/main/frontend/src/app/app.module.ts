import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {Routes, RouterModule} from "@angular/router";
import {LessonComponent} from "../lesson/lesson.component";
import {HomeComponent} from "../home/home.component";
import {QuestionComponent} from "../question/question.component";
import {LoginComponent} from "../login/login.component";
import {RegisterComponent} from "../register/register.component";
import {SideMenuComponent} from "../sidemenu/sidemenu.component";





const appRoutes: Routes = [
  { path: 'lessons/:id', component: LessonComponent },
  { path: 'home', component: HomeComponent },
  { path: '', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'lessons/:id/test', component: QuestionComponent },
/*  { path: 'hero/:id',      component: HeroDetailComponent },
  {
    path: 'heroes',
    component: HeroListComponent,
    data: { title: 'Heroes List' }
  },
  { path: '',
    redirectTo: '/heroes',
    pathMatch: 'full'
  },
  { path: '**', component: PageNotFoundComponent }*/
];



@NgModule({
  declarations: [
    AppComponent, LessonComponent, HomeComponent, QuestionComponent, LoginComponent, RegisterComponent, SideMenuComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
