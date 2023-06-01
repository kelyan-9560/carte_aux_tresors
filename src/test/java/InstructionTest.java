import exceptions.InstructionsException;
import models.Instruction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionTest {

    @Test
    @DisplayName("should throws an InstructionsException() when instruction is not found")
    void should_throws_an_exception_when_instruction_is_found() {
        assertThrows(
                InstructionsException.class,
                () -> new Instruction("Z"));
    }

    @Test
    @DisplayName("should throws an InstructionsException() when instruction letter is too long")
    void should_throws_an_exception_when_instruction_letter_is_to_long() {
        assertThrows(
                InstructionsException.class,
                () -> new Instruction("AA"));
    }
}