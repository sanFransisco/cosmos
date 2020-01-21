import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AppConfigService } from '../../app-config.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NothingImpl } from '../../types/nothing';

@Component({
  selector: 'cosmos-editform',
  providers:[],
  templateUrl: './editform.component.html',
  styleUrls: ['./editform.component.css']
})
export class EditformComponent implements OnInit {

  @Output("create")
  create:EventEmitter<{type:string, data:any}>;

  //false means black, true means white
  nothingType:FormControl = new FormControl("");

  //fields of config
  nothingConfig:any[];

  fieldNameByType:{white:string,black:string};
  //show the white field current edited object
  whiteField: FormControl = new FormControl("",[Validators.required]);
  //show the black field current edited object
  blackField: FormControl = new FormControl(false);
  //shows the name
  nameField: FormControl = new FormControl("",[Validators.required,Validators.minLength(5) ]);
  //shows the description
  description: FormControl = new FormControl("",[Validators.required,Validators.minLength(5) ]);

  editForm: FormGroup = new FormGroup({
    white:this.whiteField,
    black:this.blackField,
    name:this.nameField,
    description:this.description,
    nothingType:this.nothingType
  });

  validateForm():boolean{
    return this.editForm.valid;
  }

  handleSubmit(){
    debugger;
   
      var name = this.editForm.get("name").value;
      var description = this.editForm.get("description").value;
    
      if(this.nothingType.value == "White"){
        if(this.whiteValid()){
          this.create.emit({type:"White", data:{creator:this.editForm.get("white").value, name:name, description:description}});
       }      
    }else if(this.nothingType.value == "Black"){
      if(this.blackValid()){
      this.create.emit({type:"Black", data:{isBlackHole:this.editForm.get("black").value, name:name, description:description}});
    }
  }
}
  
  
  constructor(appConfig:AppConfigService) { 

    this.create = new EventEmitter();    
    this.nothingConfig = appConfig.getLayouts();
    // this.nothingConfig.forEach(config=>{
    //   if(config.white != undefined)
    //     this.fieldNameByType.white = config.cols
    // });
    console.log( this.nothingConfig );
    //console.log( this.fieldName);
  }

  ngOnInit() {
  }

basicValidation(){
  return this.editForm.get("name").valid && this.editForm.get("description").valid
}

  whiteValid(){

    return this.basicValidation()  && this.editForm.get("white").valid;
  }

  blackValid(){
    return this.basicValidation() && this.editForm.get("black").valid;
  }
}
