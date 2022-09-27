package com.example.Empresa.Service;

import com.example.Empresa.Entity.MovimientosEmpresa;
import com.example.Empresa.Repository.IMovimientosEmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovimientosEmpresaService {

    private IMovimientosEmpresaRepository IMovimientosEmpresaRepository;

    public MovimientosEmpresaService(IMovimientosEmpresaRepository IMoviEmpreRepo) {
        this.IMovimientosEmpresaRepository = IMoviEmpreRepo;
    }

    public MovimientosEmpresa CrearMontoEmpresa(MovimientosEmpresa DatosEmpresa){
        return this.IMovimientosEmpresaRepository.save(DatosEmpresa);
    }
    public ArrayList<MovimientosEmpresa> InformacionMoviEmpresa(){
        return (ArrayList<MovimientosEmpresa>) this.IMovimientosEmpresaRepository.findAll();
    }
    public MovimientosEmpresa BuscarMoviEmpresaId(int id){
        Optional<MovimientosEmpresa> existe = this.IMovimientosEmpresaRepository.findById(id);
        if(existe.isPresent()){
            return existe.get();
        }else{
            return null;
        }
    }

    public Response ActualizarMoviEmpresaId(MovimientosEmpresa DatosMoviEmpresa){
        Response response = new Response();
        MovimientosEmpresa existe = BuscarMoviEmpresaId(DatosMoviEmpresa.getId());
        existe.setMonto(DatosMoviEmpresa.getMonto());
        response.setCodigo(200);
        this.IMovimientosEmpresaRepository.save(DatosMoviEmpresa);
        response.setMensaje("Movimiento de la empresa Actualizada correctamente");
        return response;
    }

    public Response EliminarMoviEmpresaId(int id){
        Response response = new Response();
        try{
            this.IMovimientosEmpresaRepository.deleteById(id);
            response.setCodigo(200);
            response.setMensaje("Monto eliminado correctamente");
            return response;
        }catch(Exception ex){
            response.setCodigo(500);
            response.setMensaje("Error: "+ ex.getMessage());
            return response;
        }
    }
}
