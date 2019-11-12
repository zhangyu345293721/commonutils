package com.tool.algo.arrangementselect;

import org.junit.jupiter.api.Test;

/**
 * 劝阻IP
 *
 * @author: zhangyu
 */
public class DefangingIP1108 {

    @Test
    public void defangingIpTestDemo() {
        String address = "255.100.50.0";
        String s = defangIPaddr2(address);
        System.out.println("s = " + s);
    }

    /**
     * 对于.位置改为[.]
     *
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[\\.]");
    }

    /**
     * 对于.位置改为[.]
     *
     * @param address
     * @return
     */
    public String defangIPaddr2(String address) {
        StringBuffer sb = new StringBuffer();
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                sb.append("[.]");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
