import { Component, OnInit } from '@angular/core';
import { Car } from '../car';
import { Router } from '@angular/router';
import { CarService } from '../car.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  car : Car ;
  constructor(private carService : CarService , private router : Router) {
    this.car = new Car();
   }
  ngOnInit(): void {

  }

  onSubmit(form: any): void {
    this.saveCar();
    this.goToCarList();
  }

  saveCar(){
    this.carService.createCar(this.car).subscribe(data =>{
      console.log(this.car)
    })
  }

  goToCarList(){
    this.router.navigate(['/cars']);
  }
}
