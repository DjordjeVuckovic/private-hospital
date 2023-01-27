import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {BloodContract} from "../Model/BloodContract";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class BloodContractService {
  apiHost: string = 'localhost:5432/privateHospital/api/v1/blood-contract';
  headers: HttpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private readonly httpClient: HttpClient) {
  }
  createRequest(request:BloodContract): Observable<BloodContract> {
    return this.httpClient.post<BloodContract>(this.apiHost,request,{headers: this.headers});
  }
}