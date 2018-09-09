import ou.*;
/**
 * The class SneakyHoverFrog is a subclass of HoverFrog 
 * with the addition of the instance variable isSneaking 
 * and the methods setIsSneaking() and getIsSneaking(), 
 * setColour(), stopSneaking(), startSneaking() and
 * panicIfCanBeSeen().
 * 
 * @author Sam Lichy 
 * @version 24/01/18
 */
public class SneakyHoverFrog extends HoverFrog
{
   private boolean isSneaking;

   /**
    * Constructor for objects of class SneakyHoverFrog
    */
   public SneakyHoverFrog()
   {
      super();
      this.isSneaking = false;
   }

   /**
    * A setter method for instance variable isSneaking
    */
   public void setIsSneaking(boolean value)
   {
      this.isSneaking = value;
   }
   
   /**
    * A setter method which sets the colour of the receiver 
    * to the argument if the latter is any colour other than 
    * white and the value of isSneaking is false. Otherwise 
    * it should do nothing.
    */
   @Override
   public void setColour(OUColour aColour)
   {
      if (super.getColour() != OUColour.WHITE && isSneaking == false)
      {
         super.setColour(aColour); 
      }
   }
   
   /**
    * A getter method for instance variable isSneaking
    */
   public boolean getIsSneaking()
   {
      return isSneaking;
   }
   
   /**
    * A public instance method that sets the value of the 
    * receiver's isSneaking variable to true and its 
    * colour to white.
    */
   public void startSneaking()
   {
      this.isSneaking = true;
      super.setColour(OUColour.WHITE);
   }
   
   /**
    * A public instance method that sets the value of the 
    * receiver's isSneaking variable to false and its 
    * colour to green.
    */
   public void stopSneaking()
   {
      this.isSneaking = false;
      super.setColour(OUColour.GREEN);
   }
   
   /**
    * A public instance method that sets the value of the 
    * receiver's isSneaking variable to true and its 
    * colour to white.
    */
   public void panicIfCanBeSeen(Amphibian a)
   {
      if (isSneaking == true)
      {
         if (a.getPosition() == super.getPosition()) 
         {
            if (super.getHeight() >=0 && super.getHeight() <= 3)
            {
               super.setColour(OUColour.RED);
               super.croak();
               super.croak();
               super.croak();
               
               if (super.getHeight() != 0)
               {
                  int height = super.getHeight();
                  
                  for (int i = 0; i < height; i++)
                  {
                     super.setHeight(super.getHeight() - 1);
                  }
               }
               
               this.stopSneaking();            
            }
         }
      }
   }
}
