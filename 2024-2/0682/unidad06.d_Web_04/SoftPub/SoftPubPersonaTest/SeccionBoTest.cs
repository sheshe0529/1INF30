using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubPersonaBussiness;
using SoftPubPersonaModel;

namespace SoftPubPersonaTest
{
    internal class SeccionBoTest
    {
        private static SeccionBo seccionBo;

        internal static void testSeccionBo()
        {
            System.Console.WriteLine("\ntestSeccionBo");
            seccionBo = new SeccionBo();
            //testSeccionBoInsertarSecciones();
            testSeccionBoListarTodos();            
        }

        private static void testSeccionBoListarTodos()
        {
            BindingList<Object> listaSeccion = seccionBo.listarTodos();
            foreach (Seccion seccion in listaSeccion)
            {
                System.Console.Write(seccion.IdSeccion);
                System.Console.Write(", ");
                System.Console.Write(seccion.Nombre_Seccion);
                System.Console.Write(", ");
                System.Console.WriteLine(seccion.Departamento);
            }
        }

        private static void testSeccionBoInsertarSecciones()
        {
            int resultado = seccionBo.insertar("INF", "Ingeniería Informática", "Ingeniería");
            resultado = seccionBo.insertar("TEL", "Ingeniería de las Telecomunicaciones", "Ingeniería");
            resultado = seccionBo.insertar("ELE", "Ingeniería Electrónica", "Ingeniería");
            resultado = seccionBo.insertar("MEC", "Ingeniería Mecánica", "Ingeniería");

        }
    }
}
