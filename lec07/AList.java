
public class AList<Glorp> {
    private Glorp[] items;
    private int size;

    public AList() {
        items = (Glorp[]) new Object[64];
        size = 0;
    }

    public void addLast(Glorp x) {
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[size] = x;
        size++;
    }

    public Glorp getLast() {
        if (size == 0) {
            throw new RuntimeException("List is empty.");
        }
        return items[size - 1];
    }

    public Glorp removeLast() {
        if (size == 0) {
            throw new RuntimeException("List is empty.");
        }
        Glorp returnItem = items[size - 1];
        items[size - 1] = null;
        size--;
        if (items.length > 64 && ((double) size / (double) items.length < 0.25)) {
            resize(items.length / 2);
        }
        return returnItem;
    }

    public Glorp get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public void resize(int new_size) {
        Glorp[] new_items = (Glorp[]) new Object[new_size];
        System.arraycopy(items, 0, new_items, 0, size);
        items = new_items;
    }

}