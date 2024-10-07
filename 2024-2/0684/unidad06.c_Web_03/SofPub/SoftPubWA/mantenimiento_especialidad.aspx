<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPub.Master" AutoEventWireup="true" CodeBehind="mantenimiento_especialidad.aspx.cs" Inherits="SoftPubWA.mantenimiento_especialidad" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Especialidad
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
        <asp:GridView ID="dgvEspecialidad" runat="server" CssClass="table table-hover table-responsive table-striped"></asp:GridView>
        <div class="card-footer">
            <asp:Button ID="btnInsertar" CssClass="float-start btn btn-primary" runat="server" Text="Insertar" OnClick="btnInsertar_Click" />
        </div>
</asp:Content>
