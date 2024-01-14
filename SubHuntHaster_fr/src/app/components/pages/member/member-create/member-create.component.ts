import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MemberService} from "../service/member.service";
import {CompetitionModel} from "../../competition/model/competition.model";

@Component({
  selector: 'app-member-create',
  templateUrl: './member-create.component.html',
  styleUrls: ['./member-create.component.css']
})
// {
//
//   "number": 123,
//   "firstName": "John",
//   "lastName": "Doe",
//   "accessionDate": "2023-01-01",
//   "nationality": "SomeCountry",
//   "identityDocument": "PASSPORT",
//   "identityNumber": "ABC123",
//   "rankings": [],
//   "huntings": []
// }
export class MemberCreateComponent implements OnInit{
  memberForm!: FormGroup;
  constructor(private formBuilder: FormBuilder,private memberService:MemberService) { }
  ngOnInit() {
    this.memberForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      number: ['', Validators.required],
      lastName: ['', Validators.required],
      accessionDate: ['', Validators.required]
    });
  }

  onSubmit() {

      const member: any = {
        ...this.memberForm.value,
      };

      this.memberService.post(member).subscribe(
        () => {

        },

      );
    }
}
