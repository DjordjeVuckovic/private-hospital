import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { MaterialModule } from "./material/material.module";
import { HospitalModule } from "./modules/hospital/hospital.module";
import { PagesModule } from "./modules/pages/pages.module";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTabsModule} from "@angular/material/tabs";
import {MatStepperModule} from "@angular/material/stepper";
import {MatSelectModule} from "@angular/material/select";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from '@angular/material/core';
import {MatExpansionModule} from "@angular/material/expansion";
import { ContractCardComponent } from './components/contract-card/contract-card.component';
import {WindowComponent} from "./View/window/window.component";
import {MatToolbarModule} from "@angular/material/toolbar";
import { OffersComponent } from './View/offers/offers.component';
import { LoginComponent } from './View/login/login.component';
import {MatDividerModule} from "@angular/material/divider";
import {NgToastModule} from "ng-angular-popup";

@NgModule({
  declarations: [
    AppComponent,
    ContractCardComponent,
    WindowComponent,
    OffersComponent,
    LoginComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        HttpClientModule,
        MaterialModule,
        PagesModule,
        HospitalModule,
        MatTabsModule,
        MatStepperModule,
        MatSelectModule,
        ReactiveFormsModule,
        MatDatepickerModule,
        MatNativeDateModule,
        FormsModule,
        MatExpansionModule,
        MatToolbarModule,
        MatDividerModule,
        NgToastModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
