<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPub.Master" AutoEventWireup="true" CodeBehind="gestionar_especialidad.aspx.cs" Inherits="SoftPubWA.gestionar_especialidad" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Gestión de especialidades
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Creación de especialidad</h2>
            </div>
            <div class="card-body">
                <div class="mb-3 row">
                    <asp:Label ID="lblIdEspecialidad" runat="server" Text="Id Especialidad: " CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-4">
                        <asp:TextBox ID="txtIdEspecialidad" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblEspecialidad" runat="server" Text="Nombre de Especialidad: " CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-4">
                        <asp:TextBox ID="txtEspecialidad" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblFacultad" runat="server" Text="Nombre de Facultad: " CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-4">
                        <asp:TextBox ID="txtFacultad" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblNivel" runat="server" Text="Nivel: " CssClass="col-sm-2 col-form-label"></asp:Label>
                    <div class="col-sm-4">
                        <asp:DropDownList  ID="ddlNivel" runat="server" CssClass="form-control">
                            <asp:ListItem Selected="True" Value="PREGRADO"> Pregrado </asp:ListItem>
                            <asp:ListItem Value="MAESTRIA"> Maestría </asp:ListItem>        
                        </asp:DropDownList>                        
                    </div>
                </div>
            </div>
            <div class="card-footer">
                <asp:Button ID="btnRegresar" CssClass="float-start btn btn-primary" runat="server" Text="Regresar" OnClick="btnRegresar_Click"/>
                <asp:Button ID="btnGuardar" CssClass="float-end btn btn-secondary" runat="server" Text="Guardar" OnClick="btnGuardar_Click"/>
            </div>
        </div>
    </div>
</asp:Content>
