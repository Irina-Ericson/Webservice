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
import {Ladokdata} from 'src/assets/models/Ladokdata';
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

showAlert = false;
dataSource: any = new MatTableDataSource<CanvasdataResult>();


statuses=["Utkast", "Klarmarkerat", "Attesterat"];


kurser!: Kurs[];
canvasdatan!:Canvasdata[];
studentsIts!:StudentIts[];
canvasdataResults!:CanvasdataResult[];
ladokdatan!:Ladokdata;

currentKurs!:Kurs;
currentCanvasdata!:Canvasdata;
currentStudentIts!:StudentIts;
currentCanvasdataResult!:CanvasdataResult;
currentIndex=-1;
inputfile="";
kursnamn="";
uppgift="";
currentCanvasdataResultId="";
message="";
dateForMarked="";
personnummer="";

someDate = new Date(1639326601000).toLocaleString('en', {
                                    month: 'long',
                                    day: 'numeric',
                                    year: 'numeric',
                                  });;

kurs ={
  id: "",
  kurskod: "",
  modul: "",

};




 canvasdataResult={
    c_id: "",
    id:"" ,
    status:"",
    omdome:"",
    studentnamn:"",
    personnummer:"",
    resultat:"",
    ladokdata:"",
    information:"",
    registr_datum: new Date,
    kursnamn:"",
    uppgift:""

 };
ladokdata={
        id:"",
        studentnamn:"",
        antagningsar:"",
        personnummer: "",
        kursnummer:"",
        kursar:"",
        resultat:"",
        intyg:"",
        campus:"",
        registr_datum: new Date,
        information:"",
        kursmodul:"",
        status:"",
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
  onSelectKurs(kurs: Kurs): void {
          this.currentKurs = kurs;
          console.log(`currentKurs=${JSON.stringify(this.currentKurs)}`);


      }

onSelect(canvasdataResult: CanvasdataResult): void {
          this.currentCanvasdataResult = canvasdataResult;
          //console.log(`currentKurs=${JSON.stringify(this.currentCanvasdataResult)}`);


      }

  getKursByKurskod(){
        this.kursService.findKursByKurskod(this.kursnamn)
          .subscribe((myData)=>{this.kurser=myData;
            console.log(this.kurser);})

      }

   findKursByKurskod(){
     this.canvasdataService.getCanvasdataResultByUppgift(this.kursnamn, this.uppgift)
      .subscribe((response)=>{this.canvasdataResults=response;},
        (error) => {this.errorMessage = error.message; this.loading = false;
                               },
                               () => {this.loading = false;})

           }

    getPnr(){
          this.studentItsService.findPnrByStudentID(this.studentID)
            .subscribe((response)=>{this.studentsIts=response;
              console.log(response);})

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

  setCurrentCanvasdataResult(canvasdataResult: CanvasdataResult, index: number):void{
            this.currentCanvasdataResult=canvasdataResult;
            this.currentIndex=index;
          }

setCurrentKurs(kurs: Kurs, index: number):void{
            this.currentKurs=kurs;
            this.currentIndex=index;
          }

  updateResultat_2()
  {

            console.log("tjena");
            console.log(this.currentCanvasdataResult.id);
            let id=this.currentCanvasdataResult.id;
            this.ladokdataService.updateLadokdata(id).subscribe((response) => {});
            console.log("fine");
  }

 updateResultat() : void {
        console.log("tjenis");
        console.log(this.currentCanvasdataResult.id);
        console.log(this.canvasdataResults);

        console.log(this.currentCanvasdataResult);
        this.ladokdataService.update(this.currentCanvasdataResult.id, this.currentCanvasdataResult.resultat, this.currentCanvasdataResult.registr_datum,
        this.currentCanvasdataResult.status, this.currentCanvasdataResult.information, this.currentCanvasdataResult).subscribe({next:(myData)=>{
              console.log(this.currentCanvasdataResult.registr_datum);

              console.log(myData);
              this.message = myData.message ? myData.message : 'Resultat är nu uppdaterat!';
              console.log(this.message);
              },
              error: (e) => console.log(e)
                    });
     }

  /**  updateResultat() {
      this.canvasdataService.updateLadokdata(this.canvasdataResults, this.canvasdataResults.id).subscribe((response) => {});
    }**/

  onSubmit() {
  //console.log(this.canvasdataResult);

  //  this.findCanvasdataByKurskod();
 this.getKursByKurskod();

   // this.getStudentByUppgift();


 this.findKursByKurskod();
 this.getPnr();



  }

}





