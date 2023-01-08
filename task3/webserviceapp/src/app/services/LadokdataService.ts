import {Ladokdata} from 'src/assets/models/Ladokdata';
import {Injectable} from '@angular/core';
import { HttpClient,HttpClientModule , HttpRequest, HttpEvent, HttpParams} from '@angular/common/http';
import {CanvasdataResult} from 'src/assets/models/CanvasdataResult';
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


public updateLadokdata(id:any) {
     return this.http.put(`${this.apiServerUrl}/ladokdata/updateCanvasResult_2/${id}`, {});
    }

update_1(id: any, data: any): Observable<any> {
      return this.http.patch(`${this.apiServerUrl}/ladokdata/saveLadokdata_1/${id}`, data);
    }

update(id: any, resultat: any, registr_datum: any, status:any, information:any, canvasdataResult:any): Observable<any>  {
    let params = new HttpParams()
        .set('id', id)
        .set('resultat', resultat)
        .set('registr_datum', registr_datum)
        .set('status', status)
        .set('information', information);

        console.log(params.toString());
        console.log(registr_datum);

    return this.http.patch(`${this.apiServerUrl}/ladokdata/saveLadokdata/${id}/${resultat}/${registr_datum}/${status}/${information}`, canvasdataResult);
    }
}
