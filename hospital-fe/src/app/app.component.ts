import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {LoginService} from "./Services/login.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(private rt:Router,private loginService:LoginService) {
  }
  signOut() {
    this.loginService.signOut()
    this.rt.navigate([''])
  }
}
