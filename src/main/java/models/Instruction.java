package models;

import exceptions.InstructionsException;

import java.util.Objects;

public class Instruction {
    private final String value;

    public Instruction(String value) {
        instructionCheck(value);
        this.value = value;
    }

    private void instructionCheck(String value) {
        if (value.length() != 1) {
            throw new InstructionsException("Instruction must be a single character");
        }
        if (!"ADG".contains(value)) {
            throw new InstructionsException("Instruction must be A, D or G");
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instruction that = (Instruction) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "models.Instruction{" +
                "value='" + value + '\'' +
                '}';
    }
}
