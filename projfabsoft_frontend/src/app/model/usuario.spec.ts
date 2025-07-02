import { Usuario } from './usuario';

describe('Usuario', () => {
  it('should create an instance', () => {
    expect(new Usuario(1, 'Test User', 'test@example.com')).toBeTruthy();
  });
});