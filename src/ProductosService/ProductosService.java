/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductosService;

import ProductosService.ProductosStore;

import Exceptions.StoreException;
import Exceptions.ValidationException;
import java.util.List;

/**
 *
 * @author Nico
 */
public class ProductosService {
    
    private ProductosStore store = new ProductosStore();
    
    public ProductosService () {}
    
    private void validateProducto(Producto producto) throws ValidationException {
        if (producto.getCantidadInicial() < 0)
            throw new ValidationException("La cantidad inicial no puede ser negativa.");
    
        if (producto.getPrecioUnitario() < 0)
            throw new ValidationException("El precio unitario no puede ser negativo.");
        
        if (producto.getTitulo() == "")
            throw new ValidationException("El titulo del producto no puede ser nulo.");
        
    }
    
    public void add(Producto producto) throws ValidationException, StoreException {
    
        this.validateProducto(producto);
        
        try {
            this.store.Registrar(producto);
        } catch (Exception ex) {
            throw new StoreException(ex.getMessage());
        }
        
    }
    
    public List<Producto> list() throws StoreException {
        try {
            return this.store.Listar();
        } catch (Exception ex) {
            throw new StoreException(ex.getMessage());
        }
    }
    
    public void update(Producto producto) throws ValidationException, StoreException {
    
        this.validateProducto(producto);
        
        try {
            this.store.Modificar(producto);
        } catch (Exception ex) {
            throw new StoreException(ex.getMessage());
        }
        
    }
    
    public void delete(Producto producto) throws ValidationException, StoreException {
        
        try {
            this.store.Eliminar(producto.getId());
        } catch (Exception ex) {
            throw new StoreException(ex.getMessage());
        }
        
    }
    
}
