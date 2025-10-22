package modelo;

public class Videoteca {

    private Pelicula[] peliculas;
    
    private int contador;
    private float velocidad;
    //añadir getter y setter


    public Videoteca(int numeroPeliculas) {
        this.velocidad = 1.0f; 
        this.peliculas = new Pelicula[numeroPeliculas];
        this.contador = 0; // Inicializa contador

    }

   

    //MÉTODOS DE LÓGICA DE NEGOCIOS (CRUD)
    public boolean addPelicula(Pelicula p) {
        if (!isFull()){
            peliculas[contador] = p;
            contador++;
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull(){
        if (peliculas.length == contador){
            return true;
        } else {
            return false;
        }
    }
    
    
     public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public Pelicula[] getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Pelicula[] peliculas) {
        this.peliculas = peliculas;
    }

    public void resetearVideoteca(int numeroPeliculas) {
        peliculas = new Pelicula[numeroPeliculas];
        contador = 0;
    }
     public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }
    
}
