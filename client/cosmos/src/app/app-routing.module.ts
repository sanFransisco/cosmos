import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {DatatableComponent} from "./components/datatable/datatable.component";

const routes: Routes = [
  {
    path:"home",      
    children:[
      {
        path:"crud",
        component:DatatableComponent
      }],
},
{ 
  path: '', 
  redirectTo: '/home/crud', 
  pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
