package com.unlock;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Key;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.locks.Lock;

public class SwingShow {
    static Main main;
    static ImageIcon icon1 = new ImageIcon("C:\\Users\\admin\\Desktop\\spring\\LockKeys\\src\\lock.png");
    static ImageIcon icon2 = new ImageIcon("C:\\Users\\admin\\Desktop\\spring\\LockKeys\\src\\key.png");
    static ImageIcon icon3 = new ImageIcon("C:\\Users\\admin\\Desktop\\spring\\LockKeys\\src\\key_lock.png");
    static ImageIcon icon4 = new ImageIcon("C:\\Users\\admin\\Desktop\\spring\\LockKeys\\src\\swipe_card.png");
    static ImageIcon icon5 = new ImageIcon("C:\\Users\\admin\\Desktop\\spring\\LockKeys\\src\\add-circle0.png");
    static Border border = BorderFactory.createLineBorder(Color.BLACK);
    public static void main(String[] args) {
        main = new Main();
        // 确保一个漂亮的外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);
        // 创建 JFrame 实例
        JFrame frame0 = new JFrame("Locks and Keys");
        // 设置 frame 的宽高
        frame0.setSize(900,700);
        // JFrame在屏幕居中
        frame0.setLocationRelativeTo(null);
        frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 创建面板，这个类似于 HTML 的 div 标签,我们可以创建多个面板并在 JFrame 中指定位置,面板中我们可以添加文本字段，按钮及其他组件。
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 600));
        // 添加面板
        frame0.add(panel);
        // 调用用户定义的方法并添加组件到面板
        placeComponents(panel);
        // 设置界面可见
        frame0.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        // 布局部分,设置布局为 null
        panel.setLayout(new BorderLayout());
        // 创建导航条
        JTextField tf0 = new JTextField("Locks and Keys", 30);
        tf0.setEditable(false);
        tf0.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 60));
        tf0.setHorizontalAlignment(JTextField.CENTER);
        tf0.setBackground(new java.awt.Color(200, 217, 229));
        tf0.setPreferredSize(new Dimension(800,120));
        panel.add(tf0, BorderLayout.NORTH);

        //创建homePage按钮流式布局
        JPanel guideBtn = new JPanel(new FlowLayout(1,60,100));

        // 创建按钮Lock
        JPanel btnLock = new JPanel(new BorderLayout());
        JButton button1 = new JButton(icon1);
        button1.setPreferredSize(new Dimension(128,128));
        JLabel label1 = new JLabel("View All Locks");
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        label1.setBorder(new EmptyBorder(10,0,0,0));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        btnLock.add(button1,BorderLayout.CENTER);
        btnLock.add(label1,BorderLayout.SOUTH);
        // 创建按钮Key
        JPanel btnKey = new JPanel(new BorderLayout());
        JButton button2 = new JButton(icon2);
        button2.setPreferredSize(new Dimension(128,128));
        JLabel label2 = new JLabel("View All Keys");
        label2.setFont(new Font("Arial", Font.BOLD, 16));
        label2.setBorder(new EmptyBorder(10,0,0,0));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        btnKey.add(button2,BorderLayout.CENTER);
        btnKey.add(label2,BorderLayout.SOUTH);
        // 创建按钮Combo
        JPanel btnCombo = new JPanel(new BorderLayout());
        JButton button3 = new JButton(icon3);
        button3.setPreferredSize(new Dimension(128,128));
        JLabel label3 = new JLabel("View All Combos");
        label3.setFont(new Font("Arial", Font.BOLD, 16));
        label3.setBorder(new EmptyBorder(10,0,0,0));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        btnCombo.add(button3,BorderLayout.CENTER);
        btnCombo.add(label3,BorderLayout.SOUTH);
        // 创建按钮Add
        JPanel btnAdd = new JPanel(new BorderLayout());
        JButton button4 = new JButton(icon5);
        button4.setPreferredSize(new Dimension(128,128));
        button4.setBackground(Color.white);
        JLabel label4 = new JLabel("Add");
        label4.setFont(new Font("Arial", Font.BOLD, 16));
        label4.setBorder(new EmptyBorder(10,0,0,0));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        btnAdd.add(button4,BorderLayout.CENTER);
        btnAdd.add(label4,BorderLayout.SOUTH);

        guideBtn.add(btnLock);
        guideBtn.add(btnKey);
        guideBtn.add(btnCombo);
        guideBtn.add(btnAdd);
        panel.add(guideBtn,BorderLayout.CENTER);

        //点击Lock事件
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLocks();
            }
        });

        //点击Key事件
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showKeys();
            }
        });

        //点击Combo事件
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCombos();
            }
        });

        //点击Add事件
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddCardLayout addCardLayout = new AddCardLayout();
                addCardLayout.AddCardLayout();
            }
        });
    }

    /////////////////////////////////////////////////////////方法///////////////////////////////////////////////////////

    /////////////////////////////////展示所有Lock///////////////////////////////
    private static void showLocks() {
        //创建新的窗口
        JFrame frame1 = new JFrame("Locks");
        frame1.setLayout(new BorderLayout(0, 0));
        // 窗体大小
        frame1.setSize(new Dimension(800, 600));
        // JFrame在屏幕居中
        frame1.setLocationRelativeTo(null);
        // 显示窗体
        frame1.setVisible(true);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
//                frame1.add(panel1);
        // 创建导航条
        JTextField tf0 = new JTextField("Locks", 30);
//                tf0.setBounds(0, 0, 750, 100);
        tf0.setEditable(false);
        tf0.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 60));
        tf0.setHorizontalAlignment(JTextField.CENTER);
        tf0.setBackground(new java.awt.Color(200, 217, 229));
        panel1.add(tf0, BorderLayout.NORTH);
        panel1.setPreferredSize(new Dimension(750, 550));

        // 创建所有Lock
        HashSet<Lock1> allLocks = main.getAllLocks();
        JPanel p = new JPanel(new GridLayout(allLocks.size()/5, 5, 27, 10));
        p.setBorder(new EmptyBorder(10,10,10,10));
        TreeSet<Lock1> treeSet = new TreeSet<>(new Comparator<Lock1>() {
            @Override
            public int compare(Lock1 o1, Lock1 o2) {
                return o1.getID() - o2.getID();
            }
        });
        treeSet.addAll(allLocks);
        for (final Lock1 lock1 : treeSet) {
            JLabel lLock = new JLabel(lock1.getID() + "");
            JButton btn1 = new JButton();
            JPanel pLock = new JPanel(new BorderLayout());

            pLock.setPreferredSize(new Dimension(128, 168));
            btn1.setPreferredSize(new Dimension(128, 128));
            btn1.setIcon(icon1);
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lockDetail(lock1);
                }
            });
            lLock.setFont(new Font("Arial", Font.BOLD, 15));
            lLock.setPreferredSize(new Dimension(128, 40));
            lLock.setHorizontalAlignment(JTextField.CENTER);

            pLock.add(btn1, BorderLayout.NORTH);
            pLock.add(lLock, BorderLayout.CENTER);
            p.add(pLock);
        }
        JScrollPane jScrollPane = new JScrollPane(p);
        panel1.add(jScrollPane, BorderLayout.CENTER);
        frame1.add(panel1, BorderLayout.CENTER);
    }

    /////////////////////////////////展示所有Key////////////////////////////////
    private static void showKeys() {
        //创建新的窗口
        JFrame frame1 = new JFrame("Keys");
        frame1.setLayout(new BorderLayout(0, 0));
        // 窗体大小
        frame1.setSize(new Dimension(800, 600));
        // JFrame在屏幕居中
        frame1.setLocationRelativeTo(null);
        // 显示窗体
        frame1.setVisible(true);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
//                frame1.add(panel1);

        // 创建导航条
        JTextField tf0 = new JTextField("Keys", 30);
        tf0.setEditable(false);
        tf0.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 60));
        tf0.setHorizontalAlignment(JTextField.CENTER);
        tf0.setBackground(new java.awt.Color(200, 217, 229));
        panel1.add(tf0, BorderLayout.NORTH);
        panel1.setPreferredSize(new Dimension(800, 600));
        HashSet<Key1> allKeys = main.getAllKeys();
        // 创建所有Lock
        JPanel p = new JPanel(new GridLayout(allKeys.size()/5, 5, 27, 10));
        p.setBorder(new EmptyBorder(10,10,10,10));

        TreeSet<Key1> treeSet = new TreeSet<>(new Comparator<Key1>() {
            @Override
            public int compare(Key1 o1, Key1 o2) {
                return o1.getID() - o2.getID();
            }
        });
        treeSet.addAll(allKeys);
        for (final Key1 key1 : treeSet) {
            int lockCount = 0;
            try {
                lockCount = main.searchLocksOpenedByGivenKey(key1.getID()).size();

            } catch (Exception e) {

            }
            String text = key1.getID() + "";
            if (lockCount > 1) {
                text = "Master " + text;
            }
            JLabel lockId = new JLabel(text);
            JButton btn1 = new JButton();
            JPanel pLock = new JPanel(new BorderLayout());
            pLock.setPreferredSize(new Dimension(128, 168));
            btn1.setIcon(key1.getType()?icon2:icon4);
            btn1.setPreferredSize(new Dimension(128, 128));
            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    keyDetail(key1);
                }
            });
            lockId.setFont(new Font("Arial", Font.BOLD, 15));
            lockId.setPreferredSize(new Dimension(128, 40));
            lockId.setHorizontalAlignment(JTextField.CENTER);

            pLock.add(btn1, BorderLayout.NORTH);
            pLock.add(lockId, BorderLayout.CENTER);
            p.add(pLock);
        }
        JScrollPane jScrollPane = new JScrollPane(p);
        panel1.add(jScrollPane, BorderLayout.CENTER);
        frame1.add(panel1, BorderLayout.CENTER);
    }
    /////////////////////////////////展示所有Combo//////////////////////////////
    private static void showCombos(){
        //创建新的窗口
        JFrame frame1 = new JFrame("Combinations");
        frame1.setLayout(new BorderLayout(0, 0));
        // 窗体大小
        frame1.setSize(new Dimension(700, 600));
        // JFrame在屏幕居中
        frame1.setLocationRelativeTo(null);
        // 显示窗体
        frame1.setVisible(true);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        // 创建导航条
        JTextField tf0 = new JTextField("Combinations", 30);
        tf0.setEditable(false);
        tf0.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 60));
        tf0.setHorizontalAlignment(JTextField.CENTER);
        tf0.setBackground(new java.awt.Color(200, 217, 229));
        panel1.add(tf0, BorderLayout.NORTH);
        panel1.setPreferredSize(new Dimension(700, 600));
        //创建所有Combo
        JPanel boxPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(boxPanel, BoxLayout.Y_AXIS);
        boxPanel.setPreferredSize(new Dimension(600, 3400));
        boxPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        HashSet<KeyLock> combos = main.getAllCombos();
        TreeSet<KeyLock> keyLock = new TreeSet<>(new Comparator<KeyLock>() {
            @Override
            public int compare(KeyLock o1, KeyLock o2) {
                return o1.getLockID() - o2.getLockID();
            }
        });
        keyLock.addAll(combos);
        for (final KeyLock lock : keyLock){
            JPanel keyLockPanel = new JPanel(new BorderLayout());
            keyLockPanel.setBorder(border);
            keyLockPanel.setPreferredSize(new Dimension(600,150));
            JPanel keyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel lockPanel = new JPanel(new BorderLayout());
            JLabel lockId = new JLabel(lock.getLockID() + "");
            JLabel lockImg = new JLabel(icon1);
            lockId.setBorder(new EmptyBorder(2,0,0,0));
            lockId.setHorizontalAlignment(SwingConstants.CENTER);
            lockImg.setHorizontalAlignment(SwingConstants.CENTER);
            lockPanel.add(lockId,BorderLayout.NORTH);
            lockPanel.add(lockImg,BorderLayout.CENTER);
            try{
                HashSet<Key1> keys = main.searchKeysOpeningGivenLock(lock.getLockID());
                TreeSet<Key1> treeSet = new TreeSet<>(new Comparator<Key1>() {
                    @Override
                    public int compare(Key1 o1, Key1 o2) {
                        return o1.getID() - o2.getID();
                    }
                });
                treeSet.addAll(keys);
                for (final Key1 key1 : treeSet){
                    JPanel keyP = new JPanel(new BorderLayout());
                    JLabel keyId = new JLabel(key1.getID() + "");
                    JLabel keyImg = new JLabel(key1.getType()?icon2:icon4);
                    keyId.setHorizontalAlignment(SwingConstants.CENTER);
                    keyImg.setHorizontalAlignment(SwingConstants.CENTER);
                    keyP.add(keyId,BorderLayout.NORTH);
                    keyP.add(keyImg,BorderLayout.CENTER);
                    keyPanel.add(keyP);

                    keyLockPanel.add(lockPanel,BorderLayout.WEST);
                    keyLockPanel.add(keyPanel,BorderLayout.CENTER);
                }
            }catch (Exception e){
            }
            boxPanel.add(keyLockPanel);
        }
        JScrollPane jScrollPane = new JScrollPane(boxPanel);
        panel1.add(jScrollPane, BorderLayout.CENTER);
        frame1.add(panel1, BorderLayout.CENTER);
    }

    //展示Lock Detail
    public static void lockDetail(Lock1 lock1) {
        //创建新的窗口
        JFrame frame1 = new JFrame("Lock's Detail");
        frame1.setLayout(new BorderLayout(0, 0));
        // 窗体大小
        frame1.setSize(new Dimension(820, 500));
        // JFrame在屏幕居中
        frame1.setLocationRelativeTo(null);
        // 显示窗体
        frame1.setVisible(true);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        // 创建导航条
        JTextField tf0 = new JTextField("Lock's Detail", 30);
        tf0.setEditable(false);
        tf0.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 60));
        tf0.setHorizontalAlignment(JTextField.CENTER);
        tf0.setBackground(new java.awt.Color(200, 217, 229));
        panel1.add(tf0,BorderLayout.NORTH);
        frame1.add(panel1);
        //创建Lock信息
        JPanel pTable = new JPanel(new BorderLayout());
        JLabel lockNum = new JLabel(lock1.getID() + "");
        String tags[] = {"ID", "Room number", "Location"};
        String values[] = {lock1.getID() + "", lock1.getRoomNumber() + "", "Eagle Hall"};
        JPanel lockInfo = new JPanel(new GridLayout(3, 2));
        for (int i = 0; i < 3; i++) {
            JLabel jl_tag = new JLabel(tags[i]);
            jl_tag.setBorder(border);
            jl_tag.setHorizontalAlignment(JTextField.CENTER);
            JLabel jl_value = new JLabel(values[i]);
            jl_value.setBorder(border);
            jl_value.setHorizontalAlignment(JTextField.CENTER);
            jl_tag.setFont(new Font("Arial", Font.BOLD, 18));
            jl_value.setFont(new Font("Arial", Font.BOLD, 18));
            lockInfo.add(jl_tag);
            lockInfo.add(jl_value);
        }

        pTable.setBorder(new EmptyBorder(10,10,10,10));
        lockNum.setBorder(border);
        lockNum.setPreferredSize(new Dimension(180, 180));
        lockNum.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        lockNum.setBackground(new java.awt.Color(200, 217, 229));
        lockNum.setHorizontalAlignment(JTextField.CENTER);

