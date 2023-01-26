import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListadoCddComponent } from './listado-cdd.component';

describe('ListadoCddComponent', () => {
  let component: ListadoCddComponent;
  let fixture: ComponentFixture<ListadoCddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListadoCddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListadoCddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
