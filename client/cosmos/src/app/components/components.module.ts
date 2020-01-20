import { NgModule } from '@angular/core';
import {MatTableModule, 
  MatSelectModule, 
  MatInputModule,
  MatBadgeModule,
  MatRadioModule,
  MatButtonModule,
  MatCheckboxModule} from '@angular/material';
import {
  ReactiveFormsModule, 
  FormsModule } from '@angular/forms'

@NgModule({
  declarations: [],
  imports: [   
  ],
  exports:[
    MatTableModule, 
    MatSelectModule, 
    ReactiveFormsModule,
    FormsModule, 
    MatInputModule, 
    MatBadgeModule,
    MatRadioModule,
    MatButtonModule,
    MatCheckboxModule]
})
export class ComponentsModule { }
