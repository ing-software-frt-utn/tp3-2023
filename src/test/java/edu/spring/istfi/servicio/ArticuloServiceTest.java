package edu.spring.istfi.servicio;

import edu.spring.istfi.model.*;
import edu.spring.istfi.servicio.ArticuloService;
import edu.spring.istfi.repository.ArticuloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ArticuloServiceTest {

    private ArticuloService servicio;
    private ArticuloRepository repositorioArticulos;

    @BeforeEach
    public void before(){
        repositorioArticulos = mock(ArticuloRepository.class);
        servicio = new ArticuloService(repositorioArticulos);
    }

    @Test
    public void crearArticulo(){
        Talle talle = new Talle("XL");
        Color color = new Color("Negro");
        Marca marca = new Marca("Adidas");
        Categoria categoria = new Categoria("Deportiva");
        Articulo articulo = servicio.createArticulo("remera",4500,10);
        articulo.setTalle(talle);
        articulo.setMarca(marca);
        articulo.setColor(color);
        articulo.setCategoria(categoria);

        assertEquals(articulo.getDescripcion(),"remera");
        assertEquals(articulo.getCosto(),4500);
        assertEquals(articulo.getMargenDeGanancia(),10);
        assertEquals(articulo.getTalle().getDescripcion(),"XL");
        assertEquals(articulo.getColor().getDescripcion(),"Negro");
        assertEquals(articulo.getMarca().getDescripcion(),"Adidas");
        assertEquals(articulo.getCategoria().getDescripcion(),"Deportiva");

        verify(repositorioArticulos,times(1)).save(any(Articulo.class));
    }

    @Test
    public void buscarArticuloPorCodigo() {

        Talle talle = new Talle("XL");
        Color color = new Color("Negro");
        Marca marca = new Marca("Adidas");
        Categoria categoria = new Categoria("Deportiva");

        Articulo articuloEjemplo = new Articulo("Remera", 4500, 0.20);
        articuloEjemplo.setTalle(talle);
        articuloEjemplo.setMarca(marca);
        articuloEjemplo.setColor(color);
        articuloEjemplo.setCategoria(categoria);

        when(repositorioArticulos.findByCodigo(001)).thenReturn(articuloEjemplo);

        Articulo articuloEncontrado = servicio.buscarArticuloPorCodigo(001);

        assertEquals("Remera", articuloEncontrado.getDescripcion());
        assertEquals(4500, articuloEncontrado.getCosto());
        assertEquals(0.20, articuloEncontrado.getMargenDeGanancia());
        assertEquals("XL", articuloEncontrado.getTalle().getDescripcion());
        assertEquals("Adidas", articuloEncontrado.getMarca().getDescripcion());
        assertEquals("Negro", articuloEncontrado.getColor().getDescripcion());
        assertEquals("Deportiva", articuloEncontrado.getCategoria().getDescripcion());

        verify(repositorioArticulos, times(1)).findByCodigo(001);
    }
}