/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Exceptions.StoreException;
import Exceptions.ValidationException;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.MockClienteDAO;


import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import VentasService.VentasService;

import ProductosService.Producto;
import ProductosService.ProductosService;
import ProductosService.ProductosValidacion;
import VentasService.ProductoDetalle;
import VentasService.Venta;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.InputMismatchException;
import java.util.Vector;
import java.util.regex.PatternSyntaxException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author JEN
 */
public class Sistema extends javax.swing.JFrame {
//    ClienteDAO client = new ClienteDAO();
//    MockClienteDAO client = new MockClienteDAO();
    int contadorP=0;
    int obligTit=0;
    int obligPrec=0;
    int obligCantI=0;
    int obligCod=0;
    int Borrar=0;
    DefaultTableModel modelo = new DefaultTableModel();
    //Tabla de productos
    
    DefaultListModel listamodeloTitulo=new DefaultListModel();
    DefaultListModel listamodeloDesc=new DefaultListModel();
    DefaultListModel listamodeloCod=new DefaultListModel();
    
    
    JList jList1=new JList();
    JList jList2=new JList();
    JList jList3=new JList();
    
    // Servicio para manejar la creacion y obtencion de ventas
    VentasService ventasService = new VentasService();
    ProductosService productosService = new ProductosService();
    JFrame modalFrame = new JFrame();
    JDialog modalDialog;
    Venta tmpVenta = new Venta();
    
    
    //Boton eliminar:
    JButton botonEliminar = new JButton("btnEliminarpro");
    
    //Para el boton buscar:   
        TableRowSorter trs;

    public Sistema() {
        initComponents();
        this.setLocationRelativeTo(null);
        btnSaveProducto.setEnabled(false);//Este boton al proncipio esta deshabilitado
        txtIdCliente.setVisible(false);
        
        
        
        // Custom model for Products table
        TableProducto.setModel(new DefaultTableModel() {
            String[] columns = Producto.getColumnNames();
        
            @Override 
            public int getColumnCount() { 
                return columns.length; 
            } 

            @Override 
            public String getColumnName(int index) { 
                return columns[index]; 
            } 
        });
        
        // Custom model for Ventas table
        TableVenta.setModel(new DefaultTableModel() {
            String[] columns = ProductoDetalle.getColumnNames();
            
            @Override 
            public int getColumnCount() { 
                return columns.length; 
            } 

            @Override 
            public String getColumnName(int index) { 
                return columns[index]; 
            } 
        });
        
        LoadProductos();
       
    }
    
    public void LoadProductos() {
        List<Object[]> objToAdd = new ArrayList();
        try {
            this.productosService.list().forEach(prod -> objToAdd.add(prod.toArray()));
        } catch (StoreException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }
        
        modelo = (DefaultTableModel) TableProducto.getModel();

        objToAdd.forEach(obj -> modelo.addRow(obj));

        TableProducto.setModel(modelo);        
    }
    
    public void LoadVentas() {
        List<Object[]> objToAdd = new ArrayList();
        
        try {
            this.ventasService.list().forEach(venta -> objToAdd.add(venta.toArray()));
        } catch (StoreException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return;
        }
        
        modelo = (DefaultTableModel) TableVenta.getModel();
        objToAdd.forEach(obj -> modelo.addRow(obj));
        TableVenta.setModel(modelo);
    }
    
    public void LoadDetalle(List<ProductoDetalle> detalle) {
        ClearTableVenta();
        detalle.forEach(prod -> AddDetalleProducto(prod));
    }
    
    public void AddDetalleProducto(ProductoDetalle prodDetalle) {
        Object[] toAdd = prodDetalle.toObject();
        
        modelo = (DefaultTableModel) TableVenta.getModel();
        modelo.addRow(toAdd);
        TableVenta.setModel(modelo);
    }

