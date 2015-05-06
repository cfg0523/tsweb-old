/**
 * @author hayden
 */
package com.techsen.tsweb.entity;

import java.util.Date;

import com.techsen.tsweb.util.ObjectUtil;

/**
 * 实体基类
 */
public abstract class BaseEntity {

    /**
     * 主键id
     */
    protected String id;

    /**
     * 记录创建人
     */
    protected String createBy;

    /**
     * 记录创建时间
     */
    protected Date createDate;

    /**
     * 记录修改人
     */
    protected String updateBy;

    /**
     * 记录修改时间
     */
    protected Date updateDate;

    /**
     * 记录备注
     */
    protected String remarks;

    /**
     * 覆盖实体默认的toString方法
     */
    public String toString() {
        return ObjectUtil.toString(this);
    }

    public String getId() {
        return id;
    }

    public BaseEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public BaseEntity setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public BaseEntity setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public BaseEntity setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public BaseEntity setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public String getRemarks() {
        return remarks;
    }

    public BaseEntity setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

}
