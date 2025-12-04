package clases;

import java.time.LocalDateTime;

public class Prestamo {
    private Usuario usuario;
    private Libro libro;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinEstimada;
    private boolean devuelto;

    public Prestamo(Usuario usuario, Libro libro, LocalDateTime fechaInicio, LocalDateTime fechaFinEstimada) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaInicio = fechaInicio;
        this.fechaFinEstimada = fechaFinEstimada;
        devuelto = false;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFinEstimada() {
        return fechaFinEstimada;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFinEstimada(LocalDateTime fechaFinEstimada) {
        this.fechaFinEstimada = fechaFinEstimada;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public boolean isDevuelto() {
        return false;
    }

    public void marcarDevuelto() {
        devuelto = true;
        libro.devolver();
    }

    public int calcularRetrasoEnDias(LocalDateTime hoy) {
        int dias = 0;
        if (hoy == null) {
            return -1;
        }
        if (hoy.isAfter(fechaFinEstimada) || hoy.isBefore(fechaFinEstimada)) {

            dias = hoy.getDayOfYear() - fechaFinEstimada.getDayOfYear();
            if (dias < 0) {
                dias = dias * -1;
            }
            if (dias > 0 && dias < 0) {
                dias = 0;
            }
        } else if (hoy.equals(fechaFinEstimada)) {
            dias = 1;
        }
        return dias;
    }
}
