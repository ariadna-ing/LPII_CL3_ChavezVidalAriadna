package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TblUsuariocl3;

/**
 * Servlet implementation class ControladorUsuario
 */
public class ControladorUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }  //fin del constructor...

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}  //fin del metodo doget...

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String username= request.getParameter("username");
	       String password= request.getParameter("password");
	       
	       TblUsuariocl3 usuariocl3 = new TblUsuariocl3();
	       usuariocl3.setUsuariocl3(username);
	       
	     
		TblUsuariocl3 usuarioEncontrado = usuarioDAO.BuscarUsuario(usuariocl3);
	       if(usuarioEncontrado != null) {
	    	   // verificar contraseña
	    	   if(usuarioEncontrado.getPasswordcl3().equals(password)) {
	    		   HttpSession session = request.getSession();
	    		   session.setAttribute("usuario", usuarioEncontrado);
	    		   response.sendRedirect(request.getContextPath() + "/index.jsp");
	    	   } else {
	    		   String mensajeerror = "Usuario o contraseña incorrecto";
	    		   request.setAttribute("mensaje", mensajeerror);
	    		   request.getRequestDispatcher("login.jsp").forward(request, response);
	    	   }
	       } else {
	    	   String mensajeerror = "Usuario o contraseña incorrecto";
	    	   request.setAttribute("mensaje", mensajeerror);
	    	   request.getRequestDispatcher("login.jsp").forward(request, response);
	    	  	
	       }
	}  //fin del metodo dopost...

}   //fin de la clase...
