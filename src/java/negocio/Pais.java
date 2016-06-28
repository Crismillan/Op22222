/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import accesodato.Coneccion;

/**
 *
 * @author emanuel
 */
public class Pais {
    private int pais_id;
    private String nombre;
    private String creado_por;
    private String estado;
    Coneccion con;
    
    public Pais(){
    con=new Coneccion(); 
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreado_por() {
        return creado_por;
    }

    public void setCreado_por(String creado_por) {
        this.creado_por = creado_por;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void GuardarPais(){
        con.setInsertar("insert into paises(nombre,creado_por,estado) values('"+this.getNombre()+"','"+this.getCreado_por()+"','activo')");
    }
    public void BorrarPais(){
        con.setInsertar("update paises set estado='pasivo' where pais_id='"+this.getPais_id()+"' ");
    }
    public void ActualizarPais(){
        con.setInsertar("update paises set Nombre='"+this.getNombre()+"',Creado_por='"+this.getCreado_por()+"',estado='activo' where pais_id='"+this.getPais_id()+"'");
    }
}
