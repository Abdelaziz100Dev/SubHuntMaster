import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {CompetitionModel} from "../model/competition.model";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class CompetitionService {
  public URLCOMPETITION = "http://localhost:8080/api/competition";
  public URLMEMBERS = "http://localhost:8080/api/member";


  constructor(private http :HttpClient) {

  }
  // public deleteDevis(devis:DevisModel) {
  //   return this.http.delete<DevisModel>(this.URLCOMPETITION+"/"+devis.id);
  //
  // }

  getAllcompetition(page: number, size: number): Observable<any> {
    const params   = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());

    console.log('params', params);

    return this.http.get<any>(this.URLCOMPETITION, { params }).pipe(
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
    return this.http.post(this.URLCOMPETITION,competition);
  }
  deleteCompetition(competition: CompetitionModel) {
    return this.http.delete(this.URLCOMPETITION+"/"+competition.id);

  }
  // getallMembers
  getAllMembers() {
    return this.http.get<Array<any>>(this.URLMEMBERS);
  }

}
