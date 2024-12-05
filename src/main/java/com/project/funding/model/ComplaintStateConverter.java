package com.project.funding.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ComplaintStateConverter implements AttributeConverter<ComplaintState, String> {

    @Override
    public String convertToDatabaseColumn(ComplaintState attribute) {
        if (attribute == null) {
            return null;
        }
        switch (attribute) {
            case PENDING:
                return "민원 접수";
            case IN_PROGRESS:
                return "민원 처리 중";
            case RESOLVED:
                return "민원 완료";
            default:
                throw new IllegalArgumentException("Unknown attribute: " + attribute);
        }
    }

    @Override
    public ComplaintState convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        switch (dbData) {
            case "민원 접수":
                return ComplaintState.PENDING;
            case "민원 처리 중":
                return ComplaintState.IN_PROGRESS;
            case "민원 완료":
                return ComplaintState.RESOLVED;
            default:
                throw new IllegalArgumentException("Unknown dbData: " + dbData);
        }
    }
}