//        LockInfo.setPreferredScrollableViewportSize(new Dimension(500, 180));
        JPanel midPanel = new JPanel();
        JLabel lKeys = new JLabel("Key(s): ");
        midPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        midPanel.setPreferredSize(new Dimension(200,40));
        lKeys.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        midPanel.add(lKeys);
        pTable.add(lockNum, BorderLayout.WEST);
        pTable.add(lockInfo, BorderLayout.CENTER);
        pTable.add(midPanel,BorderLayout.SOUTH);

        try {
            HashSet<Key1> keys = main.searchKeysOpeningGivenLock(lock1.getID());
            TreeSet<Key1> treeSet = new TreeSet<>(new Comparator<Key1>() {
                @Override
                public int compare(Key1 o1, Key1 o2) {
                    return o1.getID() - o2.getID();
                }
            });
            treeSet.addAll(keys);

            JPanel p = new JPanel(new GridLayout(keys.size() / 5, 5, 15, 10));
            p.setPreferredSize(new Dimension(190, 190));
            for (final Key1 key1 : treeSet) {
                int lockCount = 0;
                try {
                    lockCount = main.searchLocksOpenedByGivenKey(key1.getID()).size();
                } catch (Exception e) {
                }
                String master = "";
                if (lockCount > 1) {
                    master = "Master " + master;
                }else {
                }
                JPanel pLock = new JPanel(new BorderLayout());
                JPanel keyInfo = new JPanel(new BorderLayout());
                JLabel keyId = new JLabel(master + key1.getID() + "");
                JLabel keyImg = new JLabel();
                pLock.setPreferredSize(new Dimension(68, 68));
                pLock.setBorder(new EmptyBorder(0,10,10,10));
                icon2.setImage(icon2.getImage().getScaledInstance(icon2.getIconWidth(),icon2.getIconHeight(), Image.SCALE_DEFAULT));
                keyImg.setIcon(key1.getType()?icon2:icon4);
                keyImg.setHorizontalAlignment(SwingConstants.CENTER);
                keyImg.setBorder(border);
                keyId.setFont(new Font("Arial", Font.BOLD, 15));
                keyId.setHorizontalAlignment(SwingConstants.CENTER);
                keyId.setBorder(border);
                JButton jDel = new JButton("Delete");
                jDel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            main.deleteKey(key1.getID(), lock1.getID());
                            p.remove(pLock);
                            p.updateUI();
                            p.repaint();
                        } catch (Exception e1) {
                            Object[] options = { "OK" };
                            JOptionPane.showOptionDialog(
                                    null,
                                    e1.getMessage(),
                                    "Delete Error",
                                    JOptionPane.ERROR_MESSAGE, JOptionPane.ERROR_MESSAGE,
                                    null, options, options[0]);
                        }
                    }
                });
                keyInfo.add(keyId,BorderLayout.NORTH);
                keyInfo.add(keyImg,BorderLayout.CENTER);
                keyInfo.add(jDel,BorderLayout.SOUTH);
                pLock.add(keyInfo, BorderLayout.CENTER);
                p.add(pLock);
            }
            panel1.add(p, BorderLayout.SOUTH);
        } catch (Exception e) {
            JLabel noLock = new JLabel(e.getMessage());
            panel1.add(noLock, BorderLayout.SOUTH);
        }
        panel1.add(pTable, BorderLayout.CENTER);
    }

    //展示Key Detail
    public static void keyDetail(Key1 key1) {
        //创建新的窗口
        JFrame frame1 = new JFrame("Key's Detail");
        frame1.setLayout(new BorderLayout(0, 0));
        // 窗体大小
        frame1.setSize(new Dimension(820, 500));
        // JFrame在屏幕居中
        frame1.setLocationRelativeTo(null);
        // 显示窗体
        frame1.setVisible(true);
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
//                frame1.add(panel1);

        // 创建导航条
        JTextField tf0 = new JTextField("Key's Detail", 30);
        tf0.setEditable(false);
        tf0.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 60));
        tf0.setHorizontalAlignment(JTextField.CENTER);
        tf0.setBackground(new java.awt.Color(200, 217, 229));
        panel1.add(tf0,BorderLayout.NORTH);
        frame1.add(panel1);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        //创建Lock信息
        JPanel pTable = new JPanel(new BorderLayout());
        JLabel lockNum = new JLabel(key1.getID() + "");

        int lockCount = 0;
        try {
            lockCount = main.searchLocksOpenedByGivenKey(key1.getID()).size();

        } catch (Exception e) {
        }
        String master = "";
        if (lockCount > 1) {
            master = "YES " + master;
        }else {
            master = "NO" + master;
        }
        String type = "";
        if (key1.getType()==true){
            type += "Physical";
        }else {
            type += "Swipe Card";
        }
        String tags[] = {"ID", "Type", "Whether Master Key"};
        String values[] = {key1.getID() + "", type + "", master};
        JPanel lockInfo = new JPanel(new GridLayout(3, 2));
        for (int i = 0; i < 3; i++) {
            JLabel jl_tag = new JLabel(tags[i]);
            jl_tag.setBorder(border);
            jl_tag.setHorizontalAlignment(JTextField.CENTER);
            JLabel jl_value = new JLabel(values[i]);
            jl_value.setBorder(border);
            jl_value.setHorizontalAlignment(JTextField.CENTER);
            jl_tag.setFont(new Font("Arial", Font.BOLD, 18));
            jl_value.setFont(new Font("Arial", Font.BOLD, 18));
            lockInfo.add(jl_tag);
            lockInfo.add(jl_value);
        }
        pTable.setBorder(new EmptyBorder(10,10,10,10));
        lockNum.setBorder(border);
        lockNum.setPreferredSize(new Dimension(180, 180));
        lockNum.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        lockNum.setBackground(new java.awt.Color(200, 217, 229));
        lockNum.setHorizontalAlignment(JTextField.CENTER);
