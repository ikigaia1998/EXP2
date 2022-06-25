package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Libro;
import util.MySqlDBConexion;

public class LibroModel {
	
private static Logger Log = Logger.getLogger(LibroModel.class.getName());
	
	public int insertarLibroModel(Libro obj) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySqlDBConexion.getConexion();
			
			String sql = "insert into libro value (?,?,?,?,?,curtime(),?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getIdLibro());
			pstm.setString(2, obj.getTitulo());
			pstm.setString(3, obj.getAnio());
			pstm.setString(4, obj.getCategoria());
			pstm.setString(5, obj.getSerie());
			pstm.setString(6, obj.getPais());
			pstm.setString(7, obj.getTipo());
			
			Log.info(">>> " + pstm);				
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) pstm.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return salida;
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public int eliminaLibro(int idLibro) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			
			conn = MySqlDBConexion.getConexion();
			
			
			String sql = "delete from libro where idLibro = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idLibro);
			
			Log.info(">>> " + pstm);
			
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return salida;
	}
	
	public int actualizaLibro(Libro obj) {
		int Actualiza = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {		
			conn =  MySqlDBConexion.getConexion();

			String sql = "update libro set titulo=?, anio=?, categoria=?, serie=?, pais=?,tipo=? where idLibro=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getTitulo());
			pstm.setString(2, obj.getAnio());
			pstm.setString(3, obj.getCategoria());
			pstm.setString(4, obj.getSerie());
			pstm.setString(5, obj.getPais());
			pstm.setString(6, obj.getTipo());
			pstm.setInt(7, obj.getIdLibro());
			Log.info(">>> " + pstm);
			Actualiza = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return Actualiza;
	}
	
	
	public List<Libro> listaTodos(){
		ArrayList<Libro> salida = new ArrayList<Libro>();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			
			conn = MySqlDBConexion.getConexion();
			
			String sql = "select * from libro";
			psmt = conn.prepareStatement(sql);
			
			Log.info(">>> " + psmt);
			
			
			rs = psmt.executeQuery();
			Libro obj = null;
			while(rs.next()) {
				obj = new Libro();
				obj.setIdLibro(rs.getInt(1));
				obj.setTitulo(rs.getString(2));
				obj.setAnio(rs.getString(3));
				obj.setCategoria(rs.getString(4));
				obj.setSerie(rs.getString(5));
				obj.setPais(rs.getString(7)); 
				obj.setTipo(rs.getString(8));
				salida.add(obj); 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (psmt != null) psmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return salida;
	}
	//////////////////////////////////////////////////////////////
	
	public List<Libro> consultaPorTiAnioCateSeriPaTip(String titulo,String desde, String hasta,String categoria, String serie, String pais, String tipo){
		ArrayList<Libro> data = new ArrayList<Libro>();
		Connection conn = null;
		PreparedStatement  pstm = null;
		ResultSet rs = null;
		try {
			conn = 	MySqlDBConexion.getConexion();
			String sql = "SELECT * FROM sistema_biblioteca_simple_2022_01.libro where "
					+ "(titulo like ?) and "
					+ "(? ='' or ?='' or anio between ? and ?)and"
					+ "(? ='' or categoria = ?) and "
					+ "(? ='' or serie = ?) and "
					+ "(? ='' or pais = ?) and "
					+ "(? ='' or tipo = ?) ; ";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%"+titulo+"%");
			pstm.setString(2, desde);
			pstm.setString(3, hasta);
			pstm.setString(4, desde);
			pstm.setString(5, hasta);
			pstm.setString(6, categoria);
			pstm.setString(7, categoria);
			pstm.setString(8, serie);
			pstm.setString(9, serie);
			pstm.setString(10, pais);
			pstm.setString(11, pais);
			pstm.setString(12, tipo);
			pstm.setString(13, tipo);

			
			System.out.println("SQL --> " + pstm);
			
			rs = pstm.executeQuery();
	

			Libro obj = null;
			while(rs.next()){
				obj = new Libro();
				obj.setIdLibro(rs.getInt("idLibro"));
				obj.setTitulo(rs.getString("titulo"));
				obj.setAnio(rs.getString("anio"));
				obj.setCategoria(rs.getString("categoria"));
				obj.setSerie(rs.getString("serie"));
				obj.setPais(rs.getString("pais"));
				obj.setTipo(rs.getString("tipo"));
				data.add(obj);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs != null)     rs.close();
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		return data;
	}
}
