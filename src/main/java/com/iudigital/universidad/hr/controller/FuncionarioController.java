package com.iudigital.universidad.hr.controller;

import com.iudigital.universidad.hr.data.FuncionarioDao;
import com.iudigital.universidad.hr.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    
    private FuncionarioDao funcionarioDao;
    
    public FuncionarioController() {
        
        funcionarioDao = new FuncionarioDao();
    }
    
    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        return funcionarioDao.obtenerFuncionarios();
    }
    
    public void crear(Funcionario funcionario) throws SQLException {
        funcionarioDao.crear(funcionario);
    }
    
    public Funcionario obtenerFuncionario(int funcionario_id) throws SQLException {
        return funcionarioDao.obtenerFuncionario(funcionario_id);
    }
    
    public void actualizarFuncionario(int funcionario_id, Funcionario funcionario) throws SQLException {
        funcionarioDao.actualizarFuncionario(funcionario_id, funcionario);
    }
    
    public void eliminarFuncionario(int funcionario_id) throws SQLException {
        funcionarioDao.eliminarFuncionario(funcionario_id);
    }
}
