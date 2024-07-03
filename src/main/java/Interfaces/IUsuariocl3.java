package Interfaces;

import java.util.List;

import model.TblUsuariocl3;

public interface IUsuariocl3 {

	// declaramos metodos
			public void RegistrarUsuario(TblUsuariocl3 usuariocl3);
			public TblUsuariocl3 BuscarUsuario(TblUsuariocl3 usuariocl3s);
			public List<TblUsuariocl3> ListadoUsuario();
			
	
	
}
