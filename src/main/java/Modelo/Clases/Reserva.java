package Modelo.Clases;

import java.time.LocalDateTime;

public class Reserva {
    private int id_socio;
    private int id_ejemplar;
    private LocalDateTime fecha_inicio;
    private LocalDateTime fecha_fin;

    // Constructor
    public Reserva(int id_socio, int id_ejemplar, LocalDateTime fecha_inicio, LocalDateTime fecha_fin) {
        this.id_socio = id_socio;
        this.id_ejemplar = id_ejemplar;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    // Getters y setters
    public int getIdSocio() {
        return id_socio;
    }

    public void setIdSocio(int id_socio) {
        this.id_socio = id_socio;
    }

    public int getIdEjemplar() {
        return id_ejemplar;
    }

    public void setIdEjemplar(int id_ejemplar) {
        this.id_ejemplar = id_ejemplar;
    }

    public LocalDateTime getFechaInicio() {
        return fecha_inicio;
    }

    public void setFechaInicio(LocalDateTime fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDateTime getFechaFin() {
        return fecha_fin;
    }

    public void setFechaFin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
