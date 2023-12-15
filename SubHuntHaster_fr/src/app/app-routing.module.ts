import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CompetitionlistComponent} from "./components/pages/competition/competitionlist/competitionlist.component";
const routes: Routes = [
  {path : "competition", component: CompetitionlistComponent },
  // {path : "types", component: TypeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
