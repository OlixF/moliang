package com.moliang.BLL;

import com.moliang.Model.Goods;

import net.sf.json.JSONArray;

public interface IGoodsBll {
	
	public JSONArray getList(int page, int size);
}
