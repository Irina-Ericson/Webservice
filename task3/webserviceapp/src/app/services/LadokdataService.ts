import {Ladokdata} from 'src/assets/models/Ladokdata';
import {Injectable} from '@angular/core';
import { HttpClient,HttpClientModule , HttpRequest, HttpEvent, HttpParams} from '@angular/common/http';

import {environment} from 'src/environments/environment';
import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule,Validators } from '@angular/forms';



@Injectable({
  providedIn: 'root'})
export class LadokdataService{
ladokdata!: Ladokdata[];

//private apiServerUrl=environment.apiBaseUrl;
private apiServerUrl = environment.apiBaseUrl;
public dataForm!:  FormGroup;
host:string = "http://localhost:8080";

constructor (private http: HttpClient){}


updateLadokdata(id: any, data: any): Observable<any> {
      return this.http.put(`${this.apiServerUrl}/ladokdata/saveLadokdata/${id}`, data);
    }

}
