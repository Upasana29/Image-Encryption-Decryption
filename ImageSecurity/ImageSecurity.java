import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

class ImageSecurity{
    
    public static void Operation(int key)
    {
         JFileChooser filechooser =new JFileChooser();
         filechooser.showOpenDialog(null);
         File file= filechooser.getSelectedFile();

    try{
        FileInputStream IN = new FileInputStream(file);
        byte []data =new byte[IN.available()];
        IN.read(data);
        int i=0;
        for(byte b:data){
            System.out.println(b);
            data[i]=(byte) (b^key);
            i++;
        }
        FileOutputStream out = new FileOutputStream(file);
        out.write(data);
        out.close();
        IN.close();

        JOptionPane.showMessageDialog(null, "Encryption Done");

    } catch(Exception e){
            e.printStackTrace();
          }

    }
   

     public static void main(String[] args) {
         System.out.println("testing");
         JFrame frame = new JFrame();
         frame.setTitle("Image Security");
         frame.setSize(225, 350);
         frame.setLocationRelativeTo(null);
         frame.getContentPane().setBackground(Color.LIGHT_GRAY);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel heading= new JLabel("your pictures are safe here!!!");
        heading.setIcon(new ImageIcon("d2.jpg"));
        heading.setForeground(Color.WHITE);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setHorizontalTextPosition(SwingConstants.CENTER);
        heading.setVerticalTextPosition(SwingConstants.BOTTOM);
        heading.setBackground(new Color(7,94,84));
        heading.setOpaque(true);
        heading.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        Font font = new FontUIResource("ROBOTO", Font.BOLD, 12);
        JLabel heading2= new JLabel("Enter Your Key Please");  
        heading2.setBackground(new Color(7,94,84));
        heading.setOpaque(true);
        heading2.setHorizontalAlignment(SwingConstants.LEFT);
        heading2.setHorizontalTextPosition(SwingConstants.CENTER);
         JTextField TF = new JTextField(15);
         //TF.setText("Enter your key please");
         TF.setFont(font);
         TF.setBounds(70, 20, 100, 40);
         JButton Button1 = new JButton();
         JButton Button2 = new JButton();
         Button1.setBounds(5, 50, 60, 40);
         Button2.setBounds(30, 50, 60, 40);
         Button1.setText("Encryption");
         Button2.setText("Decryption");
         Button1.setFont(font);
         Button1.setFont(font);
           
         Button1.addActionListener(e->{
            System.out.println("buttonClick");
            String Text=TF.getText();
            int temp = Integer.parseInt(Text);
             Operation(temp);
        });
        Button2.addActionListener(e->{
            System.out.println("buttonClick");
            String Text=TF.getText();
            int temp = Integer.parseInt(Text);
             Operation(temp);
        });

         frame.setLayout(new FlowLayout());
         frame.add(heading);
         frame.add(heading2);
         frame.add(TF);
         frame.add(Button1);
         frame.add(Button2);
         
         frame.setVisible(true);


     }
}