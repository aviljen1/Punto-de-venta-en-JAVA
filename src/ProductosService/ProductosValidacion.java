/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProductosService;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author adminsti
 */
public class ProductosValidacion {
    
    //Este sirve para permitir solo caracteres
    static public void textKeyPress(KeyEvent evt){
	//declaramos una variable y le asignamos un evento
	char car=evt.getKeyChar();
	if((car< 'a' ||car>'z') && (car<'A' || car> 'Z')
		&& (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)){
		evt.consume();
	}
    }
    //Nos permite solo numeros
    public static void numberKeyPress(KeyEvent evt){
	//declaramos una variable y le asignamos un evento
	char car=evt.getKeyChar();
	if((car < '1' || car >'9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
		evt.consume();
	}
    }
    //Nos permite solo decimales
   public  static void numberDecimalKeyPress(KeyEvent evt, JTextField textField){
	//declaramos una variable y le asignamos un evento
	char car= evt.getKeyChar();
	if((car < '0' || car < '9')  && textField.getText().contains(".") && (car != (char) KeyEvent.VK_BACK_SPACE)){
            evt.consume();
        }else if ((car< '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }
    
    //Validar campos obligatorios:
  public static  int camposObligTxt(JTextField textField,JLabel label,JButton btnSaveProducto, int contador){
       
        if(textField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor ingrese un valor en "+label.getText());
            label.setForeground(Color.RED);
        }else{
            label.setForeground(Color.BLACK);
        }
        if(textField.getText().isEmpty()){
           // btnSaveProducto.setEnabled(false);
            contador=0;
            
        }else{
            //btnSaveProducto.setEnabled(true);
            contador=1;
           
        } return   contador;
    
    }
    
    public static void limpiarProducto(JTextField textField) {//limpia los campos de producto
        textField.setText("");
        
    }
    
    
    
    
      //--------------------------------------------
    
    //Funcion para validar existencia de registro en Jlist
    public static boolean ExisteEnLista(DefaultListModel modelLista, String Dto){
	boolean bandera=false;
	for(int i=0; i<modelLista.getSize(); i++){
		if(modelLista.getElementAt(i).equals(Dto)){
			bandera=true;}}return bandera;}

    //Metodo tipo void para registrar en Lista
    public static int AgregarLista(DefaultListModel modelLista, DefaultListModel modellista1, DefaultListModel modellista2,String cod, String desc, String tit,JList list1, JList list2, JList list3){
	if(!ExisteEnLista(modelLista, cod)){
		modelLista.addElement(cod); 
                modellista1.addElement (desc); 
                modellista2.addElement(tit);
                list1.setModel(modelLista); 
                list2.setModel(modellista1); 
                list3.setModel(modellista2);
                 return 0;    
            
        }else{
	JOptionPane.showMessageDialog(null, "El Producto con el Codigo "+cod+" ya existe", "!Aviso del programa", JOptionPane.WARNING_MESSAGE);
        return 1;
        }
        
    }
    
    
}
