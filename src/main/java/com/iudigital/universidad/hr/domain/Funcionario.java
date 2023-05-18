package com.iudigital.universidad.hr.domain;

public class Funcionario {
    
    private int funcionario_id;
    private int tipo_identificacion_id;
    private String numero_identificacion;
    private String nombres;
    private String apellidos;
    private int estado_civil_id;
    private String sexo;
    private String direccion;
    private String numero_telefono;
    private String fecha_nacimiento;

    public int getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public int getTipo_identificacion_id() {
        return tipo_identificacion_id;
    }

    public void setTipo_identificacion_id(int tipo_identificacion_id) {
        this.tipo_identificacion_id = tipo_identificacion_id;
    }

    public String getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(String numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEstado_civil_id() {
        return estado_civil_id;
    }

    public void setEstado_civil_id(int estado_civil_id) {
        this.estado_civil_id = estado_civil_id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return nombres + " " + apellidos;
    }
    
}
