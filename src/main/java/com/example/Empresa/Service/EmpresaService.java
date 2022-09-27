package com.example.Empresa.Service;

import com.example.Empresa.Entity.Empresa;
import com.example.Empresa.Repository.IEmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpresaService {

    private IEmpresaRepository IEmpresaRepository;

    public EmpresaService(IEmpresaRepository IEmRepo) {
        this.IEmpresaRepository = IEmRepo;
    }

    public ArrayList<Empresa> SelectAllService(){
        return (ArrayList<Empresa>) this.IEmpresaRepository.findAll();

    }

    public Response CrearEmpresa(Empresa DatosEmpresa){
        Response response = new Response();
        this.IEmpresaRepository.save(DatosEmpresa);
        response.setCodigo(200);
        response.setMensaje("Empresa Registrada exitosamente");
        return response;
    }

    public Empresa EmpresaPorId(int id){
        Optional<Empresa> existe = this.IEmpresaRepository.findById(id);
        if(existe.isPresent()){
            return existe.get();
        }else{
            return null;
        }
    }

    public Response EliminarEmpresaId(int id){
        Response response = new Response();
        try {
            this.IEmpresaRepository.deleteById(id);
            response.setCodigo(200);
            response.setMensaje("La empresa se ha eliminado exitosamente");
            return response;
        }catch(Exception ex){
            response.setCodigo(500);
            response.setMensaje("Error: " + ex.getMessage());
            return response;
        }
    }

    public Response ActualizarEmpresa(Empresa DatosEmpresa){
        Response response = new Response();
        Empresa existe = EmpresaPorId(DatosEmpresa.getId());
        existe.setDireccion(DatosEmpresa.getDireccion());
        existe.setTelefono(DatosEmpresa.getTelefono());
        existe.setNit(DatosEmpresa.getNit());
        existe.setNombre(DatosEmpresa.getNombre());
        existe.setUsuario(DatosEmpresa.getUsuario());
        existe.setMovimientosEmpresa(DatosEmpresa.getMovimientosEmpresa());
        this.IEmpresaRepository.save(existe);
        response.setCodigo(200);
        response.setMensaje("Empresa actualizada correctamente");
        return response;
    }
}
