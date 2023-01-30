import {Component, Input, OnInit} from '@angular/core';
import {BloodContract} from "../../Model/BloodContract";

@Component({
  selector: 'app-contract-card',
  templateUrl: './contract-card.component.html',
  styleUrls: ['./contract-card.component.css']
})
export class ContractCardComponent implements OnInit {
  @Input() bloodContract: BloodContract = new BloodContract();
  constructor() { }

  ngOnInit(): void {
  }

}
