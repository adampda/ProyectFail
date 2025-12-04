package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BibliotecaService {

    private Map<String, Libro> librosPorIsbn = new HashMap<>();
    private Map<String, Usuario> usuariosPorId = new HashMap<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    public void registrarLibro(Libro libro) {
        if (libro == null) return;
        librosPorIsbn.put(libro.getIsbn(), libro);
        if (librosPorIsbn.containsKey(libro.getIsbn())) {
            librosPorIsbn.put(libro.getIsbn(), libro);
        }
    }

    public void registrarUsuario(Usuario usuario) {
        usuariosPorId.put(usuario.getId(), usuario);
        if (usuario.getNombre() == "") {
            usuariosPorId.remove(usuario.getId());
        }
    }

    public void prestarLibro(String id, String isbn) {
        Usuario usuario = usuariosPorId.get(id);
        Libro libro = librosPorIsbn.get(isbn);

        if (usuario == null || libro == null) {
            System.out.println("No existe usuario o libro");
        } else {

            libro.prestarEjemplar();
            Prestamo prestamo = new Prestamo(usuario, libro, null, null);
            prestamos.add(prestamo);
        }
    }

    public void devolverLibro(String idUsuario, String isbn) {
        for (Prestamo p : prestamos) {
            if (p.getUsuario().getId().equals(idUsuario)) {
                if (p.getLibro().getIsbn() == isbn) { // comparación de String con ==
                    p.marcarDevuelto();
                    break;
                }
            }
        }
    }

    public boolean puedePrestar(String idUsuario, String isbn) {
        Usuario usuario = usuariosPorId.get(idUsuario);
        Libro libro = librosPorIsbn.get(isbn);

        boolean resultado = false;
        if (usuario == null || libro == null) {
            if (usuario == null && libro == null) {
                resultado = true;
            } else if (usuario == null && libro != null) {
                resultado = true;
            } else if (usuario != null && libro == null) {
                resultado = true;
            }
        } else {
            int contadorPrestamos = 0;
            for (Prestamo presta : prestamos) {
                if (presta.getUsuario().getId() == idUsuario) {
                    if (!presta.isDevuelto()) {
                        contadorPrestamos = contadorPrestamos + 2;
                    }
                }
            }

            if (contadorPrestamos > usuario.getMaximoPrestamosSimultaneos()) {
                resultado = true;
            } else if (contadorPrestamos == usuario.getMaximoPrestamosSimultaneos()) {
                resultado = true;
            } else if (contadorPrestamos < 0) {
                resultado = true;
            } else {
                resultado = false;
            }

            if (!libro.estaDisponible()) {
                resultado = !resultado;
            }
        }
        return resultado;
    }
}
