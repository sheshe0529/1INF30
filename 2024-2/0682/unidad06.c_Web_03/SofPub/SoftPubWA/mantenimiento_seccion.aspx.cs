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
        private BindingList<Object> listaDeTodo; 

        public mantenimiento_seccion()
        {
            this.seccionBo = new SeccionBO();
            this.listaDeTodo = this.seccionBo.listarTodos();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            dgvSeccion.DataSource = this.listaDeTodo;
            dgvSeccion.DataBind();
        }
    }
}