//        LockInfo.setPreferredScrollableViewportSize(new Dimension(500, 180));
        JPanel midPanel = new JPanel();
        JLabel lKeys = new JLabel("Lock(s): ");
        midPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        midPanel.setPreferredSize(new Dimension(200,40));
        lKeys.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 30));
        midPanel.add(lKeys);
        pTable.add(lockNum, BorderLayout.WEST);
        pTable.add(lockInfo, BorderLayout.CENTER);
        pTable.add(midPanel,BorderLayout.SOUTH);

        try {
            HashSet<Lock1> locks = main.searchLocksOpenedByGivenKey(key1.getID());
            JPanel p = new JPanel(new GridLayout(locks.size() / 5, 5, 15, 10));
            p.setPreferredSize(new Dimension(190, 190));
            TreeSet<Lock1> treeSet = new TreeSet<>(new Comparator<Lock1>() {
                @Override
                public int compare(Lock1 o1, Lock1 o2) {
                    return o1.getID() - o2.getID();
                }
            });
            treeSet.addAll(locks);
            for (final Lock1 lock1 : treeSet) {
                JLabel lockId = new JLabel(lock1.getID() + "");
                JPanel pKey = new JPanel(new BorderLayout());
                JLabel lockImg = new JLabel();

                pKey.setPreferredSize(new Dimension(68, 68));
                pKey.setBorder(new EmptyBorder(0,10,10,10));
                icon1.setImage(icon1.getImage().getScaledInstance(icon1.getIconWidth(),icon1.getIconHeight(), Image.SCALE_DEFAULT));
                lockImg.setIcon(icon1);
                lockImg.setHorizontalAlignment(SwingConstants.CENTER);
                lockImg.setBorder(border);
                lockId.setFont(new Font("Arial", Font.BOLD, 15));
                lockId.setPreferredSize(new Dimension(68, 40));
                lockId.setHorizontalAlignment(JTextField.CENTER);
                lockId.setBorder(border);
                JButton jLock = new JButton("View");
                jLock.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        lockDetail(lock1);
                    }
                });
                pKey.add(lockId, BorderLayout.NORTH);
                pKey.add(lockImg,BorderLayout.CENTER);
                pKey.add(jLock,BorderLayout.SOUTH);
                p.add(pKey);
            }
            panel1.add(p, BorderLayout.SOUTH);
        } catch (Exception e) {
            JLabel lockId = new JLabel(e.getMessage());
            panel1.add(lockId, BorderLayout.SOUTH);
        }
        panel1.add(pTable, BorderLayout.CENTER);
    }
}

