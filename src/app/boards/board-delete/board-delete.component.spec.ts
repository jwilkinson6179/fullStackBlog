import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardDeleteComponent } from './board-delete.component';

describe('BoardDeleteComponent', () => {
  let component: BoardDeleteComponent;
  let fixture: ComponentFixture<BoardDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BoardDeleteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
