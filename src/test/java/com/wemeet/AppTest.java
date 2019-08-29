package com.wemeet;

import static org.junit.Assert.assertEquals;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.builder.GraphBuilder;
import org.jgrapht.graph.builder.GraphTypeBuilder;
import org.jgrapht.traverse.TopologicalOrderIterator;
import org.jgrapht.util.SupplierUtil;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void rigorousTest()
    {
        Graph<String, DefaultEdge> graph = GraphTypeBuilder
				.directed()
				.allowingMultipleEdges(true)
				.allowingSelfLoops(true)
				.vertexSupplier(SupplierUtil.createStringSupplier())
				.edgeSupplier(SupplierUtil.createDefaultEdgeSupplier())
				.buildGraph();
        
        String v0 = graph.addVertex();
        String v1 = graph.addVertex();
        String v2 = graph.addVertex();
        
        graph.addEdge(v0, v1);
        graph.addEdge(v0, v2);
        graph.addEdge(v1, v2);
        
        assertEquals(3, graph.vertexSet().size());
        assertEquals(3, graph.edgeSet().size());
        
        assertEquals(2, graph.outDegreeOf(v0));
        assertEquals(1, graph.outDegreeOf(v1));
        assertEquals(0, graph.outDegreeOf(v2));
    }

    @Test
    public void topologicalSortingTest() {
        //有向无环图
        Graph<String, DefaultEdge> directedAcyclicGraph = GraphTypeBuilder
                .directed()
                .allowingMultipleEdges(false)
                .allowingSelfLoops(false)
                .vertexClass(String.class) //点类型
                .edgeClass(DefaultEdge.class) //边类型
                .buildGraph();

        Graph<String, DefaultEdge> graph = new GraphBuilder<>(directedAcyclicGraph)
                .addEdgeChain("程序设计基础", "Java面向对象编程", "数据结构", "计算机网络")
                .addEdgeChain("程序设计基础", "Java面向对象编程", "计算机组成原理", "操作系统")
                .addEdgeChain("程序设计基础", "Java面向对象编程", "数据结构", "操作系统")
                .addEdgeChain("程序设计基础", "Java面向对象编程", "计算机组成原理", "计算机网络")
                .build();

        TopologicalOrderIterator<String, DefaultEdge> topologicalOrderIterator = new TopologicalOrderIterator<>(graph);

        StringBuilder builder = new StringBuilder();

        try {
            topologicalOrderIterator.forEachRemaining(elem -> builder.append(elem).append(" -> "));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        builder.append("END");
        System.out.println(builder.toString());

//        graph.edgeSet().forEach(System.out::println);
    }
}
