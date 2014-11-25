/**
 * 
 */
package org.sagacity.generator.process;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.sagacity.generator.parse.PDMParse;
import org.sagacity.generator.parse.Table;
import org.sagacity.generator.util.DataBaseHelper;
import org.sagacity.util.ProjectProperty;

/**
 * @author LIZHITAO
 * 
 */
public class Run {
	public static final int CONTROLLER = 0;
	public static final int DAO = 1;
	public static final int DAOIMPL = 2;
	public static final int JS = 3;
	public static final int JSP = 4;
	public static final int MAPPER = 5;
	public static final int MODEL = 6;
	public static final int MODELARRAY = 7;
	public static final int SERVICE = 8;
	public static final int SERVICEIMPL = 9;

	Command[] processCommands;
	Command[] undoCommands;

	ControllerGenerator controllerGenerator = null;
	DaoGenerator daoGenerator = null;
	DaoImplGenerator daoImplGenerator = null;
	JSGenerator jsGenerator = null;
	JSPGenerator jspGenerator = null;
	MapperGenerator mapperGenerator = null;
	ModelArrayGenerator modelArrayGenerator = null;
	ModelGenerator modelGenerator = null;
	ServiceGenerator serviceGenerator = null;
	ServiceImplGenerator serviceImplGenerator = null;

	ControllerCommand controllerCommand = null;
	DaoCommand daoCommand = null;
	DaoImplCommand daoImplCommand = null;
	JSCommand jsCommand = null;
	JSPCommand jspCommand = null;
	MapperCommand mapperCommand = null;
	ModelCommand modelCommand = null;
	ModelArrayCommand modelArrayCommand = null;
	ServiceCommand serviceCommand = null;
	ServiceImplCommand serviceImplCommand = null;

	public Run() {
		processCommands = new Command[10];
		undoCommands = new Command[10];

		controllerGenerator = new ControllerGenerator();
		daoGenerator = new DaoGenerator();
		daoImplGenerator = new DaoImplGenerator();
		jsGenerator = new JSGenerator();
		jspGenerator = new JSPGenerator();
		mapperGenerator = new MapperGenerator();
		modelArrayGenerator = new ModelArrayGenerator();
		modelGenerator = new ModelGenerator();
		serviceGenerator = new ServiceGenerator();
		serviceImplGenerator = new ServiceImplGenerator();

		controllerCommand = new ControllerCommand(controllerGenerator);
		daoCommand = new DaoCommand(daoGenerator);
		daoImplCommand = new DaoImplCommand(daoImplGenerator);
		jsCommand = new JSCommand(jsGenerator);
		jspCommand = new JSPCommand(jspGenerator);
		mapperCommand = new MapperCommand(mapperGenerator);
		modelCommand = new ModelCommand(modelGenerator);
		modelArrayCommand = new ModelArrayCommand(modelArrayGenerator);
		serviceCommand = new ServiceCommand(serviceGenerator);
		serviceImplCommand = new ServiceImplCommand(serviceImplGenerator);

		setCommand(CONTROLLER, controllerCommand);
		setCommand(DAO, daoCommand);
		setCommand(DAOIMPL, daoImplCommand);
		setCommand(JS, jsCommand);
		setCommand(JSP, jspCommand);
		setCommand(MAPPER, mapperCommand);
		setCommand(MODEL, modelCommand);
		setCommand(MODELARRAY, modelArrayCommand);
		setCommand(SERVICE, serviceCommand);
		setCommand(SERVICEIMPL, serviceImplCommand);
	}

	public void setCommand(int slot, Command processCommand) {
		this.processCommands[slot] = processCommand;
		this.undoCommands[slot] = processCommand;
	}

	/**
	 * @active 处理所有的表并生成所有类型的文件
	 */
	public void processAllTables() {
		List<Table> list = PDMParse.getTableInfo(ProjectProperty.RESOURCES_PATH
				+ "project.pdm");

		for (int i = 0; i < 10; i++) {
			processCommands[i].execute(list, null);
		}
	}

