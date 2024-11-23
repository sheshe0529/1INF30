using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftPubPersonaBO;

namespace SoftPubWA
{
    public partial class reporte_especialidad : System.Web.UI.Page
    {
        private EspecialidadBO especialidadBO;

        public reporte_especialidad()
        {
            this.especialidadBO = new EspecialidadBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            int idEpecialidad = (int)Session["idEspecialidad"];
            byte[] reporte = this.especialidadBO.reporteEspecialidad(idEpecialidad);
            this.especialidadBO.abrirReporte(Response, "ReporteEspecialidad.pdf", reporte);            
        }
    }
}