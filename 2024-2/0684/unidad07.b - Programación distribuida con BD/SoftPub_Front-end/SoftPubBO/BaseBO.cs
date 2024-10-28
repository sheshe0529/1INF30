using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftPubBO.ServicioWeb;

namespace SoftPubBO
{
    public class BaseBO
    {
        private ServicioWeb.ServicioWebClient wsCliente;

        public BaseBO()
        {
            this.WsCliente = new ServicioWeb.ServicioWebClient();
        }

        public ServicioWebClient WsCliente { get => wsCliente; set => wsCliente = value; }
    }
}
