import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaEventos } from './lista-eventos';

describe('ListaEventos', () => {
  let component: ListaEventos;
  let fixture: ComponentFixture<ListaEventos>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaEventos]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaEventos);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
