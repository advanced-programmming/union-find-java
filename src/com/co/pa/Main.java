package com.co.pa;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{4, 6, 2, 1, 5, 3};
        int[] array1 = new int[]{3, 4, 1, 2};
	    UnionFind unionFind = new UnionFind(array1.length);

        for (int i = 0; i < array1.length; i++)
            unionFind.union(i + 1, array1[i]);

    }
}

class UnionFind{
    private int size;
    private int[] control;

    public UnionFind(int size) {
        this.size = size;
        this.control = new int[size + 1];

        for(int i = 0; i <= this.size; i++)
            this.control[i] = -1;
    }

    public int find(int value){
        if(this.control[value] <= -1) return value;
        return find(this.control[value]);
    }

    public Boolean union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);

        if(parent2 != parent1){
            if (node1 < node2){
               int numComponents = control[parent1];
               control[parent1] = numComponents - 1 ;
               control[node2] = node1;
            } else {
                int numComponents = control[parent2];
                control[parent2] = numComponents - 1;
                control[node1] = node2;
            }
        }
        return true;
    }


}
