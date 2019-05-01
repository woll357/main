package db_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Airp_detailsDAO {
	
	Connection con;
	PreparedStatement ptmt;
	ResultSet rs;
	String sql;
	
	public Airp_detailsDAO() {
		
		DataSource ds;
		try {
			ds = (DataSource)new InitialContext().lookup("java:comp/env/scanner");
			con = ds.getConnection();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	//상품등록할때 좌석갯수와 클래스 업데이트
	public void airConvert() {
		
		
		
		sql = "select ap_code, Numberof_sea, flightclass from airp_details, air_plane where airp_details.air_ty = air_plane.air_ty ";
		
		try {
			
			ptmt = con.prepareStatement(sql);
			
			
			
			rs = ptmt.executeQuery();
			
			while(rs.next()) {
				sql = "update air_item set totseatcnt = ? , flightclass = ? where ap_code = ?";
				ptmt = con.prepareStatement(sql);
				ptmt.setInt(1, rs.getInt("Numberof_sea"));
				ptmt.setString(2, rs.getString("flightclass"));
				ptmt.setString(3, rs.getString("ap_code"));
				
				
				ptmt.executeUpdate();
				
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
		   close();
	  }
		       
		
	}
	   
	
	//협력업체 비행기 리스트
		//select distinct air_code , ap_code , airp_details.air_ty , aircraft_type , linear_content , wings_width , numberof_sea , max_two , engine_type , tail_velocity , maximum_altitude , maximum_od  from air_plane , airp_details where air_code = 'A1000' ;
		public Object airplanlista(String air_code) {
			
			ArrayList<Airp_detailsDTO> res = new ArrayList<Airp_detailsDTO>();
			
			sql = "select distinct  ap_code ,air_code  , airp_details.air_ty , aircraft_type , linear_content , wings_width , numberof_sea , max_two , engine_type , tail_velocity , maximum_altitude , maximum_od ,flightclass from air_plane , airp_details where air_plane.air_ty =  airp_details.air_ty  and air_code = ? ";
			
			try {
				
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, air_code);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					
					Airp_detailsDTO	 dto = new Airp_detailsDTO();
					
					 dto.setAir_code(rs.getString("air_code"));
					 dto.setAp_code(rs.getString("ap_code"));
					 dto.setAir_ty(rs.getString("air_ty"));
					 dto.setAircraft_type(rs.getString("aircraft_type"));
					 dto.setLinear_content(rs.getString("linear_content"));
					 dto.setWings_width(rs.getString("wings_width"));
					 dto.setNumberof_sea(rs.getString("numberof_sea"));	 
					 dto.setMax_two(rs.getString("max_two"));
					 dto.setEngine_type(rs.getString("engine_type"));
					 dto.setTail_velocity(rs.getString("tail_velocity"));
					 dto.setMaximum_altitude(rs.getString("maximum_altitude"));
					 dto.setMaximum_od(rs.getString("maximum_od"));
					 dto.setFlightclass(rs.getString("flightclass"));
					 
					 
					 res.add(dto) ;
					}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}finally {
			   close();
		  }
			       
			return res;
		}
		//협력업체 비행기 검색
public Object airplanlista2(String ap_code , String air_code) {
			
			ArrayList<Airp_detailsDTO> res = new ArrayList<Airp_detailsDTO>();
			
			sql = "select distinct  ap_code ,air_code  , airp_details.air_ty , aircraft_type , linear_content , wings_width , numberof_sea , max_two , engine_type , tail_velocity , maximum_altitude , maximum_od ,flightclass from air_plane , airp_details where air_plane.air_ty =  airp_details.air_ty  and ap_code = ? and air_code = ? ";
			
			try {
				
				ptmt = con.prepareStatement(sql);
				
				ptmt.setString(1, ap_code);
				ptmt.setString(2, air_code);
				
				rs = ptmt.executeQuery();
				
				while(rs.next()) {
					
					Airp_detailsDTO	 dto = new Airp_detailsDTO();
					
					 dto.setAir_code(rs.getString("air_code"));
					 dto.setAp_code(rs.getString("ap_code"));
					 dto.setAir_ty(rs.getString("air_ty"));
					 dto.setAircraft_type(rs.getString("aircraft_type"));
					 dto.setLinear_content(rs.getString("linear_content"));
					 dto.setWings_width(rs.getString("wings_width"));
					 dto.setNumberof_sea(rs.getString("numberof_sea"));	 
					 dto.setMax_two(rs.getString("max_two"));
					 dto.setEngine_type(rs.getString("engine_type"));
					 dto.setTail_velocity(rs.getString("tail_velocity"));
					 dto.setMaximum_altitude(rs.getString("maximum_altitude"));
					 dto.setMaximum_od(rs.getString("maximum_od"));
					 dto.setFlightclass(rs.getString("flightclass"));
					 
					 
					 res.add(dto) ;
					}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}finally {
			   close();
		  }
			       
			return res;
		}
		
		
		public void close() {
			if(rs!=null) try {rs.close();} catch (SQLException e) {	}
			if(ptmt!=null) try {ptmt.close();} catch (SQLException e) {	}
			if(con!=null) try {con.close();} catch (SQLException e) {	}
		}
		
		
	}
