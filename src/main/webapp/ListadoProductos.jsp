<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="java.util.*" %>
    <%@page import="model.TblProductocl3" %>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
   
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de Productos</title>
</head>
<body bgcolor="#c5dec9">
<h1  align="center">Listado de Productos Registrados  en BD</h1>

<h2 align="center">
<a href="FormRegistrarProducto.jsp" style="text-decoration: none;color:blue;">Registrar Producto</a>
</h2>
<table border="2" align="center">

<tr>
<td>Codigo</td>
<td>Nombre</td>
<td>Precio Venta</td>
<td>Precio Compra</td>
<td>Estado</td>
<td>Descripción</td>
<td colspan="2" align="center">Acciones</td>
</tr>

<%
List<TblProductocl3> listadoproducto=(List<TblProductocl3>)request.getAttribute("listadodeproductos");
//aplicamos una condicion..
if(listadoproducto!=null){
	//aplicamos un bucle for..
	for(TblProductocl3 lis:listadoproducto){
		%>
		<tr>
		<td><%=lis.getIdproductocl3() %></td>
		<td><%=lis.getNombrecl3() %></td>
		<td><%=lis.getPrecioventacl3() %></td>
		<td><%=lis.getPreciocompcl3() %></td>
		<td><%=lis.getEstadocl3() %>
		<td><%=lis.getDescripcl3() %></td>
		<td><a href="ControladorProducto?accion=Eliminar&cod=<%=lis.getIdproductocl3() %>">Eliminar</a></td>
	    <td><a href="ControladorProducto?accion=Modificar&cod=<%=lis.getIdproductocl3()%>">Actualizar</a></td>
		
		</tr>
		
		
	<%	
	}   //fin del bucle for...
	%>
	<%
}  //fin de la condicion ...

%>
</table>


</body>
</html>