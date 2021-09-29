package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
import com.dt.core.tools.MyDateUtil;
import com.dt.context.manager.SystemManager;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Slf4j
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
    @Override
    public IPage<${entity}> selectPage(IPage<${entity}> page, ${entity} ${'${entity}'?uncap_first}){
        return page(page, getSelectQueryWrapper(${'${entity}'?uncap_first}));
    }

    @Override
    public List<${entity}> selectList(${entity} ${'${entity}'?uncap_first}){
        return list(getSelectQueryWrapper(${'${entity}'?uncap_first}));
    }

    private QueryWrapper<${entity}> getSelectQueryWrapper(${entity} ${'${entity}'?uncap_first}){
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        if(${'${entity}'?uncap_first} == null){
            queryWrapper.orderByDesc("id");
            return queryWrapper;
        }

        <#list table.fields as field>
        <#if field.comment!?length gt 0>
        //${field.comment} ${field.name} ${field.type} ${field.propertyName} ${field.propertyType}
        </#if>
        <#if field.keyFlag>
        <#elseif field.propertyType == 'String'>
        if(StringUtils.isNotBlank(${'${entity}'?uncap_first}.get${'${field.propertyName}'?cap_first}())){
            queryWrapper.eq("${field.name}", ${'${entity}'?uncap_first}.get${'${field.propertyName}'?cap_first}());
        }
        <#elseif field.name != "del_flag" && (field.propertyType == 'Integer' || field.propertyType == 'Long')>
        if(${'${entity}'?uncap_first}.get${'${field.propertyName}'?cap_first}() != null){
            queryWrapper.eq("${field.name}", ${'${entity}'?uncap_first}.get${'${field.propertyName}'?cap_first}());
        }
        </#if>
        </#list>
        return queryWrapper;
    }

}
