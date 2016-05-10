package com.makao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.makao.dao.IAreaDao;
import com.makao.entity.Area;

/**
 * @description: TODO
 * @author makao
 * @date 2016年5月7日
 */
@Repository
@Transactional
public class AreaDaoImpl implements IAreaDao {
	private static final Logger logger = Logger.getLogger(AreaDaoImpl.class);
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public int insert(Area area) {
		Session session = null;
		Transaction tx = null;
		int res = 0;// 返回0表示成功，1表示失败
		try {
			session = sessionFactory.openSession();// 获取和数据库的回话
			tx = session.beginTransaction();// 事务开始
			session.save(area);// 保存区域
			//这是在数据库中建立AreaName_cityId_product表，要放到同一事务中，保证区域点增加时，其数据库表同时建立
			String tableName = "Product_"+area.getCityId()+"_"+area.getId();
			String sql = "CREATE TABLE IF NOT EXISTS `"
					+ tableName
					+ "` (`id` int(11) NOT NULL AUTO_INCREMENT,"
					+ "`productName` varchar(30) NOT NULL,"
					+ "`catalog` varchar(30),"
					+ "`showWay` varchar(2) DEFAULT 's',"
					+ "`price` varchar(10),"
					+ "`standard` varchar(50),"
					+ "`marketPrice` varchar(10),"
					+ "`label` varchar(16),"
					+ "`coverSUrl` varchar(50),"
					+ "`coverBUrl` varchar(50),"
					+ "`inventory` int(11),"
					+ "`sequence` int(11),"
					+ "`status` varchar(30),"
					+ "`description` varchar(100),"
					+ "`origin` varchar(30),"
					+ "`salesVolume` int(11),"
					+ "`likes` int(11),"
					+ "`detailUrl` varchar(50),"
					+ "`isShow` varchar(5) DEFAULT 'yes',"
					+ "`areaId` int(11),"
					+ "`cityId` int(11),"
					+ "PRIMARY KEY (`id`))";
			session.doWork(
					// 定义一个匿名类，实现了Work接口
					new Work() {
						public void execute(Connection connection) throws SQLException {
							PreparedStatement ps = null;
							try {
								ps = connection.prepareStatement(sql);
								ps.execute();
							} finally {
								doClose(ps);
							}
						}
					});
			tx.commit();// 提交事务
		} catch (HibernateException e) {
			if (null != tx)
				tx.rollback();// 回滚
			res = 1;
			logger.error(e.getMessage(), e);
		} finally {
			if (null != session)
				session.close();// 关闭回话
		}
		return res;
	}

	@Override
	public Area getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Area area) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Area> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Area> queryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void testor() {
		// TODO Auto-generated method stub

	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	protected void doClose(PreparedStatement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (Exception ex) {
				rs = null;
				logger.error(ex.getMessage(), ex);
				ex.printStackTrace();
			}
		}
		// Statement对象关闭时,会自动释放其管理的一个ResultSet对象
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (Exception ex) {
				stmt = null;
				logger.error(ex.getMessage(), ex);
			}
		}
		// 当Hibernate的事务由Spring接管时,session的关闭由Spring管理.不用手动关闭
		// if(session != null){
		// session.close();
		// }
	}

	protected void doClose(PreparedStatement stmt) {
		// Statement对象关闭时,会自动释放其管理的一个ResultSet对象
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (Exception ex) {
				stmt = null;
				logger.error(ex.getMessage(), ex);
			}
		}
	}

}