using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftPubPersonaBO;

namespace SoftPubWA
{
    public partial class reporte_seccion : System.Web.UI.Page
    {
        private SeccionBO seccionBO;

        public reporte_seccion()
        {
            this.seccionBO = new SeccionBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            byte[] reporte = this.seccionBO.reporteSeccion();
            this.seccionBO.abrirReporte(Response, "ReporteSeccion.pdf", reporte);
            //Response.Clear();
            //Response.ContentType = "application/pdf";
            //Response.AddHeader("Content-Disposition", "inline;filename=ReporteSeccion.pdf");
            //Response.BinaryWrite(reporte);
            //Response.End();
        }
    }
}