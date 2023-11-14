using Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace TiendaTest
{
    public class VentaTest
    {
        private List<Stock> _stocks = new List<Stock>();

        [SetUp]
        public void Setup()
        {
            _stocks.Add(new Stock() {
                articulo = new Articulo() { precio = 10.0 },
                stock = 3
            });

            _stocks.Add(new Stock()
            {
                articulo = new Articulo() { precio = 20.0 },
                stock = 2
            });
        }

        [Test] public void CalculaSuTotal()
        {
            // Arrange
            Venta venta = new Venta();
            foreach (Stock s in _stocks)
            {
                venta.AgregarArticulo(s, 2);
            }

            // Act
            double total = venta.GetTotal();

            // Assert
            Assert.That(_stocks.Sum(s => s.articulo.precio * 2), Is.EqualTo(total));
        }
    }
}
