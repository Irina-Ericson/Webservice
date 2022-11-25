import {StudentIts} from 'src/assets/models/StudentIts';
import {Injectable} from '@angular/core';
import { HttpClient,HttpClientModule , HttpRequest, HttpEvent} from '@angular/common/http';

import {environment} from 'src/environments/environment';
import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';
import { FormBuilder, FormGroup, FormControl, ReactiveFormsModule,Validators } from '@angular/forms';




@Injectable({
  providedIn: 'root'})
export class StudentItsService{
studentIts!: StudentIts[];

//private apiServerUrl=environment.apiBaseUrl;
private apiServerUrl = environment.apiBaseUrl;
public dataForm!:  FormGroup;
host:string = "http://localhost:8080";

constructor (private http: HttpClient){}

 public getStudentIts(): Observable<StudentIts[]>{
    return this.http.get<StudentIts[]>(`${this.apiServerUrl}/studentITS/student`); /**OK, getAll**/
}

 get(id:any): Observable<StudentIts> {
    return this.http.get<StudentIts>(`${this.apiServerUrl}/studentITS/student/${id}`);           /**OK**/
  }

public findPnrByStudentID(studentID:string): Observable<any>{
  return this.http.get(`${this.apiServerUrl}/studentITS/myStudent/${studentID}`);
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


