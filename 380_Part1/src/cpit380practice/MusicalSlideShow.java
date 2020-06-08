package cpit380practice;


/**
 * Class that can play a music clip (Sound) during a 
 * slide show
 * @author Barb Ericson
 */
public class MusicalSlideShow extends SlideShow
{
  /////////////// fields //////////////////
  
  /** music clip (sound) to play */
  private Sound musicClip = null;
  
  ///////////////// constructors //////////
  
  /**
   * No-arg constructor.  All fields have
   * their default values
   */
  public MusicalSlideShow() 
  { super(); }
  
  /**
   * Constructor that takes an array of pictures
   * @param pictArray the array of pictures
   */
  public MusicalSlideShow(Picture[] pictArray)
  { super(pictArray);}
  
  /**
   * Constructor that takes an array of pictures
   * and the music clip to play
   * @param pictArray the array of pictures
   * @param clip the sound clip to play
   */
  public MusicalSlideShow(Picture[] pictArray,
                          Sound clip)
  {
    super(pictArray);
    this.musicClip = clip;
  }
  
  /**
   * Constructor that takes an array of pictures
   * and a title to show for the slide show
   * @param pictArray the array of pictures
   * @param title the title to show
   */
  public MusicalSlideShow(Picture[] pictArray,
                          String title)
  {
    super(pictArray,title);
  }
  
  /**
   * Constructor that takes an array of pictures
   * and the time to wait between pictures,
   * and a title
   * @param pictArray the array of pictures
   * @param time the time to wait between pictures
   * @param title the title of the show
   */
  public MusicalSlideShow(Picture[] pictArray,
                          int time,
                          String title)
  {
    super(pictArray,time,title);
  }
  
  ///////////////// methods /////////////////////////
  
  /**
   * Method to show the slide show
   * @throws exception 
   */
  public void show() throws Exception
  {
    if (musicClip != null)
      musicClip.play();
    super.show();
  }
  
  public static void main(String[] args) throws Exception
  {
    Sound music = new Sound(FileChooser.getMediaPath("music.wav"));
    Picture[] pictArray = new Picture[5];
    pictArray[0] = new Picture(FileChooser.getMediaPath("beach.jpg"));
    pictArray[1] = new Picture(FileChooser.getMediaPath("blueShrub.jpg"));
    pictArray[2] = new Picture(FileChooser.getMediaPath("church.jpg"));
    pictArray[3] = new Picture(FileChooser.getMediaPath("eiffel.jpg"));
    pictArray[4] = new Picture(FileChooser.getMediaPath("greece.jpg"));
    SlideShow vacShow = new MusicalSlideShow(pictArray,music);
    vacShow.show();
  }

}