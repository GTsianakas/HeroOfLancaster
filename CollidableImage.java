/**
 * CollidableImage class, creates instances of images that should not be allowed to overlap each other.
 * E.g. Map obstacles (trees etc), NPCs, main character etc.
 */

class CollidableImage extends Image{
 
    public CollidableImage(int x, int y,int height,int width, String path){
	super(x,y,height,width,path);
    }

    /**
     * Checks whether two collidable images are touching/overlapping with each other
     * @param img Collidable image to check if touching
     * @return True if objects are touching, false otherwise
     */
    public boolean within(CollidableImage img){
        return (this.getX() + 0.5 * this.getWidth() >= img.getX() - 0.5 * img.getWidth()
		&& this.getX() - 0.5 * this.getWidth() <= img.getX() + 0.5 * img.getWidth()
		&& this.getY() + 0.5 * this.getHeight() >= img.getY() - 0.5 * img.getHeight()
		&& this.getY() - 0.5 * this.getHeight() <= img.getY() + 0.5 * img.getHeight());
	    
    }
    
    /**
     * Returns the 2d euclidean distance between this object and anothe Collidable image
     * @param img Collidable image to find distance from
     * @return int 2d euclidean distance between the objects
     */
    public int getDistance(CollidableImage img){
	int x1 = this.getX();
	int y1 = this.getY();
	int x2 = img.getX();
	int y2 = img.getY();

	//euclidian distance
	return (int)Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }
}
