/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午5:02:40
 * @name GeneratorCommand.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.util.List;

import org.sagacity.generator.parse.Table;


/**
 * @author LIZHITAO
 * 生成代码的命令接口
 *
 */
public interface Command {
	/**
	 * 执行生成命令
	 * @param 
	 * @name execute
	 * @active
	 * @state
	 * @type void
	 * @time 下午5:04:40
	 * @exception/throws
	 * @see
	 * @since
	 */
	void execute(List<Table> list, String tableName);
	
	/**
	 * 撤销生成命令
	 * @param 
	 * @name undo
	 * @active
	 * @state
	 * @type void
	 * @time 下午5:04:54
	 * @exception/throws
	 * @see
	 * @since
	 */
	void undo(List<Table> list, String tableName);
}
