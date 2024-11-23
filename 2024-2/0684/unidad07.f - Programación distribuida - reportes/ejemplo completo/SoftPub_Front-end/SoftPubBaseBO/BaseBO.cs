using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;
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

        public void abrirReporte(HttpResponse response, string nombreDeReporte, byte[] reporte)
        {
            response.Clear();
            response.ContentType = "application/pdf";
            response.AddHeader("Content-Disposition", "inline;filename=" + nombreDeReporte + ".pdf");
            response.BinaryWrite(reporte);
            response.End();
        }

        public ReportesClient WsReportes { get => wsReportes; set => wsReportes = value; }
        protected ServicioWebClient WsCliente { get => wsCliente; set => wsCliente = value; }
    }
}
