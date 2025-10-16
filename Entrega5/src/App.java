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
                videoteca.reseteatVideoteca(numeroPeliculas);
                System.out.println ("Sus peliculas han sido borradas");
                System.out.printf("Nuevo tamaño: %d películas %n", videoteca.getPeliculas().length);//no se si esto esta bien

                break;

            case 2:
                System.out.println("no se ha implementado todavia");
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
            int duracionMinutos = Esdia.readInt("Duracion en minutos: ");
            float valoracion = Esdia.readFloat("Valoracion: ", 0, 10);
            String nombre = Esdia.readString("Nombre del director: ");
            String apellidos = Esdia.readString("Apellidos del director: ");
            boolean oscarGanado = Esdia.yesOrNo("Ha ganado un Oscar? (YES/NO): ");

            Pelicula pelicula = Pelicula.crearPeliculaDatosCrudos(titulo, anioEstreno, duracionMinutos, valoracion, nombre, apellidos, oscarGanado);
            //llamar a un mñétodo que añada la película
            if(videoteca.addPelicula(pelicula)){
        System.out.println("Pelicula añadida correctamente");
        } else {
        System.err.println("No se ha podido añadir la pelicula");
        }


            // LLamar a un método que añada la película
            // Informar al usuario si todo ha ido bien 

                
            }

                break;  

            case 4:

                Pelicula [] pelis = videoteca.getPeliculas();
                for (Pelicula p:pelis){
                    if(p!=null){
                        System.out.println(p.ObtenerPeliculaComoFila(videoteca.getVelocidad()));
                    }
                }
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