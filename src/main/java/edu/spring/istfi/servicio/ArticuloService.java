package edu.spring.istfi.servicio;

import edu.spring.istfi.model.Articulo;
import edu.spring.istfi.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloService {

    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public Articulo createArticulo(String descripcion, double costo, double margenDeGanancia){
        Articulo newArticulo = new Articulo(descripcion,costo,margenDeGanancia);
        articuloRepository.save(newArticulo);

        return newArticulo;
    }

    public Articulo buscarArticuloPorCodigo(long codigo) {
        return articuloRepository.findByCodigo(codigo);
    }
}

