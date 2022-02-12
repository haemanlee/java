package testdorm.code;


class Storm {
    protected double eyeRadius;
    protected double eyePositionX;
    protected double eyePositionY;


    public Storm(double eyeRadius, double eyePositionX, double eyePositionY) {
        this.eyeRadius = eyeRadius;
        this.eyePositionX = eyePositionX;
        this.eyePositionY = eyePositionY;
    }
    public boolean isInEyeOfTheStorm(double positionX, double positionY) {
        double distance = Math.sqrt(Math.pow(positionX - eyePositionX, 2) +
                Math.pow(positionY - eyePositionY, 2));
        return distance < eyeRadius;
    }

    public double getEyeRadius() {
        return eyeRadius;
    }

    public double getEyePositionX() {
        return eyePositionX;
    }

    public double getEyePositionY() {
        return eyePositionY;
    }
}

public class RainStorm extends Storm{
    public RainStorm(double eyeRadius, double eyePositionX, double eyePositionY) {
        super(eyeRadius, eyePositionX, eyePositionY);
    }
    @Override
    public boolean isInEyeOfTheStorm(double positionX, double positionY) {
        double distance = Math.sqrt(Math.pow(positionX - eyePositionX, 2) +
                Math.pow(positionY - eyePositionY, 2));
        return distance < eyeRadius;
    }

    public double amountOfRain() {
        return eyeRadius * 20;
    }

    @Override
    public double getEyeRadius() {
        return eyeRadius;
    }

    @Override
    public double getEyePositionX() {
        return eyePositionX;
    }

    @Override
    public double getEyePositionY() {
        return eyePositionY;
    }


    public static void main(String[] args) {
        RainStorm rainStorm = new RainStorm(1,1,1);
        System.out.println(rainStorm.eyeRadius);
        System.out.println(rainStorm.eyePositionX);

    }
}

class SnowStorm extends Storm{
    private double amountOfSnow;

    public SnowStorm(double eyeRadius, double eyePositionX, double eyePositionY, double amountOfSnow) {
        super(eyeRadius, eyePositionX, eyePositionY);
        this.amountOfSnow = amountOfSnow;
    }


    public double getAmountOfSnow() {
        return amountOfSnow;
    }

    @Override
    public boolean isInEyeOfTheStorm(double positionX, double positionY) {
        double distance = Math.sqrt(Math.pow(positionX - eyePositionX, 2) +
                Math.pow(positionY - eyePositionY, 2));
        return distance < eyeRadius;
    }

    @Override
    public double getEyeRadius() {
        return eyeRadius;
    }

    @Override
    public double getEyePositionX() {
        return eyePositionX;
    }

    @Override
    public double getEyePositionY() {
        return eyePositionY;
    }
}