    public void LimpiarTable() { //para limpiar la tabla para que no se muetsren filas repetidas
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        list1 = new java.awt.List();
        PaymentMethodPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        paymentCashMonto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        paymentCashPago = new javax.swing.JTextField();
        paymentCashVuelto = new javax.swing.JTextField();
        btnCashConfirm = new java.awt.Button();
        paymentCashErrorLabel = new javax.swing.JLabel();
        modalProgressBar = new javax.swing.JPanel();
        progressBarModal = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        menuVentasBtn = new javax.swing.JButton();
        menuProductosBtn = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        principalPanel = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnEliminarventa = new javax.swing.JButton();
        txtCodigoProducto = new javax.swing.JTextField();
        txtCantidadVenta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVenta = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtRucVenta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNombreClienteVenta = new javax.swing.JTextField();
        btnGenerarVenta = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        btnSaveSale = new javax.swing.JButton();
        btnAddProductToSale = new javax.swing.JButton();
        checkboxAplicaIva = new java.awt.Checkbox();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDniCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtTelefonoCliente = new javax.swing.JTextField();
        txtDireccionCliente = new javax.swing.JTextField();
        txtRazonCliente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableCliente = new javax.swing.JTable();
        btnGuardarCliente = new javax.swing.JButton();
        btnEditarCliente = new javax.swing.JButton();
        btnEliminarCliente = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        txtIdCliente = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtRucProveedor = new javax.swing.JTextField();
        txtNombreProveedor = new javax.swing.JTextField();
        txtTelefonoProveedor = new javax.swing.JTextField();
        txtDireccionProveedor = new javax.swing.JTextField();
        txtRazonProveedor = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableProveedor = new javax.swing.JTable();
        btnguardarProveedor = new javax.swing.JButton();
        btnEditarProveedor = new javax.swing.JButton();
        btnEliminarProveedor = new javax.swing.JButton();
        btnNuevoProveedor = new javax.swing.JButton();
        txtIdProveedor = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableVentas = new javax.swing.JTable();
        btnPdfVentas = new javax.swing.JButton();
        txtIdVenta = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField25 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtCodigoPro = new javax.swing.JTextField();
        txtPrecioUni = new javax.swing.JTextField();
        txtCantIni = new javax.swing.JTextField();
        cbxProveedorPro = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableProducto = new javax.swing.JTable();
        btnSaveProducto = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtTit = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        txtCod = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        cbxCatego = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jtxtFiltro = new javax.swing.JTextField();
        btnEliminarpro = new javax.swing.JButton();
        btnEditarpro = new javax.swing.JButton();

        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(list1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );

        jFrame1.getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        paymentCashMonto.setEnabled(false);
        paymentCashMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentCashMontoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Monto");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("Su pago");

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setText("Vuelto");

        paymentCashVuelto.setEnabled(false);

        btnCashConfirm.setBackground(new java.awt.Color(102, 102, 255));
        btnCashConfirm.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnCashConfirm.setForeground(new java.awt.Color(255, 255, 255));
        btnCashConfirm.setLabel("Confirmar");
        btnCashConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCashConfirmActionPerformed(evt);
            }
        });

        paymentCashErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCashConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(paymentCashVuelto))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(paymentCashMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(23, 23, 23)
                                        .addComponent(paymentCashPago, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(paymentCashErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentCashMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(paymentCashPago))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paymentCashErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentCashVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnCashConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Efectivo", jPanel9);

        javax.swing.GroupLayout PaymentMethodPanelLayout = new javax.swing.GroupLayout(PaymentMethodPanel);
        PaymentMethodPanel.setLayout(PaymentMethodPanelLayout);
        PaymentMethodPanelLayout.setHorizontalGroup(
            PaymentMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        PaymentMethodPanelLayout.setVerticalGroup(
            PaymentMethodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Registrando operacion, aguarde...");

        javax.swing.GroupLayout modalProgressBarLayout = new javax.swing.GroupLayout(modalProgressBar);
        modalProgressBar.setLayout(modalProgressBarLayout);
        modalProgressBarLayout.setHorizontalGroup(
            modalProgressBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modalProgressBarLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(modalProgressBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBarModal, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        modalProgressBarLayout.setVerticalGroup(
            modalProgressBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, modalProgressBarLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBarModal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 0, 204));
        jPanel2.setForeground(new java.awt.Color(51, 0, 204));

        menuVentasBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nventa.png"))); // NOI18N
        menuVentasBtn.setText("Nueva venta");
        menuVentasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVentasBtnActionPerformed(evt);
            }
        });

        menuProductosBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        menuProductosBtn.setText("Productos");
        menuProductosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuProductosBtnActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/compras.png"))); // NOI18N
        jButton5.setText("Ventas");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/config.png"))); // NOI18N
        jButton6.setText("Config");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuVentasBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuProductosBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(menuVentasBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menuProductosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap(264, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 650));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/encabezado.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, -10, 1020, 200));

        jLabel3.setText("Codigo");

        jLabel5.setText("Cantidad");

        btnEliminarventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarventaActionPerformed(evt);
            }
        });

        TableVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(TableVenta);
        if (TableVenta.getColumnModel().getColumnCount() > 0) {
            TableVenta.getColumnModel().getColumn(0).setPreferredWidth(30);
            TableVenta.getColumnModel().getColumn(1).setPreferredWidth(100);
            TableVenta.getColumnModel().getColumn(2).setPreferredWidth(30);
            TableVenta.getColumnModel().getColumn(3).setPreferredWidth(30);
            TableVenta.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("DNI/RUC");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("NOMBRE");

        txtNombreClienteVenta.setEditable(false);

        btnGenerarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/print.png"))); // NOI18N
        btnGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarVentaActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/money.png"))); // NOI18N
        jLabel10.setText("Total a pagar");

        LabelTotal.setText("----");

        btnSaveSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnSaveSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSaleActionPerformed(evt);
            }
        });

        btnAddProductToSale.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N
        btnAddProductToSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductToSaleActionPerformed(evt);
            }
        });

        checkboxAplicaIva.setLabel("Aplica IVA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(btnAddProductToSale)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarventa)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRucVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtNombreClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSaveSale, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerarVenta)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkboxAplicaIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(LabelTotal)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidadVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminarventa)
                            .addComponent(btnAddProductToSale, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRucVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSaveSale, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenerarVenta))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkboxAplicaIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );

        principalPanel.addTab("Ventas", jPanel1);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("DNI/RUC:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Nombre:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Telefono:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Direccion:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Razon Social:");

        txtDniCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniClienteActionPerformed(evt);
            }
        });

        txtDireccionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionClienteActionPerformed(evt);
            }
        });

        txtRazonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonClienteActionPerformed(evt);
            }
        });

        TableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI/RUC", "NOMBRE", "TELEFONO", "DIRECCION", "RAZON SOCIAL"
            }
        ));
        TableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableCliente);
        if (TableCliente.getColumnModel().getColumnCount() > 0) {
            TableCliente.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableCliente.getColumnModel().getColumn(1).setPreferredWidth(50);
            TableCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
            TableCliente.getColumnModel().getColumn(3).setPreferredWidth(50);
            TableCliente.getColumnModel().getColumn(4).setPreferredWidth(80);
            TableCliente.getColumnModel().getColumn(5).setPreferredWidth(80);
        }

        btnGuardarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnGuardarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClienteActionPerformed(evt);
            }
        });

        btnEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnEditarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });

        btnEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarClienteActionPerformed(evt);
            }
        });

        btnNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N
        btnNuevoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });

        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15)))
                    .addComponent(jLabel16))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnGuardarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNuevoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDireccionCliente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRazonCliente)
                            .addComponent(txtDniCliente, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRazonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardarCliente)
                            .addComponent(btnEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevoCliente))))
                .addGap(24, 24, 24))
        );

        principalPanel.addTab("tab2", jPanel3);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("RUC:");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("NOMBRE:");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("TELEFONO:");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("DIRECCION:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("RAZON SOCIAL:");

        TableProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUC", "NOMBRE", "TELEFONO", "DIRECCION", "RAZON SOCIAL"
            }
        ));
        jScrollPane3.setViewportView(TableProveedor);
        if (TableProveedor.getColumnModel().getColumnCount() > 0) {
            TableProveedor.getColumnModel().getColumn(0).setPreferredWidth(40);
            TableProveedor.getColumnModel().getColumn(1).setPreferredWidth(100);
            TableProveedor.getColumnModel().getColumn(2).setPreferredWidth(50);
            TableProveedor.getColumnModel().getColumn(3).setPreferredWidth(80);
            TableProveedor.getColumnModel().getColumn(4).setPreferredWidth(70);
        }

        btnguardarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N

        btnEditarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N

        btnEliminarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N

        btnNuevoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRazonProveedor)
                            .addComponent(txtDireccionProveedor)
                            .addComponent(txtNombreProveedor)
                            .addComponent(txtTelefonoProveedor)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtRucProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnguardarProveedor)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditarProveedor))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnEliminarProveedor)
                                .addGap(18, 18, 18)
                                .addComponent(btnNuevoProveedor)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtRucProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtTelefonoProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtDireccionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtRazonProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEditarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnguardarProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevoProveedor))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        principalPanel.addTab("tab3", jPanel4);

        TableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CLIENTE", "VENDEDOR", "TOTAL"
            }
        ));
        jScrollPane5.setViewportView(TableVentas);
        if (TableVentas.getColumnModel().getColumnCount() > 0) {
            TableVentas.getColumnModel().getColumn(0).setPreferredWidth(20);
            TableVentas.getColumnModel().getColumn(1).setPreferredWidth(60);
            TableVentas.getColumnModel().getColumn(2).setPreferredWidth(60);
            TableVentas.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        btnPdfVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnPdfVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPdfVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdVenta))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        principalPanel.addTab("tab5", jPanel6);

        jLabel27.setText("RUC");

        jLabel28.setText("NOMBRE");

        jLabel29.setText("TELEFONO");

        jLabel30.setText("DIRECCION");

        jLabel31.setText("RAZON SOCIAL");

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        jButton23.setText("ACTUALIZAR");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel32.setText("DATOS DE LA EMPRESA");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(166, 166, 166))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel27)
                        .addGap(215, 215, 215)
                        .addComponent(jLabel28)
                        .addGap(201, 201, 201)
                        .addComponent(jLabel29))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel30)
                        .addGap(200, 200, 200)
                        .addComponent(jLabel31))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(jButton23))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jLabel32)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel32)
                .addGap(68, 68, 68)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jButton23)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        principalPanel.addTab("tab6", jPanel7);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("ID: ");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Precio Unitario:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Cantidad inicial:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Titulo:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Proveedor:");

        txtCodigoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProActionPerformed(evt);
            }
        });
        txtCodigoPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoProKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProKeyTyped(evt);
            }
        });

        txtPrecioUni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioUniActionPerformed(evt);
            }
        });
        txtPrecioUni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioUniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioUniKeyTyped(evt);
            }
        });

        txtCantIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantIniActionPerformed(evt);
            }
        });
        txtCantIni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantIniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantIniKeyTyped(evt);
            }
        });

        cbxProveedorPro.setEditable(true);
        cbxProveedorPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "proveedor uno", "proveedor dos", "proveedor tres" }));
        cbxProveedorPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProveedorProActionPerformed(evt);
            }
        });

        TableProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PREC UNI", "CANT INIC", "TITULO", "DESCRIPCION", "CODIGO", "PROVEEDOR", "CATEGORIA", "ESTADO"
            }
        ));
        jScrollPane4.setViewportView(TableProducto);
        if (TableProducto.getColumnModel().getColumnCount() > 0) {
            TableProducto.getColumnModel().getColumn(0).setPreferredWidth(50);
            TableProducto.getColumnModel().getColumn(1).setPreferredWidth(100);
            TableProducto.getColumnModel().getColumn(2).setPreferredWidth(40);
            TableProducto.getColumnModel().getColumn(3).setPreferredWidth(50);
            TableProducto.getColumnModel().getColumn(4).setPreferredWidth(60);
            TableProducto.getColumnModel().getColumn(5).setPreferredWidth(100);
            TableProducto.getColumnModel().getColumn(6).setPreferredWidth(60);
            TableProducto.getColumnModel().getColumn(7).setPreferredWidth(60);
        }

        btnSaveProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/GuardarTodo.png"))); // NOI18N
        btnSaveProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveProductoActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setText("Descripcion:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel34.setText("Categoria:");

        txtTit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitActionPerformed(evt);
            }
        });
        txtTit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTitKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTitKeyTyped(evt);
            }
        });

        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });
        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescKeyTyped(evt);
            }
        });

        txtCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodActionPerformed(evt);
            }
        });
        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodKeyTyped(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel35.setText("Codigo");

        cbxCatego.setEditable(true);
        cbxCatego.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Limpieza", "Alimento", "Lacteos", "Textil", " " }));
        cbxCatego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoActionPerformed(evt);
            }
        });

        jLabel11.setText("FILTRAR (Titulo o Codigo)");

        jtxtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtFiltroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantIni, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel22))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCodigoPro, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(txtPrecioUni)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCod)
                                    .addComponent(txtDesc)
                                    .addComponent(cbxProveedorPro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxCatego, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel26)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(btnSaveProducto)
                                .addGap(8, 8, 8)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(32, 32, 32)
                        .addComponent(jtxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(206, 206, 206))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtCodigoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtPrecioUni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cbxProveedorPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34)
                    .addComponent(cbxCatego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSaveProducto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        principalPanel.addTab("Productos", jPanel5);

        getContentPane().add(principalPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 930, 470));

        btnEliminarpro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnEliminarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarproActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminarpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 270, -1, 32));

        btnEditarpro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Actualizar (2).png"))); // NOI18N
        btnEditarpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarproActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditarpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 320, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuVentasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVentasBtnActionPerformed
        // TODO add your handling code here:

        principalPanel.setSelectedIndex(0);
        this.tmpVenta = new Venta();
    }//GEN-LAST:event_menuVentasBtnActionPerformed

    // TODO add your handling code here:
