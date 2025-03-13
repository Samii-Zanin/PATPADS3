package testeGIT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteCon {
    public static void main(String[] args) {
        // Configurações do banco de dados
        String url = "jdbc:mysql://localhost:3309/hotel"; // Nome do banco de dados
        String user = "root"; // Usuário do MySQL
        String password = "1234567890"; // Senha do MySQL

        // SQL para inserir um usuário na tabela usuarios
        String sql = "INSERT INTO usuarios (usuario, senha) VALUES (?, ?)";

        try {
            // Carrega o driver JDBC (necessário para versões antigas do Java)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelece a conexão
            Connection conexao = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem-sucedida!");

            // Prepara a inserção de dados
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "fag"); // Substitua pelo usuário desejado
            stmt.setString(2, "rog"); // Substitua pela senha desejada

            // Executa o INSERT
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Usuário inserido com sucesso!");
            }

            // Fecha recursos
            stmt.close();
            conexao.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Driver JDBC não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ou inserir no banco de dados!");
            e.printStackTrace();
        }
    }
}