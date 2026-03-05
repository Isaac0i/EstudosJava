package School;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer option = 0;

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
                        System.out.println("Informe a Nota a ser lançada: ");
                        double nota = sc.nextDouble();
                        sc.nextLine();

                        students.get(reg2).getGrades().add(nota);
                        System.out.println("Nota lançada com sucesso!");
                        break;
                    }
            }
        } while (option != 5);
    }

    public double calculateAverage(Student student) {
        double notas = 0;
        for (int i = 0; i < student.getGrades().size(); i++) {
            notas += student.getGrades().get(i);
        }
        return notas / (student.getGrades().size());
    }
}

