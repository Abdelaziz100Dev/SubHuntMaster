import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogdisplayerComponent } from './dialogdisplayer.component';

describe('DialogdisplayerComponent', () => {
  let component: DialogdisplayerComponent;
  let fixture: ComponentFixture<DialogdisplayerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DialogdisplayerComponent]
    });
    fixture = TestBed.createComponent(DialogdisplayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
