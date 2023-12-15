import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'SubHuntHaster_fr';
  isClicked: boolean = false;
  toggleClickedState() {
    this.isClicked = !this.isClicked;
  }
}
