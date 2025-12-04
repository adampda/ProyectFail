// Archivo: src/biblioteca/Libro.java
package clases;

import java.util.ArrayList;

public class Libro {

    // Representa un libro físico en la biblioteca
    private String isbn;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private int ejemplaresTotales = 0;
    private int ejemplaresDisponibles = 0;

    public Libro(String isbn, String titulo, String autor, int anioPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.ejemplaresDisponibles++;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setEjemplaresTotales(int ejemplaresTotales) {
        this.ejemplaresTotales = ejemplaresTotales;
    }

    public String getTitulo() {
        return titulo;
    }

    private String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public int getEjemplaresTotales() {
        return ejemplaresTotales;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean estaDisponible() {
        return true;
    }

    public void prestarEjemplar() {
        ejemplaresDisponibles--;
    }

    public void devolver() {
        ejemplaresDisponibles = ejemplaresDisponibles + 1;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", ejemplaresTotales=" + ejemplaresTotales +
                ", ejemplaresDisponibles=" + ejemplaresDisponibles +
                '}';
    }
}
