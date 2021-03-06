package com.makao.service;

import java.util.List;
import java.util.Map;

import com.makao.entity.Product;

/**
 * @description: TODO
 * @author makao
 * @date 2016年5月6日
 */
public interface IProductService {

	int insert(Product product);

	int update(Product product);

	List<Product> queryByName(String name);

	List<Product> queryAll();

	Product getById(int id, int cityId, int areaId);

	int deleteById(int id);

	List<Product> queryByCityAreaId(int i, int j);

	int insertToWhole(Product product);

	List<Product> queryRepProducts();

	int notShowProduct(String tableName, int prodcutId);
	int showProduct(String tableName, int prodcutId);

	int updateRepProduct(Product product);
	
	/**
	 * @param cityId
	 * @param areaId
	 * @return
	 * 获取总的记录数
	 */
	int getRecordCount(int cityId, int areaId);

	/**
	 * @param cityId
	 * @param areaId
	 * @param position
	 * @param i
	 * @return
	 * 返回从指定下标开始到指定下标结束的所有记录
	 */
	List<Product> queryFromToIndex(int cityId, int areaId, int from, int to);

	/**
	 * @return
	 * 获取产品仓库，即Product表中的记录总数
	 */
	int getRecordCount();

	/**
	 * @param position
	 * @param i
	 * @return
	 * 从Product表中返回从指定下标开始到指定下标结束的所有记录
	 */
	List<Product> queryFromToIndex(int from, int to);

	/**
	 * @param string
	 * @param productId
	 * @return
	 * 给商品点赞
	 */
	int like(String tableName, int productId);

	/**
	 * @param cityId
	 * @param areaId
	 * @param id
	 * @return
	 * 从表Product_cityId_areaId中获取id为id的产品的库存和销量
	 */
	String getInventoryAndSV(int cityId, int areaId, String id);

	/**
	 * @param tableName
	 * @param productid
	 * @param inventN
	 * 修改商品的库存为inventN
	 * @return 
	 */
	int updateInventory(String tableName, String productid, String inventN);

	/**
	 * @param cityId
	 * @param areaId
	 * @param keyword
	 * @param cat
	 * @return
	 * 根据关键字搜索产品
	 */
	List<Product> searchProduct(int cityId, int areaId, String keyword,
			String cat);

	/**
	 * @param table
	 * @return
	 * 查询表里库存小于最低库存的商品
	 */
	List<Product> queryThreholds(String table);

	/**
	 * @param keyword
	 * @return
	 * 总库里查询商品
	 */
	List<Product> searchRepProducts(String keyword);

	/**
	 * @param string
	 * @param productId
	 * @param num
	 * @return
	 * 给商品补货
	 */
	int supplyProduct(String string, int productId, int num);

	/**
	 * @param string
	 * @param productId
	 * @param valueOf
	 * @return
	 * 更新库存为num，同时将supply设为0
	 */
	int suppliedProduct(String string, int productId, int num);

	/**
	 * @param tableName
	 * @param productid
	 * @param saled
	 * 销量修改为saled
	 */
	int updateSalesVolume(String tableName, String productid, int saled);

	/**
	 * @param tableName
	 * @param prodcutId
	 * @return
	 * 区域管理员删除商品
	 */
	int deleteProduct(String tableName, int prodcutId);

	/**
	 * @param offset
	 * @param pageSize
	 * @return
	 * 从Product表中返回第offset+1开始的pageSize条记录
	 */
	List<Product> queryFromToIndexOffset(int offset, int pageSize);

	/**
	 * @param cityId
	 * @param areaId
	 * @param offset
	 * @param pageSize
	 * @return
	 * 从Product_cityid_areaId表中返回第offset+1开始的pageSize条记录
	 */
	List<Product> queryFromToIndexOffset(int cityId, int areaId, int offset,
			int pageSize);

}
