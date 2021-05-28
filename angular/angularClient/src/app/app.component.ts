import { Component } from '@angular/core';
import { AuthService } from './auth.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private auth : AuthService) {}

  user : string = "You need to login!";

  title = 'angularClient';
  authTag : Boolean = false;
  ngOnInit(): void {
    if (this.auth.isAuthenticated()){
      this.user = this.auth.getCurrentUserName();
    }
    }
    
}
