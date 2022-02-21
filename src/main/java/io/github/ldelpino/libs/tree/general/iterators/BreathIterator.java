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
package io.github.ldelpino.libs.tree.general.iterators;

import io.github.ldelpino.libs.tree.general.GeneralTree;
import io.github.ldelpino.libs.tree.general.GeneralTreeIterator;
import java.util.Collection;
import java.util.Deque;

/**
 *
 * @author EL ROJO
 * @param <T>
 */
public class BreathIterator<T> extends GeneralTreeIterator<T> {

    private Deque<GeneralTree<T>> deque;
    
    public BreathIterator(GeneralTree<T> tree) {
        super(tree);
        current = tree;
        if(tree.hasSons()) {
            deque.addAll((Collection<GeneralTree<T>>)tree.getTreeSons());
        }
    }

    @Override
    public T next() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
