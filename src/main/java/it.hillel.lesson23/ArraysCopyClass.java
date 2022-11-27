package it.hillel.lesson23;

public class ArraysCopyClass {
    public static int[] arrayCopy(int[] source, int[] target) {
        int[] copyTarget;
        if (target == null) {
            copyTarget = new int[source.length];
            System.arraycopy(source, 0, copyTarget, 0, source.length);
        } else {
            copyTarget = new int[source.length + target.length];
            System.arraycopy(target, 0, copyTarget, 0, target.length);
            System.arraycopy(source, 0, copyTarget, target.length, source.length);
        }
        return copyTarget;
    }
}
