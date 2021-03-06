package com.mp.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baomidou.mybatisplus.plugins.Page;
import com.mp.dao.UserMapper;
import com.mp.pojo.User;

/**
 * @author:Lit
 * @mender:Li
 * @version:1.0.0
 * @time:2018年7月26日下午7:40:13
 * @docs:TestMp.java
 */

public class TestMP {

	private ApplicationContext app = new ClassPathXmlApplicationContext("spring-beans.xml");
	private UserMapper userMapper = app.getBean("userMapper", UserMapper.class);

	/* --------------------------------------------- 插件 --------------------------------------------- */
	
	/**
	 * 查询分页操作 分页插件操作
	 */
	@Test
	// 当前配置了分页插件 是真实的物理分页，而不是内存分页
	public void testPagination() {
		// 设置分页参数
		Page<User> page = new Page<>(1, 5);
		// 参数1 分页的辅助类 参数类型RowBounds 1,当前的页数2,显示的个数
		// 参数2 条件构造器,可以为空
		// 分页查询获得查询到的结果集
		List<User> userList = userMapper.selectPage(page, null);
		// 迭代结果集
		for (User user : userList) {
			System.out.println(user.toString());
		}
		// 获得分页相关信息
		System.out.println("总条数:" + page.getTotal());
		System.out.println("当前页码:" + page.getCurrent());
		System.out.println("总页码:" + page.getPages());
		System.out.println("每页显示的条数:" + page.getSize());
		System.out.println("是否有上一页:" + page.hasPrevious());
		System.out.println("是否有下一页:" + page.hasNext());
		// 将查询的结果封装到page中
		page.setRecords(userList);
	}

	/**
	 * 更新操作 乐观锁插件测试
	 */
	@Test
	public void testOptimisticLocker() {
		// 初始化user对象
		User user = new User();
		user.setId(24);
		user.setAccount("gsssgg");
		user.setPassword("weweddwe");
		user.setSalt(213256);
		user.setVersion(1);
		// 执行修改操作
		Integer result = userMapper.updateById(user);
		// 输出结果
		System.out.println("result:" + result);
	}

}
