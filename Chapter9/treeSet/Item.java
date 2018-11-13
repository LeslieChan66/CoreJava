package com.CoreJava.Chapter9.treeSet;

import java.util.Objects;

/**
 * @Description:
 * @author: Leslie Chan
 * @Date: 17:26 2018/8/9
 */

public class Item implements Comparable<Item> {
    private String desctiption;
    private int partNumber;

    public Item(String aDescription, int aPartNumber) {
        desctiption = aDescription;
        partNumber = aPartNumber;
    }

    public String getDesctiption()
    {
        return desctiption;
    }

    @Override
    public String toString() {
        return "[description=" + desctiption + ", partNumber=" + partNumber + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        return Objects.equals(desctiption, other.desctiption) && partNumber == other.partNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(desctiption, partNumber);
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(partNumber, o.partNumber);
        return diff != 0 ? diff : desctiption.compareTo(o.desctiption);
    }
}
