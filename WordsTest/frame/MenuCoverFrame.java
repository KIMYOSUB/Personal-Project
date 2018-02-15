package frame;

import javax.swing.*;

import inputOutput.WritePA;
import main.Main;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MenuCoverFrame extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Main main;
	JButton sb;
	JLabel li;
	Thread th;
	public MenuCoverFrame() {
		setTitle("정보처리기사 단어시험");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		creatMenu();
		
		BackGround ima = new BackGround();
		
		ima.setBounds(0, 0, 700, 350);
		ima.setLayout(null);
		
		li = new JLabel(new ImageIcon(getClass().getClassLoader().getResource("starDdong.png")));
		li.setBounds(265, 195, 56, 52);
		
		sb = new JButton(new ImageIcon(getClass().getClassLoader().getResource("start1.png")));
		sb.setRolloverIcon(new ImageIcon(getClass().getClassLoader().getResource("start_p1.png")));
		sb.setBorderPainted(false);
		sb.setContentAreaFilled(false);
		sb.setBounds(295, 210, 120, 63);
		sb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				main.showMainFrame(MenuCoverFrame.this, main);
			}
			
		});
		
		setSize(710, 400);
		
		JLayeredPane lp = new JLayeredPane();
		lp.setBounds(0, 0, 700, 350); //
		lp.setLayout(null);
		
		lp.add(ima, new Integer(0));
		lp.add(sb, new Integer(1));
		lp.add(li, new Integer(2));
		add(lp);
		
		Dimension frameSize = this.getSize();
		Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
		
		th = new Thread(this);
		th.start();
		
		setVisible(true);
		
	}
	
	void creatMenu() {                                                          //메뉴 만드는 메소드
		JMenuBar mb = new JMenuBar();
		JMenu option = new JMenu("Option");
		JMenu words = new JMenu("Words");
		
		JMenuItem url = new JMenuItem("경로 설정");
		JMenuItem help = new JMenuItem("사용설명서");
		JMenuItem ext = new JMenuItem("종료");
		
		JMenuItem sav = new JMenuItem("문제 추가");
		
		url.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//경로 설정 창 열기
				new Urlset();
			}
			
		});
		
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//프로그램 설명서
				new Description();
			}
		});
		
		ext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		sav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WriteSet(); 
			}
		});
		
		
		option.add(url);
		option.addSeparator();
		option.add(help);
		option.addSeparator();
		option.add(ext);
		
		words.add(sav);
		
		mb.add(option);
		mb.add(words);
		
		setJMenuBar(mb);
	}
	class BackGround extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Image image;
		public BackGround() {
			image = Toolkit.getDefaultToolkit().createImage(getClass().getClassLoader().getResource("cover3.jpg"));
			
		}
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(image, 0, 0, this);
		}
		@Override
		public void update(Graphics g) {
			super.update(g);
		}
	}
	
	class WriteSet extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L; 
		JLabel ans;
		JLabel pro;
		JTextField an;
		JTextArea pr;
		JButton sb;
		JLabel sc;
		WriteSet() {
			setTitle("문제답 저장");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			Container c = getContentPane();
			c.setLayout(null);
			ans = new JLabel("답:");
			pro = new JLabel("문제:");
			an = new JTextField(20);
			an.addFocusListener(new FocusAdapter() {

				@Override
				public void focusGained(FocusEvent e) {
					sc.setVisible(false);
					
				}
				
			});
			pr = new JTextArea(100, 20);
			sb = new JButton("저장");
			sc = new JLabel("저장완료!");
			sc.setForeground(Color.RED);
			sc.setVisible(false);
			sb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String pp = pr.getText();
					pp = pp.replaceAll("(\r\n|\r|\n|\n\r)", " ");
					new WritePA(pp, an.getText());
					sc.setVisible(true);
					an.setText("");
					pr.setText("");
				}
				
			});
			pr.setLineWrap(true);
			ans.setBounds(20, 10, 50, 20); pro.setBounds(20, 70, 50, 20); sb.setBounds(20, 320, 60, 20);
			an.setBounds(20, 40, 150, 20);  pr.setBounds(20, 100, 250, 200); sc.setBounds(90, 320, 100, 20);
			c.add(ans); c.add(pro); c.add(an); c.add(pr); c.add(sb); c.add(sc); 
			setSize(300, 380);
			c.setBackground(Color.GRAY);
			Dimension frameSize = this.getSize();
			Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
			setLocation((windowSize.width - frameSize.width) / 2, (windowSize.height - frameSize.height) / 2);
			setVisible(true);
		}
		
	}
	class Urlset extends JFrame{                                  

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JFileChooser fc;
		JLabel pla;
		JLabel ala;
		JTextField ptf;												// 문제 txt파일 경로
		JTextField atf;												// 답   txt파일 경로
		JButton pb;
		JButton ab;
		JTextArea dc; 
		JScrollPane jp;
		Urlset() {
			setTitle("텍스트 파일 경로설정");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			Container c1 = getContentPane();
			c1.setLayout(null);
			
			fc = new JFileChooser();
			
			pla = new JLabel("문제 경로 :");
			pla.setBounds(10, 10, 200, 20);
			
			ala = new JLabel("답  경로 :");
			ala.setBounds(10, 40, 200, 20);
			
			ptf = new JTextField(100);
			ptf.setBounds(120, 10, 100, 20);
			ptf.setText(Main.prURL);
			
			atf = new JTextField(100);
			atf.setBounds(120, 40, 100, 20);
			atf.setText(Main.asURL);
			
			pb = new JButton("열기1");
			pb.setBounds(225,10, 70, 20);
			pb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int returnVal = fc.showOpenDialog(c1);
		            if( returnVal == JFileChooser.APPROVE_OPTION)
		            {
		                //열기 버튼을 누르면
		                File file = fc.getSelectedFile();
		                ptf.setText(file.toString());
		                String gpt = ptf.getText();
						main.setprURL(gpt);
						JOptionPane.showMessageDialog(null, "경로 : "+gpt, "변경완료!", JOptionPane.INFORMATION_MESSAGE);
		            }
		            else
		            {
		                //취소 버튼을 누르면
		            }
					
				}
				
			});
			
			ab = new JButton("열기2");
			ab.setBounds(225, 40, 70, 20);
			ab.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int returnVal = fc.showOpenDialog(c1);
		            if( returnVal == JFileChooser.APPROVE_OPTION)
		            {
		                //열기 버튼을 누르면
		                File file = fc.getSelectedFile();
		                atf.setText(file.toString());
		                String gat = atf.getText();
						main.setasURL(gat);
						JOptionPane.showMessageDialog(null, "경로 : "+gat, "변경완료!", JOptionPane.INFORMATION_MESSAGE);
		            }
		            else
		            {
		                //취소 버튼을 누르면
		            }
					
				}
				
			});
			
			dc = new JTextArea("ex) C:\\Users\\kys\\Desktop\\sample.txt\n"
					+ "기본 경로 : \"Text\\Problem.txt\", \"Text\\Answer.txt\"\n"
					+ "텍스트파일 꼭 'UTF-8'로 저장", 100, 2);
			
			
			jp = new JScrollPane(dc);
			jp.setBounds(10, 70, 300, 75);
			
			c1.add(pla);
			c1.add(ala);
			c1.add(ptf);
			c1.add(atf);
			c1.add(pb);
			c1.add(ab);
			c1.add(jp);
			
			
			setSize(380, 190);
			setVisible(true);
		}
		
	}
	
	public void setMain(Main main) {
		this.main = main;
	}

	public static void main(String[] args) {
		new MenuCoverFrame();
	}

	@Override
	public void run() {
		int x = li.getX();
		int y = li.getY();
		while(true) {
			try {
				Thread.sleep(50);
			}
			catch(InterruptedException e) {
				return;
			}
			if(x < 380) {
				x++;
			}
			if(x == 380) {
				x = 265;
			}
			li.setLocation(x, y);
		}
	}
}
