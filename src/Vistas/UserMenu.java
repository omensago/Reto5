package Vistas;

import Controlador.*;
import Modelo.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author omens
 */
public class UserMenu extends javax.swing.JFrame {

    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;
    DefaultTableModel contenidoTablaEmpleados, contenidoTablaDepartamento;
    ComboBoxModel enumDepartamentos, enumZonas, enumTipoCalles;

    public UserMenu() {
        enumDepartamentos = new DefaultComboBoxModel(EnumDepartamento.values());
        enumZonas = new DefaultComboBoxModel(EnumZona.values());
        enumTipoCalles = new DefaultComboBoxModel(EnumTipoCalle.values());
        initComponents();
        this.setLocationRelativeTo(this);
        listarEmpleados();
        listarDepartamentos();
    }

    private void listarEmpleados() {

        String filtroBusqueda = txtSearch.getText();
        if (filtroBusqueda.isEmpty()) {
            String queryConsulta = "SELECT nombreEmp,apellidos,tipoDocumento,documento,correo, nombreSucursal FROM empleado INNER JOIN sucursal ON empleado.FK_idSucursal = sucursal.idSucursal";
            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(queryConsulta);
                Object[] empleados = new Object[6];
                contenidoTablaEmpleados = (DefaultTableModel) tblEmpleados.getModel();
                while (rs.next()) {
                    empleados[0] = rs.getString("nombreEmp");
                    empleados[1] = rs.getString("apellidos");
                    empleados[2] = rs.getString("tipoDocumento");
                    empleados[3] = rs.getString("documento");
                    empleados[4] = rs.getString("correo");
                    empleados[5] = rs.getString("nombreSucursal");
                    contenidoTablaEmpleados.addRow(empleados);
                    tblEmpleados.setModel(contenidoTablaEmpleados);
                }
            } catch (SQLException e) {
                System.out.println("Error");
            }
        } else {
            String queryConsulta = "SELECT nombreEmp,apellidos,tipoDocumento,documento,correo, nombreSucursal FROM empleado INNER JOIN sucursal WHERE empleado.FK_idSucursal = sucursal.idSucursal AND nombreEmp LIKE '%" + filtroBusqueda + "%' OR apellidos LIKE '%" + filtroBusqueda + "%'";
            System.out.println(queryConsulta);
            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(queryConsulta);
                Object[] empleados = new Object[6];
                contenidoTablaEmpleados = (DefaultTableModel) tblEmpleados.getModel();
                while (rs.next()) {
                    empleados[0] = rs.getString("nombreEmp");
                    empleados[1] = rs.getString("apellidos");
                    empleados[2] = rs.getString("tipoDocumento");
                    empleados[3] = rs.getString("documento");
                    empleados[4] = rs.getString("correo");
                    empleados[5] = rs.getString("nombreSucursal");
                    contenidoTablaEmpleados.addRow(empleados);
                    tblEmpleados.setModel(contenidoTablaEmpleados);
                }
            } catch (SQLException e) {
                System.out.println("Error");
            }
        }

    }

    private void listarDepartamentos() {

        String filtro = txtSearchSucursal.getText();
        if (filtro.isEmpty()) {

            String query = "SELECT nombreSucursal, nombreDepartamento, CONCAT( 'Zona ', zona, '. ',tipoCalle, ' ', numero1,' #No. ',numero2, ' - ', numero3) AS direccion FROM direccion INNER JOIN sucursal WHERE idDireccion = FK_idDireccion AND nombreDepartamento LIKE '%"+  filtro +"%' ORDER BY nombreDepartamento;";
                System.out.println(query);
            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Object[] departamento = new Object[3];
                contenidoTablaDepartamento = (DefaultTableModel) tblDepartamentos.getModel();

                while (rs.next()) {
                    departamento[0] = rs.getString("nombreSucursal");
                    departamento[1] = rs.getString("nombreDepartamento");
                    departamento[2] = rs.getString("direccion");
                    contenidoTablaDepartamento.addRow(departamento);
                    tblDepartamentos.setModel(contenidoTablaDepartamento);

                }
            } catch (SQLException e) {
                System.out.println("Error");
            }
        } else {
            String query = "SELECT nombreSucursal, nombreDepartamento, CONCAT( 'Zona ', zona, '. ',tipoCalle, ' ', numero1,' #No. ',numero2, ' - ', numero3) AS direccion FROM direccion INNER JOIN sucursal WHERE idDireccion = FK_idDireccion AND nombreDepartamento LIKE '%"+ filtro+ "%' ORDER BY nombreDepartamento;";

            try {
                connection = conexion.getConnection();
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Object[] departamento = new Object[3];
                contenidoTablaDepartamento = (DefaultTableModel) tblDepartamentos.getModel();
                while (rs.next()) {
                    departamento[0] = rs.getString("nombreSucursal");
                    departamento[1] = rs.getString("nombreDepartamento");
                    departamento[2] = rs.getString("direccion");
                    contenidoTablaDepartamento.addRow(departamento);
                    tblDepartamentos.setModel(contenidoTablaDepartamento);

                }

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    private void borrarDatosTablaDepartamentos() {
        for (int i = 0; i < tblDepartamentos.getRowCount(); i++) {
            //Eliminamos todos los registros de departamentos que tiene la tabla
            contenidoTablaDepartamento.removeRow(i);
            i = i - 1;
        }
        txtNumero1.setText("");
        txtNumero2.setText("");
        txtNumero3.setText("");
        cbDepartamento.setSelectedIndex(0);
        cbCalle.setSelectedIndex(0);
        cbZona.setSelectedIndex(0);
    }

    private void borrarRegistrosTabla() {
        for (int i = 0; i < tblEmpleados.getRowCount(); i++) {
            //Eliminamos todos los registros de empleados que tiene la tabla
            contenidoTablaEmpleados.removeRow(i);
            i = i - 1;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbZona = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbDepartamento = new javax.swing.JComboBox<>();
        cbCalle = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtNumero2 = new javax.swing.JTextField();
        txtNumero1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtNumero3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDepartamentos = new javax.swing.JTable();
        txtSearchSucursal = new javax.swing.JTextField();
        btnBusquedaSucursales = new javax.swing.JButton();
        btnPuestosTrabajo = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnAddUser = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(java.awt.SystemColor.scrollbar);

        cbZona.setModel(enumZonas);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Zona");

        cbDepartamento.setModel(enumDepartamentos);

        cbCalle.setModel(enumTipoCalles);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Tipo calle");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("-");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("#");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/confirmIcon.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Departamento");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(cbDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(44, 44, 44)
                                        .addComponent(jLabel6))
                                    .addComponent(cbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10)
                        .addGap(41, 41, 41)
                        .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9)
                        .addGap(42, 42, 42)
                        .addComponent(txtNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtNumero3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addContainerGap())
        );

        tblDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sucursal", "Departamento", "Dirección"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartamentosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDepartamentos);

        btnBusquedaSucursales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        btnBusquedaSucursales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaSucursalesActionPerformed(evt);
            }
        });

        btnPuestosTrabajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/userlogin.png"))); // NOI18N
        btnPuestosTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuestosTrabajoActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(txtSearchSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnBusquedaSucursales)
                            .addGap(228, 228, 228))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane2)
                            .addGap(18, 18, 18)
                            .addComponent(btnPuestosTrabajo)
                            .addGap(34, 34, 34)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSearchSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(btnBusquedaSucursales, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnPuestosTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sucursales", jPanel2);

        jPanel1.setBackground(java.awt.SystemColor.scrollbar);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre(s)", "Apellido(s)", "Tipo documento", "Documento", "Correo", "Sucursal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        btnAddUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/user.png"))); // NOI18N
        btnAddUser.setText("Añadir");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Empleados");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Mision TIC 2022");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Nombre");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(227, 227, 227)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(245, 245, 245)
                                        .addComponent(jLabel1)))
                                .addGap(85, 377, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddUser))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jTabbedPane1.addTab("Empleados", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed

        // Creamos una instancia del diálogo
        AddUserForm addUserForm = new AddUserForm(this, rootPaneCheckingEnabled);
        addUserForm.setVisible(true);

        //Actualizacion de la informacion
        borrarRegistrosTabla();
        listarEmpleados();

    }//GEN-LAST:event_btnAddUserActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked

        // capturar el numero de fila seleccionado
        int row = tblEmpleados.getSelectedRow();
        System.out.println("Fila seleccionada" + row);
        //Validar si el usuario no ha seleccionado una fila
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un empleado.", "", JOptionPane.WARNING_MESSAGE);
        } else {

            //Tener en cuenta que los datos de la tabla estan en tipo Object
            //fila 0 columna 1= nombre empleado
            String nombre = tblEmpleados.getValueAt(row, 0).toString();
            String apellidos = tblEmpleados.getValueAt(row, 1).toString();
            String tipoDocumento = tblEmpleados.getValueAt(row, 2).toString();
            String documento = tblEmpleados.getValueAt(row, 3).toString();
            String correo = tblEmpleados.getValueAt(row, 4).toString();
            String sucursal = tblEmpleados.getValueAt(row, 5).toString();
            System.out.println(", empleado: " + nombre + " " + apellidos
                    + ", tipo documento" + tipoDocumento + ", numero: " + documento
                    + ", correo: " + correo + "sucursal: " + sucursal);
            //Instanciamos el JDialog para mostrar la informacion del empleado seleccionado
            ShowUserForm showUserForm = new ShowUserForm(this, true);
            //cargamos la informacion
            showUserForm.recibeDatos(nombre, tipoDocumento, apellidos, documento, correo, sucursal);
            //se hace visible
            showUserForm.setVisible(true);
            //Actualizamos la informacion de la tabla en caso de que se hubiese editado el empleado
            borrarRegistrosTabla();
            listarEmpleados();

        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarRegistrosTabla();
        listarEmpleados();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Guardar informacion de sucursales

        String deparmentoOption = cbDepartamento.getSelectedItem().toString();
        String zonaOption = cbZona.getSelectedItem().toString();
        String tipoCalleOption = cbCalle.getSelectedItem().toString();
        String numero1 = txtNumero1.getText();
        String numero2 = txtNumero2.getText();
        String numero3 = txtNumero3.getText();

        if (deparmentoOption != "Seleccionaunaopcion" && tipoCalleOption != "Seleccionaunaopcion" && zonaOption != "Seleccionaunaopcion" && !numero1.isEmpty() && !numero2.isEmpty() && !numero3.isEmpty()){
           SucursalForm sucursalForm = new SucursalForm(this, true);
           sucursalForm.setVisible(true);
           sucursalForm.recibeDatosDireccion(deparmentoOption, zonaOption, tipoCalleOption, numero1, numero2, numero3 );
           
           borrarDatosTablaDepartamentos();
           listarDepartamentos();
           
        }else{
            
            JOptionPane.showMessageDialog(this, " Faltan campos por diligenciar.", "", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBusquedaSucursalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaSucursalesActionPerformed
        borrarDatosTablaDepartamentos();
        listarDepartamentos();

    }//GEN-LAST:event_btnBusquedaSucursalesActionPerformed

    private void btnPuestosTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuestosTrabajoActionPerformed
        PuestosTrabajoForm puestosTrabajoForm = new PuestosTrabajoForm(this, true);
        puestosTrabajoForm.setVisible(true);
       
    }//GEN-LAST:event_btnPuestosTrabajoActionPerformed

    private void tblDepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartamentosMouseClicked

        int row = tblDepartamentos.getSelectedRow();
        String sucursal = (String) tblDepartamentos.getValueAt(row, 0);
        System.out.println(sucursal);
        String departamento = (String) tblDepartamentos.getValueAt(row, 1);
        String queryIdSucursal = "SELECT idSucursal FROM `sucursal` INNER JOIN `direccion` WHERE FK_idDireccion = idDireccion AND nombreSucursal = '" + sucursal + "';";
        try {
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(queryIdSucursal);
            while (rs.next()) {
                int idSucursal = rs.getInt("idSucursal");
                GestionarSucursalesForm gestionarSucursal = new GestionarSucursalesForm(this, true);
                gestionarSucursal.recibirDatosSucursal(idSucursal);
                gestionarSucursal.setVisible(true);
            }
            borrarDatosTablaDepartamentos();
            listarDepartamentos();
            }catch (SQLException e) {
                System.out.println(e);
            }
    }//GEN-LAST:event_tblDepartamentosMouseClicked

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
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnBusquedaSucursales;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPuestosTrabajo;
    private javax.swing.JComboBox<String> cbCalle;
    private javax.swing.JComboBox<String> cbDepartamento;
    private javax.swing.JComboBox<String> cbZona;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDepartamentos;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtNumero1;
    private javax.swing.JTextField txtNumero2;
    private javax.swing.JTextField txtNumero3;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchSucursal;
    // End of variables declaration//GEN-END:variables
}
