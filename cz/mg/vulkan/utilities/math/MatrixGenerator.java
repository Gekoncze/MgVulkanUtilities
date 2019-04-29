package cz.mg.vulkan.utilities.math;

import static cz.mg.vulkan.utilities.math.MathF.*;


public class MatrixGenerator {
    private final Angle angle;

    public MatrixGenerator(Angle angle) {
        this.angle = angle;
    }

    public Matrix4f identity(){
        return create(
                1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        );
    }

    public Matrix4f translate(float x, float y, float z){
        return create(
                1, 0, 0, x,
                0, 1, 0, y,
                0, 0, 1, z,
                0, 0, 0, 1
        );
    }

    public Matrix4f scale(float x, float y, float z){
        return create(
                x, 0, 0, 0,
                0, y, 0, 0,
                0, 0, z, 0,
                0, 0, 0, 1
        );
    }

    public Matrix4f rotate(float angle, float x, float y, float z){
        angle = rad(angle);

        float s = sin(angle);
        float c = cos(angle);
        float d = 1 - c;

        return create(
                x*x*d+c  , x*y*d+z*s, x*z*d-y*s, 0,
                x*y*d-z*s, y*y*d+c  , y*z*d+x*s, 0,
                x*z*d+y*s, y*z*d-x*s, z*z*d+c  , 0,
                0        , 0        , 0        , 1
        );
    }

    public Matrix4f rotateX(float angle){
        angle = rad(angle);

        float s = sin(angle);
        float c = cos(angle);

        return create(
                1,  0, 0, 0,
                0,  c, s, 0,
                0, -s, c, 0,
                0,  0, 0, 1
        );
    }

    public Matrix4f rotateY(float angle){
        angle = rad(angle);

        float s = sin(angle);
        float c = cos(angle);

        return create(
                c, 0, -s, 0,
                0, 1,  0, 0,
                s, 0,  c, 0,
                0, 0,  0, 1
        );
    }

    public Matrix4f rotateZ(float angle){
        angle = rad(angle);

        float s = sin(angle);
        float c = cos(angle);

        return create(
                 c, s, 0, 0,
                -s, c, 0, 0,
                 0, 0, 1, 0,
                 0, 0, 0, 1
        );
    }

    public Matrix4f yawPitchRoll(float yaw, float pitch, float roll){
        return Matrix4f.multiply(
                rotateZ(roll),
                rotateX(pitch),
                rotateZ(yaw)
        );
    }

    public Matrix4f ortho(float left, float right, float bottom, float top, float near, float far){
        float sx = 2.0f / ( right - left );
        float sy = 2.0f / ( bottom - top );
        float sz = 1.0f / ( near - far );

        float tx = - ( right + left ) / ( right - left );
        float ty = - ( bottom + top ) / ( bottom - top );
        float tz = near / ( near - far );

        return create(
                sx, 0 , 0 , tx,
                0 , sy, 0 , ty,
                0 , 0 , sz, tz,
                0 , 0 , 0 , 1
        );
    }

    public Matrix4f perspective(float fovy, float aspect, float near, float far){
        fovy = rad(fovy);

        float f = cot(fovy / 2.0f);

        float sx = f / aspect;
        float sy = -f;
        float sz = far / (near - far);
        float tz = far * near / (near - far);

        return create(
                sx, 0, 0, 0,
                0, sy, 0, 0,
                0, 0, sz, tz,
                0, 0, -1, 0
        );
    }

    private static Matrix4f create(float... values){
        return Matrix4f.transpose(new Matrix4f(values));
    }

    private float rad(float f){
        switch(angle){
            case DEGREES: return deg2rad(f);
            case RADIANS: return f;
            case NORMALIZED: return norm2rad(f);
            default: throw new UnsupportedOperationException("" + angle);
        }
    }

    private static float deg2rad(float deg){
        return deg * PI / 180.0f;
    }

    private static float norm2rad(float norm){
        return norm * 2.0f * PI;
    }

    public enum Angle {
        DEGREES,
        RADIANS,
        NORMALIZED
    }
}
