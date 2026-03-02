import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int opcao = 0;
        String user;
        String password;
        boolean login = false;
        String book;

        Map<String, Boolean> books = new HashMap<>();
        books.put("Harry Potter", true);
        books.put("Star Wars", true);
        books.put("Programador Pragmatico", true);
        books.put("Habitos Atomicos", false);

        Map<String, String> users = new HashMap<>();
        users.put("admin", "1234");
        users.put("user1", "2710");
        users.put("user2", "1027");

        do {
            System.out.println("Informe o usuario: ");
            user = reader.nextLine();
            System.out.println("Informe a senha: ");
            password = reader.nextLine();

            if(users.containsKey(user) && users.get(user).equals(password)){
                login = true;
            } else  {
                System.out.println("Usuario ou senha errados, tente novamente");
            }

        }while(!login);

        System.out.println("Você fez o Login!");

        System.out.println("Escolha uma função do sistema: ");

        do {
            System.out.println("1. Adicionar Livro \n2. Listar Livros \n3.Alugar/Devolver Livro \n4. Excluir Livro \n5. Sair");
            opcao = parseInt(reader.nextLine());

            switch (opcao){
                case 1 :
                    if(user.equals("admin")){
                        System.out.println("Informe o livro que deseja adicionar: ");
                        book = reader.nextLine();
                        books.put(book, true);
                        System.out.println("Livro adicionado com sucesso!");
                    } else {
                        System.out.println("Somente o Adiministrador pode adicionar livros!");
                    }
                    break;
                case 2 :
                    for(Map.Entry<String, Boolean> entry : books.entrySet()){
                        System.out.println(entry.getKey() + " - " + entry.getValue());
                    }
                    break;
                case 3 :
                    System.out.println("Informe o livro que deseja alugar/devolver: ");
                    book = reader.nextLine();
                    if(books.containsKey(book)){
                        if(books.get(book).equals(true)){
                            books.put(book, false);
                            System.out.println("Livro alugado com sucesso!");
                        }else {
                            books.put(book, true);
                            System.out.println("Livro devolvido com sucesso!");
                        }
                    } else {
                        System.out.println("O livro informado não está disponivel.");
                    }
                    break;
                case 4 :
                    if(user.equals("admin")){
                        System.out.println("Informe o livro que deseja excluir: ");
                        book = reader.nextLine();
                        if(books.containsKey(book)){
                            books.remove(book);
                            System.out.println("Livro excluido com sucesso!");
                        } else {
                            System.out.println("Não temos o livro informado!");
                        }
                    } else {
                        System.out.println("Somente o AUdministrador pode excluir livros!");
                    }
                    break;
                case 5 :
                    System.out.println("Saindo...");
                    break;
            }

        } while (opcao != 5);
    }
}