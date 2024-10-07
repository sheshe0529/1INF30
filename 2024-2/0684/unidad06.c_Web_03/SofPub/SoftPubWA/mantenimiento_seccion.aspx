<%@ Page Title="" Language="C#" MasterPageFile="~/SoftPub.Master" AutoEventWireup="true" CodeBehind="mantenimiento_seccion.aspx.cs" Inherits="SoftPubWA.mantenimiento_seccion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
    Mantenimiento de Sección
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphContenido" runat="server">
    <asp:GridView ID="dgvSeccion" runat="server" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped">
        <Columns>
            <asp:BoundField HeaderText ="Id de la Sección" DataField="IdSeccion"/>
            <asp:BoundField HeaderText ="Nombre de la Sección" DataField="Nombre_seccion"/>
            <asp:BoundField HeaderText ="Departamento" DataField="Departamento"/>
            <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton runat="server" Text="<i class='fa-solid fa-edit ps-2'></i>"  CommandArgument='<%# Eval("IdSeccion") %>'  />
                            <asp:LinkButton runat="server" Text="<i class='fa-solid fa-trash ps-2'></i>" CommandArgument='<%# Eval("IdSeccion") %>' />
                        </ItemTemplate>
                    </asp:TemplateField>
        </Columns>
    </asp:GridView>
    <div class="card-footer">
        <asp:Button ID="btnInsertar" CssClass="float-start btn btn-primary" runat="server" Text="Insertar" OnClick="btnInsertar_Click" />
    </div>
</asp:Content>
