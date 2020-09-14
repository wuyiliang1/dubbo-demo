package com.scaffold.sys.server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.scaffold.common.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author wuyiliang
 * @date 2020/9/14 17:18
 */

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_token")
public class TokenEntity extends BaseEntity {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户token
     */
    private String token;
}
