package br.unisul.collegemanagement.clazz.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.stream.Stream;

/**
 * Representa o turno do dia de uma turma.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public enum ClazzShift {

    MORNING(0, "Matituno"),
    AFTERNOON(1, "Vespertino"),
    NIGHT(2, "Noturno");

    /**
     * O identificador de um turno.
     */
    @ToString.Exclude private int id;

    /**
     * O nome de um turno.
     */
    private String name;

    /**
     * Retorna o turno do dia contendo o identificador especificado.
     *
     * @param id o identificador de um turno
     * @return o turno do dia
     * @throws IllegalArgumentException se não existir um turno cadastrado para o identificador
     *      especificado
     */
    public static ClazzShift of(int id) {
        return Stream.of(ClazzShift.values())
                .filter(g -> g.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Nenhum turno cadastrado para o identificador %d.", id)));
    }

    /**
     * Retorna o turno do dia contendo o nome especificado.
     *
     * @param name o nome de um turno
     * @return o turno do dia
     * @throws IllegalArgumentException se não existir um turno cadastrado para o identificador
     */
    public static ClazzShift of(String name) {
        return Stream.of(ClazzShift.values())
                .filter(g -> g.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Nenhum turno '%s' cadastrado.", name)));
    }

}
