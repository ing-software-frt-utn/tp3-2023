using Domain;
using Repositories.Contracts;
using System;
using TechTalk.SpecFlow;
using Moq;
using Services.Contracts;

namespace SpecFlowTiendaSpecs.StepDefinitions.BorrarArticulo
{
    [Binding]
    public class BajaLogicaDeArticuloExistenteStepDefinitions
    {
        private Mock<IArticuloService> _serviceMock;
        private Articulo _articuloListado;

        [Before]
        public void Before()
        {
            _serviceMock = new Mock<IArticuloService>();
        }

        [Given(@"existe un articulo (.*) sin inventarios asociados")]
        public void GivenExisteUnArticuloSinInventariosAsociados(int codigo)
        {
            Articulo articulo = new Articulo
            {
                codigo = codigo,
                marca = "",
                descripcion = "",
                precio = 0.0
            };
            _serviceMock.Setup(m => m.BuscarArticulo(codigo)).Returns(articulo);
        }

        [Given(@"se listo la informacion del articulo (.*)")]
        public void GivenSeListoLaInformacionDelArticulo(int codigo)
        {
            Articulo articuloListado = _serviceMock.Object.BuscarArticulo(codigo);
            _articuloListado = articuloListado;
        }

        [When(@"elimino el articulo (.*)")]
        public void WhenEliminoElArticulo(int codigo)
        {
            _serviceMock.Setup(m => m.BorrarArticulo(_articuloListado))
                .Callback((Articulo articulo) => articulo.activo = false)
                .Returns(true);
            _serviceMock.Object.BorrarArticulo(_articuloListado);
        }

        [Then(@"el articulo (.*) sufre un borrado logico")]
        public void ThenElArticuloSufreUnBorradoLogico(int codigo)
        {
            _articuloListado.codigo.Should().Be(codigo);
            _articuloListado.activo.Should().Be(false);
        }
    }
}
