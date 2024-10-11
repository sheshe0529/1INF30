using System;
using System.Collections.Generic;
using System.Diagnostics.Eventing.Reader;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftPubPersonaBussiness;
using SoftPubPersonaModel;

namespace SoftPubWA
{
    public partial class insertar_seccion : System.Web.UI.Page
    {
        private SeccionBo seccionBo;
        private string idSeccion;
        private bool esta_modificando;

        public insertar_seccion()
        {
            this.seccionBo = new SeccionBo();
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Page_Init(object sender, EventArgs e)
        {
            //TODO
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            string idSeccion = txtIdSeccion.Text;
            string nombre_seccion = txtSeccion.Text;
            string departamento = txtDepartamento.Text;    
            if (esta_modificando)
                this.seccionBo.modificar(idSeccion, nombre_seccion, departamento);
            else
                this.seccionBo.insertar(idSeccion, nombre_seccion, departamento);
            Response.Redirect("mantenimiento_seccion.aspx");
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("mantenimiento_seccion.aspx");
        }
    }
}