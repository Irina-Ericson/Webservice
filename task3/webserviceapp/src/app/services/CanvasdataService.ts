import {Canvasdata} from 'src/assets/models/Canvasdata';
import {Injectable} from '@angular/core';
import { HttpClient,HttpClientModule , HttpRequest, HttpEvent} from '@angular/common/http';

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

 get(id:any): Observable<Canvasdata> {
    return this.http.get<Canvasdata>(`${this.apiServerUrl}/canvasdata/canvasdata/${id}`);           /**OK**/
  }

public getCanvasdataByKurskod(kurskod:string): Observable<any>{
  return this.http.get(`${this.apiServerUrl}/canvasdata/myCanvasdata_2/${kurskod}`);
}

list(): Observable<any> {
    return this.http.get(this.apiServerUrl);
  }
  create(data: any): Observable<any> {          /**OK**/
    return this.http.post(this.apiServerUrl, data);
  }

  update(id: any, data: any): Observable<any> {
      return this.http.put(`${this.apiServerUrl}///${id}`, data);
    }
  delete(id: any): Observable<any> {
    return this.http.delete(`${this.apiServerUrl}///${id}`);
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

       getData(id: number): Observable<Object> {
         return this.http.get(`${this.apiServerUrl}/picture/${id}`);
       }




}


