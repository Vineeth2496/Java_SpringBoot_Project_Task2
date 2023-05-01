package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
@Component
public class Dao_logics
{
	@Autowired
	JdbcTemplate jt;
	private Integer id;
	private String name;
	private Float sal;
	
	@Autowired
	Data d;
	
	public int insert()
	{
		int r=0;
		try
		{
		InputStreamReader ii=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(ii);
		System.out.println("Enter id:");
		id=Integer.parseInt(br.readLine());
		System.out.println("Enter name:");
		name=br.readLine();
		System.out.println("Enter sal:");
		sal=Float.parseFloat(br.readLine());
		
		d.setId(id);
		d.setName(name);
		d.setSal(sal);
		
		String qry1="insert into link4 values(?,?,?)";
		
		r=jt.update(qry1, d.getId(), d.getName(), d.getSal());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}
	public int update()
	{
		int r=0;
		try
		{
			String qry2="update link4 set name=? where id=?";
			InputStreamReader ii=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(ii);
			System.out.println("Enter New Name: ");
			String newname=br.readLine();
			
			System.out.println("Enter Id: ");
			Integer rid=Integer.parseInt(br.readLine());
			
			r=jt.update(qry2, newname, rid);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}
	public int delete()
	{
		int r=0;
		try
		{
		String qry3="delete from link4 where id=?";
		InputStreamReader ii=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(ii);
		
		System.out.println("Enter Delete Account id: ");
		Integer did=Integer.parseInt(br.readLine());
		
		r=jt.update(qry3, did);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return r;
	}
	public List fetch()
	{
		List t = null;
		try {
		String qry4="select * from link4 where id=?";
		InputStreamReader ii=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(ii);
		System.out.println("Enter Id with to View profile Details:");
		Integer fid=Integer.parseInt(br.readLine());
	//	String fid=br.readLine();
		
		
		t= jt.query(qry4, new RowMapper()
		 	{
			
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
				{
				jt.update(qry4, fid);
				// TODO Auto-generated method stub
				Data dd=new Data();
				dd.setId(rs.getInt(1));
				dd.setName(rs.getString(2));
				dd.setSal(rs.getFloat(3));
				return dd;
				}// closing RowMapper
		  	});// cloing aynonumus
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return t;
	}
}
