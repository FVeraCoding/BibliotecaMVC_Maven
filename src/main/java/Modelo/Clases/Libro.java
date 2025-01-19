
package Modelo.Clases;

import java.util.Date;


public class Libro {
    int id;
    String titulo;
    String autor;
    String editorial;
    String genero;
    String ISBN;
    Date anio_publicacion;
    String url;

    public Libro(String titulo, String autor, String editorial, String genero, String ISBN, Date anio_publicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.ISBN = ISBN;
        this.anio_publicacion = anio_publicacion;
    }
    
    

    public Libro(int id, String titulo, String autor, String editorial, String genero, String ISBN, Date anio_publicacion, String url) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.ISBN = ISBN;
        this.anio_publicacion = anio_publicacion;
        this.url = url;
    }

    
    
    
    public Libro(String titulo, String autor, String editorial, String genero, String ISBN, Date anio_publicacion, String url) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.ISBN = ISBN;
        this.anio_publicacion = anio_publicacion;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Date getAnio_publicacion() {
        return anio_publicacion;
    }

    public void setAnio_publicacion(Date anio_publicacion) {
        this.anio_publicacion = anio_publicacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", genero=" + genero + ", ISBN=" + ISBN + ", anio_publicacion=" + anio_publicacion + ", url=" + url + '}';
    }
    
    
    
    
    
    
}
