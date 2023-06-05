import { Observable } from "rxjs";
import { ExerciceAlgoBackendService } from "./backend/exercice-algo-backend.service";
import { Injectable } from "@angular/core";

@Injectable()
export class ExerciceAlgoService {
    constructor(private exerciceAlgoBackendService: ExerciceAlgoBackendService) {}

    public encode$(value: string): Observable<number> {
        return this.exerciceAlgoBackendService.encode$(value);
    }

    public decode$(hash: number): Observable<string> {
        return this.exerciceAlgoBackendService.decode$(hash);
    }
}