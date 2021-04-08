import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AuthModule } from '@auth0/auth0-angular';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RecipeDetailComponent } from './recipe-detail/recipe-detail.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { RecipeListComponent } from './recipe-list/recipe-list.component';
import {AuthButtonComponent} from './auth-button/auth-button.component';

@NgModule({
  declarations: [
    AppComponent,
    RecipeDetailComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    RecipeListComponent,
    AuthButtonComponent
  ],
  imports: [
    AuthModule.forRoot({
      domain: 'dev-e3z97o61.us.auth0.com',
      clientId: 'NBbIhcOr4R4dOV8mRcHBBtR8DHPCYtVz'
    }),
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
