using System;
using System.ComponentModel;
using SoftPubBO.ServicioWeb;
using SoftPubPersonaBO;

namespace SoftPubPersonaTest
{
    internal class SeccionBOTest
    {
        private static SeccionBO seccionBO;

        internal static void testSeccionBO()
        {
            System.Console.WriteLine("testSeccionBO");
            seccionBO = new SeccionBO();
            testSeccionBOInsertarSecciones();
            testSeccionBOListarTodos();
            testSeccionBOModificarSecciones();
            testSeccionBOListarTodos();
            testSeccionBOObtenerPorId();
            testSeccionBOEliminarSecciones();
            System.Console.ReadKey();
        }

        private static void testSeccionBOEliminarSecciones()
        {
            System.Console.WriteLine("testSeccionBOEliminarSecciones");
            int resultado = seccionBO.eliminar("INF");
            resultado = seccionBO.eliminar("MEC");
            resultado = seccionBO.eliminar("ELE");
            resultado = seccionBO.eliminar("TEL");
        }

        private static void testSeccionBOObtenerPorId()
        {
            System.Console.WriteLine("testSeccionBOObtenerPorId");
            seccion _seccion = seccionBO.obtenerPorId("MEC");
            if (_seccion != null)
            {
                System.Console.Write(_seccion.idSeccion);
                System.Console.Write(", ");
                System.Console.Write(_seccion.seccion1);
                System.Console.Write(", ");
                System.Console.WriteLine(_seccion.departamento);
            }
            else
            {
                System.Console.WriteLine("No existe la seccion MEC\n");
            }

            _seccion = seccionBO.obtenerPorId("TEL");
            if (_seccion != null)
            {
                System.Console.Write(_seccion.idSeccion);
                System.Console.Write(", ");
                System.Console.Write(_seccion.seccion1);
                System.Console.Write(", ");
                System.Console.WriteLine(_seccion.departamento);
            }
            else
            {
                System.Console.WriteLine("No existe la seccion TEL");
            }
        }

        private static void testSeccionBOListarTodos()
        {
            System.Console.WriteLine("testSeccionBOListarTodos");
            BindingList<seccion> listaSeccion = seccionBO.listarTodos();
            foreach (seccion _seccion in listaSeccion)
            {
                System.Console.Write(_seccion.idSeccion);
                System.Console.Write(", ");
                System.Console.Write(_seccion.seccion1);
                System.Console.Write(", ");
                System.Console.WriteLine(_seccion.departamento);
            }
        }

        private static void testSeccionBOModificarSecciones()
        {
            System.Console.WriteLine("testSeccionBOModificarSecciones");
            int resultado = seccionBO.modificar("INF", "INFORMÁTICA", "Ingeniería");
            resultado = seccionBO.modificar("TEL", "TELECO", "Ingeniería");

        }

        private static void testSeccionBOInsertarSecciones()
        {
            System.Console.WriteLine("testSeccionBOInsertarSecciones");
            int resultado = seccionBO.insertar("INF", "Ingeniería Informática", "Ingeniería");
            resultado = seccionBO.insertar("TEL", "Ingeniería de las Telecomunicaciones", "Ingeniería");
            resultado = seccionBO.insertar("ELE", "Ingeniería Electrónica", "Ingeniería");
            resultado = seccionBO.insertar("MEC", "Ingeniería Mecánica", "Ingeniería");
        }
    }
}