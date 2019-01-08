package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.Book;
import model.Goods;

public class View {

  JFrame frame;
  JFrame goods;
  JFrame confirm;
  JFrame finish;

  String user = "";
  String paw = "";
  String goodName = "";
  boolean isConfirm = false;

  public static void main(String[] args) {
    View v = new View();
    Book[] books = { new Book("可怕的家锪", "恐懼"), new Book("開心的家園", "開勳") };
    ArrayList<Goods> arrayBooks = new ArrayList<Goods>();
    for (Book b : books)
      arrayBooks.add(b);
    System.out.println(v.rentView(arrayBooks).toString());
  }

  public String[] certificationView() {
    frame = new JFrame("User Login");
    frame.setSize(350, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    frame.add(panel);

    panel.setLayout(null);

    JLabel userLabel = new JLabel("使用者:");
    userLabel.setBounds(10, 20, 80, 25);
    panel.add(userLabel);

    JTextField userText = new JTextField(20);
    userText.setBounds(100, 20, 165, 25);
    panel.add(userText);

    JLabel passwordLabel = new JLabel("密碼:");
    passwordLabel.setBounds(10, 50, 80, 25);
    panel.add(passwordLabel);

    JPasswordField passwordText = new JPasswordField(20);
    passwordText.setBounds(100, 50, 165, 25);
    panel.add(passwordText);

    JButton loginButton = new JButton("登入");
    loginButton.setBounds(10, 80, 80, 25);
    panel.add(loginButton);

    frame.setVisible(true);

    loginButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        user = userText.getText();
        paw = passwordText.getText();
      }
    });

    while (true) {
      if (!user.equals("") && !paw.equals("")) {
        break;
      }
    }
    String[] str = { user, paw };
    return str;
  }

  public Goods rentView(ArrayList<Goods> items) {

    goods = new JFrame("Choose goods");

    goods.setSize(350, 200);
    goods.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    goods.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));

    for (Goods i : items) {
      JButton a = new JButton(i.toString());
      a.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          goodName = a.getText();
        }
      });
      goods.add(a);
    }
    goods.setVisible(true);

    Goods good = null;
    while (true) {
      if (!goodName.equals("")) {
        for (Goods i : items) {
          if (i.toString().equals(goodName)) {
            good = i;
            break;
          }
        }
        break;
      }
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e1) {
        e1.printStackTrace();
      }
    }

    return good;
  }

  public boolean confirmationView(String Name) {

    confirm = new JFrame("Comfirm");

    JTextArea textarea = new JTextArea(Name);

    JLabel emptyLable = new JLabel("產品資訊寫這邊");

    JPanel panel = new JPanel();

    Container container = confirm.getContentPane();

    JButton startAutoGen = new JButton("確認資料");

    startAutoGen.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        isConfirm = true;
        System.out.println(goodName);
      }
    });

    panel.add(textarea);
    panel.add(emptyLable);
    panel.add(startAutoGen);

    confirm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    container.add(panel);

    confirm.setSize(350, 200);

    confirm.setVisible(true);

    while (true) {
      if (isConfirm) {
        confirm.setVisible(false);
        confirm.dispose();
        System.out.println("4564");
        break;
      }
      System.out.println("123131313");
    }
    return true;
  }

  public void finishView() {
    finish = new JFrame("Finish");

    finish.setSize(350, 200);

    JLabel label = new JLabel("完成租借");

    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.CENTER);
    finish.add(label);

    JButton south = new JButton("離開");
    south.setText("OK");
    south.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    finish.add(south, BorderLayout.SOUTH);
    finish.setVisible(true);

  }

  public void dead() {
    JFrame error = new JFrame("Comfirm");

    // 初始化一个文字区域
    JLabel label = new JLabel("Failed");
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.CENTER);
    error.add(label, BorderLayout.CENTER);
    JButton button = new JButton();

    button.setText("OK");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    error.setSize(350, 200);
    error.add(button, BorderLayout.SOUTH);
    error.setVisible(true);
  }

}