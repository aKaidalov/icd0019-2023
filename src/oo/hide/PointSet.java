package oo.hide;

public class PointSet {

    private Point[] arr;

    public static int index = 0;

    // init 1
    public PointSet(int capacity) {
        this.arr = new Point[capacity];
    }

    // init 2 -> 1
    public PointSet() {
        this(10);
    }

    // repr
    @Override
    public String toString() {
        String repr = "";
        if (arr[0] == null) {
            return repr;
        }
        for (Point p : arr) {
            if (p == null) {
                break;
            }
            repr += String.format("%s, ", p);
        }
        return repr.substring(0, repr.length() - 2);
    }
    @Override
    public boolean equals (Object obj) {
        if (!(obj instanceof PointSet)) {
            return false;
        }
        PointSet other = (PointSet) obj;
        return this.toString().equals(other.toString());
    }

    public void add(Point point) {
        if (arr[0] == null || !contains(point)) {
            arr[index] = point;
            index++;
        }
    }

    public int size() {
        return index;
    }

    public boolean contains(Point point) {
        for (Point p : arr) {
            if (p == null) {
                break;
            } else if (p.equals(point)) {
                return true;
            }
        }
        return false;
    }

    public PointSet subtract(PointSet other) {
        return null;
    }

    public PointSet intersect(PointSet other) {
        return null;
    }

    public void remove(Point point) {
    }
}
