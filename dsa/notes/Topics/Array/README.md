# Array

## Array Operations

1. `Adding Items to End`: We can insert a new items at the end of the data
   structure until the data structure is not full.

- O(1) running time.

2. `Adding item to Arbitrary Positions`: We want to add a number to the
   arbitrary positions - associated with a given index.

- O(N) running time, because the items must be shifted.(In worst case, all the
  items)

3. `Removing Last Item`: Removing the last item from the data structure is quite
   easy and fast operation.

- O(1) running time.

4. `Removing item from Arbitrary Positions`: Usually we don't know the index of
   the item we want to remove.

- First we have to find the item index. `O(N) runtime`.
- Then remove the item. `O(1) runtime`.
- Finally have to shift the other items. `O(N) runtime`.

---

## Best Use case of `Array` data structure

### Manipulating Last Item(Insertion or Removal)

`O(1) running time` - this is why we like arrays.

### Manipulating Arbitrary Item(Insertion or Removal)

`O(N) running time` - If these kind of operations will dominate then array data
structure is not the best option to use.

---

## Array Advantages

- The best feature of array is random access, we can access arbitrary items
  extremely fast with indexes.
- Quite an easy data structure. Easy to understand and easy to implement as
  well.
- Arrays are fast data structures in the main.

## Array Disadvantages

- We have to know the number of items we want to store at compile time. so it is
  not a dynamic data structure.
- Since it is not dynamic, whenever the data structure is full we have to resize
  it on O(N) linear running time.
- Usually we cannot store items with different datatypes in arrays.

---
