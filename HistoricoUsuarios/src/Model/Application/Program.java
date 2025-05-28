package Model.Application;

import Model.Entities.LogAcess;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        //Instanciando Scanner
        Scanner sc = new Scanner(System.in);

        //Iniciando hashset para retirar usuário repetidos
        HashSet<LogAcess> logAcesses = new HashSet<>();

        //Pegando o local do arquivo com o usuário
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        //Estrutura para pegar os dados do arquivo e fazer a leitura neles
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String historicotxt = br.readLine();

            while (historicotxt != null) {
                String[] fields = historicotxt.split(" "); //Separador é espaço
                LocalDateTime data = LocalDateTime.parse(fields[1]);  //Transforma o LocalDateTime em String
                logAcesses.add(new LogAcess(fields[0], data)); //Armazena o nome e a data no hashSet
                historicotxt = br.readLine(); //Pula para a proxima linha
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage()); //Caso de erro, ele exibe o erro na tela
        }

        //Aqui vamos remover os repetidos e exibir na tela somente os que não são, a quantidade deles
        System.out.println("Total users: " + logAcesses.size());

        //Exibir coleção completa depois de retirar duplicados
        for (LogAcess la : logAcesses) {
            System.out.println(la);
        }

        //Fechando scanner
        sc.close();
    }
}