package Interfaces;

import java.util.List;

import model.TblProductocl3;

public interface IProductocl3 {

	//declaramos los metodos
		public void RegistrarProducto(TblProductocl3 productocl3);
		public void ActualizarProducto(TblProductocl3 productocl3);
		public void EliminarProducto(TblProductocl3 productocl3);
		public TblProductocl3 BuscarProducto(TblProductocl3 productocl3);
		public List<TblProductocl3> ListadoProducto();

	}   //fin de la interface...
