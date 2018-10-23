package ${basePackage}.biz.impl;

import ${basePackage}.repository.${modelNameUpperCamel}Mapper;
import com.yst.common.bean.${modelNameUpperCamel};
import ${basePackage}.biz.${modelNameUpperCamel}Service;
import ${basePackage}.biz.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by ${author} on ${date}.
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

    @Autowired
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
