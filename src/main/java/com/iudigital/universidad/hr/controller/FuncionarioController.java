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
    
    public Funcionario obtenerFuncionario(int funcionarioId) throws SQLException {
        return funcionarioDao.obtenerFuncionario(funcionarioId);
    }
    
    public void actualizarFuncionario(int funcionarioId, Funcionario funcionario) throws SQLException {
        funcionarioDao.actualizarFuncionario(funcionarioId, funcionario);
    }
    
    public void eliminarFuncionario(int funcionarioId) throws SQLException {
        funcionarioDao.eliminarFuncionario(funcionarioId);
    }
}
