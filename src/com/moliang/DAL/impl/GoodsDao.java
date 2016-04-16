package com.moliang.DAL.impl;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.moliang.DAL.IGoodsDao;
import com.moliang.Model.Goods;
import com.moliang.Model.User;
import com.moliang.jdbc.ISysJDBC;
import com.moliang.jdbc.impl.SysJDBC;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GoodsDao implements IGoodsDao {

	ISysJDBC jdbc = null;
	ResultSet rs = null;
	
	public GoodsDao(){
		jdbc = new SysJDBC();
	}
	@Override
	public JSONArray ListGoods(int page, int size) {
		String sSql = "select * from mo_goods limit ?,?";
		jdbc.getConnection();
		ResultSet rs = jdbc.executeQuery(sSql, (page-1)*size, page*size);
		JSONArray array = new JSONArray();
		JSONObject object = null;
		try {
			while(rs.next()){
				object = new JSONObject();
				object.put("GoodsId", rs.getString("goods_id"));
				object.put("ClassId", rs.getString("class_id"));
				object.put("Name", rs.getString("goods_name"));
				object.put("Icon", rs.getString("goods_icon"));
				object.put("Img", rs.getString("goods_img"));
				object.put("Price", rs.getString("goods_price"));
				object.put("Unit", rs.getString("goods_unit"));
				object.put("MarketPrice", rs.getString("goods_market_price"));
				object.put("ExpirationDate", rs.getString("expiration_date"));
				object.put("Taste", rs.getString("goods_taste"));
				object.put("Introduce", rs.getString("goods_introduce"));
				object.put("RegisterDate", rs.getString("register_date"));
				object.put("SoldOutDate", rs.getString("sold_out_date"));
				object.put("SalesVolume", rs.getString("sales_volume"));
				object.put("Integral", rs.getString("goods_integral"));
				object.put("Evaluate", rs.getString("goods_evaluate"));
				object.put("Paking", rs.getString("goods_packing"));
				array.add(object);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		return array;
	}

}
