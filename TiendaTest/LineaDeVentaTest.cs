using Domain;
using Moq;

namespace TiendaTest
{
    public class LineaDeVentaTest
    {
        private Stock _stock;

        [SetUp]
        public void Setup()
        {
            Stock stock = new Stock()
            {
                articulo = new Articulo() { precio = 10.0 },
                stock = 3
            };

            _stock = stock;
        }


        [Test]
        public void ArrojaExcepcionSiSeIntentaCrearConStockInsuficiente()
        {
            // Arrange
            int cantidadMayorAStock = _stock.stock + 1;

            // Act and Assert
            Assert.Throws<ArgumentException>(() => new LineaDeVenta(_stock, cantidadMayorAStock));
        }

        [Test]
        public void CalculaSuPrecio()
        {
            // Arrange
            LineaDeVenta lineaDeVenta = new LineaDeVenta(_stock, 2);

            // Act
            double precioCalculado = lineaDeVenta.GetPrecio();

            // Assert
            Assert.That(precioCalculado, Is.EqualTo(20.0));
        }
    }
}