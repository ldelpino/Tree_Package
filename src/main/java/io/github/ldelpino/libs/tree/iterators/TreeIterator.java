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
package io.github.ldelpino.libs.tree.iterators;

import java.util.Iterator;

/**
 *
 * @author EL ROJO
 * @param <T>
 */
public interface TreeIterator<T> extends Iterator<T> {

    /**
     * Devuelve el tipo de iterador.
     * <p>
     * El tipo de iterador permite establecer un identificador para iterador del
     * arbol.
     *
     * @return el tipo del iterador.
     */
    public IteratorType getType();

    /**
     * La clase permite establecer un identificador para cada diferente tipo de
     * iterador en los arboles.
     */
    public class IteratorType {

        private final String typeName;
        private final boolean generalIterator;

        public IteratorType(String typeName, boolean generalIterator) {
            this.typeName = typeName;
            this.generalIterator = generalIterator;
        }

        public String getTypeName() {
            return typeName;
        }

        public boolean generalIterator() {
            return generalIterator;
        }
    }
}
