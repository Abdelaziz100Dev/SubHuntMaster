import {Component, Input} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Member} from "../model/Member";
import {FormControl, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';
import {NgForOf, NgIf} from "@angular/common";
import {CompetitionService} from "../service/competition.service";
import {RankService} from "../../rank/service/rank.service";
import {RankModel} from "../../rank/model/RankModel.model";
export  interface memberInCompetition{
  inThisCompetition: boolean;
  id: number;
  firstName: string;
}
@Component({
  selector: 'app-assign-members',
  templateUrl: './assign-members.component.html',
  styleUrls: ['./assign-members.component.css'],
  standalone: true,
  imports: [
    MatFormFieldModule, MatSelectModule, FormsModule, ReactiveFormsModule, NgIf, NgForOf],
})
export class AssignMembersComponent {
  @Input() competitionId: number | undefined;
  selectedMembers = new FormControl();
  membersList: memberInCompetition[] = [];
  // competitionId: string| null = null;
  constructor( private  competitionService: CompetitionService,private route: ActivatedRoute,private rankService :RankService) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      // this.competitionId = params.get('id');
      // Fetch competition details or perform other actions based on competitionId

      // // Set initial selected members with inThisCompetition=true
      // const initialSelectedMembers = this.membersList
      //   .filter(member => member.inThisCompetition)
      //   .map(member => member.id);
      //
      // this.selectedMembers.setValue(initialSelectedMembers);
    });
    this.getAllMembers();

  }

  assignMembers() {
    const selectedMember = this.selectedMembers.value;

    // Create an object with the desired structure
    const rankData: RankModel = {
      rank: 1,
      score: 0,
      competition: { id: this.competitionId },
      member: { id: selectedMember?.[0] } // You might want to replace this with the actual member ID
    };
    // const selectedMembers = this.selectedMembers.value;
    // console.log('Selected Members:', selectedMember , "rankData :" ,rankData, "com[etition id", this.competitionId);

    this.rankService.postRank(rankData).subscribe(
      data=>{
        console.log(data)
      },
      error => {
        if (error.details) {
          console.log("Error Details:", error.details);
        }
      }
    )
  }
  compareMembers(memberId1: number, memberId2: number): boolean {
    return memberId1 === memberId2;
  }
  getAllMembers() {
    this.competitionService.getAllMembers().subscribe(
      data=>{
        console.log(data)
        this.membersList=data;
      })
  }

}
