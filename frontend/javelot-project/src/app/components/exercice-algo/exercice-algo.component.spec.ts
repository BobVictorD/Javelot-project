import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciceAlgoComponent } from './exercice-algo.component';

describe('ExerciceAlgoComponent', () => {
  let component: ExerciceAlgoComponent;
  let fixture: ComponentFixture<ExerciceAlgoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExerciceAlgoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExerciceAlgoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
