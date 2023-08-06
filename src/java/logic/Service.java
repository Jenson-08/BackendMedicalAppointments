/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import basedatos.DaoAdmin;
import basedatos.DaoAntecedente;
import basedatos.DaoCitaAtendida;
import basedatos.DaoCitas;
import basedatos.DaoDoctor;
import basedatos.DaoEnfermedad;
import basedatos.DaoPersona;
import basedatos.DaoUsuario;
import java.util.List;
import logic.Usuario;

/**
 *
 * @author jenso
 */
public class Service {

    private static Service theInstance;

    public static Service instance() {
        if (theInstance == null) {
            theInstance = new Service();
        }
        return theInstance;
    }

    DaoDoctor dDao;
    DaoPersona pDao;
    DaoUsuario uDao;
    DaoEnfermedad eDao;
    DaoCitas cDao;
    DaoCitaAtendida caDao;
    DaoAdmin aDao;
    DaoAntecedente antecedenteDao;
    //metodos de doctor
    public void addDoctor(Doctor d) throws Exception {

        dDao.create(d);

    }

    public Doctor getDoctor(String id) throws Exception {

        return dDao.read(id);
    }

    public void updateDoctor(Doctor d) throws Exception {

        dDao.update(d);
    }

    public void updateEstadoMedico(Doctor d) throws Exception {

        dDao.updateCondicion(d);
    }

    public void deleteDoctor(Doctor d) throws Exception {

        dDao.delete(d);
    }

    public List<Doctor> DoctorsAll() throws Exception {

        return dDao.findAll();
    }

    public List<Doctor> findInactive(String inactivo) throws Exception {

        return dDao.findInactive(inactivo);
    }

    public List<Doctor> findActive(String activo) throws Exception {

        return dDao.findActive(activo);
    }

    public Doctor findbyId(String id) throws Exception {

        return dDao.findByID(id);
    }

    //metodos persona
    public void addPersona(Persona p) throws Exception {

        pDao.create(p);

    }

    public Persona getPersonaPorId(String id) throws Exception {

        return pDao.read(id);
    }

    public void updatePersona(Persona p) throws Exception {

        pDao.update(p);
    }

    public void deletePersona(Persona p) throws Exception {

        pDao.delete(p);
    }

    public List<Persona> PersonasAll() throws Exception {

        return pDao.findAll();
    }

    public List<Persona> PersonasporIdMedico(String id) throws Exception {

        return pDao.findPersonasporIdMedico(id);
    }

    //metodos de usuario
    public void addUsuario(Usuario u) throws Exception {

        uDao.create(u);

    }

    public Usuario getUsuarioPorId(String id) throws Exception {

        return uDao.read(id);
    }

    public void updateUsuario(Usuario u) throws Exception {

        uDao.update(u);
    }

    public void deleteUsuario(Usuario u) throws Exception {

        uDao.delete(u);
    }

    public List<Usuario> UsuarioAll() throws Exception {

        return uDao.findAll();
    }

    public Usuario get(Usuario id) throws Exception {
        Usuario result = uDao.read(id.getId());
        if (result == null) {
            throw new Exception("Usuario no existe");
        }
        return result;
    }

    //metodos de enfermedad
    public void addEnfermedad(Enfermedad u) throws Exception {

        eDao.create(u);

    }

    public Enfermedad getEnfermedadPorId(String id) throws Exception {

        return eDao.read(id);
    }

    public List<Enfermedad> EnfermedadesporId(String id) throws Exception {

        return eDao.findAllbyId(id);
    }

    //metodos de cita
    public void addCita(Cita c) throws Exception {

        cDao.create(c);

    }

    public List<Cita> CitasporIddeMedico(String id) throws Exception {

        return cDao.findCitasporIdMedico(id);
    }

    public Cita getCitaPorId(String id) throws Exception {

        return cDao.read(id);
    }
    //cita atendida
    public void addCitaAtendida(CitaAtendida p) throws Exception {
        caDao.create(p);
    }
    
     public List<CitaAtendida> CitasAtendidasporIddeMedico(String id) throws Exception {

        return caDao.findCitasAtendidasporIdMedico(id);
    }
     
    public List<CitaAtendida> CitasAtendidasporNombrePaciente(String nom) throws Exception {

        return caDao.findCitasAtendidasporNombrePaciente(nom);
    }
    public CitaAtendida CitaAtendidaporTitulo(String nom) throws Exception {

        return caDao.citaAtendidaPorTitulo(nom);
    }
    
    

    //admin
    public void addAdmin(Admin p) throws Exception {
        aDao.create(p);
    }
    public List<Admin> AdminAll() throws Exception {

        return aDao.findAll();
    }
    
    //antecedente
    public void addAntecedente(Antecedente p) throws Exception {
        antecedenteDao.create(p);
    }
    public List<Antecedente> AntecedentePorIdPaciente(String id) throws Exception {

        return antecedenteDao.findAntecedenteporIdPaciente(id);
    }
     public List<Antecedente> AntecedentesAll() throws Exception {

        return antecedenteDao.findAll();
    }
    public List<Antecedente> AntecedentePorIdMedico(String id) throws Exception {

        return antecedenteDao.findAntecedenteporIdMedico(id);
    }
    
    
    
    
    public Service() {
        try {
            dDao = new DaoDoctor();
            pDao = new DaoPersona();
            uDao = new DaoUsuario();
            eDao = new DaoEnfermedad();
            cDao = new DaoCitas();
            caDao = new DaoCitaAtendida();
            aDao = new DaoAdmin();
            antecedenteDao = new DaoAntecedente();
        } catch (Exception e) {
        }
    }
}
