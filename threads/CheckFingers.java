package threads;

import java.math.BigInteger;

import source.ChordNode;
import source.Finger;

public class CheckFingers implements Runnable {
    private ChordNode chordNode;

    public CheckFingers(ChordNode chordNode) {
        this.chordNode = chordNode;
    }

    @Override
    public void run() {
        System.out.println("CheckFingers");

        if (ChordNode.debug)
            System.out.println("------");
        for (int i = 0; i < ChordNode.FINGERS_SIZE; i++) {

            Finger toGet = new Finger(chordNode.getKey().getID().longValue(), i);
            Finger successorFinger = chordNode.findSuccessor(toGet);
            chordNode.setFingerTableIndex(i, successorFinger);
        }
        if (ChordNode.debug)
            System.out.println("------");
    }
}
