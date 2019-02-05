import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MgrTableComponent } from './mgr-table.component';

describe('MgrTableComponent', () => {
  let component: MgrTableComponent;
  let fixture: ComponentFixture<MgrTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MgrTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MgrTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
