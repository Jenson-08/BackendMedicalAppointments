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
public class Doctor {

    String id;
    String password;
    String name;
    String speciality;
    String fee;
    String location;
    String estado;
    int frecuencia;
    boolean dia1;
    String hEntrada1;
    String hSalida1;
    boolean dia2;
    String hEntrada2;
    String hSalida2;
    boolean dia3;
    String hEntrada3;
    String hSalida3;
    boolean dia4;
    String hEntrada4;
    String hSalida4;
    boolean dia5;
    String hEntrada5;
    String hSalida5;
    boolean dia6;
    String hEntrada6;
    String hSalida6;
    boolean dia7;
    String hEntrada7;
    String hSalida7;
    String rol;

    public Doctor(String id, String password, String name, String speciality, String fee, String location,String estado, int frecuencia, boolean dia1, String hEntrada1, String hSalida1, boolean dia2, String hEntrada2, String hSalida2, boolean dia3, String hEntrada3, String hSalida3, boolean dia4, String hEntrada4, String hSalida4, boolean dia5, String hEntrada5, String hSalida5, boolean dia6, String hEntrada6, String hSalida6, boolean dia7, String hEntrada7, String hSalida7,String rol) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.speciality = speciality;
        this.fee = fee;
        this.location = location;
        this.estado = estado;
        this.frecuencia = frecuencia;
        this.dia1 = dia1;
        this.hEntrada1 = hEntrada1;
        this.hSalida1 = hSalida1;
        this.dia2 = dia2;
        this.hEntrada2 = hEntrada2;
        this.hSalida2 = hSalida2;
        this.dia3 = dia3;
        this.hEntrada3 = hEntrada3;
        this.hSalida3 = hSalida3;
        this.dia4 = dia4;
        this.hEntrada4 = hEntrada4;
        this.hSalida4 = hSalida4;
        this.dia5 = dia5;
        this.hEntrada5 = hEntrada5;
        this.hSalida5 = hSalida5;
        this.dia6 = dia6;
        this.hEntrada6 = hEntrada6;
        this.hSalida6 = hSalida6;
        this.dia7 = dia7;
        this.hEntrada7 = hEntrada7;
        this.hSalida7 = hSalida7;
        this.estado= estado;
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Doctor(){
        
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String especiality) {
        this.speciality = especiality;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean getDia1() {
        return dia1;
    }

    public void setDia1(boolean dia1) {
        this.dia1 = dia1;
    }

    public String gethEntrada1() {
        return hEntrada1;
    }

    public void sethEntrada1(String hEntrada1) {
        this.hEntrada1 = hEntrada1;
    }

    public String gethSalida1() {
        return hSalida1;
    }

    public void sethSalida1(String hSalida1) {
        this.hSalida1 = hSalida1;
    }

    public boolean getDia2() {
        return dia2;
    }

    public void setDia2(boolean dia2) {
        this.dia2 = dia2;
    }

    public String gethEntrada2() {
        return hEntrada2;
    }

    public void sethEntrada2(String hEntrada2) {
        this.hEntrada2 = hEntrada2;
    }

    public String gethSalida2() {
        return hSalida2;
    }

    public void sethSalida2(String hSalida2) {
        this.hSalida2 = hSalida2;
    }

    public boolean getDia3() {
        return dia3;
    }

    public void setDia3(boolean dia3) {
        this.dia3 = dia3;
    }

    public String gethEntrada3() {
        return hEntrada3;
    }

    public void sethEntrada3(String hEntrada3) {
        this.hEntrada3 = hEntrada3;
    }

    public String gethSalida3() {
        return hSalida3;
    }

    public void sethSalida3(String hSalida3) {
        this.hSalida3 = hSalida3;
    }

    public boolean getDia4() {
        return dia4;
    }

    public void setDia4(boolean dia4) {
        this.dia4 = dia4;
    }

    public String gethEntrada4() {
        return hEntrada4;
    }

    public void sethEntrada4(String hEntrada4) {
        this.hEntrada4 = hEntrada4;
    }

    public String gethSalida4() {
        return hSalida4;
    }

    public void sethSalida4(String hSalida4) {
        this.hSalida4 = hSalida4;
    }

    public boolean getDia5() {
        return dia5;
    }

    public void setDia5(boolean dia5) {
        this.dia5 = dia5;
    }

    public String gethEntrada5() {
        return hEntrada5;
    }

    public void sethEntrada5(String hEntrada5) {
        this.hEntrada5 = hEntrada5;
    }

    public String gethSalida5() {
        return hSalida5;
    }

    public void sethSalida5(String hSalida5) {
        this.hSalida5 = hSalida5;
    }

    public boolean getDia6() {
        return dia6;
    }

    public void setDia6(boolean dia6) {
        this.dia6 = dia6;
    }

    public String gethEntrada6() {
        return hEntrada6;
    }

    public void sethEntrada6(String hEntrada6) {
        this.hEntrada6 = hEntrada6;
    }

    public String gethSalida6() {
        return hSalida6;
    }

    public void sethSalida6(String hSalida6) {
        this.hSalida6 = hSalida6;
    }

    public boolean getDia7() {
        return dia7;
    }

    public void setDia7(boolean dia7) {
        this.dia7 = dia7;
    }

    public String gethEntrada7() {
        return hEntrada7;
    }

    public void sethEntrada7(String hEntrada7) {
        this.hEntrada7 = hEntrada7;
    }

    public String gethSalida7() {
        return hSalida7;
    }

    public void sethSalida7(String hSalida7) {
        this.hSalida7 = hSalida7;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Doctor other = (Doctor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
