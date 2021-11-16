package ${package.ServiceImpl};

import com.dt.core.tools.TreeUtils;
import com.google.common.collect.Lists;
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
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    SystemManager systemManager;

    @Override
    public IPage<${entity}> selectPage(IPage<${entity}> page, ${entity} ${'${entity}'?uncap_first}){
        return page(page, getSelectQueryWrapper(${'${entity}'?uncap_first}));
    }

    @Override
    public List<${entity}> selectList(${entity} ${'${entity}'?uncap_first}){
        return list(getSelectQueryWrapper(${'${entity}'?uncap_first}));
    }

    @Override
    public void insert(${entity} o){
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isBlank(o.getCreateTime())){
            o.setCreateTime(MyDateUtil.getDefaultTimeString());
        }
        //更新时间 update_time char(19) updateTime String
        if(StringUtils.isBlank(o.getUpdateTime())){
            o.setUpdateTime(MyDateUtil.getDefaultTimeString());
        }
        saveTree(o);
    }

    @Override
        public void insert(List<${entity}> list){
            for(${entity} o : list){
                saveTree(o);
        }
    }

    @Override
    public void update(${entity} o){
        //创建时间 create_time char(19) createTime String
        if(StringUtils.isBlank(o.getCreateTime())){
            o.setCreateTime(MyDateUtil.getDefaultTimeString());
        }
        //更新时间 update_time char(19) updateTime String
        o.setUpdateTime(MyDateUtil.getDefaultTimeString());
        saveTree(o);
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
        queryWrapper.orderByDesc("update_time");
        return queryWrapper;
    }

    @Override
    public void addTestData(){
        for(int i=0; i<30; i++){
            addOneTestData(i);
        }
    }

    private void addOneTestData(int i) {

        ${entity} o = new ${entity}();

        <#list table.fields as field>
            <#if field.comment!?length gt 0>
        //${field.comment} ${field.name} ${field.type} ${field.propertyName} ${field.propertyType}
            </#if>
            <#if field.keyFlag>
            <#elseif field.propertyName == 'createTime'>
            <#elseif field.propertyName == 'updateTime'>
            <#elseif field.propertyType == 'String' && field.name != "del_flag">
        o.set${'${field.propertyName}'?cap_first}("${field.propertyName}");
            <#elseif field.name != "del_flag" && (field.propertyType == 'Integer')>
        o.set${'${field.propertyName}'?cap_first}(111 + i);
            <#elseif field.name != "del_flag" && (field.propertyType == 'Long')>
        o.set${'${field.propertyName}'?cap_first}(222L + i);
            </#if>

        </#list>
        insert(o);
    }

    private boolean saveTree(${entity} entity) {
        Long parentId = entity.getParentId();
        if (parentId == null || parentId.equals(0L)) {
            ${entity} parent = new ${entity}();
            parent.setId(0l);
            parent.setParentId(parent.getId());
            entity.setParent(parent);
            entity.getParent().setParentIds(StringUtils.EMPTY);
        } else {
            entity.setParent(super.getById(parentId));
        }
        // 获取修改前的parentIds，用于更新子节点的parentIds
        String oldParentIds = entity.getParentIds();
        // 设置新的父节点串
        entity.setParentIds(entity.getParent().getParentIds() + entity.getParent().getId() + ",");

        // 保存或更新实体
        Boolean result = super.saveOrUpdate(entity);

        // 更新子节点 parentIds
        List<${entity}> list = baseMapper.findByParentIdsLike("%," + entity.getId() + ",%");
            for (${entity} e : list) {
                if (e.getParentIds() != null && oldParentIds != null) {
                e.setParentIds(e.getParentIds().replace(oldParentIds, entity.getParentIds()));
                baseMapper.updateParentIds(e);
            }
        }
        return result;
    }

    @Override
    public List<${entity}> findTree() {
        List<${entity}> roots= baseMapper.findRoots();
        List<${entity}> results= Lists.newArrayList();
        List<${entity}> list=baseMapper.selectList(new QueryWrapper<>());
        for(${entity} root:roots){
            if(TreeUtils.listContains(list,root)) {
                root = TreeUtils.findChildren(root,list);
                results.add(root);
            }
        }
        return results;
    }

    @Override
    public boolean delete(${entity} entity) {
        return false;
    }
}
