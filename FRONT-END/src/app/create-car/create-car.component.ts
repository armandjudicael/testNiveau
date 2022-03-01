import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Car } from '../car';
import { CarService } from '../car.service';

@Component({
  selector: 'app-create-car',
  templateUrl: './create-car.component.html',
  styleUrls: ['./create-car.component.css']
})
export class CreateCarComponent implements OnInit {
  username : string;
  password : string;
  car : Car;
  constructor( private carService : CarService , private router : Router) {
    this.car = new Car();
    this.username = "";
    this.password = "";
  }
  
  ngOnInit(): void {
  }

  saveCar(){
    this.carService.createCar(this.car).subscribe(data =>{
      console.log(this.car)
    })
  }
  
  goToCarList(){
    this.router.navigate(['/cars']);
  }

  onSubmit(form: any): void {
    this.saveCar();
    this.goToCarList();
 }

}
