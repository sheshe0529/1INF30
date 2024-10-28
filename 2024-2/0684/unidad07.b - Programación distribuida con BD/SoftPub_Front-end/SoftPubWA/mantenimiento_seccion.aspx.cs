﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftPubBO.ServicioWeb;
using SoftPubPersonaBO;

namespace SoftPubWA
{
    public partial class mantenimiento_seccion : System.Web.UI.Page
    {
        private SeccionBO seccionBO;
        private BindingList<seccion> listaDeTodos;

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
            Response.Redirect("gestionar_seccion.aspx");
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            string idSeccion = ((LinkButton)sender).CommandArgument;
            Session["idSeccion"] = idSeccion;
            Response.Redirect("gestionar_seccion.aspx?accion=modificar");
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            string idSeccion = ((LinkButton)sender).CommandArgument;
            this.seccionBO.eliminar(idSeccion);
            Response.Redirect("mantenimiento_seccion.aspx");
        }

        protected void dgvSeccion_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            dgvSeccion.PageIndex = e.NewPageIndex;
            dgvSeccion.DataBind();
        }
    }
}