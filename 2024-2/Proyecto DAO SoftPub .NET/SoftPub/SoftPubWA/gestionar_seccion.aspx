<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPub.Master" AutoEventWireup="true" CodeBehind="gestionar_seccion.aspx.cs" Inherits="SoftPubWA.insertar_seccion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Creación de secciones
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="card">
    <div class="card-header">
        <h2>Creación de sección</h2>
    </div>
    <div class="card-body">
        <div class="mb-3 row">
            <asp:Label ID="lblIdSeccion" runat="server" Text="Id Sección: " CssClass="col-sm-2 col-form-label"></asp:Label>
            <div class="col-sm-4">
                <asp:TextBox ID="txtIdSeccion" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
        </div>
        <div class="mb-3 row">
            <asp:Label ID="lblSeccion" runat="server" Text="Nombre de Sección: " CssClass="col-sm-2 col-form-label"></asp:Label>
            <div class="col-sm-4">
                <asp:TextBox ID="txtSeccion" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
        </div>
        <div class="mb-3 row">
            <asp:Label ID="lblDepartamento" runat="server" Text="Nombre del Departamento: " CssClass="col-sm-2 col-form-label"></asp:Label>
            <div class="col-sm-4">
                <asp:TextBox ID="txtDepartamento" runat="server" CssClass="form-control"></asp:TextBox>
            </div>
        </div>
    </div>
    <div class="card-footer">
        <asp:Button ID="btnRegresar" CssClass="float-start btn btn-primary" runat="server" Text="Regresar" OnClick="btnRegresar_Click"/>
        <asp:Button ID="btnGuardar" CssClass="float-end btn btn-secondary" runat="server" Text="Guardar" OnClick="btnGuardar_Click"/>
    </div>
</div>
</asp:Content>
