package cz.mg.vulkan.utilities.math;

import cz.mg.vulkan.VkFloat;


public class Vector4f extends VkFloat.Array {
    private static final int COUNT = 4;

    public Vector4f() {
        super(COUNT);
    }

    public Vector4f(float... values) {
        super(values);
        if(values.length != COUNT) throw new IllegalArgumentException(values.length + "");
    }

    public static Vector4f multiply(Matrix4f a, Vector4f b){
        return new Vector4f(
                a.getValue(0, 0) * b.getValue(0) + a.getValue(1, 0) * b.getValue(1) + a.getValue(2, 0) * b.getValue(2) + a.getValue(3, 0) * b.getValue(3),
                a.getValue(0, 1) * b.getValue(0) + a.getValue(1, 1) * b.getValue(1) + a.getValue(2, 1) * b.getValue(2) + a.getValue(3, 1) * b.getValue(3),
                a.getValue(0, 2) * b.getValue(0) + a.getValue(1, 2) * b.getValue(1) + a.getValue(2, 2) * b.getValue(2) + a.getValue(3, 2) * b.getValue(3),
                a.getValue(0, 3) * b.getValue(0) + a.getValue(1, 3) * b.getValue(1) + a.getValue(2, 3) * b.getValue(2) + a.getValue(3, 3) * b.getValue(3)
        );
    }
}
