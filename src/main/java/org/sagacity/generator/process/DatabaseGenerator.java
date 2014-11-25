/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-25 上午11:04:17
 * @name DatabaseGenerator.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.util.List;

import org.sagacity.generator.parse.Table;

/**
 * @author LIZHITAO
 * 数据库生产类
 */
public class DatabaseGenerator extends Generator {

	/**
	 * @param 
	 * @name process
	 * @active
	 * @state
	 * @type DatabaseGenerator
	 * @time 上午11:04:17
	 * @see org.sagacity.generator.process.Generator#process(java.util.List, java.lang.String)
	 */
	@Override
	public void process(List<Table> list, String tableName) {
	}

	/**
	 * @param 
	 * @name undoProcess
	 * @active
	 * @state
	 * @type DatabaseGenerator
	 * @time 上午11:04:17
	 * @see org.sagacity.generator.process.Generator#undoProcess(java.util.List, java.lang.String)
	 */
	@Override
	public void undoProcess(List<Table> list, String tableName) {
	}

}
