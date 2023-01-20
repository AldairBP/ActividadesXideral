
public class Circulo extends Figura implements Perimetro{

	public float radio;
	
	@Override
	public void area() {
		System.out.println("Para calcular el área es = (radio)^2 * pi");

	}

	@Override
	public void perimetro() {
		System.out.println("Para calcular el perímetro es = (radio) * 2 * pi");
		
	}
}