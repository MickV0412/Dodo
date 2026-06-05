import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author Sjaak Smetsers & Renske Smetsers-Weeda
 * @version 3.0 -- 20-01-2017
 */
public class MyDodo extends Dodo
{
    private int myNrOfEggsHatched;
    
    public MyDodo() {
        super( EAST );
        myNrOfEggsHatched = 0;
    }

    public void act() {
    }

    /**
     * Move one cell forward in the current direction.
     * 
     * <P> Initial: Dodo is somewhere in the world
     * <P> Final: If possible, Dodo has moved forward one cell
     *
     */
    public void move() {
        if ( canMove() ) {
            step();
        } else {
            showError( "I'm stuck!" );
        }
    }

    /**
     * Test if Dodo can move forward, (there are no obstructions
     *    or end of world in the cell in front of her).
     * 
     * <p> Initial: Dodo is somewhere in the world
     * <p> Final:   Same as initial situation
     * 
     * @return boolean true if Dodo can move (no obstructions ahead)
     *                 false if Dodo can't move
     *                      (an obstruction or end of worl ahead)
     */
    public boolean canMove() {
        if ( borderAhead() || fenceAhead() ){
            return false;
        } else {
            return true;
        }
    }
    /**
     
       climbs over fence 
       * 
     */
    public void climbOverFence(){
        if (fenceAhead ()){
            turnLeft();
            move();
            turnRight();
            move();
            move();
            turnRight();
            move();
            turnLeft();
        }
    }

    /**
     * Hatches the egg in the current cell by removing
     * the egg from the cell.
     * Gives an error message if there is no egg
     * 
     * <p> Initial: Dodo is somewhere in the world. There is an egg in Dodo's cell.
     * <p> Final: Dodo is in the same cell. The egg has been removed (hatched).     
     */    
    public void hatchEgg () {
        if ( onEgg() ) {
            pickUpEgg();
            myNrOfEggsHatched++;
        } else {
            showError( "There was no egg in this cell" );
        }
    }
    /**
     checks if grain is ahead 
     *
     */
    
    public boolean grainAhead(){
        move();
        if(onGrain() == true){
        turnRight();
        turnRight();
        move();
        turnRight();
        turnRight();
        return true;
        }else{
        turnRight();
        turnRight();
        move();
        turnRight();
        turnRight();
        return false;
        }
        }
    
    /**
     * Returns the number of eggs Dodo has hatched so far.
     * 
     * @return int number of eggs hatched by Dodo
     */
    public int getNrOfEggsHatched() {
        return myNrOfEggsHatched;
    }
    
    /**
     * Move given number of cells forward in the current direction.
     * 
     * <p> Initial:   
     * <p> Final:  
     * 
     * @param   int distance: the number of steps made
     */
    public void jump( int distance ) {
        int nrStepsTaken = 0;               // set counter to 0
        while ( nrStepsTaken < distance ) { // check if more steps must be taken  
            move();                         // take a step
            nrStepsTaken++; 
            if ( borderAhead ()){
                System.out.println(" Cant take anymore steps");
            }else {
            System.out.println("Moved" + nrStepsTaken);
            
        }
    }
    }
    /**
     * Walks to edge of the world printing the coordinates at each step
     * 
     * <p> Initial: Dodo is on West side of world facing East.
     * <p> Final:   Dodo is on East side of world facing East.
     *              Coordinates of each cell printed in the console.
     */

    public void walkToWorldEdge( ){
        while( ! borderAhead() ){
            move();
        }
    }

    /**
     * Test if Dodo can lay an egg.
     *          (there is not already an egg in the cell)
     * 
     * <p> Initial: Dodo is somewhere in the world
     * <p> Final:   Same as initial situation
     * 
     * @return boolean true if Dodo can lay an egg (no egg there)
     *                 false if Dodo can't lay an egg
     *                      (already an egg in the cell)
     */

