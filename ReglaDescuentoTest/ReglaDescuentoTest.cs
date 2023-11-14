using ReglaDescuentoConsigna;

namespace ReglaDescuentoTest
{
    public class ReglaDescuentoTest
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void TestNoPermiteValoresNegativos()
        {
            // Arrange
            ReglaDeDescuento reglaDescuento = new ReglaDeDescuento();
            double total = -1;

            // Act and assert
            Assert.Throws<ArgumentException>(() => reglaDescuento.Calcular(total));
        }

        [Test]
        public void TestNoAplicaDescuentoAlMonto()
        {
            // Arrange
            ReglaDeDescuento reglaDescuento = new ReglaDeDescuento();
            double total = 3500;
            double totalEsperado = 0;

            // Act and Assert
            Assert.AreEqual(totalEsperado, reglaDescuento.Calcular(total));
        }

        [Test]
        public void TestAplicaPorcentajeAMontoEntreCincoMilYDiezMil()
        {
            // Arrange
            ReglaDeDescuento reglaDescuento = new ReglaDeDescuento();
            double total = 7777;
            double porcentajeUsado = 0.03d;
            double totalEsperado = total * porcentajeUsado;

            // Act and Assert
            Assert.AreEqual(totalEsperado, reglaDescuento.Calcular(total));
        }

        [Test]
        public void TestAplicaPorcentajeAMontoEntreDiezMilYVeinticincoMil()
        {
            // Arrange
            ReglaDeDescuento reglaDescuento = new ReglaDeDescuento();
            double total = 15555;
            double porcentajeUsado = 0.05d;
            double totalEsperado = total * porcentajeUsado;

            // Act and Assert
            Assert.AreEqual(totalEsperado, reglaDescuento.Calcular(total));
        }

        [Test]
        public void TestAplicaPorcentajeAMontoMayorAVeinticincoMil()
        {
            // Arrange
            ReglaDeDescuento reglaDescuento = new ReglaDeDescuento();
            double total = 777777;
            double porcentajeUsado = 0.10d;
            double totalEsperado = total * porcentajeUsado;

            // Act and Assert
            Assert.AreEqual(totalEsperado, reglaDescuento.Calcular(total));
        }
    }
}