using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftPubPersonaBO;

namespace SoftPubWA
{
    public partial class mantenimiento_seccion : System.Web.UI.Page
    {
        private SeccionBO seccionBo;
        private BindingList<Object> listaDeTodos; 

        public mantenimiento_seccion()
        {
            this.seccionBo = new SeccionBO();
            this.listaDeTodos = this.seccionBo.listarTodos();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            dgvSeccion.DataSource = this.listaDeTodos;
            dgvSeccion.DataBind();
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {

        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            string idSeccion = ((LinkButton)sender).CommandArgument;
            this.seccionBo.eliminar(idSeccion);
            Response.Redirect("mantenimiento_seccion.aspx");
        }

        protected void btnInsertar_Click(object sender, EventArgs e)
        {
            Response.Redirect("gestionar_seccion.aspx");
        }
    }
}