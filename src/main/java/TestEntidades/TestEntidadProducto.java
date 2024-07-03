package TestEntidades;

import java.util.List;

import Dao.ClassProductoImp;
import model.TblProductocl3;

public class TestEntidadProducto {

	public static void main(String[] args) {
		//realizamos la respectiva instancia de las clases...
		TblProductocl3 productocl3=new TblProductocl3();
		ClassProductoImp crud=new ClassProductoImp();
				//asignamos valores
		//asignamos valore
	/*		productocl3.setNombrecl3("leche");
			productocl3.setPrecioventacl3(10.5);
			productocl3.setPreciocompcl3(18.8);
			productocl3.setEstadocl3("nueva");
			productocl3.setDescripcl3("fresca");
			
			//invocamos al metodo registrar...
			crud.RegistrarProducto(productocl3);
	*/		
			//testeamos el metodo listado
			List<TblProductocl3> listado=crud.ListadoProducto();
			//aplicamos un bucle for...
			for(TblProductocl3 lis:listado){
				
				//imprimimos por pantalla
				System.out.println("nombre "+lis.getNombrecl3()+
						" precio venta "+lis.getPrecioventacl3()+"precio compra "+lis.getPreciocompcl3()
						+" estado "+lis.getEstadocl3()+" descripcion"+lis.getDescripcl3());
			}
			
			
			

		}   //fin del metodo main...
	

}
