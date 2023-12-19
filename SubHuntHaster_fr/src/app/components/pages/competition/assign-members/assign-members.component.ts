import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Member} from "../model/Member";
import {FormControl, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import {MatFormFieldModule} from '@angular/material/form-field';
@Component({
  selector: 'app-assign-members',
  templateUrl: './assign-members.component.html',
  styleUrls: ['./assign-members.component.css'],
  standalone: true,
  imports: [MatFormFieldModule, MatSelectModule, FormsModule, ReactiveFormsModule],
})
export class AssignMembersComponent {
  toppings = new FormControl('');
  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];
  competitionId: string| null = null;
  members: Member[] = [
    {firstName: 'Mary', id: 1},
    {firstName: 'Shelley', id: 2},
    {firstName: 'Igor', id: 3}
  ]; // Populate this array with your list of members

  selectedMembers: Member[] = [];

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.competitionId = params.get('id');
      // Fetch competition details or perform other actions based on competitionId
    });
  }

  // ... other methods

  assignMembers() {

  }
}
