package modelo;

public class Pelicula {
    
    private String titulo;
    private int anioEstreno;
    private int duracionMinutos;
    private float valoracion;
    private Director director;
//generar getter y setter y un constructor con todos los atributos, dandole a source action

    

    public Pelicula(String titulo, int anioEstreno, int duracionMinutos, float valoracion, Director director) {
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
        this.duracionMinutos = duracionMinutos;
        this.valoracion = valoracion;
        this.director = director;
    }

    public static Pelicula crearPeliculaDatosCrudos(String titulo, int anioEstreno, int duracionMinutos, float valoracion, String nombreDirector, String apellidosDirector, boolean oscarGanado) {
        
        Director director = new Director(nombreDirector, apellidosDirector, oscarGanado);
        return new Pelicula(titulo, anioEstreno, duracionMinutos, valoracion, director);
    }

    public static String obtenerCabecera() {
    return String.format("|%10s|%10s|%21s|%10s|%10s|%10s|",
        "TÍTULO",
        "AÑO ESTRENO",
        "DIRECTOR",
        "OSCAR GANADO",
        "DURACIÓN (MIN)",
        "TIEMPO VISIONADO (MIN)",
        "VALORACIÓN"
    );
}

    public String ObtenerPeliculaComoFila(float velocidad) {
        return String.format("|%10s|%10d|%10s %10s|%10s|%10d|%10.2f|",
            titulo,
            anioEstreno,
            director.getNombre(),
            director.getApellidos(),
            director.haGanadoOscarString(),
            duracionMinutos,
            valoracion
        );
    }



    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getAnioEstreno() {
        return anioEstreno;
    }
    public void setAnioEstreno(int anioEstreno) {
        this.anioEstreno = anioEstreno;
    }
    public int getDuracionMinutos() {
        return duracionMinutos;
    }
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }
    public float getValoracion() {
        return valoracion;
    }
    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }
    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }


}