//        // TODO add your handling code here:
//        if (!"".equals(txtIdCliente.getText())) {
//            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar");
//            if (pregunta == 0) {
//                int id = Integer.parseInt(txtIdCliente.getText());
//                client.EliminarCliente(id);
//                LimpiarTable();
//                LimpiarCliente();
//                ListarCliente();
//            }
//        }
//        // TODO add your handling code here:
//        if ("".equals(txtIdCliente.getText())) {
//            JOptionPane.showMessageDialog(null, "seleccione una fila");
//        } else {
//            try {
//                Cliente cl = new Cliente();
//                cl.setDni(txtDniCliente.getText());
//                cl.setNombre(txtNombreCliente.getText());
//                cl.setTelefono(txtTelefonoCliente.getText());
//                cl.setDireccion(txtDireccionCliente.getText());
//                cl.setRazon(txtRazonCliente.getText());
//                cl.setId(Integer.parseInt(txtIdCliente.getText()));
//                client.ModificarCliente(cl);
//                //JOptionPane.showMessageDialog(null, "Cliente Modificado");
//                LimpiarTable();
//                LimpiarCliente();
//                ListarCliente();
//            } catch (ValidationException ex) {
//                JOptionPane.showMessageDialog(null, ex.getMessage());
//            }
//        }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         // JEN
        principalPanel.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed


    private void menuProductosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuProductosBtnActionPerformed
        // TODO add your handling code here:
        principalPanel.setSelectedIndex(5);
    }//GEN-LAST:event_menuProductosBtnActionPerformed


    
    private void btnSaveProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveProductoActionPerformed
        // JENI
        try {
       
            cbxProveedorPro.addItem("Proveedor 1");
            cbxProveedorPro.addItem("Proveedor 2");
            cbxProveedorPro.addItem("Proveedor 3");
            
            cbxCatego.addItem("Limpieza");
            cbxCatego.addItem("Alimento");
            cbxCatego.addItem("Lacteos");
            cbxCatego.addItem("Textil");
            cbxCatego.addItem("Cocina");

            int id = Integer.parseInt(txtCodigoPro.getText());
            float precioUnitario = Float.parseFloat(txtPrecioUni.getText());
            int cantidadInicial = Integer.parseInt(txtCantIni.getText());
            String titulo = txtTit.getText();
            String descripcion= txtDesc.getText();
            String codigo = txtCod.getText(); 
            String proveedor=cbxProveedorPro.getSelectedItem().toString();
            String categoria= cbxCatego.getSelectedItem().toString();
            String estado;
            if (Borrar==1){
                estado="DESHABILITADO";
                System.out.println("Se deshabilito!");
            }else{
                estado="HABILITADO";
            }
            
            //Verifica si se repite codigo:
           if( ProductosValidacion.AgregarLista( listamodeloCod, listamodeloDesc,listamodeloTitulo,  codigo, descripcion, titulo, jList1, jList2, jList3)==0){
                Producto nuevoProducto = new Producto(id, precioUnitario, cantidadInicial, titulo, descripcion,codigo,proveedor,categoria,estado);
                 this.productosService.add(nuevoProducto);
                 LimpiarTable();
                 LoadProductos();
                 Limpiarproducto();
             
            JOptionPane.showMessageDialog(null, "Producto Registrado");  
           }else{
            JOptionPane.showMessageDialog(null, "Por favor ingrese un producto valido");
             Limpiarproducto();
           }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error:Ingresar un valor");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
       

    }//GEN-LAST:event_btnSaveProductoActionPerformed

    private void txtCodigoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProActionPerformed


    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        // TODO add your handling code here:
        LimpiarCliente();
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarClienteActionPerformed
      
    }//GEN-LAST:event_btnEliminarClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
      
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnGuardarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClienteActionPerformed
       
    }//GEN-LAST:event_btnGuardarClienteActionPerformed

    private void TableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableClienteMouseClicked
        // TODO add your handling code here:
        int fila = TableCliente.rowAtPoint(evt.getPoint());
        txtIdCliente.setText(TableCliente.getValueAt(fila, 0).toString());
        txtDniCliente.setText(TableCliente.getValueAt(fila, 1).toString());
        txtNombreCliente.setText(TableCliente.getValueAt(fila, 2).toString());
        txtTelefonoCliente.setText(TableCliente.getValueAt(fila, 3).toString());
        txtDireccionCliente.setText(TableCliente.getValueAt(fila, 4).toString());
        txtRazonCliente.setText(TableCliente.getValueAt(fila, 5).toString());
    }//GEN-LAST:event_TableClienteMouseClicked

    private void txtRazonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRazonClienteActionPerformed

    private void txtDireccionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionClienteActionPerformed

    private void txtDniClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniClienteActionPerformed

    private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerarVentaActionPerformed
    
    private void initializeModal() {
        modalFrame.setAlwaysOnTop(true); //Esto nos permite que el jFrame sea un modal
        modalFrame.setLocationRelativeTo(null);
        modalFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        modalFrame.setVisible(true);
    }
    
    private void btnSaveSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSaleActionPerformed
        
        initializeModal();
        
        // Casteo a string
        paymentCashMonto.setText(this.tmpVenta.getTotal() + "");
        
        // Inicializamos el modal
        modalFrame.getContentPane().add(PaymentMethodPanel);
        modalFrame.pack();
        modalFrame.setVisible(true);
        
        // Esto se ejecuta cada vez que se ingresa informacion en el textbox
        paymentCashPago.addKeyListener(new KeyListener() {
            @Override
            public void keyReleased(KeyEvent e) {
                
                if (paymentCashPago.getText().equals("")) {
                    return;
                }
                
                paymentCashErrorLabel.setText("");
                paymentCashPago.setBorder(new LineBorder(Color.GRAY, 1));
                
                Float pago = Float.parseFloat(paymentCashPago.getText());

                if (pago < tmpVenta.getTotal()) {
                    paymentCashErrorLabel.setForeground(Color.RED);
                    paymentCashErrorLabel.setText("El pago es menor al monto a pagar.");
                    paymentCashPago.setBorder(new LineBorder(Color.RED, 2));
                    return;
                }
                
                float diff = pago - tmpVenta.getTotal();

                if (diff < 0) {
                    paymentCashPago.setBorder(new LineBorder(Color.RED, 2));
                    return;
                }
                
                paymentCashVuelto.setText(diff + "");
            }

            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {}
        });
    }//GEN-LAST:event_btnSaveSaleActionPerformed

    private void btnAddProductToSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductToSaleActionPerformed
        // TODO add your handling code here:
        
        // Cuando agregamos dos veces el mismo producto deberiamos agrupar las dos entradas
        // en lugar de que aparezcan repetidos
        
        int cantidad;
        String codigoBarras = txtCodigoProducto.getText();
        
        if (!txtCantidadVenta.getText().equals("")){
            cantidad = Integer.parseInt(txtCantidadVenta.getText());
        } else {
            cantidad = 1;
        }
        
        try {
            Producto prodFound = this.productosService.fetch(codigoBarras);
            
            ProductoDetalle detalle = this.ventasService.createDetalle(prodFound, cantidad);
            
            this.AddDetalleProducto(detalle);
            
            // Add detail to tmp sale
            this.tmpVenta.addDetalle(detalle);
            
            LabelTotal.setText(String.valueOf(this.tmpVenta.getTotal()));
            
            ClearVentaInputs();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_btnAddProductToSaleActionPerformed

    public void ClearVentaInputs() {
        txtCodigoProducto.setText("");
        txtCantidadVenta.setText("");
    }
    
    private void btnEliminarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarventaActionPerformed
        // TODO add your handling code here:
        
        String codigoBarras = txtCodigoProducto.getText();
        
        if (codigoBarras.equals("")){
            return;
        }
        
        int cantidad;
        
        if (!txtCantidadVenta.getText().equals("")){
            cantidad = Integer.parseInt(txtCantidadVenta.getText());
        } else {
            cantidad = 1;
        }
        
        for (int i = 0; i < cantidad; i++){
            this.tmpVenta = this.ventasService.removeProductoFromDetalle(this.tmpVenta, codigoBarras);
        }
        
//        AddDetalleProducto(this.tmpVenta.getDetalle());
        this.LoadDetalle(this.tmpVenta.getDetalle());
        
        // Update amount
        String valorVenta = String.valueOf(this.tmpVenta.getTotal());
        if (valorVenta.equals("0")) {
            LabelTotal.setText("----");
        } else {
            LabelTotal.setText(valorVenta);
        }
        
        ClearVentaInputs();
    }//GEN-LAST:event_btnEliminarventaActionPerformed

    private void paymentCashMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentCashMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentCashMontoActionPerformed

    private void btnCashConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashConfirmActionPerformed
        // TODO add your handling code here:
        modalFrame.setVisible(false);
        
        initializeModal();
        
        // Casteo a string
        paymentCashMonto.setText(this.tmpVenta.getTotal() + "");
        
        // Inicializamos el modal
        modalFrame.getContentPane().add(modalProgressBar);
        modalFrame.pack();
        modalFrame.setVisible(true);
        
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ventasService.add(tmpVenta, "Cash");
                } catch (Exception ex) {
                    // Handle
                }
            }
        });
        
        newThread.run();
        
        // TODO: La barra de progreso no se actualiza y se ve todo negro
        // fixme
        progressBarModal.setIndeterminate(true);
        try{
            newThread.join();
        } catch (Exception ex) {
        
        }
        
        modalFrame.setVisible(false);
        
        // Limpiar tabla e inputs
    }//GEN-LAST:event_btnCashConfirmActionPerformed

    public void ClearTableVenta() {
        DefaultTableModel dtm = (DefaultTableModel) TableVenta.getModel();
        dtm.setRowCount(0);
    }
    
    //
            

    private void cbxProveedorProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProveedorProActionPerformed
        // TODO add your handling code here:
    /* cbxProveedorPro.addItem("Proveedor 1");
    cbxProveedorPro.addItem("Proveedor 2");
    cbxProveedorPro.addItem("Proveedor 3");*/
        
    }//GEN-LAST:event_cbxProveedorProActionPerformed

    private void txtPrecioUniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioUniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioUniActionPerformed

    private void txtCantIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantIniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantIniActionPerformed

    private void txtTitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitActionPerformed

    private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescActionPerformed

    private void txtCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodActionPerformed

    private void txtCodigoProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProKeyTyped
        // TODO add your handling code here:
        ProductosValidacion.numberKeyPress(evt);
    }//GEN-LAST:event_txtCodigoProKeyTyped

    private void txtPrecioUniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUniKeyTyped
        // TODO add your handling code here:
        ProductosValidacion.numberDecimalKeyPress(evt, txtPrecioUni);
    }//GEN-LAST:event_txtPrecioUniKeyTyped

    private void txtCantIniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantIniKeyTyped
        // TODO add your handling code here:
        ProductosValidacion.numberKeyPress(evt);
    }//GEN-LAST:event_txtCantIniKeyTyped

    private void txtTitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitKeyTyped
        // TODO add your handling code here:
        ProductosValidacion.textKeyPress(evt);
    }//GEN-LAST:event_txtTitKeyTyped

    private void txtDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyTyped
        // TODO add your handling code here:
        ProductosValidacion.textKeyPress(evt);
    }//GEN-LAST:event_txtDescKeyTyped

    private void txtCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyTyped
        // TODO add your handling code here:

       ProductosValidacion.numberKeyPress(evt);
    }//GEN-LAST:event_txtCodKeyTyped

    private void txtTitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTitKeyReleased
        // Valida el campo obligatorio Titulo
     
        obligTit=ProductosValidacion.camposObligTxt(txtTit,jLabel25, btnSaveProducto, contadorP); 
            if(obligPrec==1 && obligTit==1 && obligCantI==1 && obligCod==1){
                btnSaveProducto.setEnabled(true);
                
        }else{
            btnSaveProducto.setEnabled(false);
        }
    }//GEN-LAST:event_txtTitKeyReleased

    private void txtPrecioUniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUniKeyReleased
        // Valida el campo obligatorio Precio
        
        obligPrec=ProductosValidacion.camposObligTxt(txtPrecioUni,jLabel23, btnSaveProducto, contadorP);
        if(obligPrec==1 && obligTit==1 && obligCantI==1 && obligCod==1){
            btnSaveProducto.setEnabled(true);
             
        }else{
            btnSaveProducto.setEnabled(false);
        }
     
    }//GEN-LAST:event_txtPrecioUniKeyReleased

    private void txtCantIniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantIniKeyReleased
        // Valida el campo obligatorio Cantidad
        obligCantI=ProductosValidacion.camposObligTxt(txtCantIni,jLabel24, btnSaveProducto, contadorP);
        if(obligPrec==1 && obligTit==1 && obligCantI==1 && obligCod==1 ){
            btnSaveProducto.setEnabled(true);
            
        }else{
            btnSaveProducto.setEnabled(false);
        }
    }//GEN-LAST:event_txtCantIniKeyReleased

    private void txtCodKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyReleased
        // Valida el campo obligatorio Codigo de barra
        obligCod= ProductosValidacion.camposObligTxt(txtCod,jLabel35, btnSaveProducto, contadorP);
        if(obligPrec==1 && obligTit==1 && obligCantI==1 && obligCod==1 ){
            btnSaveProducto.setEnabled(true);
            
        }else{
            btnSaveProducto.setEnabled(false);
        }  
    }//GEN-LAST:event_txtCodKeyReleased

    private void txtCodigoProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProKeyReleased
         if(obligPrec==1 && obligTit==1 && obligCantI==1 && obligCod==1 ){
            btnSaveProducto.setEnabled(true);
            
        }else{
            btnSaveProducto.setEnabled(false);
        }      
    }//GEN-LAST:event_txtCodigoProKeyReleased

    private void txtDescKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyReleased
         if(obligPrec==1 && obligTit==1 && obligCantI==1 && obligCod==1 ){
            btnSaveProducto.setEnabled(true);
            
        }else{
            btnSaveProducto.setEnabled(false);
        }      
    }//GEN-LAST:event_txtDescKeyReleased

    private void txtCodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodKeyPressed

    private void cbxCategoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoActionPerformed
    
    
    private void btnEliminarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarproActionPerformed

   /*Esto lo que hace es deshabilitar no lo elimina de la BD sino que setea el Estado en DESHABILITADO y
        lo saca de la tabla visible pero no lo elimina de la BD.
   */
   
    int[] rows = TableProducto.getSelectedRows();
    DefaultTableModel model = (DefaultTableModel) TableProducto.getModel();
    StringBuilder productosEliminadosBuilder = new StringBuilder(); // Usamos StringBuilder para construir la cadena de productos eliminados
    int l = 0;

    for (int i = rows.length - 1; i >= 0; i--) {
        int rowIndex = TableProducto.convertRowIndexToModel(rows[i]);
        for (int j = 0; j < model.getColumnCount(); j++) {
            Object valorCelda = model.getValueAt(rowIndex, j);
            if (j == 3) {
                productosEliminadosBuilder.append(valorCelda.toString()).append(", "); // Agregamos el valor de la celda seguido de una coma y un espacio a la cadena
                l++;
            }
        }
    }

    String productosEliminados = productosEliminadosBuilder.toString(); // Convertimos el StringBuilder a String

    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar los productos: " + productosEliminados + "?");

    if (confirmacion == JOptionPane.YES_OPTION) {
    // Eliminar las filas seleccionadas
        for (int i = rows.length - 1; i >= 0; i--) {
            int rowIndex = TableProducto.convertRowIndexToModel(rows[i]);
            model.removeRow(rowIndex);
            Borrar=1;
        }
    }else {
         // No hacer nada
         Borrar=0;
    }

    if (confirmacion == JOptionPane.YES_OPTION) {
        JOptionPane.showMessageDialog(null, "Se deshabilitaron los productos: " + productosEliminados);
    } else {
        JOptionPane.showMessageDialog(null, "Operación cancelada. No se deshabilitaron productos.");
    }

    }//GEN-LAST:event_btnEliminarproActionPerformed

    private void jtxtFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtFiltroKeyTyped
        // Filtra por la columna 3  
    /*jtxtFiltro.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            try {
                int columnaAFiltrar = 3; // Cambiar a la columna deseada para el filtro
                trs.setRowFilter(RowFilter.regexFilter(jtxtFiltro.getText(), columnaAFiltrar));
            } catch (PatternSyntaxException ex) {
                // Manejar excepción si la expresión regular es inválida
                System.out.println(ex);
            } catch (IllegalArgumentException ex) {
                // Manejar excepción si la columna especificada no existe
                System.out.println(ex);
            }
        }
    });
    
    trs = new TableRowSorter(modelo);
    TableProducto.setRowSorter(trs);
*/
        //FILTRA POR LA COLUMNA 3 Y 5:
                                    
        // Agregar un KeyListener al campo de filtro
        /*jtxtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    // Definir las columnas a filtrar (en este caso, las columnas 3 y 5)
                    int[] columnasAFiltrar = {3, 5};
                
                    // Crear una lista de RowFilter para cada columna
                    List<RowFilter<Object, Object>> filters = new ArrayList<>();
                    for (int columna : columnasAFiltrar) {
                        filters.add(RowFilter.regexFilter(jtxtFiltro.getText(), columna));
                    }
                
                // Combinar los filtros en un RowFilter compuesto
                RowFilter<Object, Object> combinedFilter = RowFilter.orFilter(filters);
                
                // Aplicar el filtro a la tabla
                trs.setRowFilter(combinedFilter);
                } catch (PatternSyntaxException ex) {
                    // Manejar excepción si la expresión regular es inválida
                    System.out.println(ex);
                } catch (IllegalArgumentException ex) {
                    // Manejar excepción si alguna de las columnas especificadas no existe
                    System.out.println(ex);
                }
            }
        });
    
        // Crear un TableRowSorter y aplicarlo a la tabla
         trs = new TableRowSorter(modelo);
         TableProducto.setRowSorter(trs);
*/
        
        
        //ACA ADEMAS DE FILTRAR POR LAS COLUMNAS 3 Y 5 TAMBIEN HACEMOS QUE NO SEA SENSIBLE A MAY Y MIN:
                                   
        // Agregar un KeyListener al campo de filtro
        jtxtFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    // Definir las columnas a filtrar (en este caso, las columnas 3 y 5)
                    int[] columnasAFiltrar = {3, 5};
                
                    // Crear una lista de RowFilter para cada columna
                    List<RowFilter<Object, Object>> filters = new ArrayList<>();
                    for (int columna : columnasAFiltrar) {
                        // Crear un filtro que ignore la distinción entre mayúsculas y minúsculas
                        RowFilter<Object, Object> filter = RowFilter.regexFilter("(?i)" + jtxtFiltro.getText(), columna);
                        filters.add(filter);
                    }
                
                    // Combinar los filtros en un RowFilter compuesto
                    RowFilter<Object, Object> combinedFilter = RowFilter.orFilter(filters);
                
                    // Aplicar el filtro a la tabla
                    trs.setRowFilter(combinedFilter);
                } catch (PatternSyntaxException ex) {
                    // Manejar excepción si la expresión regular es inválida
                    System.out.println(ex);
                } catch (IllegalArgumentException ex) {
                    // Manejar excepción si alguna de las columnas especificadas no existe
                    System.out.println(ex);
                }
            }
        });
    
        // Crear un TableRowSorter y aplicarlo a la tabla
        trs = new TableRowSorter(modelo);
        TableProducto.setRowSorter(trs);




    }//GEN-LAST:event_jtxtFiltroKeyTyped

    private void btnEditarproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarproActionPerformed
                                                                                   
    // Obtener fila seleccionada
    int filaSeleccionada = TableProducto.getSelectedRow();
    
    // Verificar si hay una fila seleccionada
    if (filaSeleccionada != -1) {
        // Obtener los valores de la fila seleccionada
               // Obtener los valores de la fila seleccionada
            String proveedor = TableProducto.getValueAt(filaSeleccionada, 6).toString();
            String categoria = TableProducto.getValueAt(filaSeleccionada, 7).toString();
            // Crear una instancia de Detalle
            Detalle detalle = new Detalle(this, true);
        
            // Mostrar la ventana Detalle
             detalle.setVisible(true);
        
             // Cuando la ventana Detalle se cierra, obtener los nuevos valores ingresados
                // y actualizar la fila correspondiente en la tabla TableProducto
               detalle.addWindowListener(new java.awt.event.WindowAdapter() {
               @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                if (detalle.getAceptado()) { // Si el usuario hizo clic en "Aceptar"
                    // Obtener los nuevos valores ingresados desde la ventana Detalle
                    String id = detalle.ID.getText();
                    String precioUni = detalle.PrecioUni.getText();
                    String cantIni = detalle.CantInici.getText();
                    String titulo = detalle.Titulo.getText();
                    String desc = detalle.Desc.getText();
                    String cod = detalle.Cod.getText();
                    String nuevoProveedor = detalle.getProveedorSeleccionado();
                    String nuevaCategoria = detalle.getCategoriaSeleccionada();
                    
                    // Actualizar la fila correspondiente en la tabla TableProducto
                    TableProducto.setValueAt(id, filaSeleccionada, 0);
                    TableProducto.setValueAt(precioUni, filaSeleccionada, 1);
                    TableProducto.setValueAt(cantIni, filaSeleccionada, 2);
                    TableProducto.setValueAt(titulo, filaSeleccionada, 3);
                    TableProducto.setValueAt(desc, filaSeleccionada, 4);
                    TableProducto.setValueAt(cod, filaSeleccionada, 5);
                    TableProducto.setValueAt(nuevoProveedor, filaSeleccionada, 6);
                    TableProducto.setValueAt(nuevaCategoria, filaSeleccionada, 7);
                }
            }
        });
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila para editar.");
    }



        
    
    
    
    
    
    
           
        
        
        
    }//GEN-LAST:event_btnEditarproActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Sistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JPanel PaymentMethodPanel;
    private javax.swing.JTable TableCliente;
    private javax.swing.JTable TableProducto;
    private javax.swing.JTable TableProveedor;
    private javax.swing.JTable TableVenta;
    private javax.swing.JTable TableVentas;
    private javax.swing.JButton btnAddProductToSale;
    private java.awt.Button btnCashConfirm;
    private javax.swing.JButton btnEditarCliente;
    private javax.swing.JButton btnEditarProveedor;
    private javax.swing.JButton btnEditarpro;
    private javax.swing.JButton btnEliminarCliente;
    private javax.swing.JButton btnEliminarProveedor;
    private javax.swing.JButton btnEliminarpro;
    private javax.swing.JButton btnEliminarventa;
    private javax.swing.JButton btnGenerarVenta;
    private javax.swing.JButton btnGuardarCliente;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnNuevoProveedor;
    private javax.swing.JButton btnPdfVentas;
    private javax.swing.JButton btnSaveProducto;
    private javax.swing.JButton btnSaveSale;
    private javax.swing.JButton btnguardarProveedor;
    private javax.swing.JComboBox<String> cbxCatego;
    private javax.swing.JComboBox<String> cbxProveedorPro;
    private java.awt.Checkbox checkboxAplicaIva;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jtxtFiltro;
    private java.awt.List list1;
    private javax.swing.JButton menuProductosBtn;
    private javax.swing.JButton menuVentasBtn;
    private javax.swing.JPanel modalProgressBar;
    private javax.swing.JLabel paymentCashErrorLabel;
    private javax.swing.JTextField paymentCashMonto;
    private javax.swing.JTextField paymentCashPago;
    private javax.swing.JTextField paymentCashVuelto;
    private javax.swing.JTabbedPane principalPanel;
    private javax.swing.JProgressBar progressBarModal;
    private javax.swing.JTextField txtCantIni;
    private javax.swing.JTextField txtCantidadVenta;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtCodigoPro;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtDireccionCliente;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtDniCliente;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtIdVenta;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreClienteVenta;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtPrecioUni;
    private javax.swing.JTextField txtRazonCliente;
    private javax.swing.JTextField txtRazonProveedor;
    private javax.swing.JTextField txtRucProveedor;
    private javax.swing.JTextField txtRucVenta;
    private javax.swing.JTextField txtTelefonoCliente;
    private javax.swing.JTextField txtTelefonoProveedor;
    private javax.swing.JTextField txtTit;
    // End of variables declaration//GEN-END:variables
    private void LimpiarCliente() {//limpia los campos
        txtIdCliente.setText("");
        txtDniCliente.setText("");
        txtNombreCliente.setText("");
        txtTelefonoCliente.setText("");
        txtDireccionCliente.setText("");
        txtRazonCliente.setText("");
    }
     private void Limpiarproducto() {//limpia los campos
        txtCodigoPro.setText("");
        txtPrecioUni.setText("");
        txtCantIni.setText("");
        txtTit.setText("");
        txtDesc.setText("");
       txtCod.setText("");
      
    }
}
