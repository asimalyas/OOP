/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;

// Applying the GRASP principle: **Pure Fabrication**
// AbstractRepository is introduced to manage storage, a responsibility that doesn’t belong to a specific domain class.

public abstract class AbstractRepository<T> implements IRepository<T> {
    protected List<T> items = new ArrayList<>();

    @Override
    public void addItem(T item) {
        items.add(item);
    }

    @Override
    public List<T> getItems() {
        return items;
    }

    @Override
    public abstract T findById(int id);
}
