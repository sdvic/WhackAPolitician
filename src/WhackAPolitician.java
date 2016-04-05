import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class WhackAPolitician implements ActionListener, Runnable
{

	public JButton button;
	public JButton[] buttonArray;
	public JFrame whackAPoliticianFrame = new JFrame();
	public int numberOfButtons = 9;
	public int previousPoliticianNumber = 99;
	public int politicianNumber;
	public String[] politicianList =
		{ "Cruz", "Cheney", "Pelosi", "Boxer", "Trump" };

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new WhackAPolitician());//Starts a separate Swing thread for WhackAPolitician
															//Starts a Runnable thread for WhackApolitician (run(), below).
															//Gives Runnable a lower priority than the Swing thread.
	}

	private void getGoing()
	{
		whackAPoliticianFrame.setVisible(true);
		whackAPoliticianFrame.setSize(500, 385);
		whackAPoliticianFrame.setTitle("Smack dem politics basterdz!");
		whackAPoliticianFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		whackAPoliticianFrame.setLayout(new GridLayout(3, 2, 15, 18));
		drawButtons();
	}

	public void drawButtons()
	{
		whackAPoliticianFrame.getContentPane().removeAll();
		politicianNumber = (int) (Math.random() * numberOfButtons);
		if (politicianNumber == previousPoliticianNumber)
		{
			politicianNumber = (int) (Math.random() * numberOfButtons);
		}
		for (int i = 0; i < numberOfButtons; i++)
		{
			button = new JButton();
			button.setSize(200, 200);
			whackAPoliticianFrame.add(button);
			button.addActionListener(this);
			button.setMnemonic(politicianNumber);
			if (i == politicianNumber)
			{
				try
				{
					Image img = ImageIO.read(getClass()
							.getResource("IMG_5263.JPG"));
					button.setIcon(new ImageIcon(img));
				} catch (IOException ex)
				{
					System.out.println("computer hiccuped");
				}
				previousPoliticianNumber = politicianNumber;
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		drawButtons();
	}

	@Override
	public void run()
	{
		getGoing();
	}
}