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
          console.clickScoringArtifactButton(DeepspaceOperator2Console.ScoringArtifactStates.Hatch);
        } else if (joystick.getButtonValue(SCORING_ARTIFACT_BALL_BUTTON)) {
          console.clickScoringArtifactButton(DeepspaceOperator2Console.ScoringArtifactStates.Ball);
        } else if (joystick.getButtonValue(MEDIUM_POSITION_BUTTON)) {
          console.clickPositionButton(DeepspaceOperator2Console.PositionStates.Medium);
        } else if (joystick.getButtonValue(ACTIVATE_BUTTON)) {
          console.clickActivateButton();
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