    public boolean canLayEgg( ){
        if( onEgg() ){
            return false;
        }else{
            return true;
        }
    }  
    /**
     if canlayegg is true then lay egg
     
     */
    public void layEggIfPossible(){
        if ( canLayEgg () ){
            layEgg();
        }
    }
    public void goToEgg(){
        while ( !onEgg() ){
            move();
        }
    }
    /** 
     turns twice so it turns 180 degrees 
     
     */
    public void turn180(){
        turnRight();
        turnRight();
    }
    public void goBackToStartOfRowAndFaceBack (){
        turn180();
        walkToWorldEdge();
        turn180();
    }
    /**
      This method checks if the fence is ahead and then climbs over the fence 
    **/
    public void walkToWorldEdgeClimbingOverFences(){
        while( !borderAhead() ){
        if( fenceAhead() ){
            climbOverFence();
        } else {
            move();
        }
    }
    }
    /**
    Checks if there is a grain if there is its it picks the grain up and prints the cordinates 
    **/   
    public void pickUpGrainsAndPrintCoordinates(){
            while ( !borderAhead()){
                move();
                if (onGrain()){
                pickUpGrain();
                System.out.println(getX() + " " + getY());
                }
        }
    }
    public void stepOneCellBackwards(){
        turn180();
        move();
        turn180();
    }
    public void eggTrailToNest(){
        while( !onNest() ){
            while( !eggAhead() ){
            turnRight();
        }
    move();
    }
    }
    public boolean eggAhead(){
        move();
        if(onEgg() == true){
        turnRight();
        turnRight();
        move();
        turnRight();
        turnRight();
        return true;
        }else{
        turnRight();
        turnRight();
        move();
        turnRight();
        turnRight();
        return false;
        }
        }
    /**
    Loopt naar het einde van de wereld 
    als er een nest is zonder ei legt ze een ei       
    **/
    public void noDoubleEggs() {
    while (!borderAhead()) {
        move();
        if (onNest() && !onEgg()) {
            layEgg();
        }
    }
    }
    public void walkToNestClimbingOverFences() {
    while (!onNest()) {
        if (fenceAhead()) {
            climbOverFence();
        } else {
            move();
        }
    }
    layEgg();
    }
    public void walkAroundFencedArea() {
    while (!onEgg()) {
        if (fenceAhead()) {
            turnLeft();
        } else {
            move();
        }
    }
    }
    /**
     * kijkt naar de kant waar je hem naartoe wil kijken
     *
     */
    public void faceDirection(int direction) {
    while (getDirection() != direction) {
            turnRight();
        }
    }
    /**
     * Loopt door het doolhof naar het nest via de linkerhand regel.
     * 
     */
    public void solveMaze() {
    while (!onNest()) {
        turnLeft();
        while (fenceAhead() || borderAhead()) {
            turnRight();
        }
        move();
    }
    }
    public boolean validCoordinates(int x, int y) {
    boolean valid = x >= 0 && x < getWorld().getWidth() && y >= 0 && y < getWorld().getHeight();
    if (!valid) showError("Invalid coordinates");
    return valid;
    }
    public void goToLocation(int coordX, int coordY) {
    while (getX() < coordX) { faceDirection(EAST);  move(); }
    while (getX() > coordX) { faceDirection(WEST);  move(); }
    while (getY() < coordY) { faceDirection(SOUTH); move(); }
    while (getY() > coordY) { faceDirection(NORTH); move(); }
    }
    public int countEggsInRow() {
    int count = 0;
    if (onEgg()) count++;
    while (!borderAhead()) {
        move();
        if (onEgg()) count++;
    }
    goBackToStartOfRowAndFaceBack();
    showCompliment("Aantal eieren: " + count);
    return count;
    }
    public void layTrailOfEggs(int n) {
    for (int i = 0; i < n; i++) {
        layEgg();
        move();
    }
    }
    public int countEggsInWorld() {
    int total = 0;
    for (int row = 0; row < getWorld().getHeight(); row++) {
        goToLocation(0, row);
        total += countEggsInRow();
    }
    return total;
    }
    public void monumentOfEggs() {
    for (int row = 0; row < getWorld().getHeight(); row++) {
        int eggs = Math.min(row + 1, getWorld().getWidth());
        goToLocation(0, row);
        faceDirection(EAST);
        for (int col = 0; col < eggs; col++) {
            layEggIfPossible();
            if (col < eggs - 1) step();
        }
    }
    }
    public void stevigMonument() {
    int eggs = 1;
    for (int row = 0; row < getWorld().getHeight(); row++) {
        goToLocation(0, row);
        faceDirection(EAST);
        for (int col = 0; col < eggs && col < getWorld().getWidth(); col++) {
            layEggIfPossible();
            if (col < eggs - 1 && col < getWorld().getWidth() - 1) step();
        }
        eggs = eggs * 2;
    }
    }
    public void piramidOfEggs(){
        
    }
}