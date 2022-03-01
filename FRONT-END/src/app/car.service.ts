import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from './car';

@Injectable({
  providedIn: 'root'
})

export class CarService {
  private baseUrl = "http://localhost:8080/api/v1/cars";
  private deleteAllUrl = "http://localhost:8080/api/v1/cars/deleteAll";
  private addUrl = "http://localhost:8080/api/v1/car";
  constructor( private httpClient : HttpClient) { }
  createCar(car : Car) : Observable<Object>{ return this.httpClient.post<Car[]>(`${this.addUrl}`,car);}
  getCarList() : Observable<Car[]> { return this.httpClient.get<Car[]>(`${this.baseUrl}` )}; 
  getCarById(id : number) : Observable<Car>{return this.httpClient.get<Car>(`${this.baseUrl}/${id}`);}
  updateCar(id : number,car : Car) : Observable<Object>{ return this.httpClient.put<Car>(`${this.baseUrl}/${id}`,car);}
  deleteCar(id : number) :  Observable<Object>{ return this.httpClient.delete(`${this.baseUrl}/${id}`);}
  deleteAll() : Observable<Object>{ return this.httpClient.delete(`${this.deleteAllUrl}`);}
}
