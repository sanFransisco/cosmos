import { Component, OnInit } from '@angular/core';
import { HttpService } from '../../http.service';
import { AppConfigService } from '../../app-config.service';

@Component({
  selector: 'app-datatable',
  templateUrl: './datatable.component.html',
  styleUrls: ['./datatable.component.css']
})
export class DatatableComponent implements OnInit {

  displayedColumns: string[] = [];
  dataSource = [];
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
      }
    },err=>{
        alert("create failed");
    });
  }

  onDelete(idx:number, element:any){
 
    this.http.deleteNothing(element.id).subscribe(data=>{     
      this.dataSource.splice(idx, 1)
      this.dataSource = [...this.dataSource];
    },(err)=>{
      alert("delete failed");
    });
  }

  onUpdate(element:any){
    this.http.updateNothing(element.id, element).subscribe(data=>{
      debugger;
        this.dataSource =  [...this.dataSource];
        var idx = this.dataSource.indexOf(element);
        this.dataSource.splice(idx,1);
        this.dataSource.push(data);      
    },err=>
    alert("update failed"));
  }

}
