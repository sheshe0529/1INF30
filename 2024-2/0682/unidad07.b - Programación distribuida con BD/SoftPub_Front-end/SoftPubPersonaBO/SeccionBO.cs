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
    public class SeccionBO: BaseBO
    {
        public int insertar(string idSeccion, string nombre_seccion, string departamento)
        {
            return this.WsCliente.seccion_insertar(idSeccion, nombre_seccion, departamento);    
        }

        public int modificar(string idSeccion, string nombre_seccion, string departamento)
        {
            return this.WsCliente.seccion_modificar(idSeccion, nombre_seccion, departamento);
        }

        public int eliminar(string idSeccion)
        {
            return this.WsCliente.seccion_eliminar(idSeccion);   
        }

        public BindingList<seccion> listarTodos()
        {
            seccion[] arreglo = WsCliente.seccion_listarTodos();
            return new BindingList<seccion>(arreglo);
        }

        public seccion obtenerPorId(string idSeccion)
        {
            return WsCliente.seccion_obtenerPorId(idSeccion);   
        }
    }
}
