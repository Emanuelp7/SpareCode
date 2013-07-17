import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A Greep is an alien creature that likes to collect tomatoes.
 * 
 * @author (your name here)
 * @version 0.1
 */
public class Greep extends Creature
{
    // Remember: you cannot extend the Greep's memory. So:
    // no additional fields (other than final fields) allowed in this class!
    
    /**
     * Default constructor for testing purposes.
     */
    public Greep()
    {
        this(null);
    }

    
    /**
     * Create a Greep with its home space ship.
     */
    public Greep(Ship ship)
    {
        super(ship);
    }
    

    /**
     * Do what a greep's gotta do.
     */
    public void act()
    {
        super.act();   // do not delete! leave as first statement in act().
        if(atShip()) {
            if(carryingTomato())
                turn(180);
            dropTomato();
            edgeTurn(carryingTomato());
            //setFlag(2,false);
        }
        else {
            if(getFlag(2))
                edgeTurn(true);
            else
                edgeTurn(carryingTomato());
        }
        
    }

    /**
     * Is there any food here where we are? If so, try to load some!
     */
    public boolean checkFood()
    {
        // check whether there's a tomato pile here
        TomatoPile tomatoes = (TomatoPile) getOneIntersectingObject(TomatoPile.class);
        if(tomatoes != null) {
            loadTomato();
           // if(!seePaint("red")){
           // setFlag(2,true);
         //   spit("red");
          //  }
          //  spit("red");
            //setFlag(1,false);
        }
        return tomatoes != null;//setFlag(1,tomatoes != null);
    }


    /**
     * This method specifies the name of the author (for display on the result board).
     */
    public static String getAuthorName()
    {
        return "Emanuel Peters";  // write your name here!
    }
    
    public void edgeTurn(boolean isCarrying){
         if(atWater()||atWorldEdge()){
            if(isCarrying){
                spit("orange");
                //setFlag(1,true);
                turn(42);
            }
            else{
                if(Greenfoot.getRandomNumber(5)==1)
                     turn(Greenfoot.getRandomNumber(350));
                else
                    turn(Greenfoot.getRandomNumber(38));
            }
            move();
        }
        else{ 
        if(isCarrying){
            if(seePaint("orange")){
                if(Greenfoot.getRandomNumber(2)==2)
                    turn(5);
            }
           //if(!seePaint("purple")){
          //     setFlag(1,false);
         //   }
            else{
               if(Greenfoot.getRandomNumber(3)==1)
                    turnHome();
                    
                }
            
           // if(seePaint("purple"))
           //     setFlag(2,false);
            spit("purple");
            move();
            
        }
        else{
            if(!checkFood()){
                if(seePaint("purple")){
                   turnHome(); 
                   turn(180);
                }
                move();
            }
            else{
                move();
                turn(180);
                //spit("red");
            }
        }
    }
}
 
    /**
     * This method specifies the image we want displayed at any time. (No need 
     * to change this for the competition.)
     */
    public String getCurrentImage()
    {
        if(carryingTomato())
            return "greep-with-food.png";
        else
            return "greep.png";
    }
}