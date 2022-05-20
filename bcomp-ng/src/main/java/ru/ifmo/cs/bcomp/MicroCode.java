/*
 * $Id$
 */

package ru.ifmo.cs.bcomp;

import java.util.ArrayList;

/**
 * @author Dmitry Afanasiev <KOT@MATPOCKuH.Ru>
 */
public class MicroCode {
    private class mc {
        public final String label;
        private final long microcmd;

        public mc(String label, long microcmd) {
            this.label = label;
            this.microcmd = microcmd;
        }

        public long getMicroCommand() throws Exception {
            if (label != null)
                for (MicroCode.mc mc : MP)
                    if (this != mc)
                        if (label.equals(mc.label))
                            throw new Exception("Found duplicate label '" + label + "'");

            return microcmd;
        }
    }

    private mc[] MP;

    MicroCode() {
        try {
            MP = createMP(MicroCodeReader.readMicroCodeFromFile("mp.txt"));
        } catch (Throwable e) {
            System.out.println("Файл mp.txt не найден или произошла ошибка чтения, " +
                    "загружен стандартный интерпретатор БЭВМ.");
            MP = createMP(MicroCodeReader.readMicroCodeFromString(
                            "4000000000 \n" +
                            "00A0009004 INFETCH\n" +
                            "0104009420 \n" +
                            "0002009001 \n" +
                            "8109804002 \n" +
                            "810C404002 \n" +
                            "810C204002 \n" +
                            "8078104002 \n" +
                            "80C2101040 \n" +
                            "800C404002 CHKBR\n" +
                            "800C204002 \n" +
                            "8157104002 \n" +
                            "8024084002 CHKABS\n" +
                            "0020011002 ADFETCH\n" +
                            "811C044002 \n" +
                            "0080009024 T10XX\n" +
                            "0100000000 \n" +
                            "8114024002 \n" +
                            "81E0014002 T100X\n" +
                            "8024101040 T1000\n" +
                            "8119014002 T101X\n" +
                            "0001009401 T1010\n" +
                            "0200000000 \n" +
                            "0001009201 \n" +
                            "8024101040 \n" +
                            "0001009201 T1011\n" +
                            "0200000000 \n" +
                            "8024101040 \n" +
                            "8120024002 T11XX\n" +
                            "81E0014002 T110X\n" +
                            "0001009028 T1100\n" +
                            "8024101040 \n" +
                            "8023014002 T111X\n" +
                            "0001009020 T1111\n" +
                            "8028101040 \n" +
                            "0001009024 T1110\n" +
                            "8026804002 OPFETCH\n" +
                            "814A404002 \n" +
                            "0080009001 RDVALUE\n" +
                            "0100000000 \n" +
                            "813C804002 EXEC\n" +
                            "8130404002 CMD0XXX\n" +
                            "812D104002 CMD000X\n" +
                            "0010C09811 AND\n" +
                            "80C4101040 \n" +
                            "0020009B11 OR\n" +
                            "0010C09220 \n" +
                            "80C4101040 \n" +
                            "8137204002 CMD01XX\n" +
                            "8134104002 CMD010X\n" +
                            "0010E09011 ADD\n" +
                            "80C4101040 \n" +
                            "8032011040 ADC\n" +
                            "0010E09411 \n" +
                            "80C4101040 \n" +
                            "813A104002 CMD011X\n" +
                            "0010E09511 SUB\n" +
                            "80C4101040 \n" +
                            "0000E09511 CMP\n" +
                            "80C4101040 \n" +
                            "8143204002 CMD1XXX\n" +
                            "81E0104002 CMD100X\n" +
                            "0001009201 LOOP\n" +
                            "0220009201 \n" +
                            "80C4804020 \n" +
                            "0004009404 \n" +
                            "80C4101040 \n" +
                            "8146104002 CMD101X\n" +
                            "0010C09001 LD\n" +
                            "80C4101040 \n" +
                            "0020009001 SWAM\n" +
                            "0001009010 \n" +
                            "0210C09020 \n" +
                            "80C4101040 \n" +
                            "8153204002 CMD11XX\n" +
                            "814E104002 CMD110X\n" +
                            "0004009001 JUMP\n" +
                            "80C4101040 \n" +
                            "0020009001 CALL\n" +
                            "0001009004 \n" +
                            "0004009020 \n" +
                            "0088009208 PUSHVAL\n" +
                            "8055101040 \n" +
                            "0080009001 ST\n" +
                            "0001009010 \n" +
                            "0200000000 STORE\n" +
                            "80C4101040 \n" +
                            "8171084002 BRANCHES\n" +
                            "8166044002 BR0XXX\n" +
                            "8161024002 BR00XX\n" +
                            "815F014002 BR000X\n" +
                            "80C4041040 BEQ\n" +
                            "0020011002 BR\n" +
                            "0004009024 \n" +
                            "80C4101040 \n" +
                            "805C041040 BNE\n" +
                            "80C4101040 \n" +
                            "8164014002 BR001X\n" +
                            "815C081040 BMI\n" +
                            "80C4101040 \n" +
                            "805C081040 BPL\n" +
                            "80C4101040 \n" +
                            "816C024002 BR01XX\n" +
                            "816A014002 BR010X\n" +
                            "815C011040 BCS\n" +
                            "80C4101040 \n" +
                            "805C011040 BCC\n" +
                            "80C4101040 \n" +
                            "816F014002 BR011X\n" +
                            "815C021040 BVS\n" +
                            "80C4101040 \n" +
                            "805C021040 BVC\n" +
                            "80C4101040 \n" +
                            "81E0044002 BR1XXX\n" +
                            "81E0024002 BR10XX\n" +
                            "8176014002 BR100X\n" +
                            "806D081040 BLT\n" +
                            "806F101040 \n" +
                            "806F081040 BGE\n" +
                            "806D101040 \n" +
                            "81A4084002 ADDRLESS\n" +
                            "8189044002 AL0XXX\n" +
                            "817D024002 AL00XX\n" +
                            "80C4014002 AL000X\n" +
                            "80DE101040 HLT\n" +
                            "8183014002 AL001X\n" +
                            "8181801002 AL0010\n" +
                            "0010C00000 CLA\n" +
                            "80C4101040 \n" +
                            "0010C09210 NOT\n" +
                            "80C4101040 \n" +
                            "8186801002 AL0011\n" +
                            "0000200000 CLC\n" +
                            "80C4101040 \n" +
                            "8184011040 CMC\n" +
                            "0000208300 \n" +
                            "80C4101040 \n" +
                            "8196024002 AL01XX\n" +
                            "8190014002 AL010X\n" +
                            "818E801002 AL0100\n" +
                            "0010E60010 ROL\n" +
                            "80C4101040 \n" +
                            "0010F80010 ROR\n" +
                            "80C4101040 \n" +
                            "8194801002 AL0101\n" +
                            "0001009010 ASL\n" +
                            "0010E09011 \n" +
                            "80C4101040 \n" +
                            "0010E80010 ASR\n" +
                            "80C4101040 \n" +
                            "819C014002 AL011X\n" +
                            "819A801002 AL0110\n" +
                            "0010C11010 SXTB\n" +
                            "80C4101040 \n" +
                            "0010C06010 SWAB\n" +
                            "80C4101040 \n" +
                            "81A2801002 AL0111\n" +
                            "81A0401002 AL01110\n" +
                            "0010E09410 INC\n" +
                            "80C4101040 \n" +
                            "0010E09110 DEC\n" +
                            "80C4101040 \n" +
                            "0010E09610 NEG\n" +
                            "80C4101040 \n" +
                            "81B5044002 AL1XXX\n" +
                            "0080009008 AL10XX\n" +
                            "0100000000 \n" +
                            "81AE024002 \n" +
                            "81AC014002 AL100X\n" +
                            "0010C09001 POP\n" +
                            "0008009408 INCSP\n" +
                            "80C4101040 \n" +
                            "0040009001 POPF\n" +
                            "80AA101040 \n" +
                            "81B1014002 AL101X\n" +
                            "0004009001 RET\n" +
                            "80AA101040 \n" +
                            "0040009001 IRET\n" +
                            "0088009408 \n" +
                            "0100000000 \n" +
                            "80AF101040 \n" +
                            "81BB024002 AL11XX\n" +
                            "81B9014002 AL110X\n" +
                            "0001009010 PUSH\n" +
                            "8051101040 \n" +
                            "0001009040 PUSHF\n" +
                            "8051101040 \n" +
                            "81E0014002 AL111X\n" +
                            "0080009008 SWAP\n" +
                            "0100000000 \n" +
                            "0020009001 \n" +
                            "0001009010 \n" +
                            "0210C09020 \n" +
                            "80C4101040 \n" +
                            "81C7084002 IO\n" +
                            "0400000000 DOIO\n" +
                            "80DE801040 INT\n" +
                            "8001401040 \n" +
                            "0800000000 \n" +
                            "0088009208 IRQ\n" +
                            "0001009004 \n" +
                            "0200000000 \n" +
                            "0088009208 \n" +
                            "0001009040 \n" +
                            "0220001002 \n" +
                            "00A0020020 \n" +
                            "0100000000 \n" +
                            "0004009001 \n" +
                            "0080001420 \n" +
                            "0100000000 \n" +
                            "0040009001 \n" +
                            "8001101040 \n" +
                            "00BBE00000 START\n" +
                            "80C3101040 \n" +
                            "0080009004 READ\n" +
                            "0104009404 \n" +
                            "80DE101040 \n" +
                            "0080009004 WRITE\n" +
                            "0001009080 \n" +
                            "0204009404 \n" +
                            "80DE101040 \n" +
                            "0004009080 SETIP\n" +
                            "4000000000 STOP\n" +
                            "8001101040 \n" +
                            "0000000000 RESERVED"
            ));
        }
    }

    private mc[] createMP(ArrayList<Pair<String, String>> mp) {
        ArrayList<mc> sMP = new ArrayList<>();
        long microcmd;
        for (Pair<String, String> microcode : mp) {
            microcmd = 0;
            for (int i = 0; i < 10; i++) {
                microcmd += Character.digit(microcode.getFirst().charAt(i), 16)*Math.pow(16, 9-i);
            }
            sMP.add(new mc(microcode.getSecond(), microcmd));
        }
        return sMP.toArray(new mc[0]);
    }

    public int getMicroCodeLength() {
        return MP.length;
    }

    public long getMicroCommand(int addr) throws Exception {
        return MP[addr].getMicroCommand();
    }

    public int findLabel(String label) throws Exception {
        for (int addr = 0; addr < MP.length; addr++)
            if (label.equals(MP[addr].label))
                return addr;

        throw new Exception("Label '" + label + "' not found");
    }

    public String getLabel(int addr) {
        return addr < MP.length ? MP[addr].label : null;
    }
}
