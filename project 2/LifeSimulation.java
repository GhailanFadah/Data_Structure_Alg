import java.util.Random;

public class LifeSimulation {
    public static void main(String[] args) throws InterruptedException {
        if(args.length < 3){
            System.out.print("Usage: program requires atleast four arguments" + '\n'
                            + "argument 1: the density of the grid" + '\n'
                            + "argument 2: the amount of rows" + '\n'
                            + "argument 3: the amount of columns" + '\n'
                            + "argument 4: the amount of simulations");
            return;
        }

        int row = Integer.parseInt(args[1]);
        int col = Integer.parseInt(args[2]);
        int generation = Integer.parseInt(args[3]);
        double density = Double.parseDouble(args[0]);
        Landscape scape = new Landscape(row, col);
        Random gen = new Random();


        //initialize the grid 
        for (int i = 0; i < scape.getRows(); i++) {
            for (int j = 0; j < scape.getCols(); j++ ) { 
                scape.getCell( i, j ).setAlive( gen.nextDouble() <= density );
        

            }
        }

        // KNOWN PATTERN USED FOR TESTING
        // scape.getCell(1, 1).setAlive(true);
        // scape.getCell(1, 2).setAlive(true);
        // scape.getCell(1, 3).setAlive(true);
        // scape.getCell(5, 1).setAlive(true);
        // scape.getCell(5, 2).setAlive(true);
        // scape.getCell(5, 3).setAlive(true);
        // scape.getCell(10, 1).setAlive(true);
        // scape.getCell(10, 2).setAlive(true);
        // scape.getCell(10, 3).setAlive(true);
        // scape.getCell(1, 5).setAlive(true);
        // scape.getCell(1, 6).setAlive(true);
        // scape.getCell(1, 7).setAlive(true);
        // scape.getCell(1, 1).setAlive(true);
        // scape.getCell(1, 2).setAlive(true);
        // scape.getCell(15, 15).setAlive(true);
        // scape.getCell(15, 16).setAlive(true);
        // scape.getCell(16, 15).setAlive(true);
        // scape.getCell(16, 16).setAlive(true);
        // scape.getCell(17, 17).setAlive(true);
        // scape.getCell(17, 18).setAlive(true);
        // scape.getCell(18, 17).setAlive(true);
        // scape.getCell(18, 18).setAlive(true);

        LandscapeDisplay display = new LandscapeDisplay(scape, 15);

        // for loops that makes the game one simualtion each loop
        for(int x = 0; x < generation; x++){
            scape.advance();
            display.repaint();
            Thread.sleep(250);
        }
        
        
       
    }
       

    

    
}

