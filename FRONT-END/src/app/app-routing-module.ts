import { NgModule } from "@angular/core";
import { Routes,RouterModule } from "@angular/router";
import { CarsListComponent } from "./cars-list/cars-list.component";
import { CreateCarComponent } from "./create-car/create-car.component";
import { LoginComponent } from "./login/login.component";
import { UpdateCarComponent } from "./update-car/update-car.component";
const routes : Routes = [
    {path : 'cars',component : CarsListComponent},
    {path:"create-car",component : CreateCarComponent },
    {path : "",redirectTo : "cars",pathMatch : "full"},
    {path : "update-car/:id",component : UpdateCarComponent},
    {path : "login",component : LoginComponent}
];

@NgModule({ 
    imports : [RouterModule.forRoot(routes)], 
    exports :[RouterModule]
})
export class AppRoutingModule{

} 