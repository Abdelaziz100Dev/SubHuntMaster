import {Component, OnInit} from '@angular/core';
import {CompetitionService} from "../service/competition.service";
import {CompetitionModel} from "../model/competition.model";
import {ModalComponent} from "../modal/modal.component";


@Component({
  selector: 'app-competitionlist',
  templateUrl: './competitionlist.component.html',
  styleUrls: ['./competitionlist.component.css']
})
export class CompetitionlistComponent implements OnInit {
  competitionList: CompetitionModel[] = [];

  constructor(private  competitionService: CompetitionService,private ModalComponent :ModalComponent) {

  }
  ngOnInit(): void {
    this.getCompetitions();
  }
  public getCompetitions(){
    this.competitionService.getAll().subscribe(
      data=>{
        this.competitionList=data;
      })
  }

  handleCheck(competition: any) {

  }

  deleteCompetition(competition: any) {

  }

  updateCompetition(competition: any) {

  }

  openModal() {
    this.ModalComponent.openModal();
  }
}
