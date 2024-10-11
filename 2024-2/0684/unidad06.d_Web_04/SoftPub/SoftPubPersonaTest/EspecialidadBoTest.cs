using System;
using System.ComponentModel;
using SoftPubPersonaBussiness;
using SoftPubPersonaModel;

namespace SoftPubPersonaTest
{
    internal class EspecialidadBoTest
    {
        private static EspecialidadBo especialidadBo;

        internal static void testEspecialidadBo()
        {
            System.Console.WriteLine("\ntestEspecialidadBo");
            especialidadBo = new EspecialidadBo();            
            testEspecialidadBoListarTodos(); 
        }

        private static void testEspecialidadBoListarTodos()
        {
            BindingList<Object> listaEspecialidad = especialidadBo.listarTodos();
            foreach (Especialidad especialidad in listaEspecialidad)
            {
                System.Console.Write(especialidad.IdEspecialidad);
                System.Console.Write(", ");
                System.Console.Write(especialidad.Nombre_especialidad);
                System.Console.Write(", ");
                System.Console.Write(especialidad.Facultad);
                System.Console.Write(", ");
                System.Console.WriteLine(especialidad.Nivel);
            }
        }
    }
}