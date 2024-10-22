using System;

namespace SoftPubWS_Cliente
{
    internal class ServicioWebTest
    {
        public static ServicioWeb.ServicioWebClient wsCliente;

        internal static void servicioWebClienteTest()
        {
            wsCliente = new ServicioWeb.ServicioWebClient();
            int a = 10, b = 20;
            string nombre = "programacion 3";

            int c = wsCliente.sumar(a, b);
            System.Console.WriteLine("El resultado de la suma es: " + c);

            c = wsCliente.multiplicar(a, b);
            System.Console.WriteLine("El resultado de la multiplicacion es: " + c);

            string saludo = wsCliente.hello(nombre);
            System.Console.WriteLine("El saludo es: " + saludo);
        }
    }
}