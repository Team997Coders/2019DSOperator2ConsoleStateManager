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
}