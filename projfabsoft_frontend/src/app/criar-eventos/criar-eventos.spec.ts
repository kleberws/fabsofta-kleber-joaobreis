import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CriarEventosComponent } from './criar-eventos';
import { RouterTestingModule } from '@angular/router/testing';

describe('CriarEventosComponent', () => {
  let component: CriarEventosComponent;
  let fixture: ComponentFixture<CriarEventosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        CriarEventosComponent, // Standalone component
        RouterTestingModule    // Import necessário por causa do routerLink e Router
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(CriarEventosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
