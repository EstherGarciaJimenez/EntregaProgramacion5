package modelo;

public class Videoteca {

    private Pelicula[] peliculas;
    
    private int contador;
    private float velocidad;
    //añadir getter y setter


    public Videoteca(int numeroPeliculas) {
        videoteca = 1.0f;
        peliculas = new Pelicula[numeroPeliculas];
        pelicula =newPelicula[numeroPeliculas];

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
    
}
