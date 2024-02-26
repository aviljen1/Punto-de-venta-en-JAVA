/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductosService;

import Exceptions.StoreException;
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

    @Override
    public Producto Obtener(Producto obj) {
        for (int i=0; i < this.store.size(); i++){
            if (this.store.get(i).getCodigo().equals(obj.getCodigo())){
                return this.store.get(i);
            }
        }
        
        return null;
//        throw new Exception();
        // Este metodo deberia tirar una StoreException
        // Pero si agrego eso no cumple la interfaz
        // modificar la interfaz o cambiar el manejo de errores
        
//        throw new StoreException("No se encuentra el producto con codigo: " + obj.getCodigo());
    }
    
    
    
}
