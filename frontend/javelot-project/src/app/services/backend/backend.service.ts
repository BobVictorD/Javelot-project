import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map } from "rxjs";


@Injectable()
export class BackendService {

    private baseUrl: String = "http://localhost:9596/api/";
    private headers: HttpHeaders = new HttpHeaders();

    constructor(private httpService: HttpClient) {
        this.headers.append('Access-Control-Allow-Origin', '*');
        this.headers.append('Access-Control-Allow-Methods', 'GET, POST, OPTIONS');
    }

    public httpGet$<T>(url: string): Observable<T> {
        return this.httpService.get(this.baseUrl + url).pipe(map((response: any) => {return response as T;}));
    }
}
