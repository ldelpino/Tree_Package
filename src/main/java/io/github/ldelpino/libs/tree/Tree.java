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

import java.util.Collection;

/**
 * Establece el concepto logico de un arbol.
 * <p>
 * Un arbol es una estructura de datos que almacena un conjunto de elementos
 * ordenados en forma jerarquica, donde el nodo raiz es el que contiene a sus
 * hijos y estos a sus hijos hasta que los nodos no tengan mas hijos.</p>
 * <p>
 * A los nodos que no tienen hijos se les llama nodos hojas y al nodo que
 * representa la jerarquia maxima de la estructura se le llama nodo raiz.</p>
 * <p>
 * Los arboles pueden ser binarios o generales, los arboles binarios son
 * aquellos donde los nodos no pueden tener mas de dos hijos,mientras que los
 * arboles generales no poseen limiten de cuantos hijos pueden tener.</p>
 * <p>
 * Por definicion los arboles son estructuras recursivas, dado que los nodos
 * hijos de un arbol tambien son arboles.</p>
 * <p>
 * Un arbol puede ser visto como un grafo conexo y aciclico, donde todos los
 * nodos estan conectados con algun otro nodo (conexo) y solo existe un camino
 * desde un nodo hacia otro (aciclico).</p>
 * <p>
 * Los arboles son conjuntos de elementos, por tanto son representados tambien a
 * traves de la clase {@link java.util.Collection}, como una coleccion de
 * elementos.</p>
 *
 * @author Lazaro Cesar del Pino Olivera
 * @since jdk 16.0.1
 * @version 1.0
 * @param <T> El tipo de dato de la informacion que almacena el nodo del arbol.
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
     * Establece el nuevo nodo que hara funcion de raiz.
     *
     * @param root el nuevo nodo establecido que hara funcion de raiz.
     */
    public void setRoot(T root);

    /**
     * Establece si este nodo tiene un nodo padre.
     * <p>
     * Un nodo tiene un nodo padre sino es la raiz del arbol.</p>
     *
     * @return devuelve <strong>true</strong> si este nodo tiene un nodo padre,
     * de lo contrario devuelve <strong>false</strong>.
     */
    public boolean hasFather();

    /**
     * Devuelve el nodo padre de este arbol.
     *
     * @return el nodo padre de este nodo, si este existe, de lo contrario
     * devuelve <strong>null</strong>.
     */
    public T getFather();

    /**
     * Devuelve el nodo padre como un arbol.
     *
     * @return devuelve un arbol donde el nodo padre de este nodo es el nodo
     * raiz, si este existe, de lo contrario devuelve <strong>null</strong>.
     */
    public Tree<T> getTreeFather();

    /**
     * Establece si este arbol tiene un hijo izquierdo.
     *
     * @return <strong>true</strong> si el arbol posee un hijo izquierdo, de lo
     * contrario devuelve <strong>false</strong>.
     */
    public boolean hasLeftSon();

    /**
     * Establece si este arbol tiene hijos.
     *
     * @return <strong>true</strong> si el arbol posee hijos, de lo contrario
     * devuelve <strong>false</strong>.
     */
    public boolean hasSons();

    /**
     * Devuelve la cantidad de hijos que posee el arbol.
     *
     * @return devuelve <strong>0</strong> si el arbol no posee hijos, o un
     * numero positivo mayor o igual que <strong>1</strong> que establece la
     * cantidad de hijos que posee este arbol.
     */
    public int getSonsCount();

    /**
     * Devuelve la cantidad de nodos que posee el arbol.
     *
     * @return devuelve <strong>1</strong> si el arbol es un nodo hoja, o un
     * numero positivo mayor que <strong>1</strong> que establece la cantidad de
     * nodos que posee este arbol.
     */
    public int getNodeCount();

    /**
     * Devuelve el hijo izquierdo, si este existe.
     *
     * @return devuelve el hijo izquierdo si este existe, de lo contrario
     * devuelve <strong>null</strong>.
     */
    public T getLeftSon();

    /**
     * Devuelve el subarbol correspondiente al hijo izquierdo, si este existe.
     *
     * @return devuelve el arbol correspondiente al hijo izquierdo si este
     * existe, de lo contrario devuelve <strong>null</strong>.
     */
    public Tree<T> getLeftSonTree();

    /**
     * Devuelve una coleccion con los hijos del arbol.
     *
     * @return devuelve la coleccion con ninguno, uno o varios hijos de este
     * arbol.
     */
    public Collection<T> getSons();

    /**
     * Devuelve una coleccion con los subarboles hijos del arbol.
     *
     * @return devuelve la coleccion con ninguno, uno o varios subarboles hijos
     * de este arbol.
     */
    public Collection<Tree<T>> getCollectionTreeSons();

    /**
     * Devuelve el subarbol correspondiente al hijo establecido.
     *
     * @param node el nodo del hijo del cual se necesita obtener su arbol.
     * @return devuelve el arbol del hijo si este existe, de lo contrario
     * devuelve <strong>null</strong>.
     */
    public Tree<T> getSonTree(T node);

    /**
     * Establece si el arbol es un arbol general o no.
     * <p>
     * Un arbol general es una estructura de datos donde cada nodo puede tener
     * mas de dos hijos a diferencia de los arboles binarios donde el nodo solo
     * puede tener como maximo dos hijos, un hijo izquierdo y un hijo
     * derecho.</p>
     *
     * @return <strong>true</strong> si el arbol es un arbol general, de lo
     * contrario es un arbol binario y devuelve <strong>false</strong>.
     */
    public boolean isGeneralTree();

    /**
     * Devuelve la altura del arbol.
     * <p>
     * La altura de un arbol es la profundidad del arbol. La altura de un arbol
     * se calcula como la altura del hermano de mayor altura, donde la altura de
     * cada nodo se calcula como la mayor altura de sus nodos hijos.</p>
     *
     * @return la altura del arbol.
     */
    public int getTreeHeight();

    /**
     * Devuelve el nivel del arbol.
     * <p>
     * El nivel del arbol es el mayor nivel del nodo almacenado con respecto a
     * su padre, si el nodo del arbol es la raiz del arbol, entonces devuelve
     * <strong>0</strong> si es el nodo hijo de la raiz devuelve
     * <strong>1</strong>, y asi sucesivamente.</p>
     *
     * @return el nivel del nodo del arbol.
     */
    public int getLevelNode();

    /**
     * Devuelve los nodos hojas de este arbol.
     * <p>
     * Se considera un nodo hoja a un nodo del arbol que no posee hijos.</p>
     *
     * @return devuelve los nodos hojas a partir de este arbol.
     */
    public Collection<T> getLeaves();

    /**
     * Establece si este arbol es un nodo hoja o no.
     *
     * @return devuelve <strong>true</strong> si este arbol es un nodo hoja, de
     * lo contrario devuelve <strong>false</strong>.
     */
    public boolean isNodeALeaf();

    /**
     * Establece si un nodo es hoja o no.
     *
     * @param node el nodo a evaluar si es hoja.
     * @return devuelve <strong>true</strong> si el nodo a evaluar es un nodo
     * hoja, de lo contrario si el nodo a evaluar no es hoja o no existe,
     * entonces devuelve <strong>false</strong>.
     */
    public boolean isNodeALeaf(T node);

    /**
     * Devuelve el iterador por defecto del arbol.
     * <p>
     * Por defecto el arbol general devuelve un iterador en profundidad.</p>
     *
     * @return el iterador del arbol.
     */
    @Override
    public TreeIterator<T> iterator();
}
