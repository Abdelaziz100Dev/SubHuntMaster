import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {RankModel} from "../model/RankModel.model";

@Injectable({
  providedIn: 'root'
})
export class RankService {

  public URLRANKING = "http://localhost:8080/api/ranking";


  constructor(private http :HttpClient) {

  }

  getAll() {
    return this.http.get<Array<any>>(this.URLRANKING);
  }
  postRank(ranking: RankModel) {
    return this.http.post<any>(this.URLRANKING,ranking);
  }
}
