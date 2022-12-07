import { AfterViewInit, OnInit, Component, ViewChild, ElementRef, SimpleChanges, ChangeDetectorRef } from '@angular/core';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {Data, Router} from "@angular/router";
import {HttpClient, HttpClientModule, HttpErrorResponse} from "@angular/common/http";
import {KursService} from 'src/app/services/KursService';
import {CanvasdataService} from 'src/app/services/CanvasdataService';
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


//kurser!: Kurs[];
canvasdatan!:Canvasdata[];
studentsIts!:StudentIts[];
canvasdataResults:CanvasdataResult[]=[];
//currentKurs!:Kurs;
currentCanvasdata!:Canvasdata;
currentStudentIts!:StudentIts;
currentCanvasdataResult!:CanvasdataResult;
currentIndex=-1;
inputfile="";
kursnamn="";
uppgift="";

/**kurs ={
  id: "",
  kurskod: "",
  modul: "",

};**/


  canvasdataResult={

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

retrieveResponse: any;

  isTableLoaded: boolean = false;
  showAll: boolean = false;
  kurskod="";
  studentID="";




constructor(private kursService: KursService,
              private canvasdataService: CanvasdataService,
              private studentItsService:StudentItsService,
              private router: Router,
              private dialog: MatDialog,
              private httpClient: HttpClient,
              private dialogRef: MatDialog) {
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
  onSelect(canvasdataResult: CanvasdataResult): void {
          this.currentCanvasdataResult = canvasdataResult;
          //console.log(`currentCanvasdataResult=${JSON.stringify(this.currentCanvasdataResult)}`);


      }

  getKursByKurskod(){
        this.canvasdataService.getCanvasdataResult(this.kursnamn)
          .subscribe(
            data=>
            this.canvasdataResults = data);
            console.log("ok");

      }

  /**getStudentByUppgift(){
        this.canvasdataService.getCanvasdataResultByUppgift(this.uppgift)
          .subscribe(
            canvasdataResults_1=>
            this.canvasdataResults_1 = canvasdataResults_1);
            console.log("ok");

      }
**/
  getStudentByUppgift(): void {
    this.canvasdataService.getCanvasdataResultByUppgift()
      .subscribe(
        data => {
          this.canvasdataResults = data;
          console.log(data);
          console.log("bra");
        },
        error => {
          console.log(error);
        });
  }



    findCanvasdataByKurskod(){
        this.canvasdataService.getCanvasdataByKurskod(this.kurskod)
          .subscribe(
            canvasdatan=>
            this.canvasdatan = canvasdatan);


      }

    //studentId="irieri-9";

    /** findPnrByStudentId(){
        this.studentItsService.findPnrByStudentID(this.http.canvasdata.studentID)
                  .subscribe(
                    studentsIts=>
                    this.studentsIts = studentsIts);

    }**/


     /** setActiveKurs(kurs: Kurs,index: number):void{
          this.currentKurs=kurs;
          this.currentIndex=index;
        }**/

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

  onSubmit() {

  //  this.findCanvasdataByKurskod();
    this.getKursByKurskod();
    this.getStudentByUppgift();


 //   this.findPnrByStudentId();


  }

}





