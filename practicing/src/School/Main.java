package School;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        Map<String, Student> students = new HashMap<>();

        System.out.println("Sistema de gestão escolar");

        do {
            System.out.println("Escolha uma opção: \n1. Cadastrar estudante \n2. Lançar Boletim \n3. Ver Boletim \n4. Listar Turma \n5.Sair");
            option = Integer.parseInt(sc.nextLine());

            switch(option) {
                case 1:
                    System.out.println("Digite o nome do estudante: ");
                    String name = sc.nextLine();
                    System.out.println("Informe a Matricula do estudante: ");
                    String registration = sc.nextLine();

                    Student student1 = new Student(name, registration);
                    students.put(student1.getRegistration(), student1);
                    System.out.println("Estudante cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Informe a Matricula do estudante: ");
                    String reg2 = sc.nextLine();
                    if(students.containsKey(reg2)) {
                        String student2 = students.get(reg2).getName();
                        System.out.printf("Informe a Nota a ser lançada para o(a) %s: ", student2);
                        double nota = sc.nextDouble();
                        sc.nextLine();

                        students.get(reg2).getGrades().add(nota);
                        System.out.println("Nota lançada com sucesso!");
                    } else {
                        System.out.println("Estudante não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Informe a Matricula do estudante: ");
                    String reg3 = sc.nextLine();
                    if(students.containsKey(reg3)) {
                        Student student = students.get(reg3);
                        Double media = calculateAverage(student);
                        String stats = setStats(media);
                        student.setStats(stats);
                        student.setAverageGrade(media);

                            System.out.println(student);
                    } else {
                        System.out.println("Estudante não encontrado.");
                    }
                    break;
                case 4:
                    for(Student student : students.values()) {
                        Double media = calculateAverage(student);
                        String stats = setStats(media);
                        student.setStats(stats);
                        student.setAverageGrade(media);

                        System.out.println("Name: " + student.getName() +" - Matricula: "+ student.getRegistration() +" - Média: "+ student.getStats());
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        } while (option != 5);
    }

    public static double calculateAverage(Student student) {
        double notas = 0;
        for (int i = 0; i < student.getGrades().size(); i++) {
            notas += student.getGrades().get(i);
        }
        return notas / (student.getGrades().size());
    }

    public static String setStats(Double media) {
       return  (media >= 6) ? "Aprovado" : "Reprovado";
    }
}

