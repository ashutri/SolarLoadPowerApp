import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { SolarPowerComponent } from './solar-power/solar-power.component';
import { HourDataComponent } from './hour-data/hour-data/hour-data.component';
const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent},
  {path: 'solar-power', component: SolarPowerComponent},
  {path: 'hour-data', component: HourDataComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
