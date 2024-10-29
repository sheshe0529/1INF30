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
    public partial class gestionar_especialidad : System.Web.UI.Page
    {
        private EspecialidadBO especialidadBO;
        private int idEspecialidad;
        private bool esta_modificando;

        public gestionar_especialidad()
        {
            this.especialidadBO = new EspecialidadBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Page_Init(object sender, EventArgs e)
        {
            if (Session["idEspecialidad"] != null)
                this.idEspecialidad = (int)Session["idEspecialidad"];
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
            especialidad _especialidad = this.especialidadBO.obtenerPorId(this.idEspecialidad);
            txtIdEspecialidad.Text = _especialidad.idEspecialidad.ToString();
            txtIdEspecialidad.Enabled = false;
            txtEspecialidad.Text = _especialidad.especialidad1;
            txtFacultad.Text = _especialidad.facultad;
            ddlNivel.SelectedValue = _especialidad.nivel.ToString();
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            int idEspecialidad = Int32.Parse(txtIdEspecialidad.Text);
            string nombre_especialidad = txtEspecialidad.Text;
            string faculdad = txtFacultad.Text;
            string descripcion_nivel = ddlNivel.Text;
            //if (esta_modificando)
            //    this.especialidadBO.modificar(idEspecialidad, nombre_especialidad, faculdad, descripcion_nivel);
            //else
            //    this.especialidadBO.insertar(idEspecialidad, nombre_especialidad, faculdad, descripcion_nivel);

            Response.Redirect("mantenimiento_especialidad.aspx");
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("mantenimiento_especialidad.aspx");
        }
    }
}