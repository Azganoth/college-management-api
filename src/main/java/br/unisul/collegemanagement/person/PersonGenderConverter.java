package br.unisul.collegemanagement.person;

import br.unisul.collegemanagement.person.enums.PersonGender;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Realiza a conversão de um gênero de uma pessoa para a sua representação na base de dados.
 */
@Converter(autoApply = true)
public class PersonGenderConverter implements AttributeConverter<PersonGender, String> {

    @Override
    public String convertToDatabaseColumn(PersonGender gender) {
        if (gender == null) {
            return null;
        }
        return gender.getName();
    }

    @Override
    public PersonGender convertToEntityAttribute(String genderName) {
        if (genderName == null) {
            return null;
        }
        return PersonGender.of(genderName);
    }

}
