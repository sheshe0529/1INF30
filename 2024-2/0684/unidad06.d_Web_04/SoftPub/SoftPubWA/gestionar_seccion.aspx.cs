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
        private SeccionBo seccionBO;
        private string idSeccion;
        private bool esta_modificando;

        public insertar_seccion()
        {
            this.seccionBO = new SeccionBo();
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Page_Init(object sender, EventArgs e)
        {
            this.idSeccion = (string) Session["idSeccion"];
            string accion = Request.QueryString["accion"];
            if (accion != null && accion == "modificar")
                this.esta_modificando = true;
            else
                this.esta_modificando = false;
            if (this.esta_modificando)
                this.cargarDatosDeLaBD();
        }

        private void cargarDatosDeLaBD()
        {
            Seccion seccion = this.seccionBO.obtenerPorId(this.idSeccion);
            txtIdSeccion.Text = seccion.IdSeccion;
            txtSeccion.Text = seccion.Nombre_Seccion;
            txtDepartamento.Text = seccion.Departamento;
            txtIdSeccion.Enabled = false;
        }        

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            string idSeccion = txtIdSeccion.Text;
            string nombre_seccion = txtSeccion.Text;
            string departamento = txtDepartamento.Text;
            if (this.esta_modificando)
                this.seccionBO.modificar(idSeccion, nombre_seccion, departamento);
            else
                this.seccionBO.insertar(idSeccion, nombre_seccion, departamento);
            Response.Redirect("mantenimiento_seccion.aspx");
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("mantenimiento_seccion.aspx");
        }
    }
}