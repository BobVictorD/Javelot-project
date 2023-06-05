import { Injectable } from "@angular/core";
import { BackendService } from "./backend.service";
import { Observable, map } from "rxjs";
import { ResponseDto } from "./model/response-dto";

@Injectable()
export class ExerciceAlgoBackendService {

    private baseUrl: string = "exercice-algo/"

    constructor(private backendService: BackendService) {
    }

    public decode$(hash: number): Observable<string> {
        return this.backendService.httpGet$<ResponseDto>(this.baseUrl + "decode/" + hash).pipe(map((response: ResponseDto) => {return response.response;}));
    }

    public encode$(value: string): Observable<number> {
        return this.backendService.httpGet$<number>(this.baseUrl + "encode/" + value);
    }
}