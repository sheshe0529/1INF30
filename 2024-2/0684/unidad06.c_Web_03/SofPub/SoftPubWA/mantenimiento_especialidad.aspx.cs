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
    public partial class mantenimiento_especialidad : System.Web.UI.Page
    {
        private EspecialidadBO especialidadBO;
        private BindingList<Object> listaDeTodos;

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

        }
    }
}