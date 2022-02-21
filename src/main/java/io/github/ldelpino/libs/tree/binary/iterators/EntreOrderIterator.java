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
 * La clase establece el iterador de arboles binarios en entreorden.
 *
 * @author Lazaro Cesar del Pino Olivera
 * @since jdk 16.0.1
 * @version 1.0
 * @param <T> El tipo de dato de la informacion que almacena el nodo del arbol.
 */
public class EntreOrderIterator<T> extends BinaryTreeIterator<T> {

    private EntreOrderIterator<T> next;
    private boolean currentVisited;

    public EntreOrderIterator(BinaryTree<T> current) {
        super(current);
        if (current.hasLeftSon()) {
            next = new EntreOrderIterator<>(current.getLeftSonTree());
        }
    }

    @Override
    public T next() {
        T node = null;
        if (!hasNext()) {
            next = new EntreOrderIterator<>(current.getRightSonTree());
        }
        if (next.hasNext()) {
            node = next.next();
        } else {
            if (!currentVisited) {
                node = current.getRoot();
            } else {
                if (next.hasNext()) {
                    node = next.next();
                }
            }
        }
        return node;
    }

    @Override
    public boolean hasNext() {
        return (next != null ? next.hasNext() : null) && !currentVisited;
    }
}
