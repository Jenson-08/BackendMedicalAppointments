/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.Objects;

/**
 *
 * @author jenso
 */
public class Cita {
    private String fecha;
    private String titulocita;
    private String nomPaciente;
    private String horacita;
    private String id_medico;

    public Cita(String fecha, String titulocita, String nomPaciente, String horacita, String id_medico) {
        this.fecha = fecha;
        this.titulocita = titulocita;
        this.nomPaciente = nomPaciente;
        this.horacita = horacita;
        this.id_medico = id_medico;
    }
    
    public Cita(){
        
    }

    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulocita() {
        return titulocita;
    }

    public void setTitulocita(String titulocita) {
        this.titulocita = titulocita;
    }

    public String getNomPaciente() {
        return nomPaciente;
    }

    public void setNomPaciente(String nomPaciente) {
        this.nomPaciente = nomPaciente;
    }

    public String getHoracita() {
        return horacita;
    }

    public void setHoracita(String horacita) {
        this.horacita = horacita;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.titulocita);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cita other = (Cita) obj;
        if (!Objects.equals(this.titulocita, other.titulocita)) {
            return false;
        }
        return true;
    }
    
    
}
