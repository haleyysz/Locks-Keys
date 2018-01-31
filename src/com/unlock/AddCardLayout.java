package com.unlock;

import sun.reflect.generics.tree.Tree;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
import java.util.concurrent.locks.Lock;

public class AddCardLayout extends JFrame {
    Object[] options = {"OK"};

    public static void main(String[] args) {
        new AddCardLayout();

    }

    public void AddCardLayout() {
        //show lockId list
        HashSet<Lock1> allLocks = SwingShow.main.getAllLocks();
        TreeSet<Lock1> treeSet = new TreeSet<>(new Comparator<Lock1>() {
            @Override
            public int compare(Lock1 o1, Lock1 o2) {
                return o1.getID() - o2.getID();
            }
        });
        treeSet.addAll(allLocks);
        Lock1[] array1 = new Lock1[treeSet.size()];
        treeSet.toArray(array1);
        String[] lockNum = new String[treeSet.size()];
        for (int i = 0; i < lockNum.length; i++) {
            lockNum[i] = "" + array1[i].getID();
        }
        //show keyId list
        HashSet<Key1> allKeys = SwingShow.main.getAllKeys();
        TreeSet<Key1> treeSet1 = new TreeSet<>(new Comparator<Key1>() {
            @Override
            public int compare(Key1 o1, Key1 o2) {
                return o1.getID() - o2.getID();
            }
        });
        treeSet1.addAll(allKeys);
        Key1[] array2 = new Key1[treeSet1.size()];
        treeSet1.toArray(array2);
        String[] keyNum = new String[treeSet1.size()];
        for (int i = 0; i < keyNum.length; i++) {
            keyNum[i] = "" + array2[i].getID();
        }

        //创建新的窗口
        this.setTitle("Add");
        // 窗体大小
//            this.setSize(1600,860);
        this.setSize(1000, 700);
        // JFrame在屏幕居中
        this.setLocationRelativeTo(null);
        // 显示窗体
        this.setVisible(true);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        // 创建导航条
        JTextField tf0 = new JTextField("Add Keys or Combos", 30);
        tf0.setEditable(false);
        tf0.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 60));
        tf0.setHorizontalAlignment(JTextField.CENTER);
        tf0.setBackground(new java.awt.Color(200, 217, 229));
        panel1.add(tf0, BorderLayout.NORTH);
        //创建cardLayout
        CardLayout card = new CardLayout(100, 5);
        JPanel cardPanel = new JPanel(card);
        JPanel p = new JPanel();
        BoxLayout boxLayout = new BoxLayout(p, BoxLayout.X_AXIS);
        JButton add1 = new JButton("Add a new key and a new lock combo");
        JButton add2 = new JButton("Add a new key and map it to a lock");
        JButton add3 = new JButton("Add an existing key to an existing lock");
        add1.setPreferredSize(new Dimension(260, 40));
        add2.setPreferredSize(new Dimension(260, 40));
        add3.setPreferredSize(new Dimension(260, 40));
        add1.setFont(new Font("Arial", Font.BOLD, 13));
        add2.setFont(new Font("Arial", Font.BOLD, 13));
        add3.setFont(new Font("Arial", Font.BOLD, 13));
        add1.setMargin(new Insets(2, 2, 2, 2));
        add2.setMargin(new Insets(2, 2, 2, 2));
        add3.setMargin(new Insets(2, 2, 2, 2));
        p.add(add1);
        p.add(add2);
        p.add(add3);
