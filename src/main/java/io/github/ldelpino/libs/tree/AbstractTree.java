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
package io.github.ldelpino.libs.tree;

import java.util.AbstractCollection;

/**
 * Permite establecer las bases para la creacion de arboles binario o generales.
 *
 * @author EL ROJO
 * @param <T>
 */
public abstract class AbstractTree<T> extends AbstractCollection<T> implements Tree<T> {

    protected T root;
    protected Tree<T> father;
    protected Tree<T> leftSon;

    protected AbstractTree(T root, AbstractTree<T> father) {
        this.root = root;
        this.father = father;
    }

    protected AbstractTree(T root) {
        this(root, null);
    }

    @Override
    public int size() {
        return getSonsCount() + 1;
    }

    @Override
    public T getRoot() {
        return root;
    }

    @Override
    public void setRoot(T root) {
        this.root = root;
    }

    @Override
    public boolean hasFather() {
        return father != null;
    }

    @Override
    public T getFather() {
        return hasFather() ? father.getRoot() : null;
    }

    @Override
    public Tree<T> getTreeFather() {
        return father;
    }

    @Override
    public boolean hasSons() {
        return getSonsCount() > 0;
    }

    @Override
    public boolean hasLeftSon() {
        return leftSon != null;
    }

    @Override
    public T getLeftSon() {
        return hasSons() ? leftSon.getRoot() : null;
    }

    @Override
    public Tree<T> getLeftSonTree() {
        return leftSon;
    }

    @Override
    public int getTreeHeight() {
        return hasSons() ? leftSon.getTreeHeight() + 1 : 0;
    }

    @Override
    public int getLevelNode() {
        return hasFather() ? father.getLevelNode() + 1 : 0;
    }
}
