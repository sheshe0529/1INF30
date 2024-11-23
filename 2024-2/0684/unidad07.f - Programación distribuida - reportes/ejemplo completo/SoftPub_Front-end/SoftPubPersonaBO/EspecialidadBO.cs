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
        public byte[] reporteEspecialidad(int idEspecialidad)
        {
            return this.WsReportes.reporteEspecialidad(idEspecialidad);
        }

        public int insertar(int idEspecialidad, string nombre_especialidad, string faculdad, string descripcion_nivel)
        { 
            nivel _nivel = (nivel)Enum.Parse(typeof(nivel), descripcion_nivel);
            return this.WsCliente.especialidad_insertar(idEspecialidad, nombre_especialidad, faculdad, _nivel);
        }

        public int modificar(int idEspecialidad, string nombre_especialidad, string faculdad, string descripcion_nivel)
        {
            nivel _nivel = (nivel)Enum.Parse(typeof(nivel), descripcion_nivel);
            return this.WsCliente.especialidad_modificar(idEspecialidad, nombre_especialidad, faculdad, _nivel);
        }

        public int eliminar(int idEspecialidad)
        {
            return this.WsCliente.especialidad_eliminar(idEspecialidad);
        }

        public BindingList<especialidad> listarTodos()
        {
            especialidad[] arreglo = this.WsCliente.especialidad_listarTodos();
            if (arreglo == null)
                return null;
            else
                return new BindingList<especialidad>(arreglo);
        }

        public BindingList<especialidad> listarTodosReporte()
        {            
            especialidad[] arreglo = this.WsCliente.especialidad_listarTodos();
            if (arreglo == null)
                return null;
            else {
                especialidad _especialidad = new especialidad();
                _especialidad.idEspecialidad = 0;
                _especialidad.especialidad1 = "Todas";

                BindingList<especialidad> lista = new BindingList<especialidad>();
                lista.Add(_especialidad);

                foreach (especialidad objeto in arreglo)
                {
                    lista.Add(objeto);
                }
                return lista;
            }
        }

        public especialidad obtenerPorId(int idEspecialidad)
        {
            return this.WsCliente.especialidad_obtenerPorId(idEspecialidad);
        }        
    }
}
