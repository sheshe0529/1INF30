<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPub.Master" AutoEventWireup="true" CodeBehind="reporte_especialidad_seleccion.aspx.cs" Inherits="SoftPubWA.reporte_especialidad_seleccion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Reporte de Especialidades
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-body">
                <div class="mb-3 row">
                     <asp:Label ID="lblEspecialidad" runat="server" Text="Especialidad:" CssClass="col-form-label fw-bold"></asp:Label>
                     <div class="col-sm-4">
                        <asp:DropDownList ID="ddlEspecialidad" runat="server" CssClass="form-select"></asp:DropDownList>
                    </div>
                    <div class="col-sm-4">
                        <asp:Button ID="btnGenerarReporte" runat="server" Text="Generar Reporte" OnClick="btnGenerarReporte_Click" OnClientClick="target ='_blank';"/>
                    </div>                 
                </div>                 
            </div>
        </div>
    </div>
</asp:Content>
