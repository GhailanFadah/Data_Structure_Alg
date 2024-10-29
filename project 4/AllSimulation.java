import java.util.Random;

public class AllSimulation {

    public void antiSim(int width, int height, int numAgents, int radius, int updates, int speed)
            throws InterruptedException {
        Landscape scape = new Landscape(width, height);
        Random gen = new Random();

        // creates agents and adds them to the landscape with a radius
        for (int i = 0; i < numAgents; i++) {
            scape.addAgent(new AntiSocialAgent(gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(), radius));
        }

        // creates a LandscapeDisplay object
        LandscapeDisplay display = new LandscapeDisplay(scape);

        // updates the landscape a certain amount of times
        int counter = 0;
        while (counter < updates) {
            scape.updateAgents();
            display.repaint();
            Thread.sleep(speed);
            counter++;
        }
    }

    public void catSim(int width, int height, int numAgents, int radius, int updates, int speed)
            throws InterruptedException {

        // creates a Landscape and a random object
        Landscape scape = new Landscape(width, height);
        Random gen = new Random();

        // creates agents and adds them to the landscape with a radius and a
        // category of 20
        for (int i = 0; i < numAgents; i++) {
            scape.addAgent(new CatSocialAgent(gen.nextDouble() * scape.getWidth(), gen.nextDouble() * scape.getHeight(),
                    radius, 20));
        }

        // creates agents and adds them to the landscape with a radius and a catgory
        // of 10
        for (int i = 0; i < numAgents; i++) {
            scape.addAgent(new CatSocialAgent(gen.nextDouble() * scape.getWidth(), gen.nextDouble() * scape.getHeight(),
                    radius, 10));
        }

        // creates a LandscapeDisplay object
        LandscapeDisplay display = new LandscapeDisplay(scape);

        // updates the landscape a certain amount of times
        int counter = 0;
        while (counter < updates) {
            scape.updateAgents();
            display.repaint();
            Thread.sleep(speed);
            counter++;
        }
    }

    public void socialSim(int width, int height, int numAgents, int radius, int updates, int speed)
            throws InterruptedException {

        // creates a Landscape and a random object
        Landscape scape = new Landscape(width, speed);
        Random gen = new Random();

        // creates agents and adds them to the landscape with a radius
        for (int i = 0; i < numAgents; i++) {
            scape.addAgent(
                    new SocialAgent(gen.nextDouble() * scape.getWidth(), gen.nextDouble() * scape.getHeight(), radius));
        }

        // creates a LandscapeDisplay object
        LandscapeDisplay display = new LandscapeDisplay(scape);

        // updates the landscape a certain amount of times
        int counter = 0;
        while (counter < updates) {
            scape.updateAgents();
            display.repaint();
            Thread.sleep(speed);
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // checks the user gives atleast 6 arguments
        if(args.length < 6){
            System.out.print("Usage: program requires atleast 7 arguments" + '\n'
                            + "argument 0: which type of simulation to run default is social for category type (cat) for antiSocial type (anti) " + '\n'
                            + "argument 1: width of the Landscape" + '\n'
                            + "argument 2: height of the Landscape" + '\n'
                            + "argument 3: number of agents to add to the landscape" + '\n'
                            + "argument 4: the radius of sensensitively of radius" + '\n'
                            + "argument 5: number of updates" + '\n'
                            + "argument 6: speed of the simulation in miliseconds" + '\n');
                           
            return;
        }

        // creates AllSimulation object
        AllSimulation sim = new AllSimulation();

        // stores the input of argument 0 
        String check = args[0].toLowerCase();

        String cat = "cat";
        String anti = "anti";

        // converts argumetns 1-6 to integers
        int width = Integer.parseInt(args[1]);
        int height = Integer.parseInt(args[2]);
        int numAgents = Integer.parseInt(args[3]);
        int radius = Integer.parseInt(args[4]);
        int updates = Integer.parseInt(args[5]);
        int speed = Integer.parseInt(args[6]);

        // sees if the user wants the antisocial simulation
        if (check.equals(anti)) {
            sim.antiSim(width, height, numAgents, radius, updates, speed);

            // sees if the user wants the category simulation
        } else if (check.equals(cat)) {
            sim.catSim(width, height, numAgents, radius, updates, speed);

            // runs the default social simulation
        } else {
            sim.socialSim(width, height, numAgents, radius, updates, speed);

        }

    }

}
