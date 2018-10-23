package ${controllerPackage};
import ${modelPackage}.${modelNameUpperCamel};
import ${basePackage}.biz.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yst.common.response.ReturnT;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * Created by ${author} on ${date}.
 */
@RestController
@RequestMapping("/${baseRequestMapping}/")
public class ${modelNameUpperCamel}Controller {

    @Autowired
    ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @RequestMapping("add")
    public ReturnT add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return new ReturnT().successDefault();
    }

    @RequestMapping("delete")
    public ReturnT delete(@RequestParam Integer id) {
	    ${modelNameLowerCamel}Service.deleteById(id);
	    return new ReturnT().successDefault();
    }

    @RequestMapping("update")
    public ReturnT update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
	    ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
	    return new ReturnT().successDefault();
    }

    @RequestMapping("detail")
    public ReturnT detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        ReturnT returnT = new ReturnT();
        returnT.setData(${modelNameLowerCamel});
        return returnT.successDefault();
    }

    @RequestMapping("list")
    public ReturnT list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        ReturnT returnT = new ReturnT();
        returnT.setData(pageInfo);
        return returnT.successDefault();
    }

    @RequestMapping("queryList")
    public ReturnT queryList(${modelNameUpperCamel} ${modelNameLowerCamel}) {
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findByObj(${modelNameLowerCamel});
        ReturnT returnT = new ReturnT();
        returnT.setData(list);
        return returnT.successDefault();
    }
}
