package com.example.Empresa.Controller;

import com.example.Empresa.Entity.MovimientosEmpresa;
import com.example.Empresa.Service.MovimientosEmpresaService;
import com.example.Empresa.Service.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("MovimientosEmpresa")
public class MovimientosEmpresaController {
    private MovimientosEmpresaService MovimientosEmpresaService;

    public MovimientosEmpresaController(MovimientosEmpresaService moviEmpreSer) {
        MovimientosEmpresaService = moviEmpreSer;
    }
    @PostMapping("CrearMoviEmpresa")
    public MovimientosEmpresa CrearMoviEmpresa(@RequestBody MovimientosEmpresa DatosMontoEmpresa){
        return this.MovimientosEmpresaService.CrearMontoEmpresa(DatosMontoEmpresa);
    }
    @RequestMapping("InformacionMoviEmpresa")
    public ArrayList<MovimientosEmpresa> InformacionMoviEmpresa(){
        return this.MovimientosEmpresaService.InformacionMoviEmpresa();
    }
    @RequestMapping("BuscarMoviEmpresaId/{id}")
    public MovimientosEmpresa BuscarMoviEmpresaId(@PathVariable int id){
        return this.MovimientosEmpresaService.BuscarMoviEmpresaId(id);
    }
    @PatchMapping("ActualizarMoviEmpresaId")
    public Response ActualizarMoviEmpresaId(@RequestBody MovimientosEmpresa DatosMoviEmpresa){
        return this.MovimientosEmpresaService.ActualizarMoviEmpresaId(DatosMoviEmpresa);
    }
    @DeleteMapping("EliminarMoviEmpresaId/{id}")
    public Response EliminarMoviEmpresaId(@PathVariable int id){
        return this.MovimientosEmpresaService.EliminarMoviEmpresaId(id);
    }

}

