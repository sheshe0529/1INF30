using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubBaseBO.ServicioWeb;

namespace SoftPubBaseBO
{
    public class BaseBO
    {
        private ServicioWeb.ServicioWebClient wsCliente;

        public BaseBO()           
        { 
            this.wsCliente = new ServicioWeb.ServicioWebClient();
        }

        protected ServicioWebClient WsCliente { get => wsCliente; set => wsCliente = value; }
    }
}
