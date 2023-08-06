/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author jenso
 */
public class Antecedente {
    private String idPaciente;
    private String alergia;
    private String enfermedad;
    private String cirugia;
    private String vacuna;
    private String tiposangre;
    private String idMedico;

    public Antecedente(String idPaciente, String alergia, String enfermedad, String cirugia, String vacuna, String tipoSangre,String idMedico) {
        this.idPaciente = idPaciente;
        this.alergia = alergia;
        this.enfermedad = enfermedad;
        this.cirugia = cirugia;
        this.vacuna = vacuna;
        this.tiposangre = tipoSangre;
        this.idMedico = idMedico;
                
    }
    public Antecedente(){}

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }
    
    
    
    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getCirugia() {
        return cirugia;
    }

    public void setCirugia(String cirugia) {
        this.cirugia = cirugia;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public String getTiposangre() {
        return tiposangre;
    }

    public void setTiposangre(String tiposangre) {
        this.tiposangre = tiposangre;
    }
    
    
    
}
