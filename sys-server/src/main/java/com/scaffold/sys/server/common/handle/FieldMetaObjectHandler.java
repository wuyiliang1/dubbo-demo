package com.scaffold.sys.server.common.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *  mp公共字段填充
 *
 * @author wuyiliang
 * @date 2020/9/14 9:55
 */
@Component
public class FieldMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date();
        setFieldValByName("createDate", date, metaObject);
        setFieldValByName("updateDate", date, metaObject);
        setFieldValByName("delFlag", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateDate", new Date(), metaObject);
    }
}
