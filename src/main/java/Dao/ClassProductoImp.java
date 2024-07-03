package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProductocl3;
import model.TblProductocl3;

public class ClassProductoImp implements IProductocl3 {

	@Override
	public void RegistrarProducto(TblProductocl3 productocl3) {
		//establecer conexion con la unidad de persistencia...
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_ChavezVidalAriadna");
			    //permite gestionar entidades
				EntityManager em=fabr.createEntityManager();
				//iniciar transaccion
				em.getTransaction().begin();
				//registramos
				em.persist(productocl3);
				//emitimos mensaje por consola
				System.out.println("producto registrado en la BD correctamente");
				//confirmamos
				em.getTransaction().commit();
				//cerramos la transaccion
				em.close();
			}  //fin del metodo registrar...

	@Override
	public void ActualizarProducto(TblProductocl3 productocl3) {
		//establecemos conexion con la unidad de persistencia...
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_ChavezVidalAriadna");
				//permite gestionar entidades
				EntityManager em=fabr.createEntityManager();
				//iniciar transaccion
				em.getTransaction().begin();
				//actualizamos
				em.merge(productocl3);
				//comfirmamos 
				em.getTransaction().commit();
				//cerramos
				em.close();
				
				
			}   //fin del metodo actualizar
	
	@Override
	public void EliminarProducto(TblProductocl3 productocl3) {
		//establecemos la conexion con unidad de persistencia.
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_ChavezVidalAriadna");
				//gestionar las entidades
				EntityManager em=fabr.createEntityManager();
				//iniciamos la transaccion
				em.getTransaction().begin();
				//recuperamos el codigo a eliminar
				TblProductocl3 elim=em.merge(productocl3);
				//procedemos a eliminar el registro
				em.remove(elim);
				//emitimos mensaje por consola
				System.out.println("Producto eliminado de la base de datos");
				//confirmamos
				em.getTransaction().commit();
				//cerramos
				em.close();
				
			}   //fin del metodo eliminar

	@Override
	public TblProductocl3 BuscarProducto(TblProductocl3 productocl3) {
		//establecemos la conexion con la unidad de persistencia..
				EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_ChavezVidalAriadna");
				//gestionar las entidads
				EntityManager em=fabr.createEntityManager();
				//iniciamos la transaccion
				em.getTransaction().begin();
				//recuperamos el codigo a buscar
				TblProductocl3 busproductocl3=em.find(TblProductocl3.class,productocl3.getIdproductocl3());
				//confirmamos 
				em.getTransaction().commit();
				//cerramos
				em.close();
				return busproductocl3;
			}  //fin del metodo buscar

	@Override
	public List<TblProductocl3> ListadoProducto() {
		 EntityManagerFactory fabr=Persistence.createEntityManagerFactory("LPII_CL3_ChavezVidalAriadna");
	        //gestionamos las entidads
	        EntityManager em=fabr.createEntityManager();
	        //iniciamos la transaccion
	        em.getTransaction().begin();
	        //recuperamos los productos  de la base de datos
	        //***********utilizando jpql
	        List<TblProductocl3> listadoproductos=em.createQuery("select p from TblProductocl3 p",TblProductocl3.class).getResultList();
	        //confirmamos la transaccion
	        em.getTransaction().commit();
	        //cerramos
	        em.close();
			return listadoproductos;
		}   //fin del metodo listado 

}
