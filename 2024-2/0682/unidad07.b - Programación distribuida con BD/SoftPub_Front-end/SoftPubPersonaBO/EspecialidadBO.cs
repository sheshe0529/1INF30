using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubBaseBO;
using SoftPubBaseBO.ServicioWeb;

namespace SoftPubPersonaBO
{
    public class EspecialidadBO : BaseBO
    {
        public int insertar(int idEspecialidad, string nombre_especialidad, string facultad, nivel _nivel)
        {
            return WsCliente.especialidad_insertar(idEspecialidad, nombre_especialidad, facultad, _nivel);
        }

        public int modificar(int idEspecialidad, string nombre_especialidad, string facultad, nivel _nivel)
        {
            return WsCliente.especialidad_modificar(idEspecialidad, nombre_especialidad, facultad, _nivel);    
        }

        public int eliminar(int idEspecialidad)
        {
            return WsCliente.especialidad_eliminar(idEspecialidad);    
        }

        public BindingList<especialidad> listarTodos()
        {
            especialidad[] arreglo = WsCliente.especialidad_listarTodos();
            return new BindingList<especialidad>(arreglo);
        }

        public especialidad obtenerPorId(int idEspecialidad)
        {
            return WsCliente.especialidad_obtenerPorId(idEspecialidad);
        }
    }
}
