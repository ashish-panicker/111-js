import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { WelcomeComponent } from './shared/welcome/welcome.component';
import { HeaderComponent } from './shared/header/header.component';
import { CardComponent } from './shared/card/card.component';
import { LoginComponent } from './auth/login/login.component';
import { RegisterComponent } from './auth/register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LandingComponent } from './shared/landing/landing.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { PasswordStrengthDirective } from './shared/directives/password-strength.directive';
import { DashboardComponent } from './shared/dashboard/dashboard.component';
import { NavbarComponent } from './shared/navbar/navbar.component';
import { CoursesListComponent } from './shared/courses-list/courses-list.component';
import { CoursesNewComponent } from './shared/courses-new/courses-new.component';
import { LibWelcomeModule } from '@ashishspanicker/lib-welcome';
import { HeaderModule } from '@ashishspanicker/header';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeComponent,
    HeaderComponent,
    CardComponent,
    LoginComponent,
    RegisterComponent,
    LandingComponent,
    PasswordStrengthDirective,
    DashboardComponent,
    NavbarComponent,
    CoursesListComponent,
    CoursesNewComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule, // <-- import FormsModule before binding with [(ngModel)]
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    LibWelcomeModule,
    HeaderModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  // schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule {}
