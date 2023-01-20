
public class Triangulo extends Figura implements Perimetro {
	
	public float base;
	public float l1;
	public float l2;
	public float altura;
	
	@Override
	public void area() {
		System.out.println("Para calcular el área es = (base * altura)/2");
	}

	@Override
	public void perimetro() {
		System.out.println("Para calcular el perímetro es = base + lado1 + lado2");	}
	
}
