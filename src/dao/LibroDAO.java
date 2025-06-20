package dao;
import modelo.Libro;
import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {
	
	//metodo para agregar libro 
	public void agregarLibro(Libro Libro) {
		String sql = "INSERT INTO libros (titulo, autor, genero, estado, ubicacion, propietario) VALUES (?, ?, ?, ?, ?, ?)";
		
		try (Connection con = Conexion.obtenerConexion();
			PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setString(1, libro.getTitulo());
			stmt.setString(2, libro.getAutor());
			stmt.setString(3, libro.getGenero());
			stmt.setString(4, libro.getEstado());
			stmt.setString(5, libro.getUbicacion());
			stmt.setString(6, libro.getPropietario());
			
			stmt.executeUpdate();
			System.out.println("Libro agreado");
			
		} catch (SQLException e) {
			System.out.println("Error al agregar el libro:" + e.getMessage());
		}
	}
	
	//metodo para obtener libros
	public List<Libro> obtenerLibros() {
		List<Libro> libros = new ArrayList<>();
		String sql = "SELECT * FROM libros";
		
		try (Connection con = Conexion.obtenerConexion();
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery()) {
			
			while (rs.next()) {
				Libros libros = new Libro(
						rs.getInt("id"),
						rs.getString("titulo"),
						rs.getString("autor"),
						rs.getString("genero"),
						rs.getString("estado"),
						rs.getString("ubicacion"),
						rs.getString("propietario")
				);
				libros.add(libro);
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener los libros" + e.getMessage());
		}
		return libros;
	}
	
	//metodo obtener un libro por id
	public Libro obtenerLibroPorId(int id) {
		Libro = null;
		String sql = "SELECT * FROM libros WHERW id = ?";
		
		try (Connection con = Conexion.obtenerConexion();
			PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				libro = new Libro(
						rs.getInt(id),
						rs.getString("titulo"),
						rs.getString("autor"),
						rs.getString("genero"),
						rs.getString("estado"),
						rs.getString("ubicacion"),
						rs.getString("propietario")
				);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al obtener el libro" + e.getMessage());
		
		}
		return libro;
		}
	}
