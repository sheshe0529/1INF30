﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftPubPersonaBussiness;

namespace SoftPubWA
{
    public partial class mantenimiento_seccion : System.Web.UI.Page
    {
        private SeccionBo seccionBo;
        private BindingList<Object> listaDeTodos;

        public mantenimiento_seccion()
        {
            this.seccionBo = new SeccionBo();
            this.listaDeTodos = this.seccionBo.listarTodos();
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
            //TODO
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            string idSeccion = ((LinkButton)sender).CommandArgument;
            this.seccionBo.eliminar(idSeccion);
            Response.Redirect("mantenimiento_seccion.aspx");
        }

        protected void dgvSeccion_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            dgvSeccion.PageIndex = e.NewPageIndex;
            dgvSeccion.DataBind();
        }
    }
}