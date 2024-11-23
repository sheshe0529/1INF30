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
        private ServicioWeb.ReportesClient wsReportes;

        public BaseBO()           
        { 
            this.wsCliente = new ServicioWeb.ServicioWebClient();
            this.WsReportes = new ServicioWeb.ReportesClient();
        }

        protected ReportesClient WsReportes { get => wsReportes; set => wsReportes = value; }
        protected ServicioWebClient WsCliente { get => wsCliente; set => wsCliente = value; }
    }
}
