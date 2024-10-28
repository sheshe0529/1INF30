using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftPubBO.ServicioWeb;
using SoftPubPersonaBO;
using static System.Collections.Specialized.BitVector32;

namespace SoftPubWA
{
    public partial class gestionar_seccion : System.Web.UI.Page
    {
        private SeccionBO seccionBO;
        private string idSeccion;
        private bool esta_modificando;

        public gestionar_seccion()
        {
            this.seccionBO = new SeccionBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Page_Init(object sender, EventArgs e)
        {
            this.idSeccion = (string)Session["idSeccion"];
            string accion = Request.QueryString["accion"];
            if (accion != null && accion == "modificar")
                esta_modificando = true;
            else
                esta_modificando = false;
            if (esta_modificando)
                this.cargarDatosDeLaBD();
        }

        private void cargarDatosDeLaBD()
        {
            seccion _seccion = this.seccionBO.obtenerPorId(this.idSeccion);
            txtIdSeccion.Text = _seccion.idSeccion;
            txtIdSeccion.Enabled = false;
            txtSeccion.Text = _seccion.seccion1;
            txtDepartamento.Text = _seccion.departamento;
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            string idSeccion = txtIdSeccion.Text;
            string nombre_seccion = txtSeccion.Text;
            string departamento = txtDepartamento.Text;
            if (esta_modificando)
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