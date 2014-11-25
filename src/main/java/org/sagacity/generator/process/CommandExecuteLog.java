/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午7:25:43
 * @name CommandExecuteLog.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

/**
 * @author LIZHITAO 命令执行日志
 */
public class CommandExecuteLog {
	private String commandName;
	private GeneratorType generatorType;
	private String tableName;
	
	public CommandExecuteLog(String commandName, GeneratorType generatorType, String tableName){
		this.commandName = commandName;
		this.generatorType = generatorType;
		this.tableName = tableName;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public GeneratorType getGeneratorType() {
		return generatorType;
	}

	public void setGeneratorType(GeneratorType generatorType) {
		this.generatorType = generatorType;
	}

}
