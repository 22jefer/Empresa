package com.example.Empresa.Controller;

import com.example.Empresa.Entity.Usuario;
import com.example.Empresa.Service.Response;
import com.example.Empresa.Service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("Usuario")
public class UsuarioController {

    private UsuarioService UsuarioService;

    public UsuarioController(UsuarioService usuServi) {
        UsuarioService = usuServi;
    }
    @RequestMapping("InformacionUsuarios")
    public ArrayList<Usuario> SelectAllController(){
        return this.UsuarioService.SelectAllService();
    }
    @PostMapping("CrearUsuario")
    public Response CrearUsuario(@RequestBody Usuario request){
        return this.UsuarioService.CrearUsuario(request);
    }
    @RequestMapping("BuscarUsuarioId/{id}")
    public Usuario BuscarUsuarioId(@PathVariable int id){
        return this.UsuarioService.BuscarUsuarioId(id);
    }
    @PatchMapping("ActualizarUsuarioId")
    public Response ActualizarUsuarioId(@RequestBody Usuario DatosUsuario){
        return this.UsuarioService.ActualizarUsuarioId(DatosUsuario);
    }
    @DeleteMapping("EliminarUsuarioId/{id}")
    public Response EliminarUsuarioId(@PathVariable  int id){
        return this.UsuarioService.EliminarUsuarioId(id);
    }
}
