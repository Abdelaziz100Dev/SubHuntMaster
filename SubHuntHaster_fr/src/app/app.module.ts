import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { CompetitionlistComponent } from './components/pages/competition/competitionlist/competitionlist.component';
// import { ModalComponentComponent } from './components/pages/competition/modal/modal.component';
// import { ModalComponent } from './components/pages/competition/modal/modal.component';
import {MdbCheckboxModule} from "mdb-angular-ui-kit/checkbox";
import { UpdateComponent } from './components/pages/competition/update/update.component';
import { CreateComponent } from './components/pages/competition/create/create.component';
import {MatInputModule} from "@angular/material/input";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import { AssignMembersComponent } from './components/pages/competition/assign-members/assign-members.component';
import { RankComponent } from './components/pages/rank/rank.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    // CompetitionlistComponent,
    UpdateComponent,
    CreateComponent,
    RankComponent,
    // AssignMembersComponent,
    // ModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    // NgOptimizedImage,
    BrowserAnimationsModule,
    MdbCheckboxModule,
    MatInputModule,
    MatAutocompleteModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
