package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Interfaces.IUsuariocl3;
import model.TblUsuariocl3;

public class ClassUsuarioImp implements IUsuariocl3{

	@Override
	public void RegistrarUsuario(TblUsuariocl3 usuariocl3) {
		// establecer conexion con la unidad de persistencia..
				EntityManagerFactory em=Persistence.createEntityManagerFactory("LPII_CL3_ChavezVidalAriadna");
				//gestionar las entidades
				EntityManager emanager=em.createEntityManager();
				//iniciamos la transaccion
				emanager.getTransaction().begin();
				//registramos
				emanager.persist(usuariocl3);
				//emitimos mensaje por consola
				System.out.println("Usuario Registrado en la BD");
				// confirmamos
				emanager.getTransaction().commit();
				//cerramos
				emanager.close();
				
			}   // fin del metodo registrar

	@Override
	public TblUsuariocl3 BuscarUsuario(TblUsuariocl3 usuariocl3s) {
		// establecer conexion con la unidad de persistencia..
		EntityManagerFactory em=Persistence.createEntityManagerFactory("LPII_CL3_ChavezVidalAriadna");
		//gestionar las entidades
		EntityManager emanager=em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		
		String jpql="SELECT u FROM TblUsuariocl2 u WHERE u.usuariocl2 = :username";
		TypedQuery<TblUsuariocl3> query =emanager.createQuery(jpql, TblUsuariocl3.class);
		TblUsuariocl3 usuarioencontrado= null;
		try {
			usuarioencontrado = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		emanager.getTransaction().commit();
		emanager.close();
        return usuarioencontrado;
		
	}   // fin del metodo buscar

	@Override
	public List<TblUsuariocl3> ListadoUsuario() {
		//establecemos conexion con la unidad de persistencia..
		EntityManagerFactory em=Persistence.createEntityManagerFactory("LPII_CL3_ChavezVidalAriadna");
		//gestionar las entidades
		EntityManager emanager=em.createEntityManager();
		//iniciamos la transaccion
		emanager.getTransaction().begin();
		//recuperamos el listado de productos de la BD
		//aplicamos consultas JPQL(jpa query language), el metodo createQuery(), sirve para
		//hacer consultas dinámicas
		List<TblUsuariocl3> listadousuario=emanager.createQuery("select p from TblUsuariocl3 p",TblUsuariocl3.class).getResultList();
	    // confirmamos
		emanager.getTransaction().commit();
		//cerramos
		emanager.close();
		//retornar el listado de producto en la bd
	    return listadousuario;
	}

	
	
}
