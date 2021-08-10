package com.dandelion.swaggereg.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhanghab
 * @date 2021/8/10
 * @description:
 **/

@Data
@ApiModel(value = "用户实体")
public class User {

    @ApiModelProperty(value = "用户名")
    private String userName;


    @ApiModelProperty(value = "密码")
    private String password;
}
