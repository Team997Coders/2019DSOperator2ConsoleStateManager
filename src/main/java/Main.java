import joystick.*;
import net.java.games.input.*;

/**
 * The class implements a console application that spews out the state
 * of the 
 */
public class Main {
  // Yes, I know this looks stupid...
  // The firmware Joystick buttons are 1 based...the JInputJoystick
  // class buttons are zero based. Subtract one from each so we can
  // see what the "real" value is from the firmware in the constant, but still
  // ident the correct button in this test harness.
  private static final int SCORING_ARTIFACT_HATCH_BUTTON = 1 - 1;
  private static final int SCORING_ARTIFACT_BALL_BUTTON = 2 - 1;
  private static final int MEDIUM_POSITION_BUTTON = 3 - 1;
  private static final int ACTIVATE_BUTTON = 4 - 1;
  private static final int LOW_POSITION_BUTTON = 5 - 1;
  private static final int SCORING_DIRECTION_FRONT_BUTTON = 6 - 1;
  private static final int SCORING_DIRECTION_BACK_BUTTON = 7 - 1;
  private static final int SCORING_DESTINATION_ROCKET_BUTTON = 8 - 1;
  private static final int SCORING_DESTINATION_CARGOSHIP_BUTTON = 9 - 1;
  private static final int HIGH_POSITION_BUTTON = 10 - 1;
  private static final int CANCEL_BUTTON = 11 - 1;
  private static final int INTAKE_BUTTON = 12 - 1;
  private static final int VISION_A_BUTTON = 13 - 1;
  private static final int VISION_B_BUTTON = 14 - 1;
  private static final int VISION_X_BUTTON = 15 - 1;
  private static final int VISION_LEFT_HAT_ANGLE = 315;
  private static final int VISION_CENTER_HAT_ANGLE = 0;
  private static final int VISION_RIGHT_HAT_ANGLE = 45;

  public static void main(String ... argv) {
    // First create a joystick object.
    JInputJoystick joystick = new JInputJoystick(Controller.Type.STICK, Controller.Type.GAMEPAD);

    // Check if a joystick was found.
    if( !joystick.isControllerConnected() ){
      System.out.println("Custom Deepspace gamepad controller not found!");
      System.exit(0);
    }

    DeepspaceOperator2Console console = new DeepspaceOperator2Console();
    ActivateCommand activateCommand = new ActivateCommand(console);
    console.whenActivateClicked(activateCommand);

    System.out.println("Connected to custom Deepspace gamepad controller.");

    while(true) {
      // Get current state of joystick and check if joystick is disconnected.
      if( !joystick.pollController() ) {
        // Bail out
        System.out.println("Deepspace gamepad controller disconnected!");
        System.exit(1);
      }
            
      // Read gamepad button states and forward states to custom console.
      try {
        if (joystick.getButtonValue(SCORING_ARTIFACT_HATCH_BUTTON)) {
          console.clickScoringArtifactHatchButton();
        } else if (joystick.getButtonValue(SCORING_ARTIFACT_BALL_BUTTON)) {
          console.clickScoringArtifactBallButton();
        } else if (joystick.getButtonValue(SCORING_DIRECTION_FRONT_BUTTON)) {
          console.clickScoringDirectionFrontButton();
        } else if (joystick.getButtonValue(SCORING_DIRECTION_BACK_BUTTON)) {
          console.clickScoringDirectionBackButton();
        } else if (joystick.getButtonValue(SCORING_DESTINATION_ROCKET_BUTTON)) {
          console.clickScoringDestinationRocketButton();
        } else if (joystick.getButtonValue(SCORING_DESTINATION_CARGOSHIP_BUTTON)) {
          console.clickScoringDestinationCargoShipButton();
        } else if (joystick.getButtonValue(HIGH_POSITION_BUTTON)) {
          console.clickHighPositionButton();
        } else if (joystick.getButtonValue(MEDIUM_POSITION_BUTTON)) {
          console.clickMediumPositionButton();
        } else if (joystick.getButtonValue(LOW_POSITION_BUTTON)) {
          console.clickLowPositionButton();
        } else if (joystick.getButtonValue(INTAKE_BUTTON)) {
          console.clickIntakeButton();
        } else if (joystick.getButtonValue(ACTIVATE_BUTTON)) {
          console.clickActivateButton();
        } else if (joystick.getButtonValue(CANCEL_BUTTON)) {
          console.clickCancelButton();
          System.out.println("Cancel pressed.");
        }
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Expected buttons not found...continuing.");
      }

      try {
        // Don't spin the CPUs
        Thread.sleep(100);
      } catch (InterruptedException e) {
        System.exit(0);
      }
    }
  }
}