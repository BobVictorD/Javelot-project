import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable, map } from 'rxjs';
import { DonneeMeteoDto } from 'src/app/services/backend/model/donnees-meteo-dto';
import { VilleDto } from 'src/app/services/backend/model/ville-dto';

export interface VilleVue extends VilleDto {
  data: any;
}

@Component({
  selector: 'app-donnees-meteo',
  templateUrl: './donnees-meteo.component.html',
  styleUrls: ['./donnees-meteo.component.css']
})
export class DonneesMeteoComponent implements OnInit {

  villeVue: VilleVue | undefined;

  options: any;

  constructor(private activatedRoute: ActivatedRoute, private datePipe: DatePipe) {
  }

  ngOnInit() {
    const documentStyle = getComputedStyle(document.documentElement);
    const textColor = documentStyle.getPropertyValue('--text-color');
    const textColorSecondary = documentStyle.getPropertyValue('--text-color-secondary');
    const surfaceBorder = documentStyle.getPropertyValue('--surface-border');

    this.options = {
      maintainAspectRatio: false,
      aspectRatio: 0.6,
      plugins: {
          legend: {
              labels: {
                  color: textColor
              }
          }
      },
      scales: {
          x: {
              ticks: {
                  color: textColorSecondary
              },
              grid: {
                  color: surfaceBorder,
                  drawBorder: false
              }
          },
          y: {
              ticks: {
                  color: textColorSecondary
              },
              grid: {
                  color: surfaceBorder,
                  drawBorder: false
              }
          }
        }
      };


    this.activatedRoute.data.subscribe(
      ({villeObs}) => {
        if(villeObs != null) {
          const data = {
            labels: villeObs.releveMeteos.map((p: DonneeMeteoDto) => this.datePipe.transform(p.date, 'dd/MM/yy HH:mm')),
            datasets: [
              {
                label : 'temperature',
                data : villeObs.releveMeteos.map((p: DonneeMeteoDto) => p.temperature),
                fill: false,
                borderColor: documentStyle.getPropertyValue('--blue-500'),
                tension: 0.4
              }
            ]
          };
          this.villeVue = {...villeObs, data: data};
        }
      });
  }

}
