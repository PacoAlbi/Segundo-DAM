import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaPersonasAPIComponent } from './tabla-personas-api.component';

describe('TablaPersonasAPIComponent', () => {
  let component: TablaPersonasAPIComponent;
  let fixture: ComponentFixture<TablaPersonasAPIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TablaPersonasAPIComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TablaPersonasAPIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
