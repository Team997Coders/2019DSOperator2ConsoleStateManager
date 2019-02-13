import edu.wpi.first.wpilibj.command.*;

/**
 * This class implements the Deepspace operator 2 custom console
 * for running on the roborio. Hook wpilibj joystick whenPressed
 * methods to the appropriate methods below. Wpilibj whenPressed
 * methods will get called in response to custom HID firmware running
 * on an embedded device, plugged in to the driver station, which
 * mimics a joystick. The driver station will do what it always does
 * with joystick feedback and send it along to the robot.
 */
public class DeepspaceOperator2Console {
  private ScoringDirectionStates scoringDirectionState;
  private ScoringArtifactStates scoringArtifactState;
  private ScoringDestinationStates scoringDestinationState;
  private PositionStates positionState;
  private Command activateClickedCommand;
  private Command mediumPositionClickedCommand;
  private Command visionAClickedCommand;
  private Command visionBClickedCommand;
  private Command visionXClickedCommand;
  private Command visionLeftClickedCommand;
  private Command visionRightClickedCommand;
  private Command visionCenterClickedCommand;

  public DeepspaceOperator2Console() {
    setCancelState();
  }
  public void clickHighPositionButton(){
    this.positionState = PositionStates.High;
  }

  public void clickMediumPositionButton(){
    this.positionState = PositionStates.Medium;
  }

  public void clickLowPositionButton(){
    this.positionState = PositionStates.Low;
  }

  public ScoringDirectionStates getScoringDirectionState() {
    return scoringDirectionState;
  }

  public ScoringArtifactStates getScoringArtifactState() {
    return scoringArtifactState;
  }

  public PositionStates getPositionState() {
    return positionState;
  }

  public void clickScoringDirectionButton(ScoringDirectionStates scoringDirectionState) {
    this.scoringDirectionState = scoringDirectionState;
  }

  public void clickScoringDestinationButton(ScoringDestinationStates scoringDestinationState) {
    if(scoringDestinationState == ScoringDestinationStates.Rocket &&
      scoringDirectionState == ScoringDirectionStates.Back &&
        scoringArtifactState == ScoringArtifactStates.Hatch){
         }else{
          this.scoringDestinationState = scoringDestinationState;
         }
  
    if (this.scoringDestinationState == ScoringDestinationStates.CargoShip){
      this.positionState = PositionStates.None;
    }
  }

  public void clickScoringArtifactButton(ScoringArtifactStates scoringArtifactState) {
    this.scoringArtifactState = scoringArtifactState;
  }

  public void clickCancelButton() {
    setCancelState();
  }

  private void setCancelState() {
    // TODO: This default state MUST match the default state of the firmware
    // when it is turned on. This state and the firmware state are
    // NOT in communication with each other.
    scoringDirectionState = ScoringDirectionStates.Front;
    scoringArtifactState = ScoringArtifactStates.None;
    scoringDestinationState = ScoringDestinationStates.None;
    positionState = PositionStates.None;
  }

  public void clickActivateButton() {
    activateClickedCommand.start();
  }

  public void whenActivateClicked(Command activateClickedCommand) {
    this.activateClickedCommand = activateClickedCommand;
  }

  public void clickVisionAButton() {
    visionAClickedCommand.start();
  }

  public void clickVisionBButton() {
    visionBClickedCommand.start();
  }

  public void clickVisionXButton() {
    visionXClickedCommand.start();
  }

  public void clickVisionLeftButton() {
    visionLeftClickedCommand.start();
  }

  public void clickVisionRightButton() {
  visionRightClickedCommand.start();
  }

  public void clickVisionCenterButton() {
    visionCenterClickedCommand.start();
}

  public void clickPositionButton(PositionStates positionState) {
    this.positionState = positionState;
  }

  // I don't think we need any callback command handlers for any
  // of the state buttons. We do need them for the vision buttons
  // and for the active button (but not for the cancel button unless
  // the robot goes into turtle mode or something).

  public void whenVisionAClicked(Command visionAClickedCommand) {
    this.visionAClickedCommand = visionAClickedCommand;
  }
  public void whenVisionBClicked(Command visionBClickedCommand) {
    this.visionBClickedCommand = visionBClickedCommand;
  }
  public void whenVisionXClicked(Command visionXClickedCommand) {
    this.visionXClickedCommand = visionXClickedCommand;
  }
  public void whenVisionLeftClicked(Command visionLeftClickedCommand) {
    this.visionLeftClickedCommand = visionLeftClickedCommand;
  }
  public void whenVisionRightClicked(Command visionRightClickedCommand) {
    this.visionRightClickedCommand = visionRightClickedCommand;
  }
  public void whenVisionCenterClicked(Command visionCenterClickedCommand) {
    this.visionCenterClickedCommand = visionCenterClickedCommand;
  }


// Perhaps not needed?
/*
  public enum Buttons {
    ScoringDirection, 
    ScoringArtifact, 
    ScoringDestination, 
    HighPosition, 
    MediumPosition, 
    LowPosition, 
    VisionA, 
    VisionB, 
    VisionX, 
    VisionPanLeft, 
    VisionCenter, 
    VisionPanRight,
    Intake
  }
*/

  public enum ScoringDirectionStates {
    Front,
    Back
  }

  public enum ScoringArtifactStates {
    None,
    Ball,
    Hatch
  }

  public enum ScoringDestinationStates {
    None,
    CargoShip,
    Rocket
  }

  public enum PositionStates {
    None,
    High,
    Medium,
    Low
  }
}