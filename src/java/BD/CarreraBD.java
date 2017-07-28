/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Modelo.Carrera;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRN-315
 */
public class CarreraBD {
    private List<Carrera> carreras = new ArrayList<>();
    
    
    public void obtenerCarreras(){
        carreras.clear();;
        try{
            String sentenciasql = "SELECT * FROM carrera";
            Statement statement = Conexion.getConexion().createStatement();
            ResultSet resultado = statement.executeQuery(sentenciasql);
            while(resultado.next()){
                Carrera carrera = new Carrera();
                carrera.idCarrera = resultado.getString("idCarrera");
                carrera.nomCarrera = resultado.getString("nomCarrera");
                carrera.Facultad = FacultadBD.obtenerFacultad(resultado.getInt("idFacultad"));
                carreras.add(carrera);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public boolean guardar(String idCarrera, String nomCarrera, Integer idFacultad){
        boolean guardado=true;
        try{
            String sentenciasql;
            PreparedStatement preparedStatement;
            sentenciasql="INSERT INTO carrera (idCarrera,nomCarrera,idFacultad) VALUES "+"(?,?,?)";
            preparedStatement=Conexion.getConexion().prepareStatement(sentenciasql);
            preparedStatement.setString(1, idCarrera);
            preparedStatement.setString(2, nomCarrera);
            preparedStatement.setInt(3, idFacultad);
            preparedStatement.execute();
        }catch(SQLException ex){
            guardado=false;
            ex.printStackTrace();
        }
        return guardado;
    }
    
    public List<Carrera> getCarreras(){
        return carreras;
    }
    
    public void setCarreras(List<Carrera> carreras){
        this.carreras=carreras;
    }
}
