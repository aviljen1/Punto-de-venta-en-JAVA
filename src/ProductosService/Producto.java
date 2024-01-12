/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductosService;

/**
 *
 * @author Nico
 */
public class Producto {

    private int id;
    private float precioUnitario;
    private int cantidadInicial;
    private String titulo;
    private String descripcion = null;
    
    // TODO: Convertir en enum
    private String categoria;
    
    public Producto() {
        id = 0;
        precioUnitario = 0;
        cantidadInicial = 0;
        titulo = "";
        descripcion = "";
    }
    
    public Producto(int id, float precioUnitario, int cantidadInicial, String titulo, String descripcion) {
        this.id = id;
        this.precioUnitario = precioUnitario;
        this.cantidadInicial = cantidadInicial;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
    public int getId() {
        return id;
    }

    public void setPrecioUnitario(float precioUnitario){
        this.precioUnitario = precioUnitario;
    }
    
    public float getPrecioUnitario() {
        return this.precioUnitario;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(int cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
