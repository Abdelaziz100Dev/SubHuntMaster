import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

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

  getAll() {
    return this.http.get<Array<any>>(this.URL);
  }

}
