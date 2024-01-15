/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductosService;

import Modelo.CrudOperations;
import ProductosService.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nico
 */
public class ProductosStore implements CrudOperations<Producto> {

    private List<Producto> store = new ArrayList<>();
    
    @Override
    public boolean Registrar(Producto cl) {
        cl.setId(this.store.size()+1);
        this.store.add(cl);
        return true;
    }

    @Override
    public List Listar() {
        return this.store;
    }

    @Override
    public boolean Eliminar(int id) {
        for (int i=0; i < this.store.size(); i++){
            if (this.store.get(i).getId() == id){
                this.store.remove(i);
                return true;
            }
        }
        
        return false;
    }

    @Override
    public boolean Modificar(Producto cl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
