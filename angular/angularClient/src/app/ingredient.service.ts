import { Injectable } from '@angular/core';
import { element } from 'protractor';
import {Ingredient} from './interfaces/Ingredient'
import {INGREDIENTS} from './Mock/MockIngredient'
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
 
@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  private filtered : Ingredient[];
  private heroesUrl = 'http://localhost:8080/api/ingredient'; 

  getIngredient(): Ingredient[] {
    return INGREDIENTS;
  }

  getHttpIngredient(): Observable<Ingredient[]> {
    return this.http.get<Ingredient[]>(this.heroesUrl)
  }

  searchIngredientBySubStr(subStr : string) : Ingredient[]{
    this.filtered = []
    for (let item of INGREDIENTS) {
      if (item.IngredientName.includes(subStr)) {
          this.filtered.push(item)
      }
  }  
    return this.filtered;
  }

  constructor(private http: HttpClient) { }

  
}
