package adventofcode2020.day8;

public class Instruction {

    String operation;
    String operand;
    int amount;
    int lineInFile;
    boolean executed = false;
    int amountsExecuted = 0;

    public Instruction(String line, int lineInFile) {
        String[] match = line.split(" ");
        operation = match[0];
        String op = match[1];
        operand = op.substring(0, 1);
        amount = Integer.parseInt(op.substring(1));
        this.lineInFile = lineInFile;
    }

    public void setAmountsExecuted(int amountsExecuted) {
        this.amountsExecuted = amountsExecuted;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
        amountsExecuted++;
    }

    public boolean isExecuted() {
        return executed;
    }

    public int operandInstructionSet(int instructionSet) {

        if (operation.equals("acc") || operation.equals("nop")) {
            instructionSet++;
        }

        if (operation.equals("jmp")) {
            switch (operand) {
                case "+":
                    instructionSet = instructionSet + amount;
                    break;
                case "-":
                    instructionSet = instructionSet - amount;
                    break;
            }
        }
        return instructionSet;
    }

    public int setAccumulator(int accumulator) {
        if (operation.equals("acc")) {
            switch (operand) {
                case "+":
                    accumulator = accumulator + amount;
                    break;
                case "-":
                    accumulator = accumulator - amount;
                    break;
            }
        }
        return accumulator;
    }

    public void setOperand(String nop) {
    }
}

