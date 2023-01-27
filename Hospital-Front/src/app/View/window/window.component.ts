import { Component, OnInit } from '@angular/core';
import {FormControl} from "@angular/forms";
import {BloodUnit} from "../../Model/BloodUnit";
import {BloodContract} from "../../Model/BloodContract";
import {BloodType} from "../../Model/BloodType";
import {BloodContractService} from "../../Services/bloodContract.service";
import {NgToastService} from "ng-angular-popup";

@Component({
  selector: 'app-window',
  templateUrl: './window.component.html',
  styleUrls: ['./window.component.css']
})
export class WindowComponent implements OnInit {

  typesList: string[] = ['A+', 'B+', 'AB+', 'A-', 'B-', 'AB-','0-','0+'];
  transportDate: Date | undefined;
  bloodTypes = new FormControl('');
  bloodUnits : BloodUnit[] = []

  constructor( private bloodContractService:BloodContractService,private alert: NgToastService) { }

  submit() {
    var bloodContract: BloodContract = new BloodContract();
    bloodContract.bloodUnits = this.bloodUnits
    bloodContract.deliveryDate = this.transportDate;
    console.log(bloodContract)
    this.bloodContractService.createRequest(bloodContract).subscribe({
      next:res=>{
        this.alert.success({detail: 'Sucsses!', summary: "You have made a blood contract request.", duration: 5000})
      },
      error:err=>{
        this.alert.error({detail: 'Error!', summary: err, duration: 5000})
      }
    })
  }

  hasValues() {
    return this.bloodTypes.value;

  }
  // @ts-ignore

  setVloodType(type: BloodUnit){
    if(type == 'A+'){
      return BloodType.A_POSITIVE;
    }
    if(type == 'A-'){
      return BloodType.A_NEGATIVE;
    }
    if(type == 'B-'){
      return BloodType.B_NEGATIVE;
    }
    if(type == 'B+'){
      return BloodType.B_POSITIVE;
    }
    if(type == 'B-'){
      return BloodType.B_NEGATIVE;
    }
    if(type == '0-'){
      return BloodType.O_NEGATIVE;
    }
    if(type == '0+'){
      return BloodType.O_POSITIVE;
    }
    if(type == 'AB-'){
      return BloodType.AB_NEGATIVE;
    }
    if(type == 'AB+'){
      return BloodType.AB_POSITIVE;
    }
  }

  blbla(num:string,type: string|undefined) {

    var bloodUnit = new BloodUnit();
    // @ts-ignore
    bloodUnit.bloodType = this.setVloodType(type)
    bloodUnit.bloodAmount= Number(num)

    this.bloodUnits.push(bloodUnit)
    console.log(this.bloodUnits)
  }

  ngOnInit(): void {
  }

}
