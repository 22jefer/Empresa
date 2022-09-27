package com.example.Empresa.Service;

import com.example.Empresa.Entity.Usuario;
import com.example.Empresa.Repository.IUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    private IUsuarioRepository IUsuarioRepository;

    public UsuarioService(IUsuarioRepository IUsuRepo) {
        this.IUsuarioRepository = IUsuRepo;
    }

    public ArrayList<Usuario> SelectAllService(){
        return (ArrayList<Usuario>) this.IUsuarioRepository.findAll();
    }

    public Response CrearUsuario(Usuario DatosUsuario){
        Response response = new Response();
        this.IUsuarioRepository.save(DatosUsuario);
        response.setCodigo(200);
        response.setMensaje("Usuario creado exitosamente");
        return response;
    }
    public Usuario BuscarUsuarioId(int id){
        Optional<Usuario> existe = this.IUsuarioRepository.findById(id);
        if(existe.isPresent()){
            return existe.get();
        }else{
            return null;
        }
    }
    public Response ActualizarUsuarioId(Usuario DatosUsuario){
        Response response = new Response();
        Usuario existe = BuscarUsuarioId(DatosUsuario.getId());
        existe.setCorreo(DatosUsuario.getCorreo());
        existe.setNombre(DatosUsuario.getNombre());
        existe.setTipoU(DatosUsuario.getTipoU());
        this.IUsuarioRepository.save(DatosUsuario);
        response.setCodigo(200);
        response.setMensaje("Usuario actualizado exitozamente");
        return response;
    }

    public Response EliminarUsuarioId(int id){
        Response response = new Response();
        try{
            this.IUsuarioRepository.deleteById(id);
            response.setCodigo(200);
            response.setMensaje("Usuario eliminado exitosamente");
            return response;
        }catch(Exception ex){
            response.setCodigo(500);
            response.setMensaje("Error: "+ ex.getMessage());
            return response;
        }
    }
}
