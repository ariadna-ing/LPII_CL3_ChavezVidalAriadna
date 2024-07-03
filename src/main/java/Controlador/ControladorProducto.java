package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ClassProductoImp;
import model.TblProductocl3;

/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }  //fin del constructor...

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//response.getWriter().append("Served at: ").append(request.getContextPath());
		TblProductocl3 productocl3=new TblProductocl3();
		ClassProductoImp crud=new ClassProductoImp();
				
				
				//recuperamos la accion y codigo
				String accion=request.getParameter("accion");
				//aplicamos una condicion...
				if(accion!=null){
					switch(accion){
					case "Modificar":
						int codigo=Integer.parseInt(request.getParameter("cod"));
						//asignar el codigo...
						productocl3.setIdproductocl3(codigo);
						TblProductocl3 buscarcod=crud.BuscarProducto(productocl3);
						//enviar los valores buscados por codigo de la base de datos
						//al formulario actualizar..
						request.setAttribute("codigo",buscarcod.getIdproductocl3());
						request.setAttribute("nombre",buscarcod.getNombrecl3());
						request.setAttribute("precioventa",buscarcod.getPrecioventacl3());
						request.setAttribute("preciocompra",buscarcod.getPreciocompcl3());
						request.setAttribute("estado",buscarcod.getEstadocl3());
						request.setAttribute("descripcion",buscarcod.getDescripcl3());
						
						//redireccionar..
						request.getRequestDispatcher("/FormActualizarProducto.jsp").forward(request, response);
						//salimos
						break;
					case "Eliminar":
						int codeliminar=Integer.parseInt(request.getParameter("cod"));
						//asignamos el codigo a eliminar
						productocl3.setIdproductocl3(codeliminar);
						//invocamos al metodo eliminar...
						crud.EliminarProducto(productocl3);
						//refrescar el listado..
						List<TblProductocl3> listado=crud.ListadoProducto();
						request.setAttribute("listadoproductos",listado);
						//redireccionar
						request.getRequestDispatcher("/ListadoProductos.jsp");
						//salimos
						break;
					
					case "Listar":
						List<TblProductocl3> listadoproducto=crud.ListadoProducto();
						//invocamos el listado  de productos para la vista
						request.setAttribute("listadodeproductos",listadoproducto);
						//redireccionamos
						request.getRequestDispatcher("/ListadoProductos.jsp").forward(request, response);
						//salimos
						break;
						
					 }  //fin del switch...
					
					
				}   //fin del if...
					
	
	
	}  //fin del metodo doget...

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//doGet(request, response);
				
				//recuperamos los valores del formulario...
				String codigo=request.getParameter("codigo");
				String nombre=request.getParameter("nombre");
				double precioventa = Double.parseDouble(request.getParameter("precioventa"));
				double preciocomp = Double.parseDouble(request.getParameter("preciocomp"));
				String estado=request.getParameter("estado");
				String descrip=request.getParameter("descrip");
								
				List<TblProductocl3> listadoproducto=null;
				
				//instanciar las respectivas entidades...
				TblProductocl3 productocl3=new TblProductocl3();
				ClassProductoImp crud=new ClassProductoImp();
				//asignamos valores
				productocl3.setNombrecl3(nombre);
				productocl3.setPrecioventacl3(precioventa);
				productocl3.setPreciocompcl3(preciocomp);
				productocl3.setEstadocl3(estado);
				productocl3.setDescripcl3(descrip);
				
				if(codigo!=null){
					//recupero el codigo a  actualizar...
					int cod=Integer.parseInt(codigo);
					//asigno el codigo a actualizar
					productocl3.setIdproductocl3(cod);
					//invoco al metodo actualizar
					crud.ActualizarProducto(productocl3);
					//actualizador listado de clientes
					 listadoproducto=crud.ListadoProducto();
					
				}else{	
				//invocamos la metodo registrar...
				crud.RegistrarProducto(productocl3);
				//actualizador listado de productos
				listadoproducto=crud.ListadoProducto();
				
				} //fin del else...
				
				//invocamos el listado  de productos para la vista
				request.setAttribute("listadodeproductos",listadoproducto);
				//redireccionamos
				request.getRequestDispatcher("/ListadoProductos.jsp").forward(request, response);
				
				
					
		
		
		
	}  //fin del metodo dopost...

}   //fin de la clase...
