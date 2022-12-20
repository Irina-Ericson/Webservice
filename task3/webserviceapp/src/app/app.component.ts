import { AfterViewInit, OnInit, Component, ViewChild, ElementRef, SimpleChanges, ChangeDetectorRef } from '@angular/core';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {Data, Router} from "@angular/router";
import {HttpClient, HttpClientModule, HttpErrorResponse} from "@angular/common/http";
import {KursService} from 'src/app/services/KursService';
import {CanvasdataService} from 'src/app/services/CanvasdataService';
import {LadokdataService} from 'src/app/services/LadokdataService';
import {StudentItsService} from 'src/app/services/StudentItsService';
import {Kurs} from 'src/assets/models/Kurs';
import {Canvasdata} from 'src/assets/models/Canvasdata';
import {CanvasdataResult} from 'src/assets/models/CanvasdataResult';
import {StudentIts} from 'src/assets/models/StudentIts';
import { Observable } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';





@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'webserviceapp';

dataSource: any = new MatTableDataSource<CanvasdataResult>();

message="Hej"
uppgifter=["0005 Inlämningsuppgifter", "0001 Tentamen"];


kurser!: Kurs[];
canvasdatan!:Canvasdata[];
studentsIts!:StudentIts[];
canvasdataResults!:CanvasdataResult[];
currentKurs!:Kurs;
currentCanvasdata!:Canvasdata;
currentStudentIts!:StudentIts;
currentCanvasdataResult!:CanvasdataResult;
currentIndex=-1;
inputfile="";
kursnamn="";
uppgift="";

kurs ={
  id: "",
  kurskod: "",
  modul: "",

};


  canvasdataResult={
    c_id:"",
    id:"",
    status:"",
    omdome:"",
    studentnamn:"",
    personnummer:"",
    resultat:"",
    ladokdata:"",
    information:"",
    registrDatum:Date.now(),
    kursnamn:"",
    uppgift:""

 };



  studentIts={

  id:"",
  studentnamn:"",
  personnummer:"",
  studentId:"",
  losenord:"",
  epostadress:""
    };

   ladokdata={
   id:"",
   studentnamn:"",
   antagningsar:"",
   personnummer:"",
   kursnummer:"",
   kursar:"",
   resultat:this.canvasdataResult.resultat,
   intyg:"",
   campus:"",
   registrDatum:this.canvasdataResult.registrDatum,
   information:this.canvasdataResult.information,
   kursmodul:"",
   status:this.canvasdataResult.status
};

retrieveResponse: any;

  isTableLoaded: boolean = false;
  showAll: boolean = false;
  kurskod="";
  studentID="";

    loading = false;
    errorMessage = '';



constructor(private kursService: KursService,
              private canvasdataService: CanvasdataService,
              private studentItsService:StudentItsService,
              private router: Router,
              private dialog: MatDialog,
              private httpClient: HttpClient,
              private dialogRef: MatDialog,
              private ladokdataService: LadokdataService) {
  }

  setTableIsLoaded() {
    this.isTableLoaded = true;
  }


  ngOnInit(): void {


      this.dataSource = new MatTableDataSource<CanvasdataResult>();
     // this.dataSource = new MatTableDataSource(this.canvasdataResult);// create new object


   /** this.dataSource = new MatTableDataSource<Kurs>();
    this.dataSource = new MatTableDataSource(this.kurser);// create new object
    console.log(this.dataSource);**/

  }
  /**onSelect(kurs: Kurs): void {
          this.currentKurs = kurs;
          console.log(`currentKurs=${JSON.stringify(this.currentKurs)}`);


      }**/

onSelect(canvasdataResult: CanvasdataResult): void {
          this.currentCanvasdataResult = canvasdataResult;
          console.log(`currentKurs=${JSON.stringify(this.currentCanvasdataResult)}`);


      }

  getKursByKurskod(){
        this.canvasdataService.getCanvasdataResult(this.kurskod)
          .subscribe(
            data=>
            this.canvasdataResults = data);
            console.log("fine");

      }

   findKursByKurskod(){
     this.canvasdataService.getCanvasdataResultByUppgift(this.kursnamn, this.uppgift)
      .subscribe((response)=>{this.canvasdataResults=response;},
        (error) => {this.errorMessage = error.message; this.loading = false;
                               },
                               () => {this.loading = false;})

           }






    findCanvasdataByKurskod(){
        this.canvasdataService.getCanvasdataByKurskod(this.kurskod)
          .subscribe(
            canvasdatan=>
            this.canvasdatan = canvasdatan);


      }

      setActiveCanvasdata(canvasdata: Canvasdata,index: number):void{
          this.currentCanvasdata=canvasdata;
          this.currentIndex=index;
        }

    setActiveStudentIts(studentIts: StudentIts,index: number):void{
          this.currentStudentIts=studentIts;
          this.currentIndex=index;
        }


  applyFilter(event: Event) {
      const filterValue = (event.target as HTMLInputElement).value;
      this.dataSource.filter = filterValue.trim().toLowerCase();

      if (this.dataSource.paginator) {
        this.dataSource.paginator.firstPage();
      }
    }

  /**setCurrentCanvasdataResult(canvasdataResult: CanvasdataResult, index: number):void{
            this.currentCanvasdataResult=canvasdataResult;
            this.currentIndex=index;
          }**/

  updateResultat(): void{

        this.message = '';
        this.ladokdataService.updateLadokdata(this.ladokdata.id, this.ladokdata)
          .subscribe({

          next: (res) => {
            console.log(res);
            this.message = res.message ? res.message : 'Resultat är nu uppdaterat!';
          },
          error: (e) => console.error(e)
        });
    }


  onSubmit() {

  //  this.findCanvasdataByKurskod();
  // this.getKursByKurskod();

   // this.getStudentByUppgift();


  this.findKursByKurskod();


  }

}





