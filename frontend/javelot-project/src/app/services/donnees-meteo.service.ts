import { Injectable, inject } from "@angular/core";
import { DonnesMeteoBackendService } from "./backend/donnes-meteo-backend.service";
import { ActivatedRouteSnapshot, ResolveFn, RouterStateSnapshot } from "@angular/router";
import { VilleDto } from "./backend/model/ville-dto";
import { Observable } from "rxjs";

@Injectable()
export class DonneesMeteoService {
    constructor(private donnesMeteoBackendService: DonnesMeteoBackendService) {}

    public getVilleDto(nom: string): Observable<VilleDto> {
        return this.donnesMeteoBackendService.getDonneesMeteo(nom);
    }
}

export const villeResolver: ResolveFn<Observable<VilleDto>> =
    (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => {
      return inject(DonneesMeteoService).getVilleDto(route.paramMap.get('nom')!);
    };