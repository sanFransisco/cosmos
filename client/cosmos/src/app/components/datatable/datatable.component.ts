import { Component, OnInit } from '@angular/core';
import { HttpService } from '../../http.service';
import { AppConfigService } from '../../app-config.service';



const ELEMENT_DATA: any[] = [
  {id: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {id: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {id: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {id: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {id: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {id: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {id: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {id: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {id: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {id: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
];

@Component({
  selector: 'app-datatable',
  templateUrl: './datatable.component.html',
  styleUrls: ['./datatable.component.css']
})
export class DatatableComponent implements OnInit {

  displayedColumns: string[] = [];
  dataSource = ELEMENT_DATA;
  descriptionState:string;
  nameState:string;

  constructor(private http:HttpService, private appConfig:AppConfigService) { }

  ngOnInit() {
    this.http.getAllNothings().subscribe(data=>{
      this.dataSource = data;      
    });
    this.displayedColumns = this.appConfig.getTableCommonCol()
  }

  initColumnsFromConfig(){
    this.displayedColumns = this.appConfig.getLayouts();
   
  }

  onCreate(evt:any){
    debugger;
    this.http.addNothing(evt.type, evt.data).subscribe(data=>{
      if(data instanceof Object){
        debugger;
        this.dataSource =  [...this.dataSource];
        this.dataSource.push(data);
        alert("create successed");
      }
    },err=>{
        alert("create failed");
    });
  }

  onDelete(idx:number, element:any){
 
    this.http.deleteNothing(element.id).subscribe(data=>{     
      this.dataSource.splice(idx, 1)
    },(err)=>{
      alert("delete failed");
    });
  }

  onUpdate(element:any){

  }

  onModelChange(data:any){
    this.http.updateNothing(data.id, data).subscribe(data=>{      
      if(data instanceof Array){
        alert("update successed");
      }
    },err=>{
      alert("update failed");
    })
  }

}
