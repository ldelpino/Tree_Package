/*
 * Copyright 2021 EL ROJO.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.ldelpino.libs.tree.binary;

import io.github.ldelpino.libs.tree.binary.iterators.PosOrderIterator;
import io.github.ldelpino.libs.tree.binary.iterators.EntreOrderIterator;
import io.github.ldelpino.libs.tree.binary.iterators.PreOrderIterator;
import io.github.ldelpino.libs.tree.AbstractTree;
import io.github.ldelpino.libs.tree.Tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * Establece el concepto de un arbol binario.
 * <p>
 * Un arbol binario binario es un arbol donde cada nodo puede tener como maximo
 * 2 nodos hijos. Los arboles binarios mantienen las mismas propiedades de los
 * arboles como estructura de datos generica con la unica diferencia que cada
 * nodo solo puede tener dos hijos (nodo izquierdo y nodo derecho).</p>
 * <p>
 * </p>
 *
 * @author Lazaro Cesar del Pino Olivera
 * @since jdk 16.0.1
 * @version 1.0
 * @param <T> El tipo de dato de la informacion que almacena el nodo del arbol.
 */
public class BinaryTree<T> extends AbstractTree<T> {

    /**
     * El nodo o hijo derecho del arbol.
     */
    protected BinaryTree<T> rightSon;

    /**
     * El arbol o nodo izquierdo de este arbol o null sino tiene.
     */
    protected BinaryTree<T> leftSon;

    /**
     * Construye un nuevo arbol a partir del nodo raiz y su padre.
     * <p>
     * El constructor se utiliza principalmente para la creacion de
     * subarboles.</p>
     *
     * @param root la informacion que almacena el nodo raiz del arbol.
     * @param father el arbol que hace funcion de padre de este arbol.
     */
    public BinaryTree(T root, BinaryTree<T> father) {
        super(root, father);
    }

    /**
     * Cronstuye un nuevo arbol a partir del nodo raiz.
     * <p>
     * El constructor se utiliza principalmente para la creacion de la jerarquia
     * maxima de un arbol.</p>
     *
     * @param root la informacion que almacena el nodo raiz del arbol.
     */
    public BinaryTree(T root) {
        super(root);
    }

    /**
     * Establece si el arbol es un arbol general o no.
     * <p>
     * Un arbol general es una estructura de datos donde cada nodo puede tener
     * mas de dos hijos a diferencia de los arboles binarios donde el nodo solo
     * puede tener como maximo dos hijos, un hijo izquierdo y un hijo
     * derecho.</p>
     * <p>
     * El metodo es <strong>final</strong> para evitar inconsistencias o
     * redundancias entre los diferentes tipos de arboles y siempre devolvera
     * <strong>false</strong>.</p>
     *
     * @return false.
     */
    @Override
    public final boolean isGeneralTree() {
        return false;
    }

    @Override
    public BinaryTree<T> getTreeFather() {
        return (BinaryTree<T>) super.getTreeFather();
    }

    /**
     * Establece el nodo o arbol padre de este arbol.
     *
     * @param father el nodo padre de este arbol.
     */
    public void setTreeFather(BinaryTree<T> father) {
        this.father = father;
    }

    /**
     * Devuelve el subarbol correspondiente al hijo izquierdo, si este existe.
     *
     * @return devuelve el arbol correspondiente al hijo izquierdo si este
     * existe, de lo contrario devuelve <strong>null</strong>.
     */
    public BinaryTree<T> getLeftSonTree() {
        return leftSon;
    }

    /**
     * Establece el nodo o hijo izquierdo de este arbol.
     *
     * @param leftSon el nodo izquierdo del arbol.
     */
    public void setLeftSonTree(BinaryTree<T> leftSon) {
        this.leftSon = leftSon;
    }

    /**
     * Establece si este arbol tiene hijo izquierdo o no.
     *
     * @return <strong>true</strong> si este arbol tiene hijo izquierdo, de lo
     * contrario devuelve <strong>false</strong>.
     */
    public boolean hasLeftSon() {
        return leftSon != null;
    }

    /**
     * Devuelve el hijo izquierdo, si este existe.
     *
     * @return devuelve el hijo izquierdo si este existe, de lo contrario
     * devuelve <strong>null</strong>.
     */
    public T getLeftSon() {
        return hasSons() ? leftSon.getRoot() : null;
    }

    /**
     * Establece el nodo o hijo derecho de este arbol.
     *
     * @param rightSon el nodo derecho del arbol.
     */
    public void setRightSonTree(BinaryTree<T> rightSon) {
        this.rightSon = rightSon;
    }

    /**
     * Devuelve el subarbol correspondiente al hijo derecho, si este existe.
     *
     * @return devuelve el arbol correspondiente al hijo derecho si este existe,
     * de lo contrario devuelve <strong>null</strong>.
     */
    public BinaryTree<T> getRightSonTree() {
        return rightSon;
    }

    /**
     * Establece si este arbol tiene hijo derecho o no.
     *
     * @return <strong>true</strong> si este arbol tiene hijo derecho, de lo
     * contrario devuelve <strong>false</strong>.
     */
    public boolean hasRightSon() {
        return rightSon != null;
    }

