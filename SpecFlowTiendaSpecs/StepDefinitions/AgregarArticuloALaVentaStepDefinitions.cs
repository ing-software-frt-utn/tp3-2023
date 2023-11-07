using Domain;
using Moq;
using Repositories.Contracts;
using Services.Contracts;
using System;
using TechTalk.SpecFlow;

namespace SpecFlowTiendaSpecs.StepDefinitions
{
    [Binding]
    public class AgregarArticuloALaVentaStepDefinitions
    {
        private Mock<IArticuloService> _articuloServiceMock;
        private Mock<IStockService> _stockServiceMock;
        private Articulo _articulo;
        private List<Stock> _stocks;
        private Venta _venta;

        [Before]
        public void Before()
        {
            _articuloServiceMock = new Mock<IArticuloService>();
            _stockServiceMock = new Mock<IStockService>();
        }

        [Given(@"una venta en proceso")]
        public void GivenUnaVentaEnProceso() 
        {
            _venta = new Venta();
        }

        [Given(@"existe un articulo con el codigo (.*), con la informacion:")]
        public void GivenExisteUnArticuloConElCodigoConLaInformacion(int codigo, Table table)
        {
            Articulo articulo = table.Rows.Select(row => new Articulo
            {
                codigo = codigo,
                marca = row["Marca"],
                descripcion = row["Descripcion"]
            }).First();

            _articuloServiceMock.Setup(m => m.BuscarArticulo(codigo)).Returns(articulo);
        }

        [Given(@"existen las siguientes combinaciones de talle y color para el articulo (.*):")]
        public void GivenExistenLasSiguientesCombinacionesDeTalleYColorParaElArticulo(int codigo, Table table)
        {
            Articulo articulo = _articuloServiceMock.Object.BuscarArticulo(codigo);
            List<Stock> stocks = table.Rows.Select(row => new Stock
            {
                articulo = articulo,
                talle = new Talle { numero = int.Parse(row["Talle"]) },
                color = new Color { descripcion = row["Color"] },
                stock = int.Parse(row["Stock"])
            }).ToList();

            // Only stocks greater than zero
            _stockServiceMock.Setup(m => m.ObtenerStocks(articulo)).Returns(
                stocks.OrderBy(s => s.stock).Where(s => s.stock > 0).ToList());
        }

        [When(@"ingreso el codigo (.*)")]
        public void WhenIngresoElCodigo(int codigo)
        {
            _articulo = _articuloServiceMock.Object.BuscarArticulo(codigo);
        }

        [Then(@"se debe mostrar la siguiente informacion del articulo:")]
        public void ThenSeDebeMostrarLaSiguienteInformacionDelArticulo(Table table)
        {
            _articulo.marca.Should().Be(table.Rows.First()["Marca"]);
            _articulo.descripcion.Should().Be(table.Rows.First()["Descripcion"]);
        }

        [Then(@"Se deben listar las siguientes combinaciones de talle y color con stock mayor a 0:")]
        public void ThenSeDebenListarLasSiguientesCombinacionesDeTalleYColorConStockMayorA(Table table)
        {
            List<Stock> stocks = _stockServiceMock.Object.ObtenerStocks(_articulo);
            var tableRows = table.Rows.OrderBy(r => int.Parse(r["Stock"])).ToList();

            for (int i = 0; i < stocks.Count; i++)
            {
                stocks[i].talle.numero.Should().Be(int.Parse(tableRows[i]["Talle"]));
                stocks[i].color.descripcion.Should().Be(tableRows[i]["Color"]);
                stocks[i].stock.Should().Be(int.Parse(tableRows[i]["Stock"]));
            }
        }
    }
}
