/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author Nico
 */
interface CrudOperations {
    boolean RegistrarCliente(Cliente cl);
    List ListarCliente();
    boolean EliminarCliente(int id);
    boolean ModificarCliente(Cliente cl);
}