package br.unisul.collegemanagement.person.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.stream.Stream;

/**
 * Representa o gênero de uma pessoa.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public enum PersonGender {

    UNKNOWN(0, "Desconhecido"),
    MALE(1, "Masculino"),
    FEMALE(2, "Feminino"),
    UNDEFINED(9, "Indefinido");

    /**
     * O identificador de um gênero.
     */
    @ToString.Exclude private int id;

    /**
     * O nome de um gênero.
     */
    private String name;

    /**
     * Retorna o gênero de uma pessoa contendo o identificador especificado.
     *
     * @param id o identificador de um gênero
     * @return o gênero de uma pessoa
     * @throws IllegalArgumentException se não existir um gênero cadastrado para o identificador
     *      especificado
     */
    public static PersonGender of(int id) {
        return Stream.of(PersonGender.values())
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Nenhum gênero cadastrado para o identificador %d.", id)));
    }

    /**
     * Retorna o gênero de uma pessoa contendo o nome especificado.
     *
     * @param name o nome de um gênero
     * @return o gênero de uma pessoa
     * @throws IllegalArgumentException se não existir um gênero cadastrado para o identificador
     */
    public static PersonGender of(String name) {
        return Stream.of(PersonGender.values())
                .filter(g -> g.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Nenhum gênero '%s' cadastrado.", name)));
    }

}
