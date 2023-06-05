import { LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { HorizontalBarComponent } from './components/horizontal-bar/horizontal-bar.component';
import { ExerciceAlgoComponent } from './components/exercice-algo/exercice-algo.component';
import { DonneesMeteoComponent } from './components/donnees-meteo/donnees-meteo.component';
import { AppComponent } from './components/app/app.component';
import { BackendService } from './services/backend/backend.service';
import { DonnesMeteoBackendService } from './services/backend/donnes-meteo-backend.service';
import { ExerciceAlgoBackendService } from './services/backend/exercice-algo-backend.service';
import { AccueilComponent } from './components/accueil/accueil.component';
import { FormsModule } from '@angular/forms';
import { InputNumberModule } from 'primeng/inputnumber';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { ExerciceAlgoService } from './services/exercice-algo.service';
import { HttpClientModule } from '@angular/common/http';
import { DonneesMeteoService } from './services/donnees-meteo.service';
import { ChartModule } from 'primeng/chart';
import { DatePipe, registerLocaleData } from '@angular/common';
import * as fr from '@angular/common/locales/fr';


@NgModule({
  declarations: [
    AppComponent,
    HorizontalBarComponent,
    ExerciceAlgoComponent,
    DonneesMeteoComponent,
    AccueilComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    InputTextModule,
    InputNumberModule,
    ButtonModule,
    AppRoutingModule,
    HttpClientModule,
    ChartModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue: "fr-FR" },
    BackendService,
    DonnesMeteoBackendService,
    ExerciceAlgoBackendService,
    ExerciceAlgoService,
    DonneesMeteoService,
    DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
    registerLocaleData(fr.default);
  }
 }
