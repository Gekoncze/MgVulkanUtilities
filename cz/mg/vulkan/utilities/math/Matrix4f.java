package cz.mg.vulkan.utilities.math;

import cz.mg.vulkan.VkFloat;


public class Matrix4f extends VkFloat.Array {
    private static final int WIDTH = 4;
    private static final int HEIGHT = 4;
    private static final int COUNT = WIDTH * HEIGHT;

    public Matrix4f() {
        super(COUNT);
    }

    public Matrix4f(float... values) {
        super(values);
        if(values.length != COUNT) throw new IllegalArgumentException(values.length + "");
    }

    public float getValue(int x, int y){
        return getValue(x + y*WIDTH);
    }

    public void setValue(int x, int y, float value){
        setValue(x + y*WIDTH, value);
    }

    public static Matrix4f multiply(Matrix4f a, Matrix4f b){
        return new Matrix4f(
                a.getValue(0, 0) * b.getValue(0, 0) + a.getValue(1, 0) * b.getValue(0, 1) + a.getValue(2, 0) * b.getValue(0, 2) + a.getValue(3, 0) * b.getValue(0, 3),
                a.getValue(0, 0) * b.getValue(1, 0) + a.getValue(1, 0) * b.getValue(1, 1) + a.getValue(2, 0) * b.getValue(1, 2) + a.getValue(3, 0) * b.getValue(1, 3),
                a.getValue(0, 0) * b.getValue(2, 0) + a.getValue(1, 0) * b.getValue(2, 1) + a.getValue(2, 0) * b.getValue(2, 2) + a.getValue(3, 0) * b.getValue(2, 3),
                a.getValue(0, 0) * b.getValue(3, 0) + a.getValue(1, 0) * b.getValue(3, 1) + a.getValue(2, 0) * b.getValue(3, 2) + a.getValue(3, 0) * b.getValue(3, 3),

                a.getValue(0, 1) * b.getValue(0, 0) + a.getValue(1, 1) * b.getValue(0, 1) + a.getValue(2, 1) * b.getValue(0, 2) + a.getValue(3, 1) * b.getValue(0, 3),
                a.getValue(0, 1) * b.getValue(1, 0) + a.getValue(1, 1) * b.getValue(1, 1) + a.getValue(2, 1) * b.getValue(1, 2) + a.getValue(3, 1) * b.getValue(1, 3),
                a.getValue(0, 1) * b.getValue(2, 0) + a.getValue(1, 1) * b.getValue(2, 1) + a.getValue(2, 1) * b.getValue(2, 2) + a.getValue(3, 1) * b.getValue(2, 3),
                a.getValue(0, 1) * b.getValue(3, 0) + a.getValue(1, 1) * b.getValue(3, 1) + a.getValue(2, 1) * b.getValue(3, 2) + a.getValue(3, 1) * b.getValue(3, 3),

                a.getValue(0, 2) * b.getValue(0, 0) + a.getValue(1, 2) * b.getValue(0, 1) + a.getValue(2, 2) * b.getValue(0, 2) + a.getValue(3, 2) * b.getValue(0, 3),
                a.getValue(0, 2) * b.getValue(1, 0) + a.getValue(1, 2) * b.getValue(1, 1) + a.getValue(2, 2) * b.getValue(1, 2) + a.getValue(3, 2) * b.getValue(1, 3),
                a.getValue(0, 2) * b.getValue(2, 0) + a.getValue(1, 2) * b.getValue(2, 1) + a.getValue(2, 2) * b.getValue(2, 2) + a.getValue(3, 2) * b.getValue(2, 3),
                a.getValue(0, 2) * b.getValue(3, 0) + a.getValue(1, 2) * b.getValue(3, 1) + a.getValue(2, 2) * b.getValue(3, 2) + a.getValue(3, 2) * b.getValue(3, 3),

                a.getValue(0, 3) * b.getValue(0, 0) + a.getValue(1, 3) * b.getValue(0, 1) + a.getValue(2, 3) * b.getValue(0, 2) + a.getValue(3, 3) * b.getValue(0, 3),
                a.getValue(0, 3) * b.getValue(1, 0) + a.getValue(1, 3) * b.getValue(1, 1) + a.getValue(2, 3) * b.getValue(1, 2) + a.getValue(3, 3) * b.getValue(1, 3),
                a.getValue(0, 3) * b.getValue(2, 0) + a.getValue(1, 3) * b.getValue(2, 1) + a.getValue(2, 3) * b.getValue(2, 2) + a.getValue(3, 3) * b.getValue(2, 3),
                a.getValue(0, 3) * b.getValue(3, 0) + a.getValue(1, 3) * b.getValue(3, 1) + a.getValue(2, 3) * b.getValue(3, 2) + a.getValue(3, 3) * b.getValue(3, 3)
        );
    }

    public static Matrix4f multiply(Matrix4f... ms){
        if(ms.length <= 0) return null;
        Matrix4f first = ms[0];
        for(int i = 1; i < ms.length; i++){
            Matrix4f second = ms[i];
            first = Matrix4f.multiply(first, second);
        }
        return first;
    }

    public static Matrix4f transpose(Matrix4f m){
        return new Matrix4f(
                m.getValue(0, 0), m.getValue(0, 1), m.getValue(0, 2), m.getValue(0, 3),
                m.getValue(1, 0), m.getValue(1, 1), m.getValue(1, 2), m.getValue(1, 3),
                m.getValue(2, 0), m.getValue(2, 1), m.getValue(2, 2), m.getValue(2, 3),
                m.getValue(3, 0), m.getValue(3, 1), m.getValue(3, 2), m.getValue(3, 3)
        );
    }
}
