/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nico
 */
public class MockClienteDAO implements CrudOperations {
    
    private final List<Cliente> ListaCl = new ArrayList();
   
    @Override
    public boolean RegistrarCliente(Cliente cl){
        // ID must be unique and incremental
        cl.setId(this.ListaCl.size()+1);
        this.ListaCl.add(cl);
        return true;
    }
  
    @Override
    public List ListarCliente() {
        return this.ListaCl;
    }
    
    @Override
    public boolean EliminarCliente(int id) {
        for (int i=0; i < this.ListaCl.size(); i++){
            if (this.ListaCl.get(i).getId() == id){
                this.ListaCl.remove(i);
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public boolean ModificarCliente(Cliente cl){
        for(Cliente cl_element: this.ListaCl){
            if(cl_element.getId() == cl.getId()){
                cl_element.update(cl);
                return true;
            }
        }
        
        return false;
    }
}