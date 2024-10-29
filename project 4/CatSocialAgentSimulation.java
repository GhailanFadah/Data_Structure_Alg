import java.util.Random;

public class CatSocialAgentSimulation {

    public static void main(String[] args) throws InterruptedException {

        // creates a Landscape and a random object
        Landscape scape = new Landscape(500, 500);
        Random gen = new Random();

        // creates 100 agents and adds them to the landscape with a radius and a
        // category of 20
        for (int i = 0; i < 99; i++) {
            scape.addAgent(new CatSocialAgent(gen.nextDouble() * scape.getWidth(), gen.nextDouble() * scape.getHeight(), 90, 20));
        }

        // creates 100 agents and adds them to the landscape with a radius and a catgory
        // of 10
        for (int i = 0; i < 99; i++) {
            scape.addAgent(new CatSocialAgent(gen.nextDouble() * scape.getWidth(), gen.nextDouble() * scape.getHeight(), 90, 10));
        }

        // creates a LandscapeDisplay object
        LandscapeDisplay display = new LandscapeDisplay(scape);

        // updates the landscape a certain amount of times
        int counter = 0;
        while (counter < 200) {
            scape.updateAgents();
            display.repaint();
            Thread.sleep(150);
            counter++;
        }

    }
}
