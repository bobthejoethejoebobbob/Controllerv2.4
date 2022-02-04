package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="Drive Encoder", group="Exercises")
public class DucksAndParkRedEncoders extends LinearOpMode
{
    private ElapsedTime runtime = new ElapsedTime(); //Declared AND Initialized
    private DcMotor FrontLeft; //Declared  but not initialized
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor BackRight;
    private DcMotor Intake;
    private DcMotor Spinner;
    private DcMotor Intake2;
    private DcMotor Slide;
    private Servo Bucket;
    double armPos;
    double clawPos;
    double drive;
    double turn;
    double strafe;
    double force;
    double spin;
    double slide;
    double frontLeftPower;
    double frontRightPower;
    double backLeftPower;
    double backRightPower;
    double intakePower;
    double spinnerPower;
    double slidePower;
    double multiplier;
    double timeA; //strafe to carousel
    double timeB; //do carousel
    double timeC; //move back
    double timeD; //turn robot
    double timeE; //strafe left and drive into park
    double tickConversion;
    int intakeSetting;
    int spinnerSetting;
    double intakeFactor;
    int i;
    boolean trackingMode;
    double spinFactor;
    boolean checker;
    boolean rotation;
    boolean holdArm;
    boolean dpadWasDown;
    int clawMode;
    boolean bWasDown;
    boolean xWasDown;
    int armMode;
    double initialposition;
    public double startTime = runtime.milliseconds();
    public void mecanumDrive(String driveType, double value1, double power) {
        if(driveType.equals("forward")){
            FrontLeft.setTargetPosition((int) (42.78*value1+FrontLeft.getCurrentPosition()));
            BackLeft.setTargetPosition((int) (42.78*value1+BackLeft.getCurrentPosition()));
            FrontRight.setTargetPosition((int) (42.78*value1+FrontRight.getCurrentPosition()));
            BackRight.setTargetPosition((int)(42.78*value1+BackRight.getCurrentPosition()));
            FrontLeft.setPower(power);
            BackLeft.setPower(power);
            FrontRight.setPower(power);
            BackRight.setPower(power);
        } else if(driveType.equals("strafe")){
            FrontLeft.setTargetPosition((int) (-47.53*value1+FrontLeft.getCurrentPosition()));
            BackLeft.setTargetPosition((int) (47.53*value1+BackLeft.getCurrentPosition()));
            FrontRight.setTargetPosition((int) (47.53*value1+FrontRight.getCurrentPosition()));
            BackRight.setTargetPosition((int)(-47.53*value1+BackRight.getCurrentPosition()));
            FrontLeft.setPower(power);
            BackLeft.setPower(power);
            FrontRight.setPower(power);
            BackRight.setPower(power);
        }
        //noinspection StatementWithEmptyBody
        while((FrontLeft.isBusy()||BackLeft.isBusy()||BackRight.isBusy()||FrontRight.isBusy())&&opModeIsActive()){}
        FrontLeft.setPower(0.0);
        BackLeft.setPower(0.0);
        FrontRight.setPower(0.0);
        BackRight.setPower(0.0);

    }
    public void runOpMode() throws InterruptedException
    {
        double x = 0; // encoder ticks/foot
        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        FrontRight.setDirection(DcMotor.Direction.FORWARD);
        BackRight.setDirection(DcMotor.Direction.FORWARD);

        // reset encoder counts kept by motors.
        FrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FrontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // set motors to run to target encoder position and stop with brakes on.
        FrontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FrontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //Spinner.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        telemetry.addData("Mode", "running");
        telemetry.update();
        resetStartTime();
        waitForStart();
        mecanumDrive("strafe", 1, .5);
        mecanumDrive("forward", 3, 1);
        double duckTime = runtime.seconds();
        while(opModeIsActive() && runtime.seconds()<duckTime+5.5){
            Spinner.setPower(-.5);
        }
        Spinner.setPower(0);
        mecanumDrive("forward", -5, 1);
        mecanumDrive("strafe", -2, 1);
        mecanumDrive("forward", -93, 1);
    }
}