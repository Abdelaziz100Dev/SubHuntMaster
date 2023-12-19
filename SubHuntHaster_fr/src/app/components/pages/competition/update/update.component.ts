import {Component, OnInit} from '@angular/core';
import {ShareDataService} from "../service/sharedata/share-data.service";
import {CompetitionModel} from "../model/competition.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CompetitionService} from "../service/competition.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent  implements OnInit{
  competitionList: CompetitionModel | null = null;
  competitionForm!: FormGroup;
    constructor(private shareDataService: ShareDataService,private formBuilder: FormBuilder,private competitionService: CompetitionService,private router: Router) {
    }

    ngOnInit(): void {
      this.competitionForm = this.formBuilder.group({
        // Define your form controls based on Competition model
        code: ['', Validators.required],
        startTime: [null, Validators.required],
        endTime: [null, Validators.required],
        // Add more controls as needed
      });

      this.shareDataService.getSelectedCompetition().subscribe(
        competitionList=>{
          this.competitionList=competitionList;
          // console.log(this.competitionList);
          this.populateForm();
        })
    }

  populateForm(): void {
    if (this.competitionList) {
      this.competitionForm.patchValue({
        code: this.competitionList.code,
        startTime: this.competitionList.startTime,
        endTime: this.competitionList.endTime,
      });
    }
  }

  onSubmit(): void {
    if (this.competitionForm.valid) {
      // Get the updated values from the form
      const updatedCompetition: CompetitionModel = {
        ...this.competitionList,
        ...this.competitionForm.value,
      };
      console.log(updatedCompetition);
      // Call API to update the Competition
      this.competitionService.updateCompetition(updatedCompetition).subscribe(
        () => {
          // this.competitionService.getAll();
          this.router.navigate(['competition']);
        },

      );
    }}

}
