package ${package};
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import org.jgenerator.model.${entityName};
import org.jgenerator.model.entityArray.${entityName}Array;
import org.jgenerator.service.${entityName}Service;
import org.jgenerator.core.util.page.Pager;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Controller
@Scope("request")
public class ${entityName}Controller {
	public static final String MODULE_PATH = "manage/${entityName ? uncap_first}/";
	@Resource
	private ${entityName}Service ${entityName ? uncap_first}ServiceImpl;

	@RequestMapping(value = "/manage/${entityName ? uncap_first}/manager")
	public String manager() {
		return MODULE_PATH + "manager";
	}

	@RequestMapping(value = "/manage/${entityName ? uncap_first}/query")
	@ResponseBody
	public Map<String, Object> query(${entityName} ${entityName ? uncap_first}, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<${entityName}> pager = ${entityName ? uncap_first}ServiceImpl.queryPage(${entityName ? uncap_first},
				page, rows, orderBy, sortBy);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", pager.getTotalCount());
		result.put("rows", pager.getDataList());
		return result;
	}
	
	@RequestMapping(value = "/manage/${entityName ? uncap_first}/toAdd")
	public String toAdd(Model model){
		return MODULE_PATH + "add";
	}
	
	@RequestMapping(value = "/manage/${entityName ? uncap_first}/add")
	@ResponseBody
	public String add(${entityName} ${entityName ? uncap_first}){
		${entityName ? uncap_first}ServiceImpl.save(${entityName ? uncap_first});
		return "1";
	}
	
	@RequestMapping(value = "/manage/${entityName ? uncap_first}/toEdit")
	public String toEdit(Model model, Integer id){
		${entityName} ${entityName ? uncap_first} = ${entityName ? uncap_first}ServiceImpl.fetch(id);
		model.addAttribute("${entityName ? uncap_first}", ${entityName ? uncap_first});
		return MODULE_PATH + "edit";
	}
	
	@RequestMapping(value = "/manage/${entityName ? uncap_first}/edit")
	@ResponseBody
	public String edit(${entityName} ${entityName ? uncap_first}){
		${entityName ? uncap_first}ServiceImpl.saveOrUpdate(${entityName ? uncap_first});
		return "1";
	}
	
	@RequestMapping(value = "/manage/${entityName ? uncap_first}/deleteByIds")
	@ResponseBody
	public String deleteByIds(${entityName}Array array){
		if(null != array && null != array.get${entityName}Array()){
			for(${entityName} entity : array.get${entityName}Array()){
				${entityName ? uncap_first}ServiceImpl.delete(entity.getId());
			}
		}
		return "1";
	}
	
	@RequestMapping(value = "/manage/${entityName ? uncap_first}/queryCombox")
	@ResponseBody
	public List<${entityName}> queryCombox(${entityName} ${entityName ? uncap_first}, 
		Integer page, Integer rows, String orderBy, String sortBy) {
		Pager<${entityName}> pager = ${entityName ? uncap_first}ServiceImpl.queryPage(${entityName ? uncap_first},
				page, Integer.MAX_VALUE, orderBy, sortBy);
		return pager.getDataList();
	}
}