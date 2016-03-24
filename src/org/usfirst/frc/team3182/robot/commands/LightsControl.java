package org.usfirst.frc.team3182.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3182.robot.Robot;
import org.usfirst.frc.team3182.robot.util.Animation;
import org.usfirst.frc.team3182.robot.util.Color;


public class LightsControl extends Command {


    private Animation animation;

    public LightsControl(Animation a) {
        requires(Robot.lights);
        animation = a;
        execute();
    }


    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        switch (animation){
            case CELEBRATE:
                for (int i=0;i<Robot.lights.LENGTH;i++){ //set the strip to random colors
                    Robot.lights.setPixel(i, new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
                }
                while(true) {
                    Robot.lights.fountain();
                    Robot.lights.displayStrip();
                    Timer.delay(.3);
                }
            case COLLECT:

                break;
            case EXPEL:

                break;
            default:

                break;
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.lights.clear();
    }

    @Override
    protected void interrupted() {
        end();
    }
    /*
    // FOR TESTING
    public static void main(String args[]){

        Lights l = new Lights();
        l.setPixel(8, new Color(255, 0, 0));
        for (int i=0;i<5; i++) {
            for (Color c : l.getStrip()) System.out.print(c + " ");
            System.out.println("");
            l.fountain();
        }
    }*/
}
