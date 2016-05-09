/*
 * Powered By zoe
 * Since 2008 - 2016
 */

package com.zoe.phip.web.model.sdm;

import javax.persistence.*;

import com.zoe.phip.module.service.entity.MasterEntity;


/**
 * @author
 * @version 1.0
 * @date 2016-05-03
 */
@Table(name = "PHIP_ST_RS_SET_ELEMENT_INFO")
public class StRsSetElementInfo extends MasterEntity {
    /**
     * 数据集ID
     */
    @Column(name = "FK_SET_ID")
    private String fkSetId;
    /**
     * 数据元编码
     */
    @Column(name = "ELEMENT_CODE")
    private String elementCode;
    /**
     * 数据元名称
     */
    @Column(name = "ELEMENT_NAME")
    private String elementName;
    /**
     * 是否主键
     */
    @Column(name = "IS_PRIMARY_KEY")
    private java.math.BigDecimal isPrimaryKey;
    /**
     * 是否索引
     */
    @Column(name = "IS_INDEX_KEY")
    private java.math.BigDecimal isIndexKey;
    /**
     * 是否为空
     */
    @Column(name = "IS_NULLABLE")
    private java.math.BigDecimal isNullable;
    /**
     * 数据元ID
     */
    @Column(name = "FK_BASE_ELEMENT_ID")
    private String fkBaseElementId;
    /**
     * 字典ID
     */
    @Column(name = "FK_DICT_ID")
    private String fkDictId;
    /**
     * 数据类型
     */
    @Column(name = "DATA_TYPE")
    private String dataType;
    /**
     * 数据长度
     */
    @Column(name = "DATA_LENGTH")
    private String dataLength;
    /**
     * 数据精度
     */
    @Column(name = "DATA_ACCURACY")
    private Integer dataAccuracy;
    /**
     * 定义描述
     */
    @Column(name = "DEFINE")
    private String define;
    /**
     * 预期值类型
     */
    @Column(name = "EXPECT_TYPE")
    private Integer expectType;
    /**
     * 预期值
     */
    @Column(name = "EXPECT_VALUE")
    private String expectValue;
    /**
     *
     */
    @Column(name = "STANDARD_ID")
    private String standardId;
    /**
     *
     */
    @Column(name = "COLUMN_SORT")
    private String columnSort;
    /**
     *
     */
    @Column(name = "OTHERS")
    private String others;
    /**
     *
     */
    @Column(name = "STANDARD_CODE")
    private String standardCode;
    /**
     *
     */
    @Column(name = "DATA_ALLOW_VALUE")
    private String dataAllowValue;
    /**
     *
     */
    @Column(name = "VERSION")
    private String version;

    public String getFkSetId() {
        return this.fkSetId;
    }


    public void setFkSetId(String fkSetId) {
        this.fkSetId = fkSetId;
    }

    public String getElementCode() {
        return this.elementCode;
    }


    public void setElementCode(String elementCode) {
        this.elementCode = elementCode;
    }

    public String getElementName() {
        return this.elementName;
    }


    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public java.math.BigDecimal getIsPrimaryKey() {
        return this.isPrimaryKey;
    }


    public void setIsPrimaryKey(java.math.BigDecimal isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }

    public java.math.BigDecimal getIsIndexKey() {
        return this.isIndexKey;
    }


    public void setIsIndexKey(java.math.BigDecimal isIndexKey) {
        this.isIndexKey = isIndexKey;
    }

    public java.math.BigDecimal getIsNullable() {
        return this.isNullable;
    }


    public void setIsNullable(java.math.BigDecimal isNullable) {
        this.isNullable = isNullable;
    }

    public String getFkBaseElementId() {
        return this.fkBaseElementId;
    }


    public void setFkBaseElementId(String fkBaseElementId) {
        this.fkBaseElementId = fkBaseElementId;
    }

    public String getFkDictId() {
        return this.fkDictId;
    }


    public void setFkDictId(String fkDictId) {
        this.fkDictId = fkDictId;
    }

    public String getDataType() {
        return this.dataType;
    }


    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataLength() {
        return this.dataLength;
    }


    public void setDataLength(String dataLength) {
        this.dataLength = dataLength;
    }

    public Integer getDataAccuracy() {
        return this.dataAccuracy;
    }


    public void setDataAccuracy(Integer dataAccuracy) {
        this.dataAccuracy = dataAccuracy;
    }

    public String getDefine() {
        return this.define;
    }


    public void setDefine(String define) {
        this.define = define;
    }

    public Integer getExpectType() {
        return this.expectType;
    }


    public void setExpectType(Integer expectType) {
        this.expectType = expectType;
    }

    public String getExpectValue() {
        return this.expectValue;
    }


    public void setExpectValue(String expectValue) {
        this.expectValue = expectValue;
    }

    public String getStandardId() {
        return this.standardId;
    }


    public void setStandardId(String standardId) {
        this.standardId = standardId;
    }

    public String getColumnSort() {
        return this.columnSort;
    }


    public void setColumnSort(String columnSort) {
        this.columnSort = columnSort;
    }

    public String getOthers() {
        return this.others;
    }


    public void setOthers(String others) {
        this.others = others;
    }

    public String getStandardCode() {
        return this.standardCode;
    }


    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode;
    }

    public String getDataAllowValue() {
        return this.dataAllowValue;
    }


    public void setDataAllowValue(String dataAllowValue) {
        this.dataAllowValue = dataAllowValue;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 字典代码
     */
    private String dictCode;

    /**
     * 字典名称
     */
    private String dictName;


    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }
}
