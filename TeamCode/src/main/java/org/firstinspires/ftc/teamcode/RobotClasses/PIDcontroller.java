package org.firstinspires.ftc.teamcode.Autonomous.RobotClasses;

public class PIDcontroller {
    private  double kp;
    private double ki;
    private  double kd;
    private double target;
    private double ierror;
    private long prevtime;
    private double preverror;

    public PIDcontroller(double kp, double ki, double kd){
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;

    }


    public double update(double target, double current){
        double error = target - current;
        ierror += error;

        double deltatime = System.currentTimeMillis() - prevtime;
        prevtime = System.currentTimeMillis();

        double deltaerror = error - preverror;
        preverror = error;


        double _p_controller = kp * error;
        double _i_controller = ki * ierror * deltatime;
        double _d_controller = kd * (deltaerror);


        return _p_controller + _i_controller + _d_controller;


    }
}