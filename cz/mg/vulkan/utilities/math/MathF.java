package cz.mg.vulkan.utilities.math;

public class MathF {
    public static final float PI = 3.1415f;

    public static float cos(float f){
        return (float) Math.cos(f);
    }

    public static float tan(float f){
        return (float) Math.tan(f);
    }

    public static float cot(float f){
        return 1.0f / tan(f);
    }

    public static float sin(float f){
        return (float) Math.sin(f);
    }

    public static float sqrt(float f){
        return (float) Math.sqrt(f);
    }

    public static float length(float dx, float dy){
        return sqrt(dx*dx + dy*dy);
    }

    public static float length(float dx, float dy, float dz){
        return sqrt(dx*dx + dy*dy + dz*dz);
    }
}