	/**
	 * @active 按类型处理所有的表的规定类型的文件 类型为controller、dao...
	 * @param type
	 */
	public void processAllTables(GeneratorType type) {
		String t = type.toString();
		List<Table> list = PDMParse.getTableInfo(ProjectProperty.RESOURCES_PATH
				+ "project.pdm");
		if (t.equals("DAO")) {
			processCommands[DAO].execute(list, null);
		} else if (t.equals("MODEL")) {
			processCommands[MODEL].execute(list, null);
		} else if (t.equals("DAOIMPL")) {
			processCommands[DAOIMPL].execute(list, null);
		} else if (t.equals("SERVICE")) {
			processCommands[SERVICE].execute(list, null);
		} else if (t.equals("SERVICEIMPL")) {
			processCommands[SERVICEIMPL].execute(list, null);
		} else if (t.equals("JS")) {
			processCommands[JS].execute(list, null);
		} else if (t.equals("MAPPER")) {
			processCommands[MAPPER].execute(list, null);
		} else if (t.equals("MODELARRAY")) {
			processCommands[MODELARRAY].execute(list, null);
		} else if (t.equals("CONTROLLER")) {
			processCommands[CONTROLLER].execute(list, null);
		} else if (t.equals("JSP")) {
			processCommands[JSP].execute(list, null);
		}
	}

	public void processSingleTable(String tableName) {
		List<Table> list = PDMParse.getTableInfo(ProjectProperty.RESOURCES_PATH
				+ "project.pdm");

		for (int i = 0; i < 10; i++) {
			processCommands[i].execute(list, tableName);
		}
	}

	public void processSingleTable(GeneratorType type, String tableName) {
		String t = type.toString();
		List<Table> list = PDMParse.getTableInfo(ProjectProperty.RESOURCES_PATH
				+ "project.pdm");
		if (t.equals("DAO")) {
			processCommands[DAO].execute(list, tableName);
		} else if (t.equals("MODEL")) {
			processCommands[MODEL].execute(list, tableName);
		} else if (t.equals("DAOIMPL")) {
			processCommands[DAOIMPL].execute(list, tableName);
		} else if (t.equals("SERVICE")) {
			processCommands[SERVICE].execute(list, tableName);
		} else if (t.equals("SERVICEIMPL")) {
			processCommands[SERVICEIMPL].execute(list, tableName);
		} else if (t.equals("JS")) {
			processCommands[JS].execute(list, tableName);
		} else if (t.equals("MAPPER")) {
			processCommands[MAPPER].execute(list, tableName);
		} else if (t.equals("MODELARRAY")) {
			processCommands[MODELARRAY].execute(list, tableName);
		} else if (t.equals("CONTROLLER")) {
			processCommands[CONTROLLER].execute(list, tableName);
		} else if (t.equals("JSP")) {
			processCommands[JSP].execute(list, tableName);
		}
	}

	/**
	 * 执行删除代码操作
	 * 
	 * @param
	 * @name undo
	 * @active
	 * @state
	 * @type void
	 * @time 上午10:50:56
	 * @exception/throws
	 * @see
	 * @since
	 * @param tableName
	 */
	public void undo(String tableName) {
		List<Table> list = PDMParse.getTableInfo(ProjectProperty.RESOURCES_PATH
				+ "project.pdm");
		undoCommands[CONTROLLER].undo(list, tableName);
		undoCommands[MODELARRAY].undo(list, tableName);
		undoCommands[MODEL].undo(list, tableName);
		undoCommands[DAOIMPL].undo(list, tableName);
		undoCommands[DAO].undo(list, tableName);
		undoCommands[SERVICEIMPL].undo(list, tableName);
		undoCommands[SERVICE].undo(list, tableName);
		undoCommands[MAPPER].undo(list, tableName);
		undoCommands[JSP].undo(list, tableName);
		undoCommands[JS].undo(list, tableName);

		if (null == tableName) {
			DataBaseHelper.dropTable(list);
		} else {
			Table table = new Table();
			table.setName(tableName);
			DataBaseHelper.dropTable(table);
		}

		if (null != tableName) {
			try {
				DataBaseHelper
						.execute("DELETE FROM ManageMenu WHERE url = 'manage/"
								+ StringUtils.uncapitalize(tableName)
								+ "/manager.action'");
			} catch (Exception e) {
				System.out.println("==================菜单表不存在！================");
			}
		} else {
			for (Table t : list) {
				try {
					DataBaseHelper
							.execute("DELETE FROM ManageMenu WHERE url = 'manage/"
									+ StringUtils.uncapitalize(t.getName())
									+ "/manager.action'");
				} catch (Exception e1) {
					System.out
							.println("==================菜单表不存在！================");
				}
			}
		}
	}
}
