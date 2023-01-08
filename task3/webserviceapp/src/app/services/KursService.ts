import {Kurs} from 'src/assets/models/Kurs';
import {Injectable} from '@angular/core';
import { HttpClient,HttpClientModule , HttpRequest, HttpEvent} from '@angular/common/http';

import {environment} from 'src/environments/environment';
import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule,Validators } from '@angular/forms';




@Injectable({
  providedIn: 'root'})
export class KursService{
kurser!: Kurs[];

//private apiServerUrl=environment.apiBaseUrl;
private apiServerUrl = environment.apiBaseUrl;
public dataForm!:  FormGroup;
host:string = "http://localhost:8080";

constructor (private http: HttpClient){}

 public getKurser(): Observable<Kurs[]>{
    return this.http.get<Kurs[]>(`${this.apiServerUrl}/kurs/kurs`); /**OK, getAll**/
}

 get(id:any): Observable<Kurs> {
    return this.http.get<Kurs>(`${this.apiServerUrl}/kurs/kurs/${id}`);           /**OK**/
  }

public findKursByKurskod(kursnamn:string): Observable<any>{
  return this.http.get(`${this.apiServerUrl}/kurs/myKurs/${kursnamn}`);
}

list(): Observable<any> {
    return this.http.get(this.apiServerUrl);
  }
  create(data: any): Observable<any> {          /**OK**/
    return this.http.post(this.apiServerUrl, data);
  }

  update(id: any, data: any): Observable<any> {
      return this.http.put(`${this.apiServerUrl}/picture/update/${id}`, data);
    }
  delete(id: any): Observable<any> {
    return this.http.delete(`${this.apiServerUrl}/picture/delete/${id}`);
  }

  public deleteAll(): Observable<any> {
    return this.http.delete(this.apiServerUrl);
  }


  createData(formData: FormData): Observable<any> {
    return this.http.post(`${this.apiServerUrl}/picture/add`, formData);
  }


     getAll(): Observable<any> {

       return this.http.get(`${this.apiServerUrl}/kurs`);
     }

       getData(id: number): Observable<Object> {
         return this.http.get(`${this.apiServerUrl}/picture/${id}`);
       }




}


