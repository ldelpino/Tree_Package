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

import io.github.ldelpino.libs.tree.TreeIterator;

/**
 *
 * @author EL ROJO
 * @param <T>
 */
public abstract class BinaryTreeIterator<T> implements TreeIterator<T> {

    protected BinaryTree<T> current;
    protected BinaryTree<T> next;

    public BinaryTreeIterator(BinaryTree<T> current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
