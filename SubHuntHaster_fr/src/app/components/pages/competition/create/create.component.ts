import {Component, OnInit} from '@angular/core';
import {CompetitionModel} from "../model/competition.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ShareDataService} from "../service/sharedata/share-data.service";
import {CompetitionService} from "../service/competition.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit{
  competitionForm!: FormGroup;

  constructor(private shareDataService: ShareDataService,private formBuilder: FormBuilder,private competitionService: CompetitionService,private router: Router) {

  }

  ngOnInit() {
    this.competitionForm = this.formBuilder.group({
      // Define your form controls based on Competition model
      code: ['', Validators.required],
      date: ['', Validators.required],
      startTime: [null, Validators.required],
      endTime: [null, Validators.required],
      numberOfParticipants: [0, Validators.required],
      location: ['', Validators.required],
      amount: [0, Validators.required],
    });
  }

  onSubmit() {
    // console.log(" llllllllllll");
    if ("this.competitionForm.valid") {
      // Get the updated values from the form
      const updatedCompetition: CompetitionModel = {
        ...this.competitionForm.value,
      };

      this.competitionService.updateCompetition(updatedCompetition).subscribe(
        () => {
          // this.competitionService.getAll();
          this.router.navigate(['competition']).then(r => console.log(r));
          // Do something after API successfully updates Competition
        },

      );
      // Now, you can submit the updatedCompetition to your backend or perform other actions
      console.log(updatedCompetition);
    }

  }
}
