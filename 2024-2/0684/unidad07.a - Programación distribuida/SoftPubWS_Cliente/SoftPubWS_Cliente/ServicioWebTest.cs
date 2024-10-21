using System;

namespace SoftPubWS_Cliente
{
    internal class ServicioWebTest
    {
        public static OtroNameSpace.ServicioWebClient ws_Cliente;

        internal static void ServicioWebClienteTest()
        {
            ws_Cliente = new OtroNameSpace.ServicioWebClient();

            System.Console.WriteLine("Prueba del servicio Web");
            int a = 10, b = 20;
            string nombre = "programacion 3";

            int c = ws_Cliente.sumar(a, b);
            System.Console.WriteLine("El resultado de la suma es: " + c);

            c = ws_Cliente.multiplicar(a, b);
            System.Console.WriteLine("El resultado de la multiplicación es: " + c);

            string saludo = ws_Cliente.hello(nombre);
            System.Console.WriteLine("El saludo es: " + saludo);
        }
    }
}