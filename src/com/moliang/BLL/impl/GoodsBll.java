package com.moliang.BLL.impl;

import com.moliang.BLL.IGoodsBll;
import com.moliang.DAL.IGoodsDao;
import com.moliang.DAL.impl.GoodsDao;
import com.moliang.Model.Goods;

import net.sf.json.JSONArray;

public class GoodsBll implements IGoodsBll {

	IGoodsDao goodsDao = new GoodsDao();
	@Override
	public JSONArray getList(int page, int size) {
		return goodsDao.ListGoods(page, size);
	}

}
