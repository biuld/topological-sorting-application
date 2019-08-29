package com.wemeet.core;

/**
 * Created by biuld on 2019/8/29.
 */

public class Edge {
    private String source;
    private String target;

    public Edge(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
