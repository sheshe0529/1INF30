using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftPubBaseBO.ServicioWeb;
using SoftPubPersonaBO;

namespace SoftPubWA
{
    public partial class reporte_especialidad_seleccion : System.Web.UI.Page
    {
        private EspecialidadBO especialidadBO;

        public reporte_especialidad_seleccion()
        {
            this.especialidadBO = new EspecialidadBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack) 
            { 
                ddlEspecialidad.DataSource = this.especialidadBO.listarTodosReporte();
                ddlEspecialidad.DataTextField = "especialidad1";
                ddlEspecialidad.DataValueField = "idEspecialidad";
                ddlEspecialidad.DataBind();
            }
        }

        protected void btnGenerarReporte_Click(object sender, EventArgs e)
        {
            int idEspecialidad = Int32.Parse(ddlEspecialidad.SelectedValue);
            Session["idEspecialidad"] = idEspecialidad;
            Response.Redirect("reporte_especialidad.aspx");
        }
    }
}