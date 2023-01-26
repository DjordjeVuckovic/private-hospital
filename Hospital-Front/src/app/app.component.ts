import { Component } from '@angular/core';
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'HospitalFront';
  typesList: string[] = ['A+', 'B+', 'AB+', 'A-', 'B-', 'AB-','0-','0+'];
  bloodTypes = new FormControl('');

  submit() {
    console.log(this.bloodTypes.value)
  }

  hasValues() {
    return this.bloodTypes.value;

  }
}
