import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonneesMeteoComponent } from './donnees-meteo.component';

describe('DonneesMeteoComponent', () => {
  let component: DonneesMeteoComponent;
  let fixture: ComponentFixture<DonneesMeteoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DonneesMeteoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DonneesMeteoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
