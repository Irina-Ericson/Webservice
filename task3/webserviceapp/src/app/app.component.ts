import { AfterViewInit, OnInit, Component, ViewChild, ElementRef } from '@angular/core';
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
import {StudentIts} from 'src/assets/models/StudentIts';
import { Observable } from 'rxjs';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'webserviceapp';

columndefs : any[] = ['name','code', 'point', 'date', 'status', 'information'];

message="Hej"

dataSource: any = new MatTableDataSource<Kurs>();
kurser: Kurs[] = [];
canvasdatan:Canvasdata[]=[];
studentsIts:StudentIts[]=[];
currentKurs!:Kurs;
currentCanvasdata!:Canvasdata;
currentStudentIts!:StudentIts;
inputfile="";
kurs ={
  id: "",
  kurskod: "",
  modul: "",

};
canvasdata={
  id:"",
  studentID:"",
  studentnamn:"",
  epostadress:"",
  kursnamn:"",
  kurskod:""
  };

  studentIts={

  id:"",
  studentnamn:"",
  personnummer:"",
  studentId:"",
  losenord:"",
  epostadress:""
    }


  isTableLoaded: boolean = false;
  showAll: boolean = false;
  kurskod="";
  studentID="";
  currentIndex=-1;



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

   /** this.dataSource = new MatTableDataSource<Kurs>();
    this.dataSource = new MatTableDataSource(this.kurser);// create new object
    console.log(this.dataSource);**/

  }

  getKursByKurskod(){
        this.kursService.findKursByKurskod(this.kurskod)
          .subscribe(
            kurser=>
            this.kurser = kurser);
            console.log("ok");

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


      setActiveKurs(kurs: Kurs,index: number):void{
          this.currentKurs=kurs;
          this.currentIndex=index;
        }

      setActiveCanvasdata(canvasdata: Canvasdata,index: number):void{
          this.currentCanvasdata=canvasdata;
          this.currentIndex=index;
        }

    setActiveStudentIts(studentIts: StudentIts,index: number):void{
          this.currentStudentIts=studentIts;
          this.currentIndex=index;
        }

onSubmit() {


    this.findCanvasdataByKurskod();
    this.getKursByKurskod();
 //   this.findPnrByStudentId();


  }
  }






