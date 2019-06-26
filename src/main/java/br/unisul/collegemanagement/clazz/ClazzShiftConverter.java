package br.unisul.collegemanagement.clazz;

import br.unisul.collegemanagement.clazz.enums.ClazzShift;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Realiza a conversão de um turno do dia de uma turma para a sua representação na base de dados.
 */
@Converter(autoApply = true)
public class ClazzShiftConverter implements AttributeConverter<ClazzShift, String> {

    @Override
    public String convertToDatabaseColumn(ClazzShift clazzShift) {
        if (clazzShift == null) {
            return null;
        }
        return clazzShift.getName();
    }

    @Override
    public ClazzShift convertToEntityAttribute(String shiftName) {
        if (shiftName == null) {
            return null;
        }
        return ClazzShift.of(shiftName);
    }

}
