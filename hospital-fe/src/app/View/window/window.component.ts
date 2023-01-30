import { Component, OnInit } from '@angular/core';
import {FormControl} from "@angular/forms";
import {BloodUnit} from "../../Model/BloodUnit";
import {BloodContract} from "../../Model/BloodContract";
import {BloodType} from "../../Model/BloodType";
import {BloodContractService} from "../../Services/bloodContract.service";
import {NgToastService} from "ng-angular-popup";
import {LoginService} from "../../Services/login.service";

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
  currentContract:BloodContract = new BloodContract();

  constructor( private bloodContractService:BloodContractService,private alert: NgToastService,private loginService:LoginService ) { }

  submit() {
    const bloodContract: BloodContract = new BloodContract();
    bloodContract.bloodUnits = this.bloodUnits
    bloodContract.deliveryDate = this.transportDate;
    bloodContract.hospitalName = this.loginService.getToken()!
    console.log(bloodContract)
    this.bloodContractService.createRequest(bloodContract).subscribe({
      next:res=>{
        this.alert.success({detail: 'Success!', summary: "You have made a blood contract request.", duration: 5000})
      },
      error:err=>{
        this.alert.error({detail: 'Error!', summary: err, duration: 5000})
      }
    })
  }

  hasValues() {
    // if(this.bloodTypes.value){
    //   // @ts-ignore
    //   if(this.bloodTypes.value.){
    //     return false
    //   }
    //
    // }
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

  convertBloodType
  (num:string,type: string|undefined) {
    console.log(type)
    const bloodUnit = new BloodUnit();
    // @ts-ignore
    let typeConvert = this.setVloodType(type)
    console.log(typeConvert)
    let same = false;
    this.bloodUnits.forEach(value => {
      console.log(value.bloodType)
      if(value.bloodType == typeConvert){
        value.bloodAmount = Number(num)
        same = true
      }
    })
    if(same){
      return
    }
    bloodUnit.bloodType = typeConvert
    bloodUnit.bloodAmount= Number(num)
    this.bloodUnits.push(bloodUnit)
    console.log(this.bloodUnits)
  }

  ngOnInit(): void {
    this.bloodContractService.getCurrentContract(this.loginService.getToken()!).subscribe({
      next: res=>{
        this.currentContract = res;
        console.log(this.currentContract)
      },
      error: err =>{
        this.alert.warning({detail: 'Error!', summary: "No contact provided!", duration: 5000})
     }
    })
  }

}
