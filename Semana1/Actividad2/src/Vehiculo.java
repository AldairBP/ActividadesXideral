public class Vehiculo {

    private String marca;
    private static Vehiculo vehiculo;

    // Se genera un contructor
    private Vehiculo(String modelo) {
        this.marca = modelo;
        System.out.println("La marca del vehículo es: " + this.marca);
    }

    // Se genera el método getInstance
    public static Vehiculo getInstance(String marca) {
        if (vehiculo == null){					//Si la variable de referencia no apunta a un objeto
            vehiculo = new Vehiculo(marca);	//Creamos un objeto
        }
        else{
            System.out.println("El objeto marca "+ marca + " no ha "
            		+ "sido generado dado que ya existe uno");
        }
        //Retorna el valor 
        return vehiculo; 
    }
    
    //getters and setters
	public String getBrand() {
		return marca;
	}

	public void setBrand(String marca) {
		this.marca = marca;
	}
    	
	}