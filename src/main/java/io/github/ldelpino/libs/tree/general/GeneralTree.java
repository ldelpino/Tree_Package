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
package io.github.ldelpino.libs.tree.general;

import io.github.ldelpino.libs.tree.AbstractTree;
import io.github.ldelpino.libs.tree.Tree;
import io.github.ldelpino.libs.tree.TreeIterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author EL ROJO
 * @param <T>
 */
public class GeneralTree<T> extends AbstractTree<T> {

    private final LinkedList<GeneralTree<T>> rightSons;

    public GeneralTree(T root, GeneralTree<T> father) {
        super(root, father);
        rightSons = new LinkedList<>();
    }

    public GeneralTree(T root) {
        this(root, null);
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
     * <strong>true</strong>.</p>
     *
     * @return true.
     */
    @Override
    public final boolean isGeneralTree() {
        return true;
    }

    public boolean hasRightSons() {
        return !rightSons.isEmpty();
    }

    public LinkedList<GeneralTree<T>> getRightSons() {
        return rightSons;
    }

    @Override
    public int getSonsCount() {
        return rightSons.size() + (hasLeftSon() ? 1 : 0);
    }

    @Override
    public Collection<Tree<T>> getCollectionTreeSons() {
        LinkedList<Tree<T>> copy = new LinkedList<>();
        if (hasLeftSon()) {
            copy.add(getLeftSonTree());
        }
        if (hasRightSons()) {
            getRightSons().forEach((GeneralTree<T> t) -> {
                copy.add(t);
            });
        }
        return copy;
    }

    @Override
    public Tree<T> getSonTree(T node) {
        if (hasLeftSon() && getLeftSon().equals(node)) {
            return getLeftSonTree();
        }
        if (hasRightSons()) {
            for (GeneralTree<T> tree : getRightSons()) {
                if (tree.getRoot().equals(node)) {
                    return tree;
                }
            }
        }
        Tree<T> sonTree = hasLeftSon() ? getLeftSonTree().getSonTree(node) : null;
        while(sonTree == null) {
            sonTree = 
        }
        return null;
    }

    @Override
    public Collection<T> getLeaves() {
        LinkedList<T> leaves = new LinkedList<>();
        if (!hasLeftSon() && !hasRightSons()) {
            leaves.add(getRoot());
        } else if (hasLeftSon()) {
            leaves.addAll(getLeftSonTree().getLeaves());
        } else {
            getRightSons().forEach(tree -> {
                leaves.addAll(tree.getLeaves());
            });
        }
        return leaves;
    }

    @Override
    public boolean isNodeALeaf(T node) {
        boolean isLeaf = false;
        if (getRoot().equals(node)) {
            return !hasLeftSon() && !hasRightSons();
        } else {
            if (hasLeftSon()) {
                isLeaf = getLeftSonTree().isNodeALeaf(node);
            }
            if (!isLeaf && hasRightSons()) {
                Iterator<GeneralTree<T>> iter = getRightSons().iterator();
                while (!isLeaf && iter.hasNext()) {
                    GeneralTree<T> next = iter.next();
                    isLeaf = next.isNodeALeaf(node);
                }
            }
        }
        return isLeaf;
    }

    @Override
    public TreeIterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
