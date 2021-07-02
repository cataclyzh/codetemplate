package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {
    IPage<${entity}> selectPage(IPage<${entity}> page, ${'${entity}'?cap_first} ${'${entity}'?uncap_first});

    List<${entity}> selectList(${entity} ${'${entity}'?uncap_first});

    void insert(${entity} o);

    void insert(List<${entity}> list);

    void update(${entity} o);

    void addTestData();

}
