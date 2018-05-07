package com.accp.bizdao;

import java.util.List;

import com.accp.demo.Dictionary;
import com.accp.util.Page;

/**
 * 数据字典的业务层处理
 * 
 * @author 解金化
 * 
 * @version1.0
 * 
 * @date 2017.04.21
 *
 */
public interface DictionaryBiz {
	
	/**
	 * 添加数据字典<br/>
	 * 
	 * 首先在添加之前<br/>
	 * 
	 * 进行非null验证，非null列验证<br/>
	 * 
	 * 查询typeCode、typeValus这两列的值，这是唯一列<br/>
	 * 
	 * 判断当前添加的信息是否跟他们有相同的<br/>
	 * 
	 * 如果相同则提示哪一列相同 debug("列名+equal")<br/>
	 * 同时抛出异常<br/>
	 * 
	 * 否则进行添加操作<br/>
	 * 
	 * 添加后通过当前对象某一唯一列进行查询，返回添加的对象<br/>
	 * 
	 * @param dictionary
	 * @return
	 */
	public Dictionary add(Dictionary dictionary) throws Exception;
	
	/**
	 * 删除数据字典<br/>
	 * 
	 * 在前台提供多个勾选，在本业务层进行循环删除操作<br/>
	 * 
	 * 启动线程保护正在删除操作的数据字典对象（能做就做，不能就不用）<br/>
	 * 
	 * 创建事务，进行循环操作，保证数据安全，保证全部操作成功或者失败<br/>
	 * 
	 * @param list
	 * 		需要删除多个勾选的字典编号
	 * 
	 * @return
	 * 		事务正常提交返回true，事务回滚返回false
	 */
	public Boolean del(List<Integer> dicId) throws Exception;
	
	/**
	 * 修改数据字典信息<br/>
	 * 
	 * 禁用同样调用该方法<br/>
	 * 
	 * 非null验证，并且验证数据库中的非null列，验证信息抛出异常<br/>
	 * 
	 * 在修改之前应该进行数据库验证<br/>
	 * 将数据库中的所有读出，跟当前对象进行比对，有相同的不允许修改<br/>
	 * 并且提示用户究竟是那一列出现的相同<br/>
	 * 
	 * 修改数据库<br/>
	 * 
	 * 根据当前对象的编号重新查询，不能直接返回当前对象，有可能出现数据冗余<br/>
	 * 出现夯重代码<br/>
	 * 
	 * 接收返回的对象并返回<br/>
	 * @param diction
	 * @return
	 * 		成功返回对象，失败返回null
	 */
	public Dictionary update(Dictionary diction) throws Exception;
	
	/**
	 * 修改字典分类的名称
	 * 
	 * @param oldName
	 * 		以前的名称，在数据库总存在的
	 * 
	 * @param newName
	 * 		要将当前老的信息修改成为现在的信息，修改后的名称
	 * 
	 * @return
	 * 		成功返回真，失败返回假
	 * @throws Exception
	 * 		自定义异常
	 */
	public Boolean updateTypeName(String oldName,String newName) throws Exception;
	
	/**
	 * 分页形式查询数据字典信息<br/>
	 * 
	 * 参数是一个在servlet中封装好的page对象<br/>
	 * 
	 * 但是page对象中的属性并不完整<br/>
	 * 
	 * 剩余 页面内容的集合 需要在当前类进行完善<br/>
	 * 即page.setList();<br/>
	 * 
	 * 最后将完整属性的当前对象返回给servlet中<br/>
	 * 
	 * 在此期间不要new对象，加速内存的开销<br/>
	 * 
	 * @param page
	 * 		封装好的分页对象
	 * @param dic
	 * 		动态查询条件
	 * 
	 * @return
	 * 		当前属性完整的参数
	 * @throws Exception 
	 */
	public void getPage(Page<Dictionary> page,Dictionary dic) throws Exception;
	
	/**
	 * 根据数据字典的编号查询数据字典具体信息<br/>
	 * 
	 * 非null验证
	 * 
	 * @param id
	 * 		数据字典的编号
	 * 
	 * @return
	 * 		有则返回对象，没有返回null
	 */
	public Dictionary getById(Integer id)throws Exception;
	
	/**
	 * 获取所有 
	 * 
	 * @param d
	 * 		含有动态条件的对象
	 * 
	 * @return
	 * 		所有的对象集合
	 * 
	 * @throws Exception
	 * 		有可能的异常
	 */
	public List<Dictionary> getAll(Dictionary d) throws Exception;
	
	/**
	 * 根据提供的对象条件进行查询<br/>
	 * 
	 * 需要根据什么查询就把条件放入对象中
	 * 
	 * @param d
	 * 		含有条件信息的对象<br/>
	 * 		对象中含有所需要查询的条件信息
	 * @return
	 * @throws Exception
	 */
	public List<Dictionary> getByColumn(Dictionary d) throws Exception;
	
	/**
	 * 获取所有的分组信息
	 * @return
	 * 		返回分组的名称
	 * @throws Exception
	 * 		自定义异常
	 */
	public List<String> getTypeName() throws Exception;
	public boolean delByTypeName(String typeName) throws Exception;
}
