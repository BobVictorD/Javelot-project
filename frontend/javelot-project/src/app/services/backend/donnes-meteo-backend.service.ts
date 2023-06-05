import { Observable } from "rxjs";
import { BackendService } from "./backend.service";
import { Injectable } from "@angular/core";
import { VilleDto } from "./model/ville-dto";

@Injectable()
export class DonnesMeteoBackendService {

    private baseUrl: string = "ville/"

    constructor(private backendService: BackendService) {
    }

    public getDonneesMeteo(nomVille: string): Observable<VilleDto> {
        return this.backendService.httpGet$<VilleDto>(this.baseUrl + nomVille);
    }
}