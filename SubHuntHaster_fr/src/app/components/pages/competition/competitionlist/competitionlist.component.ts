import {AfterViewInit, ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import {CompetitionService} from "../service/competition.service";
import {CompetitionModel} from "../model/competition.model";
import {ShareDataService} from "../service/sharedata/share-data.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {Observable} from "rxjs";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import {AsyncPipe, CommonModule} from "@angular/common";
import {Member} from "../model/Member";
import {map, startWith} from 'rxjs/operators';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {AssignMembersComponent} from "../assign-members/assign-members.component";


@Component({
  selector: 'app-competitionlist',
  templateUrl: './competitionlist.component.html',
  styleUrls: ['./competitionlist.component.css'],
  standalone: true,
  imports: [
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    AsyncPipe,
    CommonModule,
    MatTableModule,
    MatPaginatorModule,
    AssignMembersComponent
  ],
})
export class CompetitionlistComponent implements OnInit,AfterViewInit  {
  displayedColumns: string[] = ['id', 'code', 'startTime', 'status', 'endTime', 'actions'];
  dataSource = new MatTableDataSource<CompetitionModel>();

  //-----
  competitionList: CompetitionModel[] = [];
  competitionForm!: FormGroup;
  myControl = new FormControl<string | Member>('');
  options: Member[] = [{firstName: 'Mary'}, {firstName: 'Shelley'}, {firstName: 'Igor'}];
  filteredOptions: any;


  constructor( private  competitionService: CompetitionService,private  shareDataService: ShareDataService,private router: Router) {

  }
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }
  ngOnInit(): void {
    this.getCompetitions(0,5);
    // this.filteredOptions = this.myControl.valueChanges.pipe(
    //   startWith(''),
    //   map(value => {
    //     const firstName = typeof value === 'string' ? value : value?.firstName;
    //     return firstName ? this._filter(firstName as string) : this.options.slice();
    //   }),
    // );

  }

  onPageChange(event: any) {
    const page = event.pageIndex;
    const size = event.pageSize;
    console.log('page', page);
    this.getCompetitions(page, size);
  }
  public  getCompetitions(page:number, size:number){
    this.competitionService.getAll(page, size).subscribe(
      data => {
        const competitions = data.competitions;
        const pageable = data.pageable;
        console.log('competitions', competitions);


        this.competitionList = competitions;
        this.dataSource = new MatTableDataSource<CompetitionModel>(this.competitionList);
        this.dataSource.paginator = this.paginator;
        // this.competitionList=data[8];
        // this.dataSource =  new MatTableDataSource<CompetitionModel>(competitions);
        // this.dataSource.paginator = this.paginator;
      },
      error => {
        console.error('Error fetching competitions', error);
      }
      );
  }

  deleteCompetition(competition: any) {
    this.competitionService.deleteCompetition(competition).subscribe(
      () => {
        this.getCompetitions(0,4);
      }
    )
  }

  onEditButtonClick(competition: CompetitionModel): void {
    this.shareDataService.setSelectedCompetition(competition);
    this.router.navigate(['competition/update', competition.id]);
  }
  create() {
    this.router.navigate(['competition/create']);
  }

  displayFn(user: Member): string {
    return user && user.firstName ? user.firstName : '';
  }

  // private _filter(firstName: string): Member[] {
  //   const filterValue = firstName.toLowerCase();
  //
  //   return this.options.filter(option => option.firstName.toLowerCase().includes(filterValue));
  // }

  addMembers(competition: CompetitionModel) {
    this.shareDataService.setSelectedCompetition(competition);
    this.router.navigate(['competition', competition.id, 'assign-members']);




  }
}


// export interface PeriodicElement {
//   name: string;
//   position: number;
//   weight: number;
//   symbol: string;
// }
//
// const ELEMENT_DATA: CompetitionModel[] = [];
