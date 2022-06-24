package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import entidad.Alumno;
import util.MySqlDBConexion;

public class AlumnoModel {
	
	private static Logger log = Logger.getLogger(AlumnoModel.class.getName());
	
	public int insertarAlumno (Alumno al) {
		
		log.info(">> Inicio >> InsertarAlumno()");
		int salida = -1;
		
		Connection cn = null;
		PreparedStatement prep = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			
			String sql = "insert into alumno values(null,?,?,?,?,?,?,curtime())";
			prep = cn.prepareStatement(sql);
			prep.setString(1, al.getNombre());
			prep.setString(2, al.getApellido());
			prep.setString(3, al.getDni());
			prep.setString(4, al.getPais());
			prep.setString(5, al.getCorreo());
			prep.setDate(6, al.getFechanac());
			
			log.info(">> SQL >>" + prep);
			
			salida = prep.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if (cn != null) cn.close();
				if (prep != null) prep.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		log.info(">> Fin >> InsertarAlumno()");
		return salida;
	}

	public int eliminateAlumno (int idAlumno) {
		
		log.info(">> Inicio >> eliminateAlumno()");
		int salida = -1;
		
		Connection cn = null;
		PreparedStatement prep = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			
			String sql = "delete from alumno where idAlumno = ?";
			prep = cn.prepareStatement(sql);
			prep.setInt(1, idAlumno);
			
			log.info(">> SQL >>" + prep);
			
			salida = prep.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if (cn != null) cn.close();
				if (prep != null) prep.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		log.info(">> Fin >> eliminateAlumno()");
		return salida;
	}
	
	
	public int ModifyAlumno (Alumno al) {
		
		log.info(">> Inicio >> ModifyAlumno()");
		int salida = -1;
		
		Connection cn = null;
		PreparedStatement prep = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			
			String sql = "update alumno set nombres=?, apellidos=?, dni=?, pais=?, correo=?, fechaNacimiento=? where idAlumno=?";
			prep = cn.prepareStatement(sql);
			prep.setString(1, al.getNombre());
			prep.setString(2, al.getApellido());
			prep.setString(3, al.getDni());
			prep.setString(4, al.getPais());
			prep.setString(5, al.getCorreo());
			prep.setDate(6, al.getFechanac());
			prep.setInt(7, al.getIdAlumno());
			
			log.info(">> SQL >>" + prep);
			
			salida = prep.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if (cn != null) cn.close();
				if (prep != null) prep.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		log.info(">> Fin >> ModifyAlumno()");
		return salida;
	}
	
	public List <Alumno> listaAlumno(){
		ArrayList <Alumno> salida = new ArrayList <Alumno>();
		
		Connection cn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			
			String sql = "select * from Alumno";
			prep = cn.prepareStatement(sql);
			
			log.info(">> SQL >>" + prep);
			
			rs = prep.executeQuery();
			Alumno al = null;
			while(rs.next()) {
			al= new Alumno();
			al.setIdAlumno(rs.getInt(1));
			al.setNombre(rs.getString(2));
			al.setApellido(rs.getString(3));
			al.setDni(rs.getString(4));
			al.setPais(rs.getString(5));
			al.setCorreo(rs.getString(6));
			al.setFechanac(rs.getDate(7));
			al.setFechareg(rs.getDate(8));
			salida.add(al);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
	} finally {
		
		try {
			if (cn != null) cn.close();
			if (prep != null) prep.close();
			if (rs != null) rs.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
		return salida;
	}
	
	
	public List <Alumno> consultaNombreApellidoDniPaisFechareg (String nombre, String apellido, String dni, String pais, String from, String to){
		ArrayList <Alumno> datos  = new ArrayList <Alumno>();
		
		Connection cn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			
			String sql = "select * from alumno where (nombres like ?) and "
			+ "(apellidos like ?) and (? = '' or dni = ?) and " 
			+ "(? = '' or pais = ?) and (? = '' or ? = '' or fechaRegistro between ? and ?); ";
			prep = cn.prepareStatement(sql);
			prep.setString(1, "%" +nombre+ "%");
			prep.setString(2, "%" +apellido+ "%");
			prep.setString(3, dni);
			prep.setString(4, dni);
			prep.setString(5, pais);
			prep.setString(6, pais);
			prep.setString(7, from);
			prep.setString(8, to);
			prep.setString(9, from);
			prep.setString(10, to);
			
			System.out.println("SQL -->" + prep);
			
			
			rs = prep.executeQuery();
			Alumno a = null;
			while(rs.next()) {
			a = new Alumno();
			a.setIdAlumno(rs.getInt(1));
			a.setNombre(rs.getString(2));
			a.setApellido(rs.getString(3));
			a.setDni(rs.getString(4));
			a.setPais(rs.getString(5));
			a.setCorreo(rs.getString(6));
			a.setFechanac(rs.getDate(7));
			a.setFechareg(rs.getDate(8));
			datos.add(a);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null) cn.close();
				if (prep != null) prep.close();
				if (rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return datos;
	}
	
		
	}
