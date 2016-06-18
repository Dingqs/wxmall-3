package com.makao.dao;

import java.util.List;

import com.makao.entity.OrderOff;
import com.makao.entity.OrderOn;

public interface IOrderOffDao {

    public int insert(OrderOff orderOff);

    public OrderOff getById(int id);

    public int update(OrderOff orderOff);
    
    public List<OrderOff> queryAll(String tableName);
    
    public List<OrderOff> queryByName(String name);

	public void testor();

	public int deleteById(int id);

	public List<OrderOff> queryCancelByAreaId(String tableName, int areaId);

	public List<OrderOff> queryRefundByAreaId(String tableName, int areaId);

	public int refundOrder(int cityId, int orderid);

	public int finishRefundOrder(int cityId, int orderid);

	public int cancelRefundOrder(int cityId, int orderid, String vcomment);

	public List<OrderOff> queryAllCanceledAndReturned(String tableName);

	public int finishReturnOrder(int cityId, int orderid);

	public OrderOff queryByOrderId(String tableName, int orderid);

	public List<OrderOff> queryByUserId(String tableName, int userid);
	
	//已收货订单查询
	public List<OrderOff> queryConfirmGetByAreaId(String tableName, int areaId);
	//发起退货申请
	public int returnOrder(int cityid, int orderid);

	/**
	 * @param cityId
	 * @param areaId
	 * @return
	 * 查询已收货的记录数
	 */
	public int getConfirmRecordCount(int cityId, int areaId);

	/**
	 * @param cityId
	 * @param areaId
	 * @return
	 * 查询退货申请中和退货中的订单
	 */
	public int getReturnRecordCount(int cityId, int areaId);

	/**
	 * @param cityId
	 * @param areaId
	 * @return
	 * 已取消，已退货，已取消退货的记录数
	 */
	public int getCancelRecordCount(int cityId, int areaId);
}