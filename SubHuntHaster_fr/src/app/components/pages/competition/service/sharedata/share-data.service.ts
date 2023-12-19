import { Injectable } from '@angular/core';
import {BehaviorSubject, Observable} from "rxjs";
import {CompetitionModel} from "../../model/competition.model";

@Injectable({
  providedIn: 'root'
})
export class ShareDataService {
  private selectedCompetitionSubject = new BehaviorSubject<CompetitionModel | null>(null);
  constructor() { }
  setSelectedCompetition(competition: CompetitionModel): void {
    this.selectedCompetitionSubject.next(competition);
  }

  getSelectedCompetition(): Observable<CompetitionModel | null> {
    return this.selectedCompetitionSubject.asObservable();
  }

}
