import edu.wpi.first.wpilibj.command.*;

/**
 * Fakey command that shims what a wpilibj command might do.
 * This is just for completeness so we can see the effect
 * of pressing the activate button from the custom console.
 */
public class ActivateCommand extends Command {
  private final DeepspaceOperator2Console console;

  public ActivateCommand(DeepspaceOperator2Console console) {
    this.console = console;
  }

  public void start() {
    // Simply spew state to console
    System.out.println("Activated! State is:");
    System.out.println(String.format("  Scoring direction: %s", console.getScoringDirectionState().toString()));
    System.out.println(String.format("  Scoring artifact: %s", console.getScoringArtifactState().toString()));
    System.out.println(String.format("  Scoring destination: %s", console.getScoringDestinationState().toString()));
    System.out.println(String.format("  Scoring position: %s", console.getPositionState().toString()));
  }
}