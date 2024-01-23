/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VentasService;

import Enums.PaymentMethod;

/**
 *
 * @author Nico
 */
public class PaymentInformation {
    private PaymentMethod method;
    
    public PaymentInformation(String method) {
        this.method = PaymentMethod.valueOf(method);
    }
    
}
