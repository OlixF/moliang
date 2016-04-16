package com.moliang.DAL;

import java.util.List;

import com.moliang.Model.Goods;

import net.sf.json.JSONArray;

public interface IGoodsDao {
	
	public JSONArray ListGoods(int page, int size);

}
