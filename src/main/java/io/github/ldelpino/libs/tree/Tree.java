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

import io.github.ldelpino.libs.tree.iterators.TreeIterator;
import io.github.ldelpino.libs.tree.iterators.TreeIterator.IteratorType;
import java.util.Collection;

/**
 * Establece el concepto logico de un arbol.
 * <p>
 * Un arbol es una estructura de datos donde, los elementos estan ordenados
 * jerarquicamente.</p>
 *
 * @author EL ROJO
 * @param <T> el tipo de dato de los nodos del arbol.
 */
public interface Tree<T> extends Collection<T> {

    /**
     * Devuelve la raiz del arbol.
     * <p>
     * La raiz de este arbol es el nodo almacenado en el propio arbol.</p>
     *
     * @return la raiz de este arbol.
     */
    public T getRoot();

    /**
     * Establece si el arbol es un arbol general o no.
     * <p>
     * Un arbol general es una estructura de datos donde cada nodo puede tener
     * mas de dos hijos adiferencia de los aboles binarios donde el nodo solo
     * puede tener como maximo dos hijos, un hijo izquierdo y un hijo
     * derecho.</p>
     *
     * @return <strong>true</strong> si el arbol es un arbol general, de lo
     * contrario es un arbol binario y devuelve <strong>false</strong>.
     */
    public boolean isGeneralTree();

    /**
     * Devuelve el nivel del arbol.
     * <p>
     * El nivel del arbol es el nivel del nodo almacenado con respecto a su
     * padre, si este existe.</p>
     *
     * @return el nivel del nodo del arbol.
     */
    public int getTreeLevel();

    /**
     * Devuelve la altura del arbol.
     * <p>
     * La altura de un arbol es la profundidad del arbol. La altura de un arbol
     * es equivalente al nivel del ultimo nodo del arbol.</p>
     *
     * @return la altura del arbol.
     */
    public int getTreeHeight();

    /**
     * Devuelve el iterador por defecto del arbol.
     * <p>
     * Por defecto el arbol general devuelve un iterador en profundidad.</p>
     *
     * @return el iterador del arbol.
     */
    @Override
    public TreeIterator<T> iterator();

    /**
     * Devuelve el iterador deseado del arbol.
     *
     * @param iteratorType el identificador del iterador a obtener.
     * @return el iterador del arbol.
     */
    public TreeIterator<T> iterator(IteratorType iteratorType);
}
