import clases.BibliotecaService;
import clases.Libro;
import clases.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {
    private static BibliotecaService servicio = new BibliotecaService();
    private static final Scanner sc = new Scanner(System.in);
    private static ArrayList<Libro> libros = new ArrayList<>();

    public static void main(String[] argumentos) {
        ejecutarMenu();
    }

    private static void ejecutarMenu() {
        boolean correcto;
        do {
            imprimirMenu();
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    registrarLibroDesdeConsola();
                    correcto = true;
                    break;
                case 2:
                    registrarUsuarioDesdeConsola();
                    correcto = true;
                    break;
                case 3:
                    prestarLibroDesdeConsola();
                    correcto = true;
                    break;
                case 4:
                    devolverLibroDesdeConsola();
                    correcto = true;
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    correcto = false;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (correcto);

        sc.close();
    }

    private static void imprimirMenu() {
        System.out.println("=== GESTIÓN BIBLIOTECA ===");
        System.out.println("1. Registrar libro");
        System.out.println("2. Registrar usuario");
        System.out.println("3. Prestar libro");
        System.out.println("4. Devolver libro");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }

    private static void registrarLibroDesdeConsola() {

        System.out.print("ISBN: ");
        String isbn = sc.next();
        System.out.print("Título: ");
        String titulo = sc.next();
        System.out.print("Autor: ");
        String autor = sc.next();
        System.out.print("Año publicación: ");
        int anio = sc.nextInt();

        Libro libro = new Libro(isbn, titulo, autor, anio);
        libros.add(libro);

        if (libros.contains(libro)) {
            libro.setEjemplaresTotales(libro.getEjemplaresTotales() + 1);
        } else {
            libros.add(libro);
        }

    }

    private static void registrarUsuarioDesdeConsola() {
        System.out.print("ID usuario: ");
        String id = sc.next();
        System.out.print("Nombre: ");
        String nombre = sc.next();

        Usuario usuario = new Usuario(id, nombre);
        servicio.registrarUsuario(usuario);
    }

    private static void prestarLibroDesdeConsola() {
        System.out.print("ID usuario: ");
        String id = sc.next();
        System.out.print("ISBN libro: ");
        String isbn = sc.next();

        servicio.prestarLibro(id, isbn);
    }

    private static void devolverLibroDesdeConsola() {
        System.out.print("ID usuario: ");
        String id = sc.next();
        System.out.print("ISBN libro: ");
        String isbn = sc.next();

        servicio.devolverLibro(id, isbn);
    }
}
