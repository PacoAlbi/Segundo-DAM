<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="_05_Hola_Mundo_WebForm.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <p style="margin-left: 80px">
            HOLA </p>
        <p style="margin-left: 40px">
            Introduce tu nombre</p>
        <p style="margin-left: 40px">
            <asp:TextBox ID="entryNombre" runat="server"></asp:TextBox>
        </p>
        <p style="margin-left: 40px">
            Introduce tu apellido</p>
        <p style="margin-left: 40px">
            <asp:TextBox ID="entryApellido" runat="server"></asp:TextBox>
        </p>
        <div style="margin-left: 80px">
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Saludo" />
        </div>
        <p>
            <asp:Label ID="texto" runat="server"></asp:Label>
        </p>
    </form>
</body>
</html>
