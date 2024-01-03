package com.kj.md.base.convertor;

import com.kj.md.base.code.CommonCode;
import com.kj.md.base.code.StudentCode;
import com.kj.md.base.code.StudentCode.GENDER;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.apache.commons.lang3.ObjectUtils;

@Converter
public class CodeConverter implements AttributeConverter<GENDER, Integer> {

    @Override
    public Integer convertToDatabaseColumn(GENDER attribute)
    {

        return ObjectUtils.isEmpty(attribute.getCode()) ? null : attribute.getCode();
    }

    @Override
    public GENDER convertToEntityAttribute(Integer dbData)
    {
        if (ObjectUtils.isEmpty(dbData))
        {
            return null;
        }
        return StudentCode.enumByCode(GENDER.class, dbData);
    }
}
