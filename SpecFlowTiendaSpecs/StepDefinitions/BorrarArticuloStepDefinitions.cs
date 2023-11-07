using Domain;
using Repositories.Contracts;
using System;
using TechTalk.SpecFlow;
using Moq;
using Services.Contracts;

namespace SpecFlowTiendaSpecs.StepDefinitions
{
    [Binding]
    public class BorrarArticuloStepDefinitions
    {
        private Mock<IArticuloService> _serviceMock;
        private Articulo _articuloListado;
        private Articulo _articuloBuscado;

        [Before] public void Before()
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

        [Given(@"existe un articulo con el codigo (.*), con la informacion")]
        public void GivenExisteUnArticuloConElCodigoConLaInformacion(int codigo, Table table)
        {
            Articulo articulo = table.Rows.Select(row => new Articulo
            {
                codigo = codigo,
                marca = row["Marca"],
                descripcion = row["Descripcion"]
            }).First();
            _serviceMock.Setup(m => m.BuscarArticulo(codigo)).Returns(articulo);
        }

        [When(@"ingreso el codigo del articulo (.*)")]
        public void WhenIngresoElCodigoDelArticulo(int codigo)
        {
            Articulo articuloBuscado = _serviceMock.Object.BuscarArticulo(codigo);
            _articuloBuscado = articuloBuscado;
        }

        [Then(@"se muestra la informacion del articulo")]
        public void ThenSeMuestraLaInformacionDelArticulo(Table table)
        {
            _articuloBuscado.Should().NotBeNull();
            _articuloBuscado.codigo.Should().Be(int.Parse(table.Rows.First()["Codigo"]));
            _articuloBuscado.marca.Should().Be(table.Rows.First()["Marca"]);
            _articuloBuscado.descripcion.Should().Be(table.Rows.First()["Descripcion"]);
        }



    }
}