///////////////////////////////////////////////////Panel_1//////////////////////////////////////////////////////////////
        JPanel panel_1 = new JPanel();
        JLabel title1 = new JLabel("Add a new key and a new lock combo");
        title1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title1.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel firstPanel = new JPanel();
        firstPanel.setPreferredSize(new Dimension(640, 420));
        firstPanel.setBorder(new EmptyBorder(120, 20, 20, 20));
        JLabel room = new JLabel("Room: #");
        room.setPreferredSize(new Dimension(80, 40));
        room.setFont(new Font("Arial", Font.BOLD, 18));
        JButton addRoom = new JButton("Add");
        addRoom.setFont(new Font("Arial", Font.BOLD, 15));
        addRoom.setPreferredSize(new Dimension(80, 30));
        String arr1[] = new String[200];
        for (int i = 0; i < 200; i++) {
            arr1[i] = i + 101 + "";
        }
        DefaultComboBoxModel model1 = new DefaultComboBoxModel(arr1);
        JComboBox comboBox = new JComboBox(model1);
        comboBox.setSelectedIndex(0);
        comboBox.setPreferredSize(new Dimension(60, 30));
        comboBox.setFont(new Font("Arial", Font.BOLD, 15));

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String comboRoom = comboBox.getSelectedItem().toString();
                int roomNum = Integer.parseInt(comboRoom);
                System.out.println(roomNum);
                addRoom.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            SwingShow.main.addNewLock(roomNum);
                            JOptionPane.showOptionDialog(
                                    null,
                                    "You add a new key and a new lock combo",
                                    "Add Successfully",
                                    JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE,
                                    null, options, options[0]);
                        } catch (Exception e1) {
                            JOptionPane.showOptionDialog(
                                    null,
                                    e1.getMessage(),
                                    "Add Error",
                                    JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
                                    null, options, options[0]);
                        }
                    }
                });
            }
        });
        firstPanel.add(room);
        firstPanel.add(comboBox);
        firstPanel.add(addRoom);
        panel_1.add(title1);
        panel_1.add(firstPanel);
///////////////////////////////////////////////////Panel_2//////////////////////////////////////////////////////////////
        JPanel panel_2 = new JPanel();
        JLabel title2 = new JLabel("Add a new key and map it to an existing lock");
        title2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.Y_AXIS));
        secondPanel.setPreferredSize(new Dimension(640, 420));
        secondPanel.setBorder(new EmptyBorder(50,0,0,0));
        JPanel keyPanel2 = new JPanel(new BorderLayout());
        JLabel ktLabel = new JLabel("Key Type:");
        ktLabel.setPreferredSize(new Dimension(100, 30));
        ktLabel.setFont(new Font("Arial", Font.BOLD, 18));
        JComboBox keyType = new JComboBox();
        keyType.setPreferredSize(new Dimension(40,30));
        keyType.addItem("Physical Key");
        keyType.addItem("Swipe Card");
        keyPanel2.add(ktLabel,BorderLayout.WEST);
        keyPanel2.add(keyType,BorderLayout.CENTER);
        keyType.setPreferredSize(new Dimension(140, 30));
        keyType.setFont(new Font("Arial", Font.BOLD, 15));
        JPanel lockPanel2 = new JPanel(new BorderLayout());
        JLabel lock1 = new JLabel("Lock ID:   #");
        lock1.setPreferredSize(new Dimension(100, 40));
        lock1.setFont(new Font("Arial", Font.BOLD, 18));
        DefaultComboBoxModel model2 = new DefaultComboBoxModel(lockNum);
        JComboBox keyBox = new JComboBox(model2);
        keyBox.setPreferredSize(new Dimension(40,30));
        keyBox.setSelectedIndex(0);
        keyBox.setPreferredSize(new Dimension(60, 30));
        keyBox.setFont(new Font("Arial", Font.BOLD, 15));
        lockPanel2.add(lock1,BorderLayout.WEST);
        lockPanel2.add(keyBox,BorderLayout.CENTER);
        JButton addKey = new JButton("Add");
        addKey.setFont(new Font("Arial", Font.BOLD, 15));
        addKey.setPreferredSize(new Dimension(80, 30));

        keyBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keytype = keyType.getSelectedItem().toString();
                Boolean key_type;
                if (keytype == "Physical Key") {
                    key_type = true;
                } else {
                    key_type = false;
                }
                String lockNum = keyBox.getSelectedItem().toString();
                int lock_num = Integer.parseInt(lockNum);

                addKey.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            SwingShow.main.addNewKey(lock_num, key_type);
                            JOptionPane.showOptionDialog(
                                    null,
                                    "You add a new key and map it to an existing lock",
                                    "Add Successfully",
                                    JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE,
                                    null, options, options[0]);
                        } catch (Exception e1) {
                            JOptionPane.showOptionDialog(
                                    null,
                                    e1.getMessage(),
                                    "Add Error",
                                    JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
                                    null, options, options[0]);
                        }
                    }
                });
            }
        });
        secondPanel.setBorder(new EmptyBorder(120,180,180,180));
        keyPanel2.setBorder(new EmptyBorder(10,10,10,10));
        lockPanel2.setBorder(new EmptyBorder(10,10,10,10));
        secondPanel.add(keyPanel2);
        secondPanel.add(lockPanel2);
        secondPanel.add(addKey);
        panel_2.add(title2);
        panel_2.add(secondPanel);
