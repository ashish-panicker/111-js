import { NgModule } from '@angular/core';
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
  ],
  imports: [
    BrowserModule,
    FormsModule, // <-- import FormsModule before binding with [(ngModel)]
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
