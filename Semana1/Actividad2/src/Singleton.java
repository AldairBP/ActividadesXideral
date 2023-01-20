
public class Singleton {

	public static void main(String[] args) {
		   Vehiculo ModelS = Vehiculo.getInstance("Tesla");
		   Vehiculo ModelX = Vehiculo.getInstance("Tesla");
	        
	        // En estas lineas comprobamos que pertenecen al mismo objeto
	        System.out.println("La marca del Model S es " + ModelS.getBrand());
	        System.out.println("La marca del Model X es " + ModelX.getBrand());
	        // Comprobamos por el metodo equals
	        System.out.println("Comprobamos según el resultado de "
	        		+ "aplicar el método equals() = " + 
	        		ModelS.getBrand().equals(ModelX.getBrand()));
	}

}
