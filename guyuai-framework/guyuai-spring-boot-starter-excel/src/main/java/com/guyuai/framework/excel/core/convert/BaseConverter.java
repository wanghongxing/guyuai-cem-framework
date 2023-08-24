package com.guyuai.framework.excel.core.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @company: 谷雨互动
 * @author: whx
 * @date: 2023/6/28
 * @version:
 */
public abstract class BaseConverter <T extends Object> implements Converter<T> {
    private Class<T> clazz;

    // 子类传入class，接收LocalDate.class,LocalDateTime.class
    public BaseConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Class supportJavaTypeKey() {
        return clazz;
    }

    @Override
    public T convertToJavaData(ReadCellData cellData, ExcelContentProperty contentProperty,
                               GlobalConfiguration globalConfiguration) {

        // LocalDateTime 时间转换
        if (cellData.getData() instanceof LocalDate) {
            if (cellData.getType().equals(CellDataTypeEnum.NUMBER)) {
                LocalDate localDate = LocalDate.of(1900, 1, 1);
                localDate = localDate.plusDays(cellData.getNumberValue().longValue());
                return (T) localDate;
            } else if (cellData.getType().equals(CellDataTypeEnum.STRING)) {
                return (T) LocalDate.parse(cellData.getStringValue(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } else {
                return null;
            }
        }

        // LocalDateTime 时间转换
        if (cellData.getData() instanceof LocalDateTime) {
            return (T) LocalDateTime.parse(cellData.getStringValue(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
        return null;

    }


    @Override
    public WriteCellData<String> convertToExcelData(T o, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if (o instanceof LocalDate) {
            LocalDate  date =(LocalDate )o;

            // todo 此处为伪代码o.String转LocalDate
             return new WriteCellData<>(date.toString());
        }

        if (o instanceof LocalDateTime) {
            LocalDateTime date =(LocalDateTime)o;
            return new WriteCellData<>(date.toString());

        }

        return new WriteCellData<>(o.toString());
    }
}
