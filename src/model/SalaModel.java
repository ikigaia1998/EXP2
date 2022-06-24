package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Sala;
import util.MySqlDBConexion;

public class SalaModel {

	private static Logger log = Logger.getLogger(SalaModel.class.getName());

	// ------------------------------------------------------------------------------------------------------------------
	public int insertaSala(Sala obj) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySqlDBConexion.getConexion();

			String sql = "insert into sala values(null,?,?,?,?,1,curtime(),?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNumero());
			pstm.setInt(2, obj.getPiso());
			pstm.setInt(3, obj.getNumAlumnos());
			pstm.setString(4, obj.getRecursos());
			pstm.setString(5, obj.getSede());

			log.info("sql --> " + pstm);

			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	// ------------------------------------------------------------------------------------------------------------------
	public int eliminaSala(int idSala) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Se crea la conexión
			conn = MySqlDBConexion.getConexion();

			// Se prepara el SQL
			String sql = "delete from sala where idSala = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idSala);

			log.info(">>> " + pstm);

			// Ejecutamos la BD
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

	// ------------------------------------------------------------------------------------------------------------------
	public int actualizaSala(Sala oSala) {
		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// Se crea la conexión
			conn = MySqlDBConexion.getConexion();

			// Se prepara el SQL
			String sql = "update sala set numero=?, piso=?, numAlumnos=?, recursos=?, estado=?, sede=? where idSala=?";
			pstm = conn.prepareCall(sql);
			pstm.setString(1, oSala.getNumero());
			pstm.setInt(2, oSala.getPiso());
			pstm.setInt(3, oSala.getNumAlumnos());
			pstm.setString(4, oSala.getRecursos());
			pstm.setInt(5, oSala.getestado());
			pstm.setString(6, oSala.getSede());
			pstm.setInt(7, oSala.getIdSala());

			log.info(">>> " + pstm);

			// Ejecutamos a la base de datos
			salida = pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
	}

	// ------------------------------------------------------------------------------------------------------------------
	public List<Sala> listaSala() {
		ArrayList<Sala> listado = new ArrayList<Sala>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conn = MySqlDBConexion.getConexion();

			String sql = "select * from Sala";
			pstm = conn.prepareStatement(sql);

			rs = pstm.executeQuery();
			Sala oSala = null;
			while (rs.next()) {
				oSala = new Sala();
				oSala.setIdSala(rs.getInt(1));
				oSala.setNumero(rs.getString(2));
				oSala.setPiso(rs.getInt(3));
				oSala.setNumAlumnos(rs.getInt(4));
				oSala.setRecursos(rs.getString(5));
				oSala.setestado(rs.getInt(6));
				oSala.setFechaRegistro(rs.getDate(7));
				oSala.setSede(rs.getString(8));
				listado.add(oSala);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		return listado;
	}

	// ------------------------------------------------------------------------------------------------------------------
	public List<Sala> consultaSala(String numero, String piso, String numAlumnos, String recursos, String desde, String hasta, String sede){
		ArrayList<Sala> data = new ArrayList<Sala>();
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			conn=MySqlDBConexion.getConexion();
			String sql = "SELECT * FROM sistema_biblioteca_simple_2022_01.sala where numero like ?"
			+"and(?='' or piso = ?)"
			+"and(?='' or numAlumnos=?)"
			+"and (?='' or recursos like ?)"
			+"and(?='' or ?='' or fechaRegistro between ? and ?)"
			+"and(?='' or sede = ?);";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, numero+"%");
			pstm.setString(2, piso);
			pstm.setString(3, piso);
			pstm.setString(4, numAlumnos);
			pstm.setString(5, numAlumnos);
			pstm.setString(6, recursos);
			pstm.setString(7, "%"+recursos+"%");
//			pstm.setString(8, estado);
//			pstm.setString(9, estado);
			pstm.setString(8, desde);
			pstm.setString(9, hasta);
			pstm.setString(10, desde);
			pstm.setString(11, hasta);
			pstm.setString(12, sede);
			pstm.setString(13, sede);
			

			
			System.out.println("SQL.--->"+pstm);
			rs=pstm.executeQuery();
			Sala obj = null;
			while(rs.next()) {
				obj = new Sala();
				obj.setIdSala(rs.getInt("idSala"));
				obj.setNumero(rs.getString("numero"));
				obj.setPiso(rs.getInt("piso"));
				obj.setNumAlumnos(rs.getInt("numAlumnos"));
				obj.setRecursos(rs.getString("recursos"));
				obj.setestado(rs.getInt("estado"));
				obj.setFechaRegistro(rs.getDate("fechaRegistro"));
				obj.setSede(rs.getString("sede"));
				data.add(obj);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	finally {
				try {
					if(rs!=null)	rs.close();
					if(pstm!=null)pstm.close();
					if(conn!=null)conn.close();
				} catch (Exception e2) {}
			}
		return data;
	}

}