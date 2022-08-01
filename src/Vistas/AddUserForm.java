package Vistas;

import Controlador.CbSucursal;
import Controlador.ControllerSucursalesPuestoTrabajo;
import Controlador.TipoDocumentoEnum;
import Modelo.Conexion;
import Modelo.Sucursal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class AddUserForm extends javax.swing.JDialog {
        
    ControllerSucursalesPuestoTrabajo controller;
    ComboBoxModel modeloEnumTIpoDocumento;
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;
    CbSucursal cbSucursales;
    ArrayList mListaSucursales;
    

    public AddUserForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        modeloEnumTIpoDocumento = new DefaultComboBoxModel(TipoDocumentoEnum.values());
        initComponents();
        this.setLocationRelativeTo(parent);
        cbSucursales = new CbSucursal();
        mListaSucursales = new ArrayList();
        controller = new ControllerSucursalesPuestoTrabajo(this);
        
        

    }


  
    
    public String llenarComboboxSucursales() {
        mListaSucursales = cbSucursales.getListaSucursales();
        Iterator iterator = mListaSucursales.iterator();
        while (iterator.hasNext()) {
            Sucursal sucursal = (Sucursal) iterator.next();
            cbSucursal.addItem(sucursal);

        }
        String nombreSucursal = cbSucursal.getSelectedItem().toString();
        String query = "SELECT idSucursal FROM  `sucursal` WHERE nombreSucursal = '" + nombreSucursal + "';";
        return query;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cbTipoDocumento = new javax.swing.JComboBox<>();
        txtApellidos = new javax.swing.JTextField();
        txtDocumento = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbSucursal = new javax.swing.JComboBox<>();
        btnSubirFoto = new javax.swing.JButton();
        cbPuestoTrabajo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(java.awt.SystemColor.scrollbar);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Nombre(s)");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Apellido(s)");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Tipo de documento");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("Documento");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Correo");

        cbTipoDocumento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbTipoDocumento.setModel(modeloEnumTIpoDocumento);
        cbTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDocumentoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/confirmIcon.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\omens\\Documents\\NetBeansProjects\\Reto1\\src\\assets\\cancelIcon.png")); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Formulario de empleados");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Sucursal");

        cbSucursal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSucursalActionPerformed(evt);
            }
        });

        btnSubirFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/usuario.png"))); // NOI18N

        cbPuestoTrabajo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbPuestoTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPuestoTrabajoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Puesto de trabajo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(148, 148, 148)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(btnGuardar)
                .addGap(62, 62, 62)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtApellidos)
                    .addComponent(cbTipoDocumento, 0, 156, Short.MAX_VALUE)
                    .addComponent(txtDocumento)
                    .addComponent(txtCorreo)
                    .addComponent(cbSucursal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbPuestoTrabajo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(btnSubirFoto)
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPuestoTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(btnSubirFoto))
                .addContainerGap(126, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String nombre = txtNombre.getText();
        String apellido = txtApellidos.getText();
        //Combobox = cbDocumentType[0] = "C.C.", cbDocumentType[1] = "C.E."
        String tipoDocumento = cbTipoDocumento.getSelectedItem().toString();
        String documento = txtDocumento.getText();
        String correo = txtCorreo.getText();
        String nombreSucursal = cbSucursal.getSelectedItem().toString();
        String puestoTrabajo = cbPuestoTrabajo.getSelectedItem().toString();
        String queryIdSucursal =  "SELECT idSucursal, idPuestoTrabajo FROM sucursal INNER JOIN puestotrabajo ON (sucursal.idSucursal = puestotrabajo.FK_idSucursal) WHERE nombreSucursal = '" + nombreSucursal +"'AND nombrePuestoTrabajo ='"+puestoTrabajo+"';";       
        System.out.println(queryIdSucursal);
        //Validar si algunos de los campos no fue diligenciando (Sólo los campos txtfield)
        if (nombre.isEmpty() || apellido.isEmpty() || documento.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hay campos requeridos sin diligenciar", "Formulario registro", JOptionPane.WARNING_MESSAGE);
        } else {

            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(queryIdSucursal);
                while (rs.next()) {
                    int idSucursal = rs.getInt("idSucursal");
                    int idPuestoTrabajo = rs.getInt("idPuestoTrabajo");
                    String queryCrearEmpleado =  "INSERT INTO `empleado`(`nombreEmp`, `apellidos`,`tipoDocumento`, `documento`, `correo`,`FK_idSucursal`, FK_idPuestoTrabajo) VALUES ('"+ nombre + "','" + apellido + "','" + tipoDocumento + "','" + documento + "','" + correo + "'," + idSucursal + "" + "," +idPuestoTrabajo + ");";
                    System.out.println(queryCrearEmpleado);
                    try {
                        
                        st.executeUpdate(queryCrearEmpleado);
                        this.dispose();
                        JOptionPane.showMessageDialog(this, "Registro exitoso", "Nuevo empleado", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, "No se pudo crear el empleado", "Nuevo empleado", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        this.dispose();


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoDocumentoActionPerformed

    private void cbSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSucursalActionPerformed

    private void cbPuestoTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPuestoTrabajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPuestoTrabajoActionPerformed

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
            java.util.logging.Logger.getLogger(AddUserForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUserForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUserForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUserForm.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddUserForm dialog = new AddUserForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSubirFoto;
    public javax.swing.JComboBox<Sucursal> cbPuestoTrabajo;
    public javax.swing.JComboBox<Sucursal> cbSucursal;
    private javax.swing.JComboBox<String> cbTipoDocumento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
