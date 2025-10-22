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

        // devuelve el tiempo total de visionado (minutos) usando la velocidad actual
    public double tiempoVisionadoTotal() {
        double total = 0.0;
        for (int i = 0; i < contador; i++) {
            Pelicula p = peliculas[i];
            if (p != null) {
                total += p.tiempoVisionado(this.velocidad);
            }
        }
        return total;
    }

   // devuelve la valoración media 
    public double valoracionMedia() {
        if (contador == 0) return 0;
        int reales = 0;
        double suma = 0;
        for (int i = 0; i < contador; i++) {
            Pelicula p = peliculas[i];
            if (p != null) {
                 suma += p.getValoracion(); reales++; 
                }
        }
        return  suma / reales;
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
