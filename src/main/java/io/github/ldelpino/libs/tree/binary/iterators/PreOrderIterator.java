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
package io.github.ldelpino.libs.tree.binary.iterators;

import io.github.ldelpino.libs.tree.binary.BinaryTree;
import io.github.ldelpino.libs.tree.binary.BinaryTreeIterator;

/**
 * La clase establece el iterador de arboles binarios en preorden.
 * <p>
 * El recorrido en preorden establece que primero debe recorrerse el nodo raiz,
 * despues el nodo izquierdo y por ultimo el nodo derecho. En el recorrido en
 * preorden debe devolverse primero la informacion del nodo en el que el
 * iterador se encuentra posicionado y establecerse al nodo izquierdo como nodo
 * siguiente, una vez la informacion sea devuelta, se accede al nodo izquierdo y
 * este se vuelve el puntero del iterador, devolviendo entonces su informacion y
 * despues la de su izquierdo si este lo posee, cuando el nodo no posea
 * izquierdo entonces el nodo siguiente sera el nodo derecho del puntero.</p>
 *
 * @author Lazaro Cesar del Pino Olivera
 * @since jdk 16.0.1
 * @version 1.0
 * @param <T> El tipo de dato de la informacion que almacena el nodo del arbol.
 */
public class PreOrderIterator<T> extends BinaryTreeIterator<T> {

    private PreOrderIterator<T> next;
    private boolean currentVisited;

    public PreOrderIterator(BinaryTree<T> current) {
        super(current);
        currentVisited = false;
        if (current.getLeftSonTree() != null) {
            next = new PreOrderIterator(current.getLeftSonTree());
        }
    }

    @Override
    public T next() {
        if (!hasNext()) {
            next = new PreOrderIterator(current.getRightSonTree());
        }
        T node;
        if (!currentVisited) {
            node = current.getRoot();
            currentVisited = true;
        } else {
            node = next.next();
        }
        return node;
    }

    @Override
    public boolean hasNext() {
        return !currentVisited || (next != null ? next.hasNext() : false);
    }
}
