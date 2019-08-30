package com.wemeet.core;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.builder.GraphBuilder;
import org.jgrapht.graph.builder.GraphTypeBuilder;
import org.jgrapht.traverse.TopologicalOrderIterator;
import org.jgrapht.util.SupplierUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by biuld on 2019/8/29.
 */

public class Topo {

    private Graph<String, Edge> simpleDirectedGraph = GraphTypeBuilder
            .directed()
            .allowingMultipleEdges(true)
            .allowingSelfLoops(true)
            .vertexSupplier(SupplierUtil.createStringSupplier())
            .edgeSupplier(SupplierUtil.createSupplier(Edge.class))
            .buildGraph();

    private GraphBuilder<String, Edge, Graph<String, Edge>> builder = new GraphBuilder<>(simpleDirectedGraph);

    private Random random = new Random();

    //添加边（自动创建不存在的点）
    public void addEdge(Edge edge) {
        builder.addEdge(edge.getSource(), edge.getTarget());
    }

    /**
     * @param style 实现全序的风格
     * @return 排序好的List
     * @throws IllegalArgumentException 当建立的图不是DAG时抛出
     */
    public List<String> sort(int style) throws IllegalArgumentException {
        TopologicalOrderIterator<String, Edge> topoIterator;

        switch (style) {
            case 0:
                topoIterator = new TopologicalOrderIterator<>(builder.build(), Comparator.naturalOrder()); //正序
                break;
            case 1:
                topoIterator = new TopologicalOrderIterator<>(builder.build(), Comparator.reverseOrder()); //逆序
                break;
            default:
                topoIterator = new TopologicalOrderIterator<>(builder.build(), Comparator.comparing(str -> random.nextInt())); //随机
                break;
        }

        List<String> result = new ArrayList<>();

        topoIterator.forEachRemaining(result::add);

        return result;
    }

    //获取点集
    public Set<String> getVertexSet() {
        return builder.build().vertexSet();
    }

    //获取边集
    public Set<Map<String, String>> getEdgeSet() {
        return builder.build().edgeSet().stream()
                .map(edge -> Map.of(edge.getSource(), edge.getTarget()))
                .collect(Collectors.toSet());
    }
}
