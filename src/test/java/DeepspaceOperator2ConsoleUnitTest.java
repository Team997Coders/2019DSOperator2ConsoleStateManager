import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import edu.wpi.first.wpilibj.command.Command;

public class DeepspaceOperator2ConsoleUnitTest {
  @Test
  public void itSetsScoringArtifactStateToBallWhenClicked() {
    // Assemble
    DeepspaceOperator2Console console = new DeepspaceOperator2Console();

    // Act
    console.clickScoringArtifactButton(DeepspaceOperator2Console.ScoringArtifactStates.Ball);

    // Assert
    assertEquals(DeepspaceOperator2Console.ScoringArtifactStates.Ball, console.getScoringArtifactState());
  }

  @Test
  public void itStartsActivatedCommandWhenActivateButtonClicked() {
    // Assemble
    DeepspaceOperator2Console console = new DeepspaceOperator2Console();
    Command activateCommand = mock(Command.class);
    console.whenActivateClicked(activateCommand);

    // Act
    console.clickActivateButton();

    // Assert
    verify(activateCommand, times(1)).start();
  }

  @Test
  public void itSetsStateCorrectlyWhenInitialized() {
    // TODO: Implement this.
    assertTrue(true);
  }
  
  @Test
  public void itStartsBCommandWhenBButtonClicked() {
    // Assemble
    DeepspaceOperator2Console console = new DeepspaceOperator2Console();
    Command visionBClickedCommand = mock(Command.class);
    console.whenVisionBClicked(visionBClickedCommand);

    // Act
    console.clickVisionBButton();

    // Assert
    verify(visionBClickedCommand, times(1)).start();
  }

  @Test
  public void itStartsXCommandWhenXButtonClicked() {
    // Assemble
    DeepspaceOperator2Console console = new DeepspaceOperator2Console();
    Command visionXClickedCommand = mock(Command.class);
    console.whenVisionXClicked(visionXClickedCommand);

    // Act
    console.clickVisionXButton();

    // Assert
    verify(visionXClickedCommand, times(1)).start();
  }

  @Test
  public void itStartsLeftCommandWhenLeftButtonClicked() {
    // Assemble
    DeepspaceOperator2Console console = new DeepspaceOperator2Console();
    Command visionLeftClickedCommand = mock(Command.class);
    console.whenVisionLeftClicked(visionLeftClickedCommand);

    // Act
    console.clickVisionLeftButton();

    // Assert
    verify(visionLeftClickedCommand, times(1)).start();
  }
  @Test
  public void itStartsRightCommandWhenRightButtonClicked() {
    // Assemble
    DeepspaceOperator2Console console = new DeepspaceOperator2Console();
    Command visionRightClickedCommand = mock(Command.class);
    console.whenVisionRightClicked(visionRightClickedCommand);

    // Act
    console.clickVisionRightButton();

    // Assert
    verify(visionRightClickedCommand, times(1)).start();
  }
  @Test
  public void itStartsCenterCommandWhenCenterButtonClicked() {
    // Assemble
    DeepspaceOperator2Console console = new DeepspaceOperator2Console();
    Command visionCenterClickedCommand = mock(Command.class);
    console.whenVisionCenterClicked(visionCenterClickedCommand);

    // Act
    console.clickVisionCenterButton();

    // Assert
    verify(visionCenterClickedCommand, times(1)).start();
  }
}