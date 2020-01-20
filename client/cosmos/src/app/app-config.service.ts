import { Injectable } from '@angular/core';
import { NothingConfig } from './config/layout-config';
import { Black, White } from './types/nothing';

@Injectable({
  providedIn: 'root'
})
export class AppConfigService {

  cosmosLayouts: NothingConfig;
  cosmosBaseURL:string;
  cosmosPort:number;
  tableCommonCol:string[];
  constructor(){
    this.cosmosLayouts = new NothingConfig();
    this.init();
  }

   init(){
     //get keys
     var BlackCols: keyof( Black) = "isBlackHole";
     var WhiteCols: keyof( White) = "creator";
     //configure layout base on nothing types
     this.cosmosLayouts.addNothingConfig(new Black(),{table: {cols:"isBlackHole"}});
     this.cosmosLayouts.addNothingConfig(new White(),{table:{cols: "creator"}});
     this.cosmosPort = 8080;
     this.cosmosBaseURL = "http://localhost:" + this.cosmosPort;
     this.tableCommonCol = ["description", "name", "update", "delete"];
   }

  getLayouts():any{
    debugger;
    return this.cosmosLayouts.getMapping();
  }

  getTableCommonCol(){
    return this.tableCommonCol;
  }
}
