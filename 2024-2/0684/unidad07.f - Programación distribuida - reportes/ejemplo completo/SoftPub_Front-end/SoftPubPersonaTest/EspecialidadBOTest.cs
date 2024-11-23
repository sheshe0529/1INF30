using System;
using System.ComponentModel;
using SoftPubBaseBO.ServicioWeb;
using SoftPubPersonaBO;

namespace SoftPubPersonaTest
{
    internal class EspecialidadBOTest
    {
        private static EspecialidadBO especialidadBO;

        internal static void testEspecialidadBO()
        {
            System.Console.WriteLine("testEspecialidadBO");
            especialidadBO = new EspecialidadBO();
            testEspecialidadBOInsertar();
            testEspecialidadBOListarTodos();
            testEspecialidadBOModificar();
            testEspecialidadBOListarTodos();
            testEspecialidadBOObtenerPorId();
            testEspecialidadBOEliminar();
        }

        private static void testEspecialidadBOEliminar()
        {
            System.Console.WriteLine("testEspecialidadBOEliminar");
            int resultado = especialidadBO.eliminar(1);
            resultado = especialidadBO.eliminar(2);
        }

        private static void testEspecialidadBOObtenerPorId()
        {
            System.Console.WriteLine("testEspecialidadBOObtenerPorId");
            especialidad _especialidad = especialidadBO.obtenerPorId(1);
            System.Console.WriteLine("objetoPorId: 1 - " + _especialidad);
            System.Console.Write(_especialidad.idEspecialidad);
            System.Console.Write(", ");
            System.Console.Write(_especialidad.especialidad1);
            System.Console.Write(", ");
            System.Console.Write(_especialidad.facultad);
            System.Console.Write(", ");
            System.Console.WriteLine(_especialidad.nivel);

            _especialidad = especialidadBO.obtenerPorId(2);
            System.Console.WriteLine("objetoPorId: 2 - " + _especialidad);
            System.Console.Write(_especialidad.idEspecialidad);
            System.Console.Write(", ");
            System.Console.Write(_especialidad.especialidad1);
            System.Console.Write(", ");
            System.Console.Write(_especialidad.facultad);
            System.Console.Write(", ");
            System.Console.WriteLine(_especialidad.nivel);

            _especialidad = especialidadBO.obtenerPorId(3);
            System.Console.WriteLine("objetoPorId: 3 - " + _especialidad);
            System.Console.Write(_especialidad.idEspecialidad);
            System.Console.Write(", ");
            System.Console.Write(_especialidad.especialidad1);
            System.Console.Write(", ");
            System.Console.Write(_especialidad.facultad);
            System.Console.Write(", ");
            System.Console.WriteLine(_especialidad.nivel);
        }

        private static void testEspecialidadBOModificar()
        {
            System.Console.WriteLine("testEspecialidadBOModificar");
            int resultado = especialidadBO.modificar(1, "Ingeniería Informática", "FCI", nivel.PREGRADO.ToString());
            resultado = especialidadBO.modificar(2, "Maestría en Informática", "EP", nivel.MAESTRIA.ToString());
        }

        private static void testEspecialidadBOListarTodos()
        {
            System.Console.WriteLine("testEspecialidadBOListarTodos");
            BindingList<especialidad> lista = especialidadBO.listarTodos();
            foreach (especialidad _especialidad in lista)
            {
                System.Console.Write(_especialidad.idEspecialidad);
                System.Console.Write(", ");
                System.Console.Write(_especialidad.especialidad1);
                System.Console.Write(", ");
                System.Console.Write(_especialidad.facultad);
                System.Console.Write(", ");
                System.Console.WriteLine(_especialidad.nivel);
            }
        }

        private static void testEspecialidadBOInsertar()
        {
            System.Console.WriteLine("testEspecialidadBOInsertar");
            int resultado = especialidadBO.insertar(1, "Ingeniería Informática", "Ciencias e Ingeniería", nivel.PREGRADO.ToString());
            resultado = especialidadBO.insertar(2, "Maestría en Informática", "Escuela de Posgrado", nivel.MAESTRIA.ToString());
        }
    }
}