public class ProxyImage implements Image{

    private Image image;

    public ProxyImage(Image image)
    {
        this.image=image;
    }

    @Override
    public void displayImage() {
         image.displayImage();
    }

    @Override
    public void renderImage() {

        System.out.println("Image is being rendered");
        image.renderImage();
    }
}
