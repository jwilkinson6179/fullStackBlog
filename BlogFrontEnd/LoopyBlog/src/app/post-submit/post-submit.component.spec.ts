import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostSubmitComponent } from './post-submit.component';

describe('PostSubmitComponent', () => {
  let component: PostSubmitComponent;
  let fixture: ComponentFixture<PostSubmitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostSubmitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostSubmitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
