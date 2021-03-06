package com.makao.dao;

import java.util.List;

import com.makao.entity.Comment;
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

	public OrderOff finishReturnOrder(int cityId, int orderid);

	public OrderOff queryByOrderId(String tableName, int orderid);

	public List<OrderOff> queryByUserId(String tableName, int userid);
	
	//已收货订单查询
	public List<OrderOff> queryConfirmGetByAreaId(String tableName, int areaId);
	//发起退货申请
	public OrderOff returnOrder(int cityid, int orderid);

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

	/**
	 * @param cityid
	 * @return
	 * Order_cityid_off表的记录数
	 */
	public int getRecordCount(int cityid);

	/**
	 * @param cityid
	 * @return
	 * 查询所有已取消(卖家取消)的和已退货的订单记录数
	 */
	public int getCanceledAndReturnedRecordCount(int cityid);

	/**
	 * @param comment
	 * @return
	 * //添加了评论后需要将评论的id号插入到对应订单中，方便后面读取
			//以"商品id=评论id,"的形式插入
	 */
	public int updateComment(Comment comment);

	/**
	 * @param string
	 * @return
	 * 将取消或退货的的订单的inventBack字段设为1
	 */
	public List<OrderOff> inventoryBackCanceledAndReturned(String string);

	/**
	 * @param cityid
	 * @return
	 * 将已收货一定时间后的订单状态改为已完成
	 */
	public List<OrderOff> terminateOrders(int cityid);

	/**
	 * @param string
	 * @return
	 * 查询待退款的订单的number
	 */
	public int queryNeedRefundNumber(String string);

	/**
	 * @param string
	 * @param areaId
	 * @return
	 * 已完成的订单，即状态为13，已收货且已过了退货期的订单
	 */
	public List<OrderOff> queryTerminaledByAreaId(String string, int areaId);

	/**
	 * @param cityId
	 * @param areaId
	 * @return
	 * 状态为13的记录数
	 */
	public int getTermialedRecordCount(int cityId, int areaId);

	public OrderOff queryByNumber(String string, String number);

	public int vcommentOrderByNumber(int cityId, String number, String vcomment);

	/**
	 * @param tableName
	 * @param areaid
	 * @param fromdate
	 * @param todate
	 * @return
	 * 从orderOff表里查询区域areaid对应的时间区间fromdate到todate的已完成和已取消退货的订单
	 */
	public List<OrderOff> queryDealed(String tableName, int areaid,
			String fromdate, String todate);

	/**
	 * @param string
	 * @param areaid
	 * @param fromdate
	 * @param todate
	 * @return
	 * 查找对应区域下在特定时间范围内的已退款的所有订单,注意是已退款不是已退货
	 */
	public List<OrderOff> queryReturned(String string, int areaid,
			String fromdate, String todate);
}