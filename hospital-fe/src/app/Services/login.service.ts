import { Injectable } from '@angular/core';
const USER_KEY:string = '';
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private username = ''

  constructor() { }
  signOut(): void {
    window.sessionStorage.clear();
    window.sessionStorage.removeItem(USER_KEY);
  }
  public isLoggedIn():boolean{
    return !!window.sessionStorage.getItem(USER_KEY);
  }
  public saveToken(token: string): void {
    console.log(token)
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, token);
  }
  public getToken(): string | null {
    return window.sessionStorage.getItem(USER_KEY);
  }
}