///////////////////////////////////////////////////Panel_3//////////////////////////////////////////////////////////////
        JPanel panel_3 = new JPanel();
        JLabel title3 = new JLabel("Add an existing key to an existing lock");
        title3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
        title3.setHorizontalAlignment(SwingConstants.CENTER);
        title3.setBorder(new EmptyBorder(10, 10, 10, 10));
        JPanel thirdPanel = new JPanel();
        thirdPanel.setLayout(new BoxLayout(thirdPanel, BoxLayout.Y_AXIS));
        thirdPanel.setPreferredSize(new Dimension(640, 420));
        JPanel keyPanel3 = new JPanel(new BorderLayout());
        JLabel key1 = new JLabel("Key  ID:   #");
        key1.setPreferredSize(new Dimension(100, 40));
        key1.setFont(new Font("Arial", Font.BOLD, 18));
        DefaultComboBoxModel model4 = new DefaultComboBoxModel(keyNum);
        JComboBox keyCount = new JComboBox(model4);
        keyCount.setPreferredSize(new Dimension(140, 30));
        keyCount.setFont(new Font("Arial", Font.BOLD, 15));
        keyPanel3.add(key1,BorderLayout.WEST);
        keyPanel3.add(keyCount,BorderLayout.CENTER);

        JPanel lockPanel3 = new JPanel(new BorderLayout());
        JLabel lock2 = new JLabel("Lock ID:   #");
        lock2.setPreferredSize(new Dimension(100, 40));
        lock2.setFont(new Font("Arial", Font.BOLD, 18));
        DefaultComboBoxModel model3 = new DefaultComboBoxModel(lockNum);
        JComboBox lockCount = new JComboBox(model3);
        lockCount.setPreferredSize(new Dimension(140, 30));
        lockCount.setFont(new Font("Arial", Font.BOLD, 15));
        lockPanel3.add(lock2,BorderLayout.WEST);
        lockPanel3.add(lockCount,BorderLayout.CENTER);

        JButton addCombo = new JButton("Add");
        addCombo.setFont(new Font("Arial", Font.BOLD, 15));
        addCombo.setPreferredSize(new Dimension(80, 30));

        addCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keycount = keyCount.getSelectedItem().toString();
                int keyNum = Integer.parseInt(keycount);
                System.out.println(keyNum);

                String lockcount = lockCount.getSelectedItem().toString();
                int lockNum = Integer.parseInt(lockcount);
                System.out.println(lockNum);
                    try {
                        SwingShow.main.addKey(keyNum,lockNum);
                           JOptionPane.showOptionDialog(
                                   null,
                                   "You add an existing key to an existing lock",
                                   "Add Successfully",
                                   JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE,
                                   null, options, options[0]);
                        } catch (Exception e1) {
                        JOptionPane.showOptionDialog(
                                null,
                                e1.getMessage(),
                                "Add Error",
                                JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
                                null, options, options[0]);
                        }
            }
        });
        thirdPanel.setBorder(new EmptyBorder(120,180,180,180));
        keyPanel3.setBorder(new EmptyBorder(10,10,10,10));
        lockPanel3.setBorder(new EmptyBorder(10,10,10,10));
        thirdPanel.add(keyPanel3);
        thirdPanel.add(lockPanel3);
        thirdPanel.add(addCombo);
        panel_3.add(title3);
        panel_3.add(thirdPanel);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        panel_1.setBackground(Color.lightGray);
        panel_2.setBackground(Color.lightGray);
        panel_3.setBackground(Color.lightGray);
        cardPanel.add(panel_1, "p1");
        cardPanel.add(panel_2, "p2");
        cardPanel.add(panel_3, "p3");
        add1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card.show(cardPanel, "p1");
                add1.setBackground(new java.awt.Color(200, 217, 229));
                add2.setBackground(Color.white);
                add3.setBackground(Color.white);
            }
        });
        add2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card.show(cardPanel, "p2");
                add2.setBackground(new java.awt.Color(200, 217, 229));
                add1.setBackground(Color.white);
                add3.setBackground(Color.white);
            }
        });
        add3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                card.show(cardPanel, "p3");
                add3.setBackground(new java.awt.Color(200, 217, 229));
                add1.setBackground(Color.white);
                add2.setBackground(Color.white);

            }
        });
        panel1.add(cardPanel);
        panel1.add(p, BorderLayout.SOUTH);
        this.add(panel1);
    }
}