    /**
     * Devuelve el hijo derecho, si este existe.
     *
     * @return devuelve el hijo derecho si este existe, de lo contrario devuelve
     * <strong>null</strong>.
     */
    public T getRightSon() {
        return hasRightSon() ? getRightSonTree().getRoot() : null;
    }

    @Override
    public boolean hasSons() {
        return !hasLeftSon() && !hasRightSon();
    }

    @Override
    public int getNodeCount() {
        int nodeCount = hasLeftSon() ? getLeftSonTree().getNodeCount() : 0;
        nodeCount += hasRightSon() ? getRightSonTree().getNodeCount() : 0;
        return nodeCount + 1;
    }

    @Override
    public int getSonsCount() {
        int count = hasLeftSon() ? 1 : 0;
        count += hasRightSon() ? 1 : 0;
        return count;
    }

    @Override
    public Collection<Tree<T>> getCollectionTreeSons() {
        ArrayList<Tree<T>> sons = new ArrayList<>(getSonsCount());
        if (hasLeftSon()) {
            sons.add(leftSon);
        }
        if (hasRightSon()) {
            sons.add(rightSon);
        }
        return sons;
    }

    @Override
    public BinaryTree<T> getSonTree(T node) {
        if (getRoot().equals(node)) {
            return this;
        }
        if (hasLeftSon() && leftSon.getRoot().equals(node)) {
            return getLeftSonTree();
        }
        if (hasRightSon() && rightSon.getRoot().equals(node)) {
            return getRightSonTree();
        }
        BinaryTree<T> sonTree = hasLeftSon() ? getLeftSonTree().getSonTree(node) : null;
        if (sonTree == null) {
            sonTree = hasRightSon() ? getRightSonTree().getSonTree(node) : null;
        }
        return sonTree;
    }

    public PreOrderIterator<T> preOrderIterator() {
        return new PreOrderIterator<>(this);
    }

    public EntreOrderIterator<T> entreOrderIterator() {
        return new EntreOrderIterator<>(this);
    }

    public PosOrderIterator<T> posOrderIterator() {
        return new PosOrderIterator<>(this);
    }

    @Override
    public BinaryTreeIterator<T> iterator() {
        return preOrderIterator();
    }

    @Override
    public Collection<T> getLeaves() {
        ArrayList<T> leaves = new ArrayList<>();
        if (!hasSons()) {
            leaves.add(getRoot());
        } else if (hasLeftSon()) {
            leaves.addAll(leftSon.getLeaves());
        } else {
            leaves.addAll(rightSon.getLeaves());
        }
        return leaves;
    }

    @Override
    public boolean isNodeALeaf() {
        return !hasSons();
    }

    @Override
    public boolean isNodeALeaf(T node) {
        boolean leaf = getRoot().equals(node) && isNodeALeaf();
        if (!leaf && hasLeftSon()) {
            leaf = getLeftSonTree().isNodeALeaf(node);
        }
        if (!leaf && hasRightSon()) {
            leaf = getRightSonTree().isNodeALeaf(node);
        }
        return leaf;
    }

    @Override
    public boolean contains(Object o) {
        return root.equals(o) ? true : hasLeftSon() ? leftSon.contains(o)
                : hasRightSon() ? rightSon.contains(o) : false;
    }

    @Override
    public Object[] toArray() {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(root);
        if (hasLeftSon()) {
            objects.addAll(Arrays.asList(leftSon.toArray()));
        }
        if (hasRightSon()) {
            objects.addAll(Arrays.asList(rightSon.toArray()));
        }
        return objects.toArray();
    }

    @Override
    public boolean add(T e) {
        boolean added = false;
        if (!added && !hasLeftSon()) {
            leftSon = new BinaryTree<>(e, this);
            added = true;
        }
        if (!added && !hasRightSon()) {
            rightSon = new BinaryTree<>(e, this);
            added = true;
        }
        if (!added) {
            added = leftSon.add(e);
        }
        //nunca tiene una razon para a;adirlo aki
        if (!added) {
            added = rightSon.add(e);
        }
        return added;
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = false;
        if (hasLeftSon() && getLeftSon().equals(o)) {
            leftSon = null;
            removed = true;
        }
        if (!removed && hasRightSon() && getRightSon().equals(o)) {
            rightSon = null;
            removed = true;
        }
        if (!removed) {
            removed = hasLeftSon() ? leftSon.remove(o) : false;
        }
        if (!removed) {
            removed = hasRightSon() ? rightSon.remove(o) : false;
        }
        return removed;
    }

    @Override
    public void clear() {
        leftSon = null;
        rightSon = null;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BinaryTree b) {
            return b.getRoot().equals(this.getRoot()) && b.getLeftSonTree().equals(this.getLeftSonTree())
                    && b.getRightSonTree().equals(this.getRightSonTree());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.rightSon);
        hash = 97 * hash + Objects.hashCode(this.leftSon);
        return hash;
    }

    @Override
    public String toString() {
        return "BinaryTree";
    }
}
