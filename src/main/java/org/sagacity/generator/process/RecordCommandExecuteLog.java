/*******************************************************
 * @author LIZHITAO
 * @date 2014-3-24 下午7:28:39
 * @name RecordCommandExecuteLog.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.process;

import java.util.Stack;

/**
 * @author LIZHITAO 记录执行命令日志的类
 */
public class RecordCommandExecuteLog {
	private static Stack<CommandExecuteLog> record = new Stack<CommandExecuteLog>();;

	private static volatile RecordCommandExecuteLog recordCommandExecuteLog = null;

	private RecordCommandExecuteLog() {}

	/**
	 * 获取日志对象
	 * @param 
	 * @name getInstance
	 * @active
	 * @state
	 * @type RecordCommandExecuteLog
	 * @time 下午7:37:50
	 * @exception/throws
	 * @see
	 * @since
	 * @return
	 */
	public static RecordCommandExecuteLog getInstance() {
		if (null == recordCommandExecuteLog) {
			synchronized (RecordCommandExecuteLog.class) {
				return new RecordCommandExecuteLog();
			}
		}
		return recordCommandExecuteLog;
	}

	/**
	 * 记录日志
	 * @param 
	 * @name record
	 * @active
	 * @state
	 * @type void
	 * @time 下午7:37:34
	 * @exception/throws
	 * @see
	 * @since
	 * @param commandExecuteLog
	 */
	public void record(CommandExecuteLog commandExecuteLog) {
		record.push(commandExecuteLog);
	}
	
	/**
	 * 取出日志
	 * @param 
	 * @name popCommandExecuteLog
	 * @active
	 * @state
	 * @type CommandExecuteLog
	 * @time 下午7:37:22
	 * @exception/throws
	 * @see
	 * @since
	 * @return
	 */
	public CommandExecuteLog popCommandExecuteLog(){
		if(record.size() > 0){
			return record.pop();
		} else{
			return new CommandExecuteLog(null, null, null);
		}
	}
}
