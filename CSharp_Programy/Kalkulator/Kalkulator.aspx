<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Kalkulator.aspx.cs" Inherits="Calculator" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
        <asp:Button ID="Button1" runat="server" Text="Add" OnClick="Button1_Click" />
        <asp:Button ID="Button2" runat="server" Text="Substract" OnClick="Button2_Click" />
        <asp:Button ID="Button3" runat="server" Text="Multiply" OnClick="Button3_Click" />
        <asp:Button ID="Button4" runat="server" Text="Divide" OnClick="Button4_Click" />
        <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>


    </div>
    </form>
</body>
</html>
