import { Component, OnInit } from '@angular/core';
import {BloodContractService} from "../../Services/bloodContract.service";
import {Offer} from "../../Model/Offer";

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {
  offers:Offer[] = []
  constructor(private offerService:BloodContractService) { }

  ngOnInit(): void {
    this.offerService.getOffers().subscribe(value => {
      this.offers = value
      console.log(this.offers)
    })
  }

}
