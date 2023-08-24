package com.guyuai.framework.excel.core.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.guyuai.framework.common.util.json.JsonUtils;
import com.guyuai.framework.excel.core.annotations.JsonClassAnnotion;
import lombok.extern.slf4j.Slf4j;

/**
 * @company: 谷雨互动
 * @author: whx
 * @date: 2023/6/18
 * @version:
 */
@Slf4j
public class JsonListArrayConvert implements Converter<Object> {

        @Override
        public Class<?> supportJavaTypeKey() {
            throw new UnsupportedOperationException("暂不支持，也不需要");
        }

        @Override
        public CellDataTypeEnum supportExcelTypeKey() {
            throw new UnsupportedOperationException("暂不支持，也不需要");
        }

        @Override
        public Object convertToJavaData(ReadCellData readCellData, ExcelContentProperty contentProperty,
                                        GlobalConfiguration globalConfiguration) {

            String json = readCellData.getStringValue();

            Class<?> type = getType(contentProperty);


            return JsonUtils.parseArray( json, type);


        }

    @Override
    public WriteCellData<String> convertToExcelData(Object value, ExcelContentProperty contentProperty,
                                                    GlobalConfiguration globalConfiguration) {
        // 生成 Excel 小表格
        return new WriteCellData<>(JsonUtils.toJsonString(value));
    }


        private static Class<?> getType(ExcelContentProperty contentProperty) {
            return contentProperty.getField().getAnnotation(JsonClassAnnotion.class).value();
        }

}
