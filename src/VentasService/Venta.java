/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VentasService;

import Modelo.BaseTableModel;
import ProductosService.Producto;
import VentasService.ProductoDetalle;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Nico
 * 
 * Este modelo solamente es para mantener la informacion
 */
public class Venta implements BaseTableModel {
    private int id;
    private float total = 0;
    private List<ProductoDetalle> detalle;
    private String compradorDNI;
    // TODO: Agregar clase para la informacion del pago
    private PaymentInformation paymentInfo;
    
    public Venta() {
        id = 0;
        total = 0;
        compradorDNI = "";
        detalle = new ArrayList<>();
    }
    
    public Venta(int id, int total, String compradorDNI, List<ProductoDetalle> detalle) {
        this.id = id;
        this.total = total;
        this.compradorDNI = compradorDNI;
        this.detalle = detalle;
    }
    
    /////// ESTA LOGICA DEBERIA ESTAR EN VENTAS-SERVICE
    public void addDetalle(ProductoDetalle prod) {
        this.detalle.add(prod);
        this.total += prod.getTotal();
    }
    
    public void setPaymentInformation(PaymentInformation paymentInfo) {
        this.paymentInfo = paymentInfo;
    }
    
//    public void removeProduct(String codigo) {
//        int indexToRemove = -1;
//        boolean flagRemove = false;
//        
//        // Search across all detail
//        for (int i = 0; i < this.detalle.size(); i++){
//            
//            ProductoDetalle pDetalle = this.detalle.get(i);
//            
//            // Check if code is equals
//            if (pDetalle.getCodigo().equals(codigo)){
//                
//                // If quantity is greater than 1 then we must only decrease quantity
//                // but not remove element
//                if (pDetalle.getCantidad() > 1) {
//                    pDetalle.setCantidad(pDetalle.getCantidad() - 1);
//                    break;
//                }
//                
//                indexToRemove = i;
//                flagRemove = true;
//                break;
//            }
//            
//        }
//        
//        if (flagRemove) {
//            this.total -= this.detalle.get(indexToRemove).getTotal();
//            this.detalle.remove(indexToRemove);
//        } 
//    }
    
    /////////////////////////////////////////////////////////////////////

    public List<ProductoDetalle> getDetalle() {
        return this.detalle;
    }
    
    public void setDetalle(List<ProductoDetalle> detalle) {
        this.detalle = detalle;
    }
    
    public int getId() {
        return id;
    }

    public void setTotal(float total){
        this.total = total;
    }
    
    public float getTotal() {
        return this.total;
    }
    
    public void setCompradorDni(String dni) {
        this.compradorDNI = dni;
    }
    
    public String getCompradorDni() {
        return this.compradorDNI;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Object[] toArray() {
        return new Object[]{
            this.id,
            this.total,
            this.detalle,
            this.compradorDNI
        };
    }
    
    public static final String[] getColumnNames() {
        return new String[]{ "Referencia", "Total", "Detalle", "Comprador DNI" };
    }
}
