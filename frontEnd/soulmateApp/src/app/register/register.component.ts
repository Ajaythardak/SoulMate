import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, Subscriber } from 'rxjs';
import { Register } from '../register';
import { RegisterService } from '../register.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm = new FormGroup({
    name : new FormControl(''),
    age : new FormControl(''),
    gender : new FormControl(''),
    city : new FormControl(''),
    emailId : new FormControl(''),
    password : new FormControl(''),
    picture : new FormControl('')
  })

  registerdata:Register | any;
  // isDirty: any;
  constructor(private router:Router, private registerService: RegisterService) { }
  // 
  ngOnInit(): void {
  }
  
  // pic:string="/assets/img/boy-girl.jpg"
  // fileToUpload: File | null=null;
  // // fileToUpload:File as File;
   // // let file:File 

  // handleFileInput(file: FileList){
  //   this.fileToUpload = file.item(0);
  //   var reader = new FileReader();
  //   reader.onload =(event:any)=>{
  //     this.pic = event.target.result;
  //   }
  //   reader.readAsBinaryString(this.fileToUpload);

  // }


  myImage!:Observable<any>;
  base64code!: any;
  picName:string="";
  onChange=($event: Event)=>{
    const target=$event.target as HTMLInputElement;
    const file: File=(target.files as FileList)[0]; 
    console.log(file);
    console.log(file.name);
    this.picName=file.name;
    
    this.convertToBase64(file)
  }

  convertToBase64(file:File){
    const observable = new Observable((subscriber: Subscriber<any>)=>{
      this.readFile(file, subscriber)
    })
    observable.subscribe((d)=>{
      console.log(d);
      this.myImage=d;
      this.base64code=d;
      console.log(d.name);
      
      
    })

  }

  readFile(file: File, subscriber: Subscriber<any>){
    const filereader = new FileReader();
    filereader.readAsDataURL(file)
    filereader.onload=()=>{
      subscriber.next(filereader.result);
      subscriber.complete();
}

filereader.onerror=()=>{
  subscriber.error()
  subscriber.complete()
}
}


  onSubmit(){
    console.log("Register Form Data = ",this.registerForm.value);
    
    this.registerdata=this.registerForm.value;
    console.log(this.registerdata);
    console.log("on submit is working");
    
    
    
  //   this.registerService.registerUser(this.registerdata, this.registerForm.).subscribe(
  //     a=>{
  //       this.router.navigateByUrl("/login");
  //       console.log("User Registered");
  //       confirm("User registration Successful");
  //       alert("Account Successfully created.")
        
  //     },
  //     error => {
  //       console.log(error);
  //       alert("signup failed");
  //     });
  }
}
