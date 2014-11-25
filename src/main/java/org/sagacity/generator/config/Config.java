/*******************************************************
 * @author LIZHITAO
 * @date 2013-8-22 下午04:06:20
 * @name Config.java
 * @JDK version 1.6
 * @version 0
 ******************************************************/
package org.sagacity.generator.config;

import org.sagacity.util.ProjectProperty;



/**
 * @author LIZHITAO	
 * @action 代码生成配置类
 */
public interface Config {
	String TEMPLATE_PATH = ProjectProperty.PROJECT_PATH + "/src/main/resources/template/";
	String DEFAULT_MODEL_PACKAGE = ParseConfig.getConfig().get("model");
	String DEFAULT_MODELARRAY_PACKAGE = ParseConfig.getConfig().get("modelArray");
	String DEFAULT_DAO_PACKAGE = ParseConfig.getConfig().get("dao");
	String DEFAULT_DAOIMPL_PACKAGE = ParseConfig.getConfig().get("daoImpl");
	String DEFAULT_SERVICE_PACKAGE = ParseConfig.getConfig().get("service");
	String DEFAULT_SERVICEIMPL_PACKAGE = ParseConfig.getConfig().get("serviceImpl");
	String DEFAULT_CONTROLLER_PACKAGE = ParseConfig.getConfig().get("controller");
	String DAO_PATH = ProjectProperty.PROJECT_PATH + ParseConfig.getConfig().get("daoPath");
	String DAOIMPL_PATH = ProjectProperty.PROJECT_PATH + ParseConfig.getConfig().get("daoImplPath");
	String SERVICE_PATH = ProjectProperty.PROJECT_PATH + ParseConfig.getConfig().get("servicePath");
	String SERVICEIMPL_PATH = ProjectProperty.PROJECT_PATH + ParseConfig.getConfig().get("serviceImplPath");
	String CONTROLLER_PATH = ProjectProperty.PROJECT_PATH + ParseConfig.getConfig().get("controllerPath");
	String MODEL_PATH = ProjectProperty.PROJECT_PATH + ParseConfig.getConfig().get("modelPath");
	String MODELARRAY_PATH = ProjectProperty.PROJECT_PATH + ParseConfig.getConfig().get("modelArrayPath");
	String JS_PATH = ProjectProperty.PROJECT_PATH + ParseConfig.getConfig().get("jsPath");
	String MANAGE_JSP_PATH = ProjectProperty.PROJECT_PATH + ParseConfig.getConfig().get("manageJspPath");
	String PORTAL_JSP_PATH = ProjectProperty.PROJECT_PATH + ParseConfig.getConfig().get("portalJspPath");
	String MAPPER_PATH = ProjectProperty.PROJECT_PATH + ParseConfig.getConfig().get("mapperPath");
	String TEMPLATE = ParseConfig.getConfig().get("template");
}
