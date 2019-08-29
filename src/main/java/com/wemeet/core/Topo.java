package com.wemeet.core;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.builder.GraphBuilder;
import org.jgrapht.graph.builder.GraphTypeBuilder;
import org.jgrapht.traverse.TopologicalOrderIterator;
import org.jgrapht.util.SupplierUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biuld on 2019/8/29.
 */

public class Topo {

    private Graph<String, DefaultEdge> directedAcyclicGraph = GraphTypeBuilder
            .directed()
            .allowingMultipleEdges(true)
            .allowingSelfLoops(true)
            .vertexSupplier(SupplierUtil.createStringSupplier())
            .edgeSupplier(SupplierUtil.createDefaultEdgeSupplier())
            .buildGraph();

    private GraphBuilder<String, DefaultEdge, Graph<String, DefaultEdge>> builder = new GraphBuilder<>(directedAcyclicGraph);

    /**
     * 添加边（自动创建不存在的点）
     *
     * @param edge
     */
    public void addEdge(Edge edge) {
        builder.addEdge(edge.getSource(), edge.getTarget());
    }

    /**
     * 拓扑排序
     *
     * @return 排序好的List
     */
    public List<String> sort() throws IllegalArgumentException {
        TopologicalOrderIterator<String, DefaultEdge> topologicalOrderIterator = new TopologicalOrderIterator<>(builder.build());

        List<String> result = new ArrayList<>();

        topologicalOrderIterator.forEachRemaining(result::add);

        return result;
    }
}
