package com.wemeet.core;

import org.jgrapht.graph.DefaultEdge;

/**
 * Created by biuld on 2019/8/29.
 */

public class Edge extends DefaultEdge {
    private String source;
    private String target;

    public Edge(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public Edge() {
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public String getTarget() {
        return target;
    }

}
