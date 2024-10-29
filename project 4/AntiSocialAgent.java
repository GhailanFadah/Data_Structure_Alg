import java.util.Random;

public class AntiSocialAgent extends SocialAgent {

    // constructor
    public AntiSocialAgent(double x0, double y0, int rad) {
        super(x0, y0, rad);
    }

    // overrides the update method of the superclass agent
    @Override
    // either moves the agent or not based on certain conditions
    public void updateState(Landscape scape) {

        // sets the move field to false
        this.moved = false;

        // creates a random object
        Random ran = new Random();
        double randomX = ran.nextInt(60) - 30 + ran.nextDouble();
        double randomY = ran.nextInt(60) - 30 + ran.nextDouble();

        /*
         * checks if the current agent has less than or equal to 2 neighbors beside
         * itself if so then there is a 1% chance that the agent is moved randomly else
         * the agent is moved randomly since it has less than 3 neighbors
         */
        if (scape.getNeighbors(this.getX(), this.getY(), this.getRadius()).size() <= 3) {
            int chance = ran.nextInt(99);
            if (chance == 1) {

                // adds the change to x and y position
                this.setX(this.getX() + randomX);
                this.setY(this.getY() + randomY);

                // sets move field to true
                this.moved = true;
            }

        } else {

            // adds the change to x and y position
            this.setX(this.getX() + randomX);
            this.setY(this.getY() + randomY);

            // sets move field to true
            this.moved = true;
        }
    }

}
