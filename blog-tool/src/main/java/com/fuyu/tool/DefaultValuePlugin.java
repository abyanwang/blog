package com.fuyu.tool;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;
import java.util.Properties;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

public class DefaultValuePlugin extends PluginAdapter {

    private boolean setDefaultValue;

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
        setDefaultValue = isTrue(properties.getProperty("setDefaultValue"));
    }

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        List<IntrospectedColumn> columns;
        if (introspectedTable.getRules().generateRecordWithBLOBsClass()) {
            columns = introspectedTable.getNonBLOBColumns();
        } else {
            columns = introspectedTable.getAllColumns();
        }

        setFieldDefaultValue(topLevelClass);
        return true;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        setFieldDefaultValue(topLevelClass);
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(TopLevelClass topLevelClass, IntrospectedTable
            introspectedTable) {
        setFieldDefaultValue(topLevelClass);
        return true;
    }

    private void setFieldDefaultValue(TopLevelClass topLevelClass) {
        if (setDefaultValue) {
            topLevelClass.getFields().forEach(field -> {
                if (StringUtils.containsIgnoreCase(field.getType().getFullyQualifiedName(), "boolean")) {
                    field.setInitializationString("false");
                }
            });
        }
    }

}
