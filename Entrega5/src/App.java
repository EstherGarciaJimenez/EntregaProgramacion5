import com.coti.tools.DiaUtil;
import com.coti.tools.Esdia;

import modelo.Videoteca;
import modelo.Pelicula;

public class App {
    public static void main(String[] args) throws Exception {
        //DiaUtil.clear(); //Limpia la consola

        Videoteca videoteca = new Videoteca (4);

        boolean continuar = true;
        while (continuar){
        System.out.println("------------------------");
        System.out.println(
            "|----------------------------------------------|\n" +
            "|              MI VIDEOTECA                    |\n" +
            "|----------------------------------------------|\n" +
            "| 1) Nueva videoteca de películas              |\n" +
            "| 2) Configurar velocidad de reproducción      |\n" +
            "| 3) Añadir una nueva película a la videoteca  |\n" +
            "| 4) Mostrar información actual de películas   |\n" +
            "| 5) Salir (se borrará toda la información)    |\n" +
            "|----------------------------------------------|"
        );


        int opcion = Esdia.readInt("Elige una opción (1-5): ", 1, 5); 

        switch (opcion) {
            case 1:
                //TODO: resetear la videoteca con el valor introducido por el usuario
                int numeroPeliculas = Esdia.readInt("Introduzca el nuevo tamaño de video", 1, 100);
                videoteca.resetearVideoteca(numeroPeliculas);
                System.out.println ("Sus peliculas han sido borradas");
                System.out.printf("Nuevo tamaño: %d películas %n", videoteca.getPeliculas().length);

                break;

            case 2:
            // Mostrar velocidad actual y permitir cambiarla
                float nuevaVelocidad;
             do {
            nuevaVelocidad = Esdia.readFloat("Introduce nueva velocidad (>= 0.1): ");
                if (nuevaVelocidad < 0.1f) {
                System.err.println("Valor no válido: la velocidad debe ser al menos 0.1");
                }
            } while (nuevaVelocidad < 0.1f);
                videoteca.setVelocidad(nuevaVelocidad);
                System.out.printf("Velocidad actualizada a %.2f", videoteca.getVelocidad());

                break;

            case 3:
            //comprobar que no este lleno
            if (videoteca.isFull()){
                System.err.println("Videoteca llena!");
            }else{
                System.out.println("Introduzca los datos:");

            //Pedir todos los datos
            String titulo = Esdia.readString("Titulo: ");
            int anioEstreno = Esdia.readInt("Año: ");
            int duracionMinutos;
            do {
            duracionMinutos = Esdia.readInt("Duracion en minutos (entero positivo): ");
                if (duracionMinutos <= 0) {
                    System.err.println("La duración debe ser un número entero positivo. Inténtalo de nuevo.");
                }
            } while (duracionMinutos <= 0);
            float valoracion = Esdia.readFloat("Valoracion: ", 0, 10);
            String nombre = Esdia.readString("Nombre del director: ");
            String apellidos = Esdia.readString("Apellidos del director: ");
            boolean oscarGanado = Esdia.yesOrNo("Ha ganado un Oscar?: ");

            Pelicula pelicula = Pelicula.crearPeliculaDatosCrudos(titulo, anioEstreno, duracionMinutos, valoracion, nombre, apellidos, oscarGanado);
            //llamar a un mñétodo que añada la película
            if(videoteca.addPelicula(pelicula)){
        System.out.println("Pelicula añadida correctamente");
        } else {
        System.err.println("No se ha podido añadir la pelicula");
        }

            // Informar al usuario si todo ha ido bien 

            }

                break;  

            case 4:

                Pelicula [] pelis = videoteca.getPeliculas();
                System.out.println(Pelicula.obtenerCabecera());
                for (Pelicula p:pelis){
                    if(p!=null){
                        System.out.println(p.ObtenerPeliculaComoFila(videoteca.getVelocidad()));
                    }
                
                }
                System.out.println("----------------------------------------------------------------------------------------------------------------|");
                double tiempoTotal = videoteca.tiempoVisionadoTotal();
                double valorMedia = videoteca.valoracionMedia();

                System.out.printf("| Tiempo de visionado total de la videoteca: %.2f min%n", tiempoTotal);
                System.out.printf("| Valoración media: %.2f%n", valorMedia);
                break;  

            case 5:
            System.out.println("Gracias por usar la videoteca. Hasta pronto!");
                continuar = false;
                break;


            default:
                break;
        }

        }





        
    }
}