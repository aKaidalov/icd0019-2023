package oo.hide;

public class PointSet {

    private Point[] arr;
    private int index = 0;

    public int getArrLength() {
        return arr.length;
    }
    public int getIndex() {
        return index;
    }

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
        for (Point p : other.arr) {
            if (other.arr[0] == null && this.arr[0] != null) {
                return false;
            } else if (p == null) {
                break;
            } else if (!(this.contains(p))) {
                return false;
            }
        }
        return true;
    }

    public void add(Point point) {
        if (index + 1 > arr.length) {
            this.arr = returnExtendedArrCopy();
        }
        if (arr[0] == null || !contains(point)) {
            arr[index] = point;
            index++;
        }
    }

    public Point[] returnExtendedArrCopy() {
        Point[] res = new Point[arr.length * 2];
        for (int i = 0; i < res.length; i++) {
            if (i < arr.length) {
                res[i] = arr[i];
            } else {
                break;
            }
        }
        return res;
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

    // subtract---------------------------------------------------------------------------

    public PointSet subtract(PointSet other) {
        Point[] subtractArr = new Point[0];
        for (Point p : arr) {
            if (p == null) {
                break;
            } else if (!(other.contains(p))) {
                subtractArr = addToAnyArr(p, subtractArr);
            }
        }
        return returnArrCopy(subtractArr);
    }

    // intersect---------------------------------------------------------------------------

    public PointSet intersect(PointSet other) {
        Point[] intersectionArr = new Point[0];
        for (Point p : arr) {
            if (p == null) {
                break;
            } else if (other.contains(p)) {
                intersectionArr = addToAnyArr(p, intersectionArr);
            }
        }
        return returnArrCopy(intersectionArr);
    }

    // intersect---------------------------------------------------------------------------

    public Point[] addToAnyArr(Point obj, Point[] newArr) {

        Point[] modifiedArrCopy = new Point[newArr.length + 1];
        for (int i = 0; i < modifiedArrCopy.length; i++) {
            if (i == modifiedArrCopy.length - 1) {
                modifiedArrCopy[i] = obj;
            } else {
                modifiedArrCopy[i] = newArr[i];
            }
        }
        return modifiedArrCopy;
    }

    public PointSet returnArrCopy(Point[] newArr) {
        PointSet res = new PointSet();
        for (Point point: newArr){
            if (point == null) {
                break;
            }
            res.add(point);
        }
        return res;
    }

    // ---------------------------------------------------------------------------

    public void remove(Point point) {
    }
}
