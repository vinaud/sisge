package com.sisge.dados;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO<T>  {
	
	
	void inserir(T entidade) throws SQLException;
	
	T obter(long id);
	
	void atualizar(T entidade);
	
	void remover(long id);
	
	List<T> listarTodos();

}
