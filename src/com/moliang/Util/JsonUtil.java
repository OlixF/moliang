package com.moliang.Util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class JsonUtil {
	public static JSONArray formatRsToJsonArray(ResultSet rs) throws Exception {
		ResultSetMetaData md = rs.getMetaData();
		int num = md.getColumnCount();
		JSONArray array = new JSONArray();
		while (rs.next()) {
			JSONObject mapOfColValues = new JSONObject();
			for (int i = 1; i <= num; i++) {
				Object o = rs.getObject(i);
				if (o instanceof Date) {
					mapOfColValues.put(md.getColumnName(i),
							DateUtil.formatDate((Date) o, "yyyy-MM-dd"));
				} else if(o instanceof Float) {
					mapOfColValues.put(md.getColumnName(i),rs.getString(i));
				} else if(o instanceof Double){
					mapOfColValues.put(md.getColumnName(i),rs.getString(i));
				} else {
					mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
				}
			}
			array.add(mapOfColValues);
		}
		return array;
	}
	public static JSONArray formatRsToJsonArrayFooter(ResultSet rs,String str) throws Exception {
		ResultSetMetaData md = rs.getMetaData();
		int num = md.getColumnCount();
		JSONArray array = new JSONArray();
		while (rs.next()) {
			JSONObject mapOfColValues = new JSONObject();
			for (int i = 1; i <= num; i++) {
				Object o = rs.getObject(i);
				if (o instanceof Date) {
					mapOfColValues.put(md.getColumnName(i),
							DateUtil.formatDate((Date) o, "yyyy-MM-dd"));
				} else {
					mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
				}
			}
			if("account".equals(str)){
				mapOfColValues.put("account_side_unit", "合 计（元）：");
			}else if("product".equals(str)){
				mapOfColValues.put("buy_num", "采购总额（元）：");
			}
			array.add(mapOfColValues);
		}
		return array;
	}
}
