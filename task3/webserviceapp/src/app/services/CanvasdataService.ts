import {Canvasdata} from 'src/assets/models/Canvasdata';
import {CanvasdataResult} from 'src/assets/models/CanvasdataResult';
import {Injectable} from '@angular/core';
import { HttpClient,HttpClientModule , HttpRequest, HttpEvent, HttpParams} from '@angular/common/http';

import {environment} from 'src/environments/environment';
import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule,Validators } from '@angular/forms';





@Injectable({
  providedIn: 'root'})
export class CanvasdataService{
canvasdata!: Canvasdata[];

//private apiServerUrl=environment.apiBaseUrl;
private apiServerUrl = environment.apiBaseUrl;
public dataForm!:  FormGroup;
host:string = "http://localhost:8080";

constructor (private http: HttpClient){}

 public getCanvasdata(): Observable<Canvasdata[]>{
    return this.http.get<Canvasdata[]>(`${this.apiServerUrl}/canvasdata/canvasdata`); /**OK, getAll**/
}

 get(c_id:any): Observable<Canvasdata> {
    return this.http.get<Canvasdata>(`${this.apiServerUrl}/canvasdata/canvasdata/${c_id}`);           /**OK**/
}


public getCanvasdataByKurskod(kurskod:string): Observable<any>{
  return this.http.get(`${this.apiServerUrl}/canvasdata/myCanvasdata_2/${kurskod}`);
}

public getCanvasdataResult(kursnamn:any): Observable<any>{
  return this.http.get(`${this.apiServerUrl}/canvasdata/canvasdataResult/${kursnamn}`);
}

/**public getCanvasdataResultByUppgift(kursnamn:any, uppgift:any): Observable<any>{
  return this.http.get(`${this.apiServerUrl}/canvasdata/canvasdataResult_2/`);
}**/

public getCanvasdataResultByUppgift(): Observable<any>{
    const url='http://localhost:8080/canvasdata/canvasdataResult_2';
    let queryParams = new HttpParams()
    .set("kursnamn",1)
    .set("uppgift", 2);
 //   queryParams = queryParams.append("kursnamn",1);
//    queryParams = queryParams.append("uppgift",1);
    //queryParams=queryParams.set("kursnamn", "uppgift");

  return this.http.get<any>(url,{params:queryParams});
}

list(): Observable<any> {
    return this.http.get(this.apiServerUrl);
  }
  create(data: any): Observable<any> {          /**OK**/
    return this.http.post(this.apiServerUrl, data);
  }

  update(c_id: any, data: any): Observable<any> {
      return this.http.put(`${this.apiServerUrl}///${c_id}`, data);
    }
  delete(c_id: any): Observable<any> {
    return this.http.delete(`${this.apiServerUrl}///${c_id}`);
  }

  public deleteAll(): Observable<any> {
    return this.http.delete(this.apiServerUrl);
  }


  createData(formData: FormData): Observable<any> {
    return this.http.post(`${this.apiServerUrl}//`, formData);
  }


     getAll(): Observable<any> {

       return this.http.get(`${this.apiServerUrl}/kurs`);
     }

       getData(c_id: number): Observable<Object> {
         return this.http.get(`${this.apiServerUrl}/canvasdata/${c_id}`);
       }




}


