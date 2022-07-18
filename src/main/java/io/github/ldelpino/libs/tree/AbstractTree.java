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
import java.util.ArrayList;
import java.util.Collection;

/**
 * Permite establecer las bases para la creacion de los distintos tipos de
 * arboles.
 * <p>
 * De cualquier arbol se conoce su nodo raiz, el arbol que hace funcion de
 * padre, si este existe y como minimo el hijo izquierdo ya sea tanto para los
 * arboles binarios como generales.</p>
 * <p>
 * La clase implementa algunos de los metodos pertenecientes a la superclase
 * {@link java.util.Collection}, asi como algunos metodos donde su comportamento
 * siempre es el mismo o dependen de otras funcionalidades ya definidas.</p>
 *
 * @author Lazaro Cesar del Pino Olivera
 * @since jdk 16.0.1
 * @version 1.0
 * @param <T> El tipo de dato de la informacion que almacena el nodo del arbol.
 */
public abstract class AbstractTree<T> extends AbstractCollection<T> implements Tree<T> {

    /**
     * El nodo que hace funcion de raiz en este arbol.
     */
    protected T root;

    /**
     * El arbol o nodo padre que tiene como hijo a este o null si este nodo es
     * la raiz.
     */
    protected Tree<T> father;

    /**
     * El arbol o nodo izquierdo de este arbol o null sino tiene.
     */
    protected Tree<T> leftSon;

    /**
     * Construye un nuevo arbol a partir del nodo raiz y su padre.
     * <p>
     * El constructor se utiliza principalmente para la creacion de
     * subarboles.</p>
     *
     * @param root la informacion que almacena el nodo raiz del arbol.
     * @param father el arbol que hace funcion de padre de este arbol.
     */
    public AbstractTree(T root, AbstractTree<T> father) {
        this.root = root;
        this.father = father;
    }

    /**
     * Crea un nuevo arbol a partir de este nodo.
     * <p>
     * El constructor se utiliza principalmente para la creacion de la jerarquia
     * maxima de un arbol.</p>
     *
     * @param root la informacion de este nodo.
     */
    public AbstractTree(T root) {
        this(root, null);
    }

    @Override
    public int size() {
        return getNodeCount();
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
    public Collection<T> getSons() {
        ArrayList<T> sons = new ArrayList<>(getSonsCount());
        getCollectionTreeSons().forEach(tree -> {
            sons.add(tree.getRoot());
        });
        return sons;
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
        Collection<Tree<T>> sons = getCollectionTreeSons();
        int mayor = 0;
        for (Tree<T> t : sons) {
            int height = t.getTreeHeight();
            if (height > mayor) {
                mayor = height;
            }
        }
        return hasSons() ? mayor++ : 1;
    }

    @Override
    public int getLevelNode() {
        return hasFather() ? father.getLevelNode() + 1 : 0;
    }

    @Override
    public boolean isNodeALeaf() {
        return !hasSons();
    }
}
