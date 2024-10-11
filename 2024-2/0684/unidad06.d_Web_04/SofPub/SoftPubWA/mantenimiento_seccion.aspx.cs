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
        private SeccionBO seccionBO;
        private BindingList<Object> listaDeTodos;

        public mantenimiento_seccion()
        {
            this.seccionBO = new SeccionBO();
            this.listaDeTodos = this.seccionBO.listarTodos();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            dgvSeccion.DataSource = listaDeTodos;
            dgvSeccion.DataBind();
        }

        protected void btnInsertar_Click(object sender, EventArgs e)
        {

        }

        protected void Unnamed_Click(object sender, EventArgs e)
        {

        }
    }
}