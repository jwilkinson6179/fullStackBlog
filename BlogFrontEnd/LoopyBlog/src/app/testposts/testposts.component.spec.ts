import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestpostsComponent } from './testposts.component';

describe('TestpostsComponent', () => {
  let component: TestpostsComponent;
  let fixture: ComponentFixture<TestpostsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestpostsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestpostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
