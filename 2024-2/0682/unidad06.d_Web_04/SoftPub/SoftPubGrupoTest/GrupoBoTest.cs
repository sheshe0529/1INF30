using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubGrupoBussiness;

namespace SoftPubGrupoTest
{
    internal class GrupoBoTest
    {
        private static GrupoBo grupoBo;

        public static void testGrupoBo()
        {
            System.Console.WriteLine("\ntestGrupoBo");
            grupoBo = new GrupoBo();
            testGrupoBoInsertar();
            System.Console.ReadLine();
        }

        private static void testGrupoBoInsertar()
        {
            int? id = grupoBo.insertar("Grupo de Inteligencia Artificial PUCP", "IA-PUCP");
            System.Console.WriteLine("idGrupo: " + id);
        }
    }
}
