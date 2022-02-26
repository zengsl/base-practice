package com.practice.datastruct.skiplist2;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/2/14 4:08 PM
 */
public class SkiplistTest {

    //["Skiplist","add","add","add","add","add",
    // "erase","erase",
    // "add","search","search","add","erase","search","add","add","add","erase","search","erase","search","search","search","erase","erase","search","erase","add","add","erase","add","search","search","search","search","search"]
    //[[],[9],[4],[5],[6],[9],
    // [2],
    // [1],[2],
    // [7],[4],[5],[6],[5],[6],[7],[4],[3],[6],[3],[4],[3],[8],[7],[6],[7],[4],[1],[6],[3],[4],[7],[6],[1],[0],[3]]
    public static void main(String[] args) {
        Skiplist sl = new Skiplist();
        sl.add(9);
        sl.add(4);
        sl.add(5);
        sl.add(6);
        sl.add(9);

        sl.erase(2);
        sl.erase(1);

        sl.add(2);

        sl.search(1);
        sl.search(2);
    }
}
