package com.mycompany.examen3;

import java.util.Scanner;

public class EXAMEN3 {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    public int getNodeLevel(Node node, int data, int level) {
        if (node == null) {
            return -1; // Si el nodo es nulo, retornamos -1
        }
        if (node.data == data) {
            return level; 
        }

        int downLevel = getNodeLevel(node.left, data, level + 1);
        if (downLevel != -1) {
            return downLevel;
        }

        return getNodeLevel(node.right, data, level + 1);
    }

    
    public int getTreeHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getTreeHeight(node.left);
        int rightHeight = getTreeHeight(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getTreeWeight(Node node) {
        if (node == null) {
            return 0;
        }
        return getTreeWeight(node.left) + getTreeWeight(node.right) + 1;
    }

    public static void main(String[] args) {
        EXAMEN3 tree = new EXAMEN3();
        
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.right.right.left = new Node(10);
        tree.root.right.right.right = new Node(11);

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=== Menu del Arbol Binario ===");
            System.out.println("1. Calcular nivel de un nodo");
            System.out.println("2. Ver altura del arbol");
            System.out.println("3. Ver peso del arbol");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("Nodos disponibles: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11");
                    System.out.print("Introduce el numero del nodo para encontrar su nivel: ");
                    int nodeData = scanner.nextInt();
                    int level = tree.getNodeLevel(tree.root, nodeData, 1);
                    if (level == -1) {
                        System.out.println("El nodo " + nodeData + " no se encuentra en el arbol.");
                    } else {
                        System.out.println("Nivel del nodo " + nodeData + ": " + level);
                    }
                }
                case 2 -> {
                    int height = tree.getTreeHeight(tree.root);
                    System.out.println("Altura del arbol (numero maximo de niveles): " + height);
                }
                case 3 -> {
                    int weight = tree.getTreeWeight(tree.root);
                    System.out.println("Peso del arbol (numero de nodos): " + weight);
                }
                case 4 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción invalida. Intenta de nuevo.");
            }
        } while (option != 4);
    }
}
   
