package com.example.Empresa.Controller;

import com.example.Empresa.Entity.Empresa;
import com.example.Empresa.Service.EmpresaService;
import com.example.Empresa.Service.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("Index")
public class IndexController {

    private EmpresaService EmpresaService;

    public IndexController(EmpresaService EmpreServi) {
        EmpresaService = EmpreServi;
    }

    @RequestMapping("InformacionEmpresas")
    public ArrayList<Empresa> SelectAllController(){
        return this.EmpresaService.SelectAllService();
    }

    @PostMapping("CrearEmpresa")
    public Response CrearEmpresa(@RequestBody Empresa RequestController){
        return this.EmpresaService.CrearEmpresa(RequestController);
    }
    @RequestMapping("EmpresaById/{id}")
    public Empresa EmpresaById(@PathVariable int id){
        return this.EmpresaService.EmpresaPorId(id);
    }

    @DeleteMapping("EliminarEmpresaId/{id}")
    public Response ElimiarEmpresaId(@PathVariable int id){
        return this.EmpresaService.EliminarEmpresaId(id);
    }
    @PatchMapping("ActualizarEmpresaId")
    public Response ActualizarEmpresaId(@RequestBody Empresa RequestController){
        return this.EmpresaService.ActualizarEmpresa(RequestController);
    }

}
