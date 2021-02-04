package learn.graphs;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo{


    /**
     *
     *           15
     *       9          23
     *   3      12   17    28
     *     8
     *
     * @param args
     */
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addVertex("15").addVertex("9").addVertex("23").addVertex("3").addVertex("12").addVertex("17").addVertex("28").addVertex("8");
        log.debug(g.toString());
        


    }
}