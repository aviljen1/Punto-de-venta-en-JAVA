/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VentasService;

import VentasService.VentasStore;
import VentasService.Venta;
import Utils.Validator;
import Exceptions.ValidationException;
import Exceptions.StoreException;
import ProductosService.Producto;
import java.util.List;

/**
 *
 * @author Nico
 * 
 * Este servicio se encarga de toda la logica de negocio relacionada a las ventas
 * validacion de informacion y creacion de ventas
 */

public class VentasService {
    private VentasStore store = new VentasStore();
    
    // Agregar logica de negocio y validacion de informacion
    
    public VentasService() {
    
    }
    
    private void validateVenta(Venta venta) throws ValidationException, StoreException {
        if (!Validator.isDniValid(venta.getCompradorDni()))
            throw new ValidationException("El dni no es valido.");
        
        if (venta.getMonto() < 0.0)
            throw new ValidationException("El monto no puede ser negativo.");
    }
    
    private float calculateIva(float amount, float ivaPercentage) {
        return amount * (float) (ivaPercentage / 100.0);
    }
    
    public ProductoDetalle createDetalle(Producto found, int cantidad, float ivaPercentage) {
        float subtotal = found.getPrecioUnitario() * cantidad;
        float total = subtotal + this.calculateIva(subtotal, ivaPercentage);
        return new ProductoDetalle(found, cantidad, 0, subtotal, ivaPercentage, total);
    }
    
    public void add(Venta venta) throws ValidationException, StoreException {
        
        this.validateVenta(venta);
        
        // Procesar pago
        // Enviar informacion para facturacion etc
        
        try {
            this.store.Registrar(venta);
        } catch(Exception ex) {
            throw new StoreException(ex.getMessage());
        }
        
    }
    
//    public void delete(Venta venta) {
//        // Eliminar una venta implica que se pierda registro de esa transaccion
//        // No puede ocurrir
//    }
    
    public void update(Venta venta) throws ValidationException, StoreException {
        this.validateVenta(venta);
        
        try {
            this.store.Modificar(venta);
        } catch(Exception ex) {
            throw new StoreException(ex.getMessage());
        }
    }
    
    public List<Venta> list() throws StoreException {
        try {
            return this.store.Listar();
        } catch(Exception ex) {
            throw new StoreException(ex.getMessage());
        }
    }
    
}
