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

/**
 *
 * @author EL ROJO
 * @param <T>
 */
public class PosOrderIterator<T> extends BinaryTreeIterator<T> {

    public PosOrderIterator(BinaryTree<T> current) {
        super(current);
        next = this.current.hasLeftSon() ? this.current.getRightSonTree()
                : this.current.hasFather() ? this.current.getTreeFather() : null;
    }

    @Override
    public T next() {
        current = next;
        if (hasNext()) {
            next = next.hasLeftSon() ? next.getRightSonTree()
                    : next.hasFather() ? next.getTreeFather() : null;
        }
        return current != null ? current.getRoot() : null;
    }
}
