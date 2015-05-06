/**
 * @author hayden
 */
package com.techsen.tsweb.dao;

/**
 * DAO接口
 */
public interface BaseDao<T> {
    /**
     * 增加
     */
    T addEntity(T entity);
    
    /**
     * 删除
     */
    void deleteEntity(T entity);
    
    /**
     * 修改
     */
    void updateEntity(T entity);
    
    /**
     * 查找
     */
    T getEntity(String id);
}
