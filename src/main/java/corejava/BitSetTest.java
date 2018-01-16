package corejava;

import lombok.extern.slf4j.Slf4j;
import utils.JsonUtils;

import java.util.BitSet;
@Slf4j
public class BitSetTest {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();

        bitSet.set(0,true);
        bitSet.set(1,true);
        bitSet.set(2,false);
        bitSet.set(3,true);
        bitSet.set(4,true);

        log.info( JsonUtils.toString(bitSet.size()));

    }
}
