import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {CompetitionModel} from "../model/competition.model";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class CompetitionService {
  public URL = "http://localhost:8080/api/competition";

  constructor(private http :HttpClient) {

  }
  // public deleteDevis(devis:DevisModel) {
  //   return this.http.delete<DevisModel>(this.URL+"/"+devis.id);
  //
  // }

  getAll(page: number, size: number): Observable<any> {
    const params   = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());

    console.log('params', params);

    return this.http.get<any>(this.URL, { params }).pipe(
      map(response => {
        return {
          competitions: response.content,
          pageable: response.pageable,
          last: response.last,
          totalPages: response.totalPages,
          totalElements: response.totalElements,
          size: response.size,
          number: response.number,
          sort: response.sort,
          numberOfElements: response.numberOfElements,
          first: response.first,
          empty: response.empty
        };
      })
    );
  }
  updateCompetition(competition: CompetitionModel) {
    return this.http.post(this.URL,competition);
  }
  deleteCompetition(competition: CompetitionModel) {
    return this.http.delete(this.URL+"/"+competition.id);

  }

}
