package com.iudigital.universidad.hr.data;

import com.iudigital.universidad.hr.domain.Funcionario;
import com.iudigital.universidad.hr.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

    private static final String GET_FUNCIONARIOS = "SELECT * FROM `funcionarios`";

    private static final String CREATE_FUNCIONARIOS = "INSERT INTO `funcionarios` (`tipo_identificacion_id`, `numero_identificacion`, `nombres`, `apellidos`, `estado_civil_id`, `sexo`, `direccion`, `numero_telefono`, `fecha_nacimiento`) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_FUNCIONARIO_BY_ID = "SELECT * FROM `funcionarios` WHERE `funcionario_id` = ?";

    private static final String UPDATE_FUNCIONARIOS = "UPDATE `funcionarios` SET `tipo_identificacion_id` = ?, `numero_identificacion` = ?, `nombres` = ?, `apellidos` = ?, `estado_civil_id` = ?, `sexo` = ?, `direccion` = ?, `numero_telefono` = ?, "
            + "`fecha_nacimiento` = ? WHERE `funcionario_id` = ?";

    private static final String DELETE_FUNCIONARIOS = "DELETE FROM `funcionarios` WHERE `funcionario_id` = ?";

    public List<Funcionario> obtenerFuncionarios() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setFuncionario_id(resultSet.getInt("funcionario_id"));
                funcionario.setTipo_identificacion_id(resultSet.getInt("tipo_identificacion_id"));
                funcionario.setNumero_identificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstado_civil_id(resultSet.getInt("estado_civil_id"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setNumero_telefono(resultSet.getString("numero_telefono"));
                funcionario.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
                funcionarios.add(funcionario);

            }
            return funcionarios;

        } finally {
            
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void crear(Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIOS);
            preparedStatement.setInt(1, funcionario.getTipo_identificacion_id());
            preparedStatement.setString(2, funcionario.getNumero_identificacion());
            preparedStatement.setString(3, funcionario.getNombres());
            preparedStatement.setString(4, funcionario.getApellidos());
            preparedStatement.setInt(5, funcionario.getEstado_civil_id());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getNumero_telefono());
            preparedStatement.setString(9, funcionario.getFecha_nacimiento());
            preparedStatement.executeUpdate();

        } finally {
            
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Funcionario obtenerFuncionario(int funcionario_id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;

        try {

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, funcionario_id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                funcionario = new Funcionario();
                funcionario.setFuncionario_id(resultSet.getInt("funcionario_id"));
                funcionario.setTipo_identificacion_id(resultSet.getInt("tipo_identificacion_id"));
                funcionario.setNumero_identificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setEstado_civil_id(resultSet.getInt("estado_civil_id"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setNumero_telefono(resultSet.getString("numero_telefono"));
                funcionario.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
                
            }
            return funcionario;

        } finally {
            
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
    
    public void actualizarFuncionario(int funcionario_id, Funcionario funcionario) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIOS);
            preparedStatement.setString(1, funcionario.getNumero_identificacion());
            preparedStatement.setString(2, funcionario.getNombres());
            preparedStatement.setString(3, funcionario.getApellidos());
            preparedStatement.setInt(4, funcionario.getEstado_civil_id());
            preparedStatement.setString(5, funcionario.getSexo());
            preparedStatement.setString(6, funcionario.getDireccion());
            preparedStatement.setString(7, funcionario.getNumero_telefono());
            preparedStatement.setString(8, funcionario.getFecha_nacimiento());
            preparedStatement.setInt(9, funcionario.getFuncionario_id());
            preparedStatement.executeUpdate();
            
        } finally {
            
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    
    public void eliminarFuncionario(int funcionario_id) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIOS);
            preparedStatement.setInt(1, funcionario_id);
            preparedStatement.executeUpdate();
            
        } finally {
            
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}
