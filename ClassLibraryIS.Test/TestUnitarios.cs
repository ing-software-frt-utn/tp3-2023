using Microsoft.VisualStudio.TestPlatform.CommunicationUtilities;

namespace ClassLibraryIS.Test
{
    [TestClass]
    public class TestUnitarios
    {
        [TestMethod]
        public void TotalIntroducidoIgualA0()
        {
            string mensaje = "";
            //setup
            ReglaDeDescuento regla = new ReglaDeDescuento();
            //execute
            try
            {
                var resultado = regla.Calcular(0);
            }
            catch(Exception ex)
            {
                 mensaje = ex.Message;
            }

            //assert
            Assert.AreEqual(mensaje, "El total debe ser mayor a 0");
            //teardown
        }

        public void TotalIntroducidoIgualA6000()
        {
            double resultado = 0;
            string mensaje = "";
            //setup
            ReglaDeDescuento regla = new ReglaDeDescuento();
            //execute
            try
            {
                 resultado = regla.Calcular(6000);
            }
            catch (Exception ex)
            {
                mensaje = ex.Message;
            }

            //assert
            Assert.AreEqual(resultado, "180");
            //teardown
        }

        public void TotalIntroducidoIgualA12000()
        {
            double resultado = 0;
            string mensaje = "";
            //setup
            ReglaDeDescuento regla = new ReglaDeDescuento();
            //execute
            try
            {
                resultado = regla.Calcular(12000);
            }
            catch (Exception ex)
            {
                mensaje = ex.Message;
            }

            //assert
            Assert.AreEqual(resultado, "600");
            //teardown
        }


    }
}