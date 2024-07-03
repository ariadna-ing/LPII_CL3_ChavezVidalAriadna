<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="model.TblProductocl3" %> 
    
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Producto</title>
</head>
<body  bgcolor="#c5dec9">
<h1 align="center">Actualizar Producto</h1>

<form  method="post" action="ControladorProducto">

<%
//int cod;
 //TblProductocl3 codigo=(TblProductocl3)request.getAttribute("codigo");
 String cod=request.getAttribute("codigo").toString();
 String nom=(request.getAttribute("nombre")!=null)?request.getAttribute("nombre").toString():"";
 String prev=(request.getAttribute("precioventa")!=null)?request.getAttribute("precioventa").toString():"";
 String prec=(request.getAttribute("preciocompra")!=null)?request.getAttribute("preciocompra").toString():"";
 String est=(request.getAttribute("estado")!=null)?request.getAttribute("estado").toString():"";
 String desc=(request.getAttribute("descripcion")!=null)?request.getAttribute("descripcion").toString():"";
%>
<table align="center"  borde="2">
<input type="hidden" name="codigo"  value="<%=cod%>">
<tr>
<td>Nombre</td>
<td>
<input type="text" name="nombre" value="<%=nom%>">
</td>
</tr>
<tr>
<td>Precio venta</td>
<td><input type="text" name="precioventa" value="<%=prev%>"></td>
</tr>
<tr>
<td>Precio compra</td>
<td><input type="text" name="preciocomp" value="<%=prec%>"></td>
</tr>
<tr>
<td>Estado</td>
<td><input type="text" name="estado" value="<%=est%>"></td>
</tr>
<tr>
<td>Descripcion</td>
<td><input type="text" name="descrip" value="<%=desc%>"></td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" value="Actualizar Producto"></td>
</tr>

</table>



</form>



</body>
</html>