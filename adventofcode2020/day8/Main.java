package adventofcode2020.day8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String debug = "";

        int instructionSet = 0;
        int accumulator = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\development\\adventofcode\\src\\adventofcode2020\\day8\\input.txt"));
            List<Instruction> instructionList = new ArrayList<>();
            List<Instruction> nopInstructions = new ArrayList<>();

            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                i++;
                instructionList.add(new Instruction(line,i));
            }

            Instruction instr = instructionList.get(0);

            //dry run, until it repeats.
            while (!instr.isExecuted()) {

                instr.setExecuted(true);
                if(instr.operation.equals("nop") || instr.operation.equals("jmp")) {
                    nopInstructions.add(instr);
                }
                instructionSet = instr.operandInstructionSet(instructionSet);
                accumulator = instr.setAccumulator(accumulator);
                instr = instructionList.get(instructionSet);
            }
            setUnExecutedAll(instructionList);

            i =0;
            int lastLine = 0;
            while(instructionSet < 641) {
                while(!instr.isExecuted()) {

                    if(instructionSet >= 641){
                        break;
                    }

                    instr.setExecuted(true);
                    instructionSet = instr.operandInstructionSet(instructionSet);
                    accumulator = instr.setAccumulator(accumulator);
                    instr = instructionList.get(instructionSet);
                    System.out.println(instr.operation + " " + instr.operand + instr.amount + " acc: " + accumulator + "set: " + instructionSet);
                   // Thread.sleep(200);
                }

                if(instructionSet > 641){
                    break;
                }

                setUnExecutedAll(instructionList);
                i++;

                if(i > 0 && i < nopInstructions.size()){
                    Instruction instruct = nopInstructions.get(i -1);
                    instructionList.get(instruct.lineInFile -1).setOperand("nop");
                    System.out.println("set to NOP on line ");
                }

                if(i < nopInstructions.size()) {
                    Instruction instruct = nopInstructions.get(i);
                    instructionList.get(instruct.lineInFile - 1).setOperand("jmp");
                    lastLine = instruct.lineInFile;
                    System.out.println("Change Line: " + instruct.lineInFile);
                }
            }

            System.out.println(lastLine);

        } catch (Exception e) {
            System.out.println("Debug:" + debug);
            e.printStackTrace();
        }
    }

    private static void setUnExecutedAll(List<Instruction> list) {
        for (Instruction instruction : list) {
            instruction.setExecuted(false);
            instruction.setAmountsExecuted(0);
        }
    }

}
