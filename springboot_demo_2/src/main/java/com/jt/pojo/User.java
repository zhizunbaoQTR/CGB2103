package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("demo_user")//1.实现对象与表的映射
public class User {
    //规则:如果对象中的属性与表中的字段同名,则用户可以省略
    //  在编译时由框架自动添加
    //标识主键  主键自增
    @TableId(type= IdType.AUTO)
    //区别:基本类型有默认值,包装类型没有默认值,所以一定要用包装类型.
    private Integer id;
//    @TableField(value = "name")//对象的属性与表中的字段关联
    private String name;
//    @TableField("age")//对象的属性与表中的字段关联
    private Integer age;
    private String sex;

}
