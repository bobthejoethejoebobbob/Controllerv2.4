////please note: completely expected to crash and burn
////INCOMPLETE DO NOT RUN NEED TO ACTUALLY CODE MOVEMENT
//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//
//@Autonomous(name="Garbage Encoderless Auto Blue Side", group="Autonomous")
//public class EncoderAutonomousTest extends LinearOpMode
//{
//    private ElapsedTime runtime = new ElapsedTime(); //Declared AND Initialized
//    private DcMotor FrontLeft; //Declared  but not initialized
//    private DcMotor FrontRight;
//    private DcMotor BackLeft;
//    private DcMotor BackRight;
//    private DcMotor Intake;
//    private DcMotor Spinner;
//    private DcMotor Intake2;
//    private DcMotor Slide;
//    private Servo Arm;
//    private Servo Claw;
//    double armPos;
//    double clawPos;
//    double drive;
//    double turn;
//    double strafe;
//    double force;
//    double spin;
//    double slide;
//    double frontLeftPower;
//    double frontRightPower;
//    double backLeftPower;
//    double backRightPower;
//    double intakePower;
//    double spinnerPower;
//    double slidePower;
//    double multiplier;
//    int intakeSetting;
//    int spinnerSetting;
//    double intakeFactor;
//    int i;
//    boolean trackingMode;
//    double spinFactor;
//    boolean checker;
//    boolean rotation;
//    boolean holdArm;
//    boolean dpadWasDown;
//    int clawMode;
//    boolean bWasDown;
//    boolean xWasDown;
//    int armMode;
//    public double startTime = runtime.milliseconds();
//
//    public void runOpMode() throws InterruptedException
//    {
//        telemetry.addData("Status", "Initialized");
//        drive = 0.0;
//        turn = 0.0;
//        strafe = 0.0;
//        force = 0.0;
//        spin = 0.0;
//        slide = 0.0;
//        frontLeftPower = 0.0;
//        frontRightPower = 0.0;
//        backLeftPower = 0.0;
//        backRightPower = 0.0;
//        intakePower = 0.0;
//        spinnerPower = 0.0;
//        slidePower = 0.0;
//        multiplier = 1.0;
//        intakeSetting = 1;
//        spinnerSetting = 1;
//        intakeFactor = 1.0;
//        trackingMode = false;
//        spinFactor = 0.0;
//        checker = false;
//        rotation = false;
//        armPos = 0.5;
//        clawPos = 0.9;
//        holdArm = false;
//        clawMode = 1;
//        bWasDown = false;
//        xWasDown = false;
//        dpadWasDown = false;
//        armMode = 0;
//
//        // Initialize the hardware variables. Note that the strings used here as parameters
//        // to 'get' must correspond to the names assigned during the robot configuration
//        // step (using the FTC Robot Controller app on the phone).
//        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
//        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
//        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
//        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
//        Intake = hardwareMap.get(DcMotor.class, "Intake");
//        Spinner = hardwareMap.get(DcMotor.class, "Spinner");
//        Intake2 = hardwareMap.get(DcMotor.class, "Intake2");
//        Slide = hardwareMap.get(DcMotor.class, "Slide");
//        Arm = hardwareMap.get(Servo.class, "Arm");
//        Claw = hardwareMap.get(Servo.class, "Claw");
//
//
//
//
//        // Most robots need the motor on one side to be reversed to drive forward
//        // Reverse the motor that runs backwards when connected directly to the battery
//        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
//        BackLeft.setDirection(DcMotor.Direction.REVERSE);
//        FrontRight.setDirection(DcMotor.Direction.FORWARD);
//        BackRight.setDirection(DcMotor.Direction.FORWARD);
//        Intake.setDirection(DcMotor.Direction.FORWARD);
//        Spinner.setDirection(DcMotor.Direction.FORWARD);
//        Intake2.setDirection(DcMotor.Direction.FORWARD);
//        Slide.setDirection(DcMotor.Direction.FORWARD);
//
//
//        FrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        BackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        FrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        BackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        Intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        Spinner.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        Intake2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        Slide.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//
//
//        // Tell the driver that initialization is complete.
//        telemetry.addData("Status", "Initialized");
//        // wait while opmode is active and left motor is busy running to position.
//
//        while (opModeIsActive() && FrontLeft.isBusy())
//        {
//            telemetry.addData("encoder-front-left", FrontLeft.getCurrentPosition() + "  busy=" + FrontLeft.isBusy());
//            telemetry.addData("encoder-back-left", BackLeft.getCurrentPosition() + "  busy=" + BackLeft.isBusy());
//            telemetry.addData("encoder-front-right", FrontRight.getCurrentPosition() + "  busy=" + FrontRight.isBusy());
//            telemetry.addData("encoder-back-right", BackRight.getCurrentPosition() + "  busy=" + BackRight.isBusy());
//            telemetry.update();
//            idle();
//        }
//
//        // set motor power to zero to turn off motors. The motors stop on their own but
//        // power is still applied so we turn off the power.
//
//        FrontLeft.setPower(0.0);
//        BackLeft.setPower(0.0);
//        FrontRight.setPower(0.0);
//        BackRight.setPower(0.0);
//
//        // wait 5 sec to you can observe the final encoder position.
//
//        resetStartTime();
//
//        while (opModeIsActive() && getRuntime() < 5)
//        {
//            telemetry.addData("encoder-front-left-end", FrontLeft.getCurrentPosition());
//            telemetry.addData("encoder-back-left-end", BackLeft.getCurrentPosition());
//            telemetry.addData("encoder-front-right-end", FrontRight.getCurrentPosition());
//            telemetry.addData("encoder-back-right-end", BackRight.getCurrentPosition());
//            telemetry.update();
//            idle();
//        }
//
//        // Back to starting position without encoders(to measure precision)
//
//
//        FrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        BackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        FrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        BackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//
//        FrontLeft.setTargetPosition(0);
//        BackLeft.setTargetPosition(0);
//        FrontRight.setTargetPosition(0);
//        BackRight.setTargetPosition(0);
//
//
//        FrontLeft.setPower(-0.25);
//        BackLeft.setPower(-0.25);
//        FrontRight.setPower(-0.25);
//        BackRight.setPower(-0.25);
//
//        // set motor power to zero to stop motors.
//
//        FrontLeft.setPower(0.0);
//        BackLeft.setPower(0.0);
//        FrontRight.setPower(0.0);
//        BackRight.setPower(0.0);
//
//        resetStartTime();
//
//        while (opModeIsActive() && getRuntime() < 5)
//        {
//            telemetry.addData("encoder-front-left-end", FrontLeft.getCurrentPosition());
//            telemetry.addData("encoder-back-left-end", BackLeft.getCurrentPosition());
//            telemetry.addData("encoder-front-right-end", FrontRight.getCurrentPosition());
//            telemetry.addData("encoder-back-right-end", BackRight.getCurrentPosition());
//            telemetry.update();
//            idle();
//        }
//    }
//}
