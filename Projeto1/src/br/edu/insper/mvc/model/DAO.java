package br.edu.insper.mvc.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private Connection connection = null;
	
	public DAO() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
		"jdbc:mysql://localhost/projeto1", "root", "05052000");
		
		}
	
	public List<Tarefa> getLista() throws SQLException{
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Tarefa ORDER BY importancia DESC;");	
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Tarefa tarefa = new Tarefa();
			tarefa.setId(rs.getInt("id"));
			tarefa.setTitulo(rs.getString("titulo"));
			tarefa.setDescricao(rs.getString("descricao"));
			tarefa.setImportancia(rs.getInt("importancia"));
			tarefa.setUsuario_id(rs.getInt("usuario_id"));
			
			tarefas.add(tarefa);
			
		}
		
		rs.close();
		stmt.close();
		return tarefas;
	}
	
	
	public void adiciona(Tarefa tarefa) throws SQLException {
		String sql = "INSERT INTO Tarefa (titulo,descricao,importancia,usuario_id) VALUES (?,?,?,1)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,tarefa.getTitulo());
		stmt.setString(2, tarefa.getDescricao());
		stmt.setInt(3, tarefa.getImportancia());
		stmt.execute();
		stmt.close();
	}
	public void remove(Integer id) throws SQLException {
		String sql = "DELETE FROM Tarefa WHERE id =?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(1, id);
		stmt.execute();
		stmt.close();
	}
	
	public void atualiza(Tarefa tarefa) throws SQLException {
		String sql = "UPDATE Tarefa SET titulo=?, descricao=?, importancia=?, usuario_id=1 WHERE id=?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,tarefa.getTitulo());
		stmt.setString(2, tarefa.getDescricao());
		stmt.setInt(3, tarefa.getImportancia());
		stmt.setInt(4, tarefa.getId());
		
		stmt.execute();
		stmt.close();
	}
	
	
	public List<Login> getEntrada() throws SQLException{
		List<Login> logins = new ArrayList<Login>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM login;");	
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			Login login = new Login();
			login.setUsuario(rs.getString("usuario"));
			login.setSenha(rs.getString("senha"));
			
			
			logins.add(login);
			
		}
		
		rs.close();
		stmt.close();
		return logins;
	}
	
	public void close() throws SQLException {
		connection.close();
		}
	}
