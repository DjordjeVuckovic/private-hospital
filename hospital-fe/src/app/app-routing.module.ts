import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from "./modules/pages/home/home.component";
import {WindowComponent} from "./View/window/window.component";
import {OffersComponent} from "./View/offers/offers.component";
import {LoginComponent} from "./View/login/login.component";
import {LoginGuard} from "./guards/login.guard";

const routes: Routes = [
  { path: 'home', component: HomeComponent,canActivate:[LoginGuard]},
  {path:'contract',component: WindowComponent,canActivate:[LoginGuard]},
  {path:'offers',component: OffersComponent,canActivate:[LoginGuard]},
  {path:'',component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
