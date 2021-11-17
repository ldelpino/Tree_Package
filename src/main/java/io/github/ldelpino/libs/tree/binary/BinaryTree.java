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

import io.github.ldelpino.libs.tree.AbstractTree;
import io.github.ldelpino.libs.tree.Tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Establece el concepto de un arol binario.
 * <p>
 * Un arbol binario es una estructura de datos de conjuntos, donde los datos
 * estan ordenados jerarquicamente, donde cada nodo puede tener como maximo dos
 * hijos, uno izquierdo y uno derecho.</p>
 *
 * @author EL ROJO
 * @param <T> el tipo de dato que almacena cada nodo.
 */
public class BinaryTree<T> extends AbstractTree<T> {

    protected BinaryTree<T> rightSon;

    public BinaryTree(T root, BinaryTree<T> father) {
        super(root, father);
    }

    public BinaryTree(T root) {
        super(root);
    }

    @Override
    public final boolean isGeneralTree() {
        return false;
    }

    public void setLeftSon(BinaryTree<T> leftSon) {
        this.leftSon = leftSon;
    }

    @Override
    public BinaryTree<T> getLeftSonTree() {
        return (BinaryTree<T>) super.getLeftSonTree();
    }

    public void setRightSon(BinaryTree<T> rightSon) {
        this.rightSon = rightSon;
    }

    public BinaryTree<T> getRightSonTree() {
        return rightSon;
    }

    @Override
    public BinaryTree<T> getTreeFather() {
        return (BinaryTree<T>) super.getTreeFather();
    }

    public void setTreeFather(BinaryTree<T> father) {
        this.father = father;
    }

    @Override
    public int getSonsCount() {
        return hasLeftSon() ? 1 + (hasRightSon() ? 1 : 0) : 0;
    }

    public boolean hasRightSon() {
        return rightSon != null;
    }

    public T getRightSon() {
        return hasRightSon() ? getRightSonTree().getRoot() : null;
    }

    @Override
    public Collection<Tree<T>> getTreeSons() {
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
        if (hasLeftSon() && leftSon.getRoot().equals(node)) {
            return (BinaryTree<T>) leftSon;
        }
        if (hasRightSon() && rightSon.getRoot().equals(node)) {
            return rightSon;
        }
        return null;
    }

    public PreOrderIterator<T> preOrderIterator() {
        return new PreOrderIterator<>(this);
    }

    public EntreOrderIterator<T> entreOrderIterator() {
        return new EntreOrderIterator<>(getLeftSonTree());
    }

    public PosOrderIterator<T> posOrderIterator() {
        return new PosOrderIterator<>(getLeftSonTree());
    }

    @Override
    public BinaryTreeIterator<T> iterator() {
        return preOrderIterator();
    }

    @Override
    public Collection<T> getLeaves() {
        ArrayList<T> leaves = new ArrayList<>();
        if (hasLeftSon()) {
            leaves.addAll(leftSon.getLeaves());
        }
        if (hasRightSon()) {
            leaves.addAll(rightSon.getLeaves());
        }
        return leaves;
    }

    @Override
    public boolean isNodeALeaf(T node) {
        boolean leaf = getRoot().equals(node) && !hasLeftSon() && !hasRightSon();
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
}
