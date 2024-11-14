using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftPubBaseBO.ServicioWeb;
using SoftPubPersonaBO;

namespace SoftPubWA
{
    public partial class mantenimiento_especialidad : System.Web.UI.Page
    {
        private EspecialidadBO especialidadBO;
        private BindingList<especialidad> listaDeTodos;

        public mantenimiento_especialidad()
        {
            this.especialidadBO = new EspecialidadBO();
            this.listaDeTodos = this.especialidadBO.listarTodos();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            dgvEspecialidad.DataSource = listaDeTodos;
            dgvEspecialidad.DataBind();
        }

        protected void btnInsertar_Click(object sender, EventArgs e)
        {
            Response.Redirect("gestionar_especialidad.aspx");
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int idEspecialidad = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["idEspecialidad"] = idEspecialidad;
            Response.Redirect("gestionar_especialidad.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int idEspecialidad = Int32.Parse(((LinkButton)sender).CommandArgument);
            this.especialidadBO.eliminar(idEspecialidad);
            Response.Redirect("mantenimiento_especialidad.aspx");
        }
    }
}