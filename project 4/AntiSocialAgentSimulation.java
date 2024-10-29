import java.util.Random;

public class AntiSocialAgentSimulation {

    public static void main(String[] args) throws InterruptedException {

        // creates a Landscape and a random object
        Landscape scape = new Landscape(500, 500);
        Random gen = new Random();

        // creates 200 agents and adds them to the landscape with a radius
        for (int i = 0; i < 200; i++) {
            scape.addAgent(
                    new AntiSocialAgent(gen.nextDouble() * scape.getWidth(), gen.nextDouble() * scape.getHeight(), 30));
        }

        // creates a LandscapeDisplay object
        LandscapeDisplay display = new LandscapeDisplay(scape);

        // updates the landscape a certain amount of times
        int counter = 0;
        while (counter < 800) {
            scape.updateAgents();
            display.repaint();
            Thread.sleep(0);
            counter++;
        }

    }

}
