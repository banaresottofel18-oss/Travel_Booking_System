/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ottofel
 */
class CustomerTable {
      private static class Entry {
        String key;
        Customer value;
        Entry next;

        Entry(String key, Customer value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Entry[] buckets;
    private int size;

    public CustomerTable() {
        buckets = new Entry[16];
    }

    private String normalize(String key) {
        return key.trim().toLowerCase();
    }

    private int indexFor(String key, int length) {
        return (key.hashCode() & 0x7fffffff) % length;
    }

    public void put(Customer customer) {
        String key = normalize(customer.getUserId());
        int index = indexFor(key, buckets.length);

        for (Entry e = buckets[index]; e != null; e = e.next) {
            if (e.key.equals(key)) {
                e.value = customer;
                return;
            }
        }
        buckets[index] = new Entry(key, customer, buckets[index]);
        size++;

        if (size > buckets.length * 0.75) {
            resize();
        }
    }

    public Customer get(String userId) {
        if (userId == null) {
            return null;
        }
        String key = normalize(userId);
        for (Entry e = buckets[indexFor(key, buckets.length)]; e != null; e = e.next) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    public boolean contains(String userId) {
        return get(userId) != null;
    }

    public boolean remove(String userId) {
        if (userId == null) {
            return false;
        }
        String key = normalize(userId);
        int index = indexFor(key, buckets.length);
        Entry prev = null;
        for (Entry e = buckets[index]; e != null; prev = e, e = e.next) {
            if (e.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = e.next;
                } else {
                    prev.next = e.next;
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Entry[] old = buckets;
        buckets = new Entry[old.length * 2];
        for (Entry head : old) {
            for (Entry e = head; e != null; e = e.next) {
                int index = indexFor(e.key, buckets.length);
                buckets[index] = new Entry(e.key, e.value, buckets[index]);
            }
        }
    }
}
