package library;

import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int opcao;
        String user;
        String password;
        boolean login = false;
        String book;
        String author;
        int year;

        Map<String, Book> books = new HashMap<>();

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
                        System.out.println("Informe o nome do autor: ");
                        author = reader.nextLine();
                        System.out.println("Informe o ano de publicação: ");
                        year = parseInt(reader.nextLine());

                        Book book1 = new Book(book, author, year);
                        books.put(book1.getTitle(), book1);
                        System.out.println("Livro adicionado com sucesso!");
                    } else {
                        System.out.println("Somente o Adiministrador pode adicionar livros!");
                    }
                    break;
                case 2 :
                    for(Map.Entry<String, Book> entry : books.entrySet()){
                        System.out.println(entry.getValue().toString());
                    }
                    break;
                case 3 :
                    System.out.println("Informe o livro que deseja alugar/devolver: ");
                    book = reader.nextLine();
                    if(books.containsKey(book)){
                        if(books.get(book).isAvailable()){
                            books.get(book).setAvailable(false);
                            System.out.println("Livro alugado com sucesso!");
                        }else {
                            books.get(book).setAvailable(true);
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