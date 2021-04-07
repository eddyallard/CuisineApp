import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RecipeDetailComponent } from './recipe-detail/recipe-detail.component';
import { RecipeListComponent } from './recipe-list/recipe-list.component';

const routes: Routes = [];

@NgModule({
  imports: [
    RouterModule.forRoot(
    [{path: '', redirectTo: '/home', pathMatch: 'full'},
      {path: 'home', component: HomeComponent},
     {path: 'recipes/all', component: RecipeListComponent},
     {path: 'login', component : LoginComponent}
  ]
  )],
  exports: [RouterModule]
})
export class AppRoutingModule {}
