﻿<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPub.Master" AutoEventWireup="true" CodeBehind="mantenimiento_seccion.aspx.cs" Inherits="SoftPubWA.mantenimiento_seccion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Sección
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <asp:GridView ID="dgvSeccion" runat="server" CssClass="table table-hover table-responsive table-striped"></asp:GridView>
    <div class="card-footer">
        <asp:Button ID="btnInsertar" CssClass="float-start btn btn-primary" runat="server" Text="Insertar" OnClick="btnInsertar_Click" />
    </div>
</asp:Content>