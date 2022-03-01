import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Car } from '../car';
import { CarService } from '../car.service';

@Component({
  selector: 'app-update-car',
  templateUrl: './update-car.component.html',
  styleUrls: ['./update-car.component.css']
})

export class UpdateCarComponent implements OnInit {
  id : number = 0;
  car : Car = new Car();
  
  constructor(private carService : CarService,
              private route : ActivatedRoute,
              private router : Router) { 

  }
  
  ngOnInit(): void {
    this.id = this.route.snapshot.params["id"];
    this.carService.getCarById(this.id).subscribe(data =>{
           this.car = data;
    },error => console.log(error))
  }

  onSubmit(){
    this.carService.updateCar(this.id,this.car).subscribe(data => {
     this.goToCarList();
    },error => console.log(error))
  }

  goToCarList(){
    this.router.navigate(["/cars"]);
  }
  
}
