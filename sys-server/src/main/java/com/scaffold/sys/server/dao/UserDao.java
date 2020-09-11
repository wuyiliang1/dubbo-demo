package com.scaffold.sys.server.dao;

import com.scaffold.common.base.BaseDao;
import com.scaffold.sys.server.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wuyiliang
 * @date 2020/9/11 11:51
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {

}
