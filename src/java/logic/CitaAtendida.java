/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author jenso
 */
public class CitaAtendida {
    private String titulo;
    private String nomPaciente;
    private String idMedico;
    private String signos;
    private String diagnosticos;
    private String prescripciones;

    public CitaAtendida(String titulo,String nomPaciente, String idMedico, String Signos, String Diagnosticos, String Prescripciones) {
        this.titulo = titulo;
        this.nomPaciente = nomPaciente;
        this.idMedico = idMedico;
        this.signos = Signos;
        this.diagnosticos = Diagnosticos;
        this.prescripciones = Prescripciones;
    }
 public CitaAtendida(){
     
 }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    public String getNomPaciente() {
        return nomPaciente;
    }

    public void setNomPaciente(String nomPaciente) {
        this.nomPaciente = nomPaciente;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getSignos() {
        return signos;
    }

    public void setSignos(String Signos) {
        this.signos = Signos;
    }

    public String getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(String Diagnosticos) {
        this.diagnosticos = Diagnosticos;
    }

    public String getPrescripciones() {
        return prescripciones;
    }

    public void setPrescripciones(String Prescripciones) {
        this.prescripciones = Prescripciones;
    }
    
    
}
