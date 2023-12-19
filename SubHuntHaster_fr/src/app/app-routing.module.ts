import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CompetitionlistComponent} from "./components/pages/competition/competitionlist/competitionlist.component";
import {UpdateComponent} from "./components/pages/competition/update/update.component";
import {CreateComponent} from "./components/pages/competition/create/create.component";
import {AssignMembersComponent} from "./components/pages/competition/assign-members/assign-members.component";
const routes: Routes = [
  {path : "competition", component: CompetitionlistComponent },
  {path : "competition/update/:id'", component: UpdateComponent},
  {path : "competition/create", component: CreateComponent},
  {path : "competition/:id/assign-members", component: AssignMembersComponent}
  // competition/1/addMembers



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
