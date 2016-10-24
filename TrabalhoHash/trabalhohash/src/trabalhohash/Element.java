package trabalhohash;

/**
 * Elemento interno da hashtable
 *
 * @param <K>
 * @param <V>
 */
public class Element<K, V> {
    public K key;
    public V value;
    public int hash;
    public boolean isActive;

    public Element(K key, V value) {
        this.key = key;
        this.value = value;

        if (key != null) {
            this.hash = key.hashCode();
        } else {
            hash = 0;
        }
        this.isActive = true; // Flag que indica se o elemento esta ativo no hashtable
    }
}
