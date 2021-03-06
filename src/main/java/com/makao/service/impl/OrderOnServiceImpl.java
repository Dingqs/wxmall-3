package com.makao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.makao.dao.IOrderOnDao;
import com.makao.entity.OrderOn;
import com.makao.service.IOrderOnService;

@Service
public class OrderOnServiceImpl implements IOrderOnService {
	@Resource
	private IOrderOnDao orderOnDao;
	public OrderOn getById(int id) {
		return this.orderOnDao.getById(id);
	}
	@Override
	public int insert(OrderOn orderOn) {
		return this.orderOnDao.insert(orderOn);
	}
	
	@Override
	public int deleteById(int id) {
		return this.orderOnDao.deleteById(id);
	}
	
	@Override
	public int update(OrderOn orderOn) {
		return this.orderOnDao.update(orderOn);
	}
	
	@Override
	public List<OrderOn> queryAll(String tableName) {
		return this.orderOnDao.queryAll(tableName);
	}
	@Override
	public List<OrderOn> queryByName(String name) {
		return this.orderOnDao.queryByName(name);
	}
	@Override
	public List<OrderOn> queryQueueByAreaId(String tableName, int areaId) {
		return this.orderOnDao.queryQueueByAreaId(tableName, areaId);
	}
	@Override
	public int cancelOrder(int cityId, int orderid, String vcomment) {
		return this.orderOnDao.cancelOrder(cityId, orderid, vcomment);
	}
	@Override
	public List<OrderOn> queryProcessByAreaId(String tableName, int areaId) {
		return this.orderOnDao.queryProcessByAreaId(tableName,areaId);
	}
	@Override
	public OrderOn distributeOrder(int cityId, int orderid) {
		return this.orderOnDao.distributeOrder(cityId, orderid);
	}
	@Override
	public OrderOn finishOrder(int cityId, int orderid) {
		return this.orderOnDao.finishOrder(cityId, orderid);
	}
	@Override
	public List<OrderOn> queryByUserId(String tableName, int userid) {
		return this.orderOnDao.queryByUserId(tableName, userid);
	}
	@Override
	public OrderOn queryByOrderId(String tableName, int orderid) {
		return this.orderOnDao.queryByOrderId(tableName,orderid);
	}
	@Override
	public List<OrderOn> queryDistributedByAreaId(String tableName, int areaId) {
		return this.orderOnDao.queryDistributedByAreaId(tableName, areaId);
	}
	@Override
	public int confirmGetOrder(int cityid, int orderid) {
		return this.orderOnDao.confirmGetOrder(cityid, orderid);
	}
	@Override
	public int getQueueRecordCount(int cityid, int areaid) {
		return this.orderOnDao.getQueueRecordCount(cityid, areaid);
	}
	@Override
	public int getProcessRecordCount(int cityId, int areaId) {
		return this.orderOnDao.getProcessRecordCount(cityId, areaId);
	}
	@Override
	public int getDistributedRecordCount(int cityId, int areaId) {
		return this.orderOnDao.getDistributedRecordCount(cityId, areaId);
	}
	@Override
	public int getRecordCount(int cityid) {
		return this.orderOnDao.getRecordCount(cityid);
	}
	@Override
	public OrderOn confirmMoney(String cityid, String orderNumber) {
		return this.orderOnDao.confirmMoney(cityid, orderNumber);
	}
	@Override
	public boolean isExist(int cityId, String orderNum) {
		return this.orderOnDao.isExist(cityId, orderNum);
	}
	@Override
	public OrderOn processOrder(int cityId, String orderid) {
		return this.orderOnDao.processOrder(cityId, orderid);
	}
	@Override
	public List<OrderOn> approachOrders(int cityid) {
		return this.orderOnDao.appoachOrders(cityid);
	}
	@Override
	public List<String> confirmOrders(int cityid) {
		return this.orderOnDao.confirmOrders(cityid);
	}
	@Override
	public int vcommentOrder(int cityId, int orderid, String vcomment) {
		return this.orderOnDao.vcommentOrder(cityId, orderid, vcomment);
	}
	@Override
	public List<OrderOn> unPaidOrders(int id) {
		return this.orderOnDao.unPaidOrders(id);
	}
	@Override
	public OrderOn userCancelOrder(int cityid, int orderid) {
		return this.orderOnDao.userCancelOrder(cityid, orderid);
	}
	@Override
	public String queryProcessAndReturnByAreaId(int cityId, int areaId) {
		return this.orderOnDao.queryProcessAndReturnByAreaId(cityId, areaId);
	}
	@Override
	public OrderOn queryByNumber(String string, String number) {
		return this.orderOnDao.queryByNumber(string, number);
	}
	@Override
	public int vcommentOrderByNumber(int cityId, String number, String vcomment) {
		return this.orderOnDao.vcommentOrderByNumber(cityId, number, vcomment);
	}
	
//	@Override
//	public void testor() {
//		this.orderOnDao.testor();
//	}
}
