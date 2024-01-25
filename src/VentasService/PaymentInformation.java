/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VentasService;

import java.time.Instant;
import Enums.PaymentMethod;
import VentasService.PaymentProcessor.CashProcessor;
import VentasService.PaymentProcessor.PaymentProcessor;

/**
 *
 * @author Nico
 */
public class PaymentInformation {
    
    private int timestamp;
    
    private String currency;
    private float amount;
    private String ref;
    private String location;
    
    /**
     TODO:
     * - Para debito y credito la informacion a guardar cambia, contemplar hacer un refactor de los modelos
     */
    
    // Refactorizar esto, la clase paymentinformation
    // no tiene que procesar el pago.
    private PaymentProcessor processor;
    
    public PaymentInformation(String method, String currency, float amount, String ref, String location) {
        this.timestamp = (int) Instant.now().toEpochMilli();
        
        this.currency = currency;
        this.amount = amount;
        this.ref = ref;
        this.location = location;
        
        // En base a este tipo instanciar mediante un strategy
        // un procesador de pago
        
        switch(PaymentMethod.valueOf(method)) {
        
            case Cash: {
                this.processor = new CashProcessor();
                break;
            }
                
            case Debit: {
                this.processor = null;
                break;
            }
            
            case Credit: {
                this.processor = null;
                break;
            }
            
            case PlusPagos: {
                this.processor = null;
                break;
            }
            
        }
    }
    
    public boolean processPayment() {
        
        if(!this.processor.authorize()){
            return false;
        }
        
        return this.processor.processPayment();
    }
    
}
