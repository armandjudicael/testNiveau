import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Car } from '../car';
import { CarService } from '../car.service';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-cars-list',
  templateUrl: './cars-list.component.html',
  styleUrls: ['./cars-list.component.css']
})

export class CarsListComponent implements OnInit {
  cars : Car[] | undefined;  
  constructor(private carService : CarService, 
    private router : Router , private toastr: ToastrService){
  }

  ngOnInit(): void {
    this.getCars();
  }

  
  private getCars(){
    this.carService.getCarList().subscribe(data => {
      this.cars = data;
    })
  }

  updateCar(id : number){
 //   this.router.navigate(['update-car',id])
  }

  deleteCar(id : number){
    this.carService.deleteCar(id).subscribe(data =>{
       this.getCars() ;
    })
  }

  comment( id : number){

  }

}
