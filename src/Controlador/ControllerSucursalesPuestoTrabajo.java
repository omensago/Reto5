
package Controlador;



import Vistas.*;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;


public class ControllerSucursalesPuestoTrabajo implements ActionListener {
    
    private final AddUserForm view;
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
    ArrayList<DatosSucursalPuestoTrabajo> list;
    DatosModeloDB model = new DatosModeloDB();
    
    
    public ControllerSucursalesPuestoTrabajo(AddUserForm view) {
        this.view = view;
        this.getListaSucursales();
        Sucursal sucursal = (Sucursal) view.cbSucursal.getSelectedItem();
        getListaPuestosTrabajo(sucursal.getIdSucursal());
        events();
    }
    
    public final void events(){
        view.cbSucursal.addActionListener (this);
    }
    
    public final void getListaSucursales(){
        list = model.getSucursales();
        if(list.size() > 0){
            
            for (int i = 0; i < list.size(); i++){
                int idSucursal = list.get(i).getIdSucursal();
                String nombreSucursal = list.get(i).getNombreSucursal();
                view.cbSucursal.addItem(new Sucursal(idSucursal, nombreSucursal));
            }
        }else{
            JOptionPane.showMessageDialog(null, "No existen sucursales aún.", "Sucursales", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public final void getListaPuestosTrabajo(int idSucursal){
        
        list = model.getPuestosTrabajo(idSucursal);
        if(list.size() > 0){
            for (int i = 0; i < list.size(); i++){
                DefaultComboBoxModel model = (DefaultComboBoxModel)view.cbPuestoTrabajo.getModel();
                Object [] puestotrabajo = new Object[2];
                puestotrabajo[0] = list.get(i).getIdPuestoTrabajo();
                puestotrabajo[1] = list.get(i).getNombrePuestoTrabajo();
                model.addElement(puestotrabajo[1]);
                view.cbPuestoTrabajo.setModel(model);
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "No existen puestos de trabajo aún.", "Sucursales", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object eventos = ae.getSource();
        if (eventos.equals(view.cbSucursal)){
            view.cbPuestoTrabajo.removeAllItems();
            Sucursal sucursal = (Sucursal)view.cbSucursal.getSelectedItem();
            getListaPuestosTrabajo(sucursal.getIdSucursal());
        }
    }
    
    
    
}
