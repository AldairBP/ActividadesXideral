
public class Cuadrado extends Figura implements Perimetro{
	
	public float lado;
	
	@Override
	public void area() {
		
		System.out.println("Para calcular el área es = lado * 4");
	}

	@Override
	public void perimetro() {
		
		System.out.println("Para calcular el perímetro es = lado * 4");	}
	
	
}
