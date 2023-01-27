import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BloodContract} from "../Model/BloodContract";
import {Observable} from "rxjs";
import {Offer} from "../Model/Offer";


@Injectable({
  providedIn: 'root'
})
export class BloodContractService {
  apiHost: string = 'http://localhost:8081/api/v1/blood-contract';
  apiHostOffers: string = 'http://localhost:8081/api/v1/offers';
  headers: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private readonly httpClient: HttpClient) {
  }
  createRequest(request:BloodContract): Observable<BloodContract> {
    return this.httpClient.post<BloodContract>(this.apiHost,request,{headers: this.headers});
  }
  getOffers(): Observable<Offer[]>{
    return this.httpClient.get<Offer[]>(this.apiHostOffers);
  }


  getCurrentContract(hospitalName:string): Observable<BloodContract> {
  return this.httpClient.get<BloodContract>(this.apiHost + '/' + hospitalName);
}
}
