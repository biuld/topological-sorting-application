package com.wemeet;

import com.wemeet.core.Edge;
import com.wemeet.core.Topo;
import org.junit.Test;

/**
 * Created by biuld on 2019/8/29.
 */
public class TopoTest {

    @Test
    public void test() {

        Topo topo = new Topo();

        topo.addEdge(new Edge("程设", "JAVA"));
        topo.addEdge(new Edge("JAVA", "计组"));
        topo.addEdge(new Edge("JAVA", "数据结构"));
        topo.addEdge(new Edge("计组", "计算机网络"));
        topo.addEdge(new Edge("计算机网络", "操作系统"));

        topo.sort().forEach(System.out::println);
    }
}
