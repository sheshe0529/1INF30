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
    public partial class gestionar_seccion : System.Web.UI.Page
    {
        private SeccionBO seccionBO;

        public gestionar_seccion() {
            this.seccionBO = new SeccionBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("mantenimiento_seccion.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            string idSeccion = txtIdSeccion.Text;
            string nombre_seccion = txtSeccion.Text;
            string departamento = txtDepartamento.Text;
            this.seccionBO.insertar(idSeccion, nombre_seccion, departamento);
            Response.Redirect("mantenimiento_seccion.aspx");
        }
    }    
}