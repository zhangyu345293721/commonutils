package com.tool.algo.list;

import com.tool.base.file.FileUtils;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: zhangyu
 */
public class FindName {
    @Test
    public void nameTestDemo() {
        List<String> nameList = FileUtils.getFileToList("d:\\mail.csv");
        List<String> savedList = FileUtils.getFileToList("d:\\save_email.csv");
        Set<String> set = new HashSet<>();
        for (String name : nameList) {
            if (!savedList.contains(name)) {
                set.add(name);
            }
        }
        for (String name : set) {
            System.out.println(name);
        }
    }
}
