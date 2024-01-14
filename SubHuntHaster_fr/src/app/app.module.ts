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
// import { DialogdisplayerComponent } from './components/pages/competition/dialogdisplayer/dialogdisplayer.component';
import { MatDialogComponent } from './components/pages/competition/mat-dialog/mat-dialog.component';
import {MatButtonModule} from "@angular/material/button";
import {MatDialogModule} from "@angular/material/dialog";
import { MemberListComponent } from './components/pages/member/member-list/member-list.component';
import { MemberCreateComponent } from './components/pages/member/member-create/member-create.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    // CompetitionlistComponent,
    UpdateComponent,
    CreateComponent,
    RankComponent,
    // DialogdisplayerComponent,
    MatDialogComponent,
    MemberListComponent,
    MemberCreateComponent,

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
    MatAutocompleteModule,
    MatDialogModule,
    MatButtonModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
