import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ExerciceAlgoComponent } from './components/exercice-algo/exercice-algo.component';
import { DonneesMeteoComponent } from './components/donnees-meteo/donnees-meteo.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import { villeResolver } from './services/donnees-meteo.service';

const routes: Routes = [
  {
    path: "accueil",
    component: AccueilComponent
  },
  {
    path: "exercice-algo",
    component: ExerciceAlgoComponent
  },
  {
    path: "donnees-meteo/:nom",
    component: DonneesMeteoComponent,
    resolve: { villeObs: villeResolver}
  },
  {
    path: "**",
    redirectTo: "accueil"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
