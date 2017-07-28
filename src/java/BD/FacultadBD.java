/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import Modelo.Facultad;
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
public class FacultadBD {
    private List<Facultad> facultades = new ArrayList<>();
    
    
    public void obtenerFacultades( ) {
        getFacultades().clear();
        try{
            String sentenciasql="SELECT * FROM facultad";
            Statement statement=Conexion.getConexion().createStatement();
            ResultSet resultado = statement.executeQuery(sentenciasql);
            while(resultado.next()){
                Facultad facultad = new Facultad();
                
                facultad.idFacultad=resultado.getInt("idFacultad");
                facultad.nomFacultad=resultado.getString("nomFacultad");
                
                getFacultades().add(facultad);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static Facultad obtenerFacultad(Integer idFacultad){
        Facultad facultad=null;
        try{
            String sentenciasql="SELECT * FROM facultad WHERE idFacultad=?";
            PreparedStatement statement=Conexion.getConexion().prepareStatement(sentenciasql);
            statement.setInt(1, idFacultad);
            ResultSet resultado=statement.executeQuery();
            while(resultado.next()){
                facultad=new Facultad();
                facultad.idFacultad=resultado.getInt("idFacultad");
                facultad.nomFacultad=resultado.getString("nomFacultad");
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return facultad;
    }
    
    public List<Facultad> getFacultades(){
        return facultades;
    }
    
    public void setFacultades(List<Facultad> facultades){
        this.facultades=facultades;
    }
    
}
