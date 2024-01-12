/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VentasService;

import java.util.List;

/**
 * 
 * @author Nico
 * 
 * Este modelo solamente es para mantener la informacion
 */
public class Venta {
    private int id;
    private float monto;
//    private List<Producto> productos;
    private String compradorDNI;
    // TODO: Agregar clase para la informacion del pago
//    private PaymentInformation paymentInfo;
    
    public Venta() {
        id = 0;
        monto = 0;
        compradorDNI = "";
    }
    
    public Venta(int id, int monto, String compradorDNI) {
        this.id = id;
        this.monto = monto;
        this.compradorDNI = compradorDNI;
    }
    
    public int getId() {
        return id;
    }

    public void setMonto(float monto){
        this.monto = monto;
    }
    
    public float getMonto() {
        return this.monto;
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
}
