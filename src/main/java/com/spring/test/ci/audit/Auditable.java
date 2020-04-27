package com.spring.test.ci.audit;

import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@ToString(callSuper = true)
public abstract class Auditable<T> implements Serializable {

    @CreatedBy
    protected T createBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "DATETIME(3)")
    protected Date createDate;

    @LastModifiedBy
    protected T lastUpdateBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastUpdateDate;

    public T getCreateBy() {
        return createBy;
    }

    public void setCreateBy(T createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public T getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(T lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
