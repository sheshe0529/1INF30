using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubPersonaBO;

namespace SoftPubPersonaTest
{
    internal class Program
    {
        static void Main(string[] args)
        {
            SeccionBO seccionBO = new SeccionBO();
            System.Console.WriteLine("testSeccionBOInsertarSecciones");
            int resultado = seccionBO.insertar("INF", "Ingeniería Informática", "Ingeniería");
            resultado = seccionBO.insertar("TEL", "Ingeniería de las Telecomunicaciones", "Ingeniería");
            resultado = seccionBO.insertar("ELE", "Ingeniería Electrónica", "Ingeniería");
            resultado = seccionBO.insertar("MEC", "Ingeniería Mecánica", "Ingeniería");
        }
    }
}
