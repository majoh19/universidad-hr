package com.iudigital.universidad.hr.presentacion;

import com.iudigital.universidad.hr.controller.FuncionarioController;
import com.iudigital.universidad.hr.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UniversidadHrDesktop {

    public static void crear(FuncionarioController funcionarioController) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite el tipo de identificacion: ");
            int tipo_identificacion_id = sc.nextInt();
            sc.nextLine();
            System.out.println("El tipo de identificacion es: " + tipo_identificacion_id);
            System.out.println("---------------------");

            System.out.println("Digite el numero de identificacion: ");
            String numero_identificacion = sc.nextLine();
            System.out.println("El numero de identificacion es:" + numero_identificacion);
            System.out.println("---------------------");

            System.out.println("Digite los nombres: ");
            String nombres = sc.nextLine();
            System.out.println("Los nombres son:" + nombres);
            System.out.println("---------------------");

            System.out.println("Digite los apellidos: ");
            String apellidos = sc.nextLine();
            System.out.println("Los apellidos son:" + apellidos);
            System.out.println("---------------------");

            System.out.println("Digite el estado civil: ");
            int estado_civil_id = sc.nextInt();
            sc.nextLine();
            System.out.println("El estado civil es:" + estado_civil_id);
            System.out.println("---------------------");

            System.out.println("Digite el sexo: ");
            String sexo = sc.nextLine();
            System.out.println("El sexo es:" + sexo);
            System.out.println("---------------------");

            System.out.println("Digite la direccion: ");
            String direccion = sc.nextLine();
            System.out.println("La direccion es:" + direccion);
            System.out.println("---------------------");

            System.out.println("Digite el numero de telefono: ");
            String numero_telefono = sc.nextLine();
            System.out.println("El numero de telefono es:" + numero_telefono);
            System.out.println("---------------------");

            System.out.println("Digite la fecha de nacimiento: ");
            String fecha_nacimiento = sc.nextLine();
            System.out.println("La fecha de nacimiento es:" + fecha_nacimiento);
            System.out.println("---------------------");

            Funcionario funcionario = new Funcionario();
            funcionario.setTipo_identificacion_id(tipo_identificacion_id);
            funcionario.setNumero_identificacion(numero_identificacion);
            funcionario.setNombres(nombres);
            funcionario.setApellidos(apellidos);
            funcionario.setEstado_civil_id(estado_civil_id);
            funcionario.setSexo(sexo);
            funcionario.setDireccion(direccion);
            funcionario.setNumero_telefono(numero_telefono);
            funcionario.setFecha_nacimiento(fecha_nacimiento);
            funcionarioController.crear(funcionario);
            System.out.println("Funcionario creado con exito");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void obtenerFuncionarios(FuncionarioController funcionarioController) {

        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay funcionarios");
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("id: " + funcionario.getFuncionario_id());
                    System.out.println("Tipo de identificacion: " + funcionario.getTipo_identificacion_id());
                    System.out.println("Numero de identificacion: " + funcionario.getNumero_identificacion());
                    System.out.println("Nombres: " + funcionario.getNombres());
                    System.out.println("Apellidos: " + funcionario.getApellidos());
                    System.out.println("Estado civil: " + funcionario.getEstado_civil_id());
                    System.out.println("Sexo: " + funcionario.getSexo());
                    System.out.println("Direccion: " + funcionario.getDireccion());
                    System.out.println("Numero de telefono: " + funcionario.getNumero_telefono());
                    System.out.println("Fecha de nacimiento: " + funcionario.getFecha_nacimiento());
                    System.out.println("---------------------------------");
                    System.out.println("---------------------------------");
                    System.out.println("---------------------------------");
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void eliminar(FuncionarioController funcionarioController) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite el ID del funcionario a eliminar: ");
            int funcionario_id = sc.nextInt();
            System.out.println("El ID del carro a eliminar es: " + funcionario_id);
            Funcionario funcionarioExiste = funcionarioController.obtenerFuncionario(funcionario_id);
            if (funcionarioExiste == null) {
                System.out.println("No existe funcionario");
                return;
            }

            funcionarioController.eliminarFuncionario(funcionario_id);
            System.out.println("Funcionario eliminado con exito");
            obtenerFuncionarios(funcionarioController);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //FuncionarioController funcionarioController = new FuncionarioController();
        //crear(funcionarioController);
        //obtenerFuncionarios(funcionarioController);
        var opcion = -1;
        var scanner = new Scanner(System.in);
        FuncionarioController funcionarioController = new FuncionarioController();

        while (opcion != 0) {
            System.out.println("--------------------------");
            System.out.println("--------------------------");
            System.out.println("Elija una opcion");
            System.out.println("--------------------------");
            System.out.println("--------------------------");

            System.out.println("1. Listar Funcionarios");
            System.out.println("2. Crear Funcionario");
            System.out.println("3.Eliminar Funcionario");

            System.out.println("--------------------------");
            System.out.println("--------------------------");

            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 0:
                    System.out.println("Ha salido de la aplicacion");
                    break;

                case 1:
                    obtenerFuncionarios(funcionarioController);
                    break;

                case 2:
                    crear(funcionarioController);
                    break;

                case 3:
                    eliminar(funcionarioController);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }

    }
}
