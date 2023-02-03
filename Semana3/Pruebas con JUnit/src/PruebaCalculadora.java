import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class PruebaCalculadora {
  @Test
  public void pruebaSuma() {
    Calculadora calculadora = new Calculadora();
    double resultado = calculadora.suma(1, 2);
    assertEquals(3, resultado, 0);
  }
  
  @Test
  public void pruebaResta() {
    Calculadora calculadora = new Calculadora();
    double resultado = calculadora.resta(1, 2);
    assertEquals(-1, resultado, 0);
  }
  
  @Test
  public void pruebaMultiplicacion() {
    Calculadora calculadora = new Calculadora();
    double resultado = calculadora.multiplicacion(3, 2);
    assertEquals(6, resultado, 0);
  }
  
  @Test
  public void pruebaDivision() {
    Calculadora calculadora = new Calculadora();
    double resultado = calculadora.division(6, 2);
    assertEquals(3, resultado, 0);
  }
}
