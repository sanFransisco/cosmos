import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { AppConfigService } from './app-config.service';
import { Observable } from 'rxjs';
import { NothingImpl } from './types/nothing';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private readonly CRUD = "/crud/";

  constructor(private appConfig: AppConfigService, 
    private http: HttpClient) {       

  }

  public getAllNothings():Observable<any>{
    var headers = new HttpHeaders({
      "Content-Type": "application/json",
      "Accept": "application/json",
      "Access-Control-Allow-Origin":"*"
  });
      return this.http.get<NothingImpl>(this.appConfig.cosmosBaseURL + this.CRUD + "all",{headers:new HttpHeaders().set("Content-Type", "application/json")});
  }

  public getNothingById(id: number):Observable<NothingImpl>{
    return this.http.post<NothingImpl>(this.appConfig.cosmosBaseURL + this.CRUD + "update", JSON.stringify(id));
  }

  public updateNothing(id: number, nothing:NothingImpl):Observable<any>{
    return this.http.post(this.appConfig.cosmosBaseURL + this.CRUD + "update", JSON.stringify({id,nothing}));
  }

  public addNothing(type:string, nothing:any):Observable<any>{
    debugger;  
    var headers = new HttpHeaders({
      'Content-Type': 'application/json',
      "Accept": "application/json",
      "Access-Control-Allow-Origin":"*"
      
  });
    return this.http.post(this.appConfig.cosmosBaseURL + this.CRUD + "create",JSON.stringify({nothing,type}), {headers:headers});

  }

  public deleteNothing(nothingID:number):Observable<any>{
    var headers = new HttpHeaders({
      'Content-Type': 'application/json',
      "Accept": "application/json",
      "Access-Control-Allow-Origin":"*"
      
  });

    const options = {body:{id:nothingID},headers:headers};
    return this.http.delete(this.appConfig.cosmosBaseURL + this.CRUD + "delete", options);
  }
}
