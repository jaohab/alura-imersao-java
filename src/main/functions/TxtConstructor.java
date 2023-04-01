package main.functions;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TxtConstructor {
    
    private String txt;
    private BufferedImage emoji;

    // Configurar o estilo da fonte
    private int fontSize = 40;
    private Font font = new Font("Impact", Font.BOLD, fontSize);

    public Graphics2D txtGenerator(int rating, Graphics2D g2d, boolean valid) {

        g2d.setFont(font);

        if (valid) {

            switch (rating) {
                case 10:
                this.txt = "Nota 10";
                g2d.setColor(new Color(255, 254, 0));
                try {
                    this.emoji = ImageIO.read(new FileInputStream(new File("assets/Sunglasses Emoji.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }    
                    break;

                case 9:
                this.txt = "Nota 9";
                g2d.setColor(new Color(247, 224, 0));
                try {
                    this.emoji = ImageIO.read(new FileInputStream(new File("assets/Sunglasses Emoji.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } 
                    break;

                case 8:
                this.txt = "Nota 8";
                g2d.setColor(new Color(242, 201, 0));
                try {
                    this.emoji = ImageIO.read(new FileInputStream(new File("assets/Sunglasses Emoji.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } 
                    break;

                case 7:
                this.txt = "Nota 7";
                g2d.setColor(new Color(236, 175, 0));
                try {
                    this.emoji = ImageIO.read(new FileInputStream(new File("assets/Sunglasses Emoji.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } 
                    break;

                case 6:
                this.txt = "Nota 6";
                g2d.setColor(new Color(230, 151, 0));
                try {
                    this.emoji = ImageIO.read(new FileInputStream(new File("assets/Sunglasses Emoji.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } 
                    break;

                case 5:
                this.txt = "Nota 5";
                g2d.setColor(new Color(222, 121, 0));
                try {
                    this.emoji = ImageIO.read(new FileInputStream(new File("assets/Sunglasses Emoji.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } 
                    break;

                case 4:
                this.txt = "Nota 4";
                g2d.setColor(new Color(215, 91, 0));
                try {
                    this.emoji = ImageIO.read(new FileInputStream(new File("assets/Sunglasses Emoji.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } 
                    break;

                case 3:
                this.txt = "Nota 3";
                g2d.setColor(new Color(209, 64, 0));
                try {
                    this.emoji = ImageIO.read(new FileInputStream(new File("assets/Sunglasses Emoji.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } 
                    break;

                case 2:
                this.txt = "Nota 2";
                g2d.setColor(new Color(202, 36, 0));
                try {
                    this.emoji = ImageIO.read(new FileInputStream(new File("assets/Sunglasses Emoji.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } 
                    break;

                case 1:
                this.txt = "Nota 1";
                g2d.setColor(new Color(195, 7, 0));
                try {
                    this.emoji = ImageIO.read(new FileInputStream(new File("assets/Sunglasses Emoji.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } 
                    break;
            
                default:
                this.txt = "Não perca seu tempo...";
                g2d.setColor(new Color(195, 7, 0));
                try {
                    this.emoji = ImageIO.read(new FileInputStream(new File("assets/Sunglasses Emoji.png")));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                    break;
            }

            // Inserir o emoji
            // g2d.drawImage(emoji, null, largura - 650, altura - 650);

        }

        if (!valid) {

            

        } 

        int g2dWidth = ((RenderedImage) g2d).getWidth();
        int gd2dHeight = ((RenderedImage) g2d).getHeight();

        // Inserir o texto no centro horizontal da imagem
        FontMetrics fm = g2d.getFontMetrics();
        int txtSize = fm.stringWidth(txt);
        g2d.drawString(txt, (g2dWidth / 2) - (txtSize / 2), (gd2dHeight - 60));

        // Inserir contorno ao texto
        g2d.setColor(Color.BLACK);
        // Contorno - Ajustar o posicionamento
        AffineTransform trans = g2d.getTransform();
        trans.translate((g2dWidth / 2) - (txtSize / 2), gd2dHeight - 60);
        g2d.transform(trans);

        // Contorno - 
        FontRenderContext frc = g2d.getFontRenderContext();
        var tl = new TextLayout(txt, g2d.getFont().deriveFont((float)fontSize), frc);
        Shape shape = tl.getOutline(null);


    

            g2d.setStroke(new BasicStroke(3f));
            g2d.draw(shape);



        return g2d;

    